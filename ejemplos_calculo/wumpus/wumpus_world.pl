:- dynamic stench/2, breeze/2, perception/2, position/2.

add(P,X,P1):-P1 is P+X.

adjacent2(down,[X,Y],[X,Y1]) :- add(Y,-1,Y1).
adjacent2(up,[X,Y],[X,Y1]) :- add(Y,1,Y1).
adjacent2(left,[X,Y],[X1,Y]) :- add(X,-1,X1).
adjacent2(right,[X,Y],[X1,Y]) :- add(X,1,X1).

adjacent([X,Y],[X1,Y1]) :- adjacent2(down,[X,Y],[X1,Y1]).
adjacent([X,Y],[X1,Y1]) :- adjacent2(up,[X,Y],[X1,Y1]).
adjacent([X,Y],[X1,Y1]) :- adjacent2(left,[X,Y],[X1,Y1]).
adjacent([X,Y],[X1,Y1]) :- adjacent2(right,[X,Y],[X1,Y1]).

moveRight(up,right).
moveRight(right,down).
moveRight(down,left).
moveRight(left,up).

moveLeft(right,up).
moveLeft(down,right).
moveLeft(left,down).
moveLeft(up,left).

count(Template, Query, Count) :-
	setof(Template, Query, Set),
	length(Set, Count).

count(Query, Count) :-
	count(Query, Query, Count).


% TODO: Ver si están bien catalogadas las reglas.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Diagnostic rules                                %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%position([1,1],1) :- perception([_,_,_,_,_],1).

stench(P) :-
	perception([stench,_,_,_,_],S),
	position(P,S).

breeze(P) :-
	perception([_,breeze,_,_,_],S),
	position(P,S).

glitter(P) :-
	perception([_,_,glitter,_,_],S),
	position(P,S).

bump(P) :-
	perception([_,_,_,bump,_],S),
	position(P,S).

wumpusKilled(S) :-
	perception([_,_,_,_,wumpusScream],S).

at(nothing,P) :-
	perception([nothing,nothing,nothing,nothing,nothing],S),
	position(P,S).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Causal rules                                    %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


% holding(O,S) : where O is an object holded by the agent, and S is a
% situation.

% action(A,S) : where A is an action taken by the agent at situation S.

% at(O,P,S) : where O is an object, P is a location, and S is a situation.

% belief(O,P,S) : where O is an object that the agent *believes* is at location
% P in situaion S.

safe(P) :-
	at(nothing,P).

safe(Pa) :-
	at(nothing,P),
	adjacent(P,Pa).

unknown(P) :-
	not(stench(P)),
	not(breeze(P)),
	not(glitter(P)),
	not(bump(P)),
	not(at(nothing,P)).

belief(wumpus,Pa) :-
	stench(P),
	adjacent(P,Pa).
%	count((adjacent(Pa,Pb),(unknown(Pb);stench(Pb))),4).

%at(wumpus,P) :-
%	belief(wumpus,P),
%	count((belief(wumpus,P)),1).

%stench(P) :- at(wumpus,P).
%stench(Pa) :- at(wumpus,P),adjacent(P,Pa).

belief(pit,Pa) :-
	breeze(P),
	adjacent(P,Pa).
%	count((adjacent(Pa,Pb),(unknown(Pb);breeze(Pb))),4).

%at(pit,P) :-
%	belief(pit,P),
%	count((belief(pit,P)),1).

at(wall,Pa) :- bump(P),orientation(O,S),adjacent2(O,P,Pa).

% present: O is an object present in the current room, and S is a situation.
%present(O,S).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Successor-State Axioms                          %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

ssa(S1):- S1 > 0,S is S1-1,action(A,S),A=\=forward,posicion(P,S),asserta(position(P,S1)).
ssa(S1):- S1 > 0,S is S1-1,action(A,S),A=\=turnright,orientation(O,S),asserta(orientation(O,S1)).
ssa(S1):- S1 > 0,S is S1-1,action(A,S),A=\=turnleft,orientation(O,S),asserta(orientation(O,S1)).

ssa(S1):- S1 > 0,S is S1-1,action(forward,S),orientation(O,S),position(P,S),adjacent2(O,P,Pa),asserta(position(Pa,S1)).

ssa(S1):- S1 > 0,S is S1-1,action(grab,S),asserta(holding(gold,S1)).
ssa(S1):- S1 > 0,S is S1-1,action(A,S),holding(gold,S),A=\=release,asserta(holding(gold,S1)).

ssa(S1):- S1 > 0,S is S1-1,action(A,S),A=\=shoot,asserta(holding(arrow,S1)).




%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Actions                                         %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

excelent(grab,S) :- position(P,S),glitter(P).
excelent(shoot,S) :- holding(arrow,S),orientation(O,S),position(P,S),adjacent2(O,P,Pa),at(wumpus,Pa).

veryGood(forward,S) :- orientation(O,S),position(P,S),adjacent2(O,P,Pa),safe(Pa).
veryGood(turnright,S) :- orientation(O,S),position(P,S),moveRight(O,O1),adjacent2(O1,P,Pa),safe(Pa).
veryGood(turnleft,S) :- orientation(O,S),position(P,S),moveLeft(O,O1),adjacent2(O1,P,Pa),safe(Pa).

notSoGood(forward,S) :- orientation(O,S),position(P,S),adjacent2(O,P,Pa),belief(wumpus,Pa).
notSoGood(forward,S) :- orientation(O,S),position(P,S),adjacent2(O,P,Pa),belief(pit,Pa).

%veryBad(forward,S) :- orientation(O,S),position(P,S),adjacent2(O,P,Pa),at(wumpus,Pa).
%veryBad(forward,S) :- orientation(O,S),position(P,S),adjacent2(O,P,Pa),at(pit,Pa).
%veryBad(forward,S) :- orientation(O,S),position(P,S),adjacent2(O,P,Pa),at(wall,Pa).

bestAction(noAction,S) :- holding(gold,S).
bestAction(A,S) :- excelent(A,S).
bestAction(A,S) :- veryGood(A,S).
bestAction(A,S) :- notSoGood(A,S).

