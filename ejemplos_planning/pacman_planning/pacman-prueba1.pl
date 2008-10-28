:- include(pop).

% Ctedra Inteligencia Artificial
% Tema: Planificacin - Operadores STRIPS
% Ejemplo Problema de los Cubos
% Fecha: Mayo/2005
%

sumarPosicion(P,O,P1):-O=:=(-1),P=:=0,P1 is 3,!.
sumarPosicion(P,O,P1):-O=:=(-1),P=\=0,P1 is P-1,!.
sumarPosicion(P,O,P1):-O=:=1,P=:=3,P1 is 0,!.
sumarPosicion(P,O,P1):-O=:=1,P=\=3,P1 is P+1,!.

%en(X,Yn) :- en(X,Y), movArriba(X,Y), sumarPosicion(Y,-1,Yn).
%en(X,Yn) :- en(X,Y), movAbajo(X,Y), sumarPosicion(Y,1,Yn).
%en(Xn,Y) :- en(X,Y), movDerecha(X,Y), sumarPosicion(X,1,Xn).
%en(Xn,Y) :- en(X,Y), movIzquierda(X,Y), sumarPosicion(X,-1,Xn).

%----------------------------------
% OPERADORES
%

% avanzar(X,Y,Xf,Yf)
%preconditions( avanzar(X,Y,Xf,Yf), [en(X,Y), vacio(X,Y)] ).
%achieves( avanzar(X,Y,Xf,Yf), en(Xf,Yf) ).
%deletes( avanzar(X,Y,Xf,Yf), en(X,Y) ).

% arriba(X,Y)
%preconditions( arriba(X,Y), [en(X,Y), vacio(X,Y)] ).
%achieves( arriba(X,Y), en(X,(Y-1) mod 4) ).
%deletes( arriba(X,Y), en(X,Y) ).

% arriba(X,Y)
preconditions( arriba(X,Y,Yn), [en(X,Y), vacio(X,Y), sumarPosicion(Y,-1,Yn)] ).
achieves( arriba(X,Y,Yn), en(X,Yn) ).
deletes( arriba(X,Y,Yn), en(X,Y) ).

% abajo(X,Y)
%preconditions( abajo(X,Y), [en(X,Y), vacio(X,Y), sumarPosicion(Y,1,Yn)] ).
%achieves( abajo(X,Y), en(X, Yn) ).
%deletes( abajo(X,Y), en(X, Y) ).

% derecha(X,Y)
%preconditions( derecha(X,Y), [en(X,Y), vacio(X,Y), sumarPosicion(X,1,Xn)] ).
%achieves( derecho(X,Y), en(Xn, Y) ).
%deletes( derecha(X,Y), en(X, Y) ).

% izquierda(X,Y)
%preconditions( izquierda(X,Y), [en(X,Y), vacio(X,Y), sumarPosicion(X,-1,Xn)] ).
%achieves( izquierda(X,Y), en(Xn, Y) ).
%deletes( izquierda(X,Y), en(X, Y) ).

% comer(X,Y)
%preconditions( comer(X,Y), [en(X,Y), comida(X,Y)] ).
%achieves( comer(X,Y), vacio(X,Y) ).
%deletes( comer(X,Y), comida(X,Y) ).

% pelear(X,Y)
%preconditions( pelear(X,Y), [en(X,Y), enemigo(X,Y)] ).
%achieves( pelear(X,Y), vacio(X,Y) ).
%deletes( pelear(X,Y), enemigo(X,Y) ).


%----------------------------------
% PREDICADOS DEL DOMINIO

primitive( en(_,_) ).
primitive( sumarPosicion(_,_,_) ).
primitive( enemigo(_,_) ).
primitive( comida(_,_) ).
primitive( vacio(_,_) ).


%----------------------------------
% ESTADO INICIAL

holds(vacio(0,0), init).
holds(vacio(0,1), init).
holds(vacio(0,2), init).
holds(comida(0,3), init).
holds(vacio(1,0), init).
holds(vacio(1,1), init).
holds(vacio(1,2), init).
holds(comida(1,3), init).
holds(vacio(2,0), init).
holds(vacio(2,1), init).
holds(vacio(2,2), init).
holds(enemigo(2,3), init).
holds(vacio(3,0), init).
holds(vacio(3,2), init).
holds(vacio(3,3), init).
holds(enemigo(3,1), init).
holds(en(0,1), init).

achieves(init,X) :-
   holds(X,init).



% Pruebas:
% solve([vacio(0,3),vacio(1,3),vacio(2,3),vacio(3,1)],P,4),seq(P,S).
% solve([vacio(0,3),vacio(1,3)],P,4),seq(P,S).

