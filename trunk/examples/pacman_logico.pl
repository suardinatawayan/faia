% Es necesario colocar el código a continuación, para que el framework pueda
% trabajar

:- dynamic percepcion/5,accionEjecutada/2,posicion/3,comida/3,enemigo/3,vacia/3,
energia/2,situacionActual/1.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%                          REGLAS DE DIAGNÓSTICO
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

posicion(X,Y,1):-percepcion([_,_,_,_],X,Y,_,1),!.

enemigo(X,Y,S):-percepcion([enemigo,_,_,_],_,_,_,S),adyacente(X,Y,izquierda,S).
enemigo(X,Y,S):-percepcion([_,enemigo,_,_],_,_,_,S),adyacente(X,Y,derecha,S).
enemigo(X,Y,S):-percepcion([_,_,enemigo,_],_,_,_,S),adyacente(X,Y,arriba,S).
enemigo(X,Y,S):-percepcion([_,_,_,enemigo],_,_,_,S),adyacente(X,Y,abajo,S).

comida(X,Y,S):-percepcion([comida,_,_,_],_,_,_,S),adyacente(X,Y,izquierda,S).
comida(X,Y,S):-percepcion([_,comida,_,_],_,_,_,S),adyacente(X,Y,derecha,S).
comida(X,Y,S):-percepcion([_,_,comida,_],_,_,_,S),adyacente(X,Y,arriba,S).
comida(X,Y,S):-percepcion([_,_,_,comida],_,_,_,S),adyacente(X,Y,abajo,S).

vacia(X,Y,S):-percepcion([vacia,_,_,_],_,_,_,S),adyacente(X,Y,izquierda,S).
vacia(X,Y,S):-percepcion([_,vacia,_,_],_,_,_,S),adyacente(X,Y,derecha,S).
vacia(X,Y,S):-percepcion([_,_,vacia,_],_,_,_,S),adyacente(X,Y,arriba,S).
vacia(X,Y,S):-percepcion([_,_,_,vacia],_,_,_,S),adyacente(X,Y,abajo,S).

energia(E,S):-percepcion([_,_,_,_],_,_,E,S).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%                              REGLAS CAUSALES
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

conoce(X,Y,S) :- vacia(X,Y,S),!.
conoce(X,Y,S) :- comida(X,Y,S),!.
conoce(X,Y,S) :- enemigo(X,Y,S),!.

acciones([],0):-!.
acciones([A|As],S):-accionEjecutada(A,S),S1 is S-1,acciones(As,S1).
accionMover(S):-accionEjecutada(arriba,S).
accionMover(S):-accionEjecutada(abajo,S).
accionMover(S):-accionEjecutada(derecha,S).
accionMover(S):-accionEjecutada(izquierda,S).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%                        AXIOMAS DE ESTADO SUCESOR
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

est(S1):- S1 > 0,S is S1-1,accionEjecutada(comer,S),posicion(X,Y,S),asserta(posicion(X,Y,S1)).
est(S1):- S1 > 0,S is S1-1,accionEjecutada(pelear,S),posicion(X,Y,S),asserta(posicion(X,Y,S1)).

est(S1):- S1 > 0,S is S1-1,accionEjecutada(arriba,S),posicion(X,Y,S),sumarPosicion(X,-1,X1),asserta(posicion(X1,Y,S1)).
est(S1):- S1 > 0,S is S1-1,accionEjecutada(abajo,S),posicion(X,Y,S),sumarPosicion(X,1,X1),asserta(posicion(X1,Y,S1)).
est(S1):- S1 > 0,S is S1-1,accionEjecutada(derecha,S),posicion(X,Y,S),sumarPosicion(Y,1,Y1),asserta(posicion(X,Y1,S1)).
est(S1):- S1 > 0,S is S1-1,accionEjecutada(izquierda,S),posicion(X,Y,S),sumarPosicion(Y,-1,Y1),asserta(posicion(X,Y1,S1)).

est(S1):- S1 > 0,S is S1-1,vacia(X,Y,S),not(vacia(X,Y,S1)),asserta(vacia(X,Y,S1)).
est(S1):- S1 > 0,S is S1-1,posicion(X,Y,S),accionEjecutada(comer,S),asserta(vacia(X,Y,S1)).
est(S1):- S1 > 0,S is S1-1,posicion(X,Y,S),accionEjecutada(pelear,S),asserta(vacia(X,Y,S1)).

est(S1):-S1 > 0,S is S1-1,posicion(_,Y1,S),comida(X,Y,S),Y=\=Y1,not(comida(X,Y,S1)),asserta(comida(X,Y,S1)).
est(S1):-S1 > 0,S is S1-1,posicion(X1,_,S),comida(X,Y,S),X=\=X1,not(comida(X,Y,S1)),asserta(comida(X,Y,S1)).
est(S1):-S1 > 0,S is S1-1,posicion(X,Y,S),accionMover(S),comida(X,Y,S),not(comida(X,Y,S1)),asserta(comida(X,Y,S1)).

est(S1):-S1 > 0,S is S1-1,posicion(_,Y1,S),enemigo(X,Y,S),Y=\=Y1,not(enemigo(X,Y,S1)),asserta(enemigo(X,Y,S1)).
est(S1):-S1 > 0,S is S1-1,posicion(X1,_,S),enemigo(X,Y,S),X=\=X1,not(enemigo(X,Y,S1)),asserta(enemigo(X,Y,S1)).
est(S1):-S1 > 0,S is S1-1,posicion(X,Y,S),accionMover(S),enemigo(X,Y,S),not(enemigo(X,Y,S1)),asserta(enemigo(X,Y,S1)).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%                          VALORACION DE ACCIONES
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

excelente(comer,S):-posicion(X,Y,S),comida(X,Y,S).
excelente(pelear,S):-posicion(X,Y,S),enemigo(X,Y,S).

% Mirar cómo está definida 'adyacente'. Esto se traduce a: es muy bueno
% moverse hacia una celda adyacente donde hay comida o un enemigo.
muy_bueno(D,S):-adyacente(Xa,Ya,D,S),comida(Xa,Ya,S).
muy_bueno(D,S):-adyacente(Xa,Ya,D,S),enemigo(Xa,Ya,S).

% Mirar cómo están definidas 'direccionDescubrimiento', etc. Esto se
% traduce a: es bueno moverse hacia una celda en cual alguna de sus adyacentes
% no es conocida, o tiene comida, o tiene un enemigo.
bueno(D,S):-direccionDescubrimiento(D,S).
bueno(D,S):-direccionComida(D,S).
bueno(D,S):-direccionEnemigo(D,S).

% Si todo lo demás no funcionó, es una acción regular moverse hacia una celda
% adyacente vacía.
regular(D,S):-adyacente(Xa,Ya,D,S),vacia(Xa,Ya,S).


mejorAccion(noAccion,S):-cumplioObjetivo(S),!.
mejorAccion(X,S):-excelente(X,S),!.
mejorAccion(X,S):-muy_bueno(X,S),!.
mejorAccion(X,S):-bueno(X,S),!.
mejorAccion(X,S):-regular(X,S),!.







%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%                            FUNCIONES EXTRA
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

sumarPosicion(P,O,P1):-O=:=(-1),P=:=0,P1 is 3,!.
sumarPosicion(P,O,P1):-O=:=(-1),P=\=0,P1 is P-1,!.
sumarPosicion(P,O,P1):-O=:=1,P=:=3,P1 is 0,!.
sumarPosicion(P,O,P1):-O=:=1,P=\=3,P1 is P+1,!.

adyacenteCelda(X,Y,X1,Y):-sumarPosicion(X,-1,X1).
adyacenteCelda(X,Y,X1,Y):-sumarPosicion(X,1,X1).
adyacenteCelda(X,Y,X,Y1):-sumarPosicion(Y,-1,Y1).
adyacenteCelda(X,Y,X,Y1):-sumarPosicion(Y,1,Y1).

adyacente(X,Y1,izquierda,S):- posicion(X,Y,S),sumarPosicion(Y,-1,Y1).
adyacente(X,Y1,derecha,S)  :- posicion(X,Y,S),sumarPosicion(Y,1,Y1).
adyacente(X1,Y,arriba,S)   :- posicion(X,Y,S),sumarPosicion(X,-1,X1).
adyacente(X1,Y,abajo,S)    :- posicion(X,Y,S),sumarPosicion(X,1,X1).

direccionDescubrimiento(D,S):-adyacente(Xa,Ya,D,S),adyacenteCelda(Xa,Ya,Xaa,Yaa),not(conoce(Xaa,Yaa,S)).
direccionComida(D,S):-adyacente(Xa,Ya,D,S),adyacenteCelda(Xa,Ya,Xaa,Yaa),comida(Xaa,Yaa,S).
direccionEnemigo(D,S):-adyacente(Xa,Ya,D,S),adyacenteCelda(Xa,Ya,Xaa,Yaa),enemigo(Xaa,Yaa,S).

%% Para saber cuándo el agente alcanzó el objetivo
tableroVacio(S):-vacia(0,0,S),vacia(0,1,S),vacia(0,2,S),vacia(0,3,S),
                 vacia(1,0,S),vacia(1,1,S),vacia(1,2,S),vacia(1,3,S),
                 vacia(2,0,S),vacia(2,1,S),vacia(2,2,S),vacia(2,3,S),
                 vacia(3,0,S),vacia(3,1,S),vacia(3,2,S),vacia(3,3,S).

cumplioObjetivo(S):-tableroVacio(S).



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%                           PROPUESTA DE MEJORA
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Se podría hacer que el agente lleve la cuenta del promedio de energía que pierde
% al pelear y moverse. De esta forma, al evaluar las acciones, podría decir que es
% conveniente pelear sólo si el promedio de energía que pierdo al hacerlo es menor
% a la energía actual del agente. De la misma forma, si mi energía actual es menor
% al promedio de energía que pierdo al moverme, es conveniente que no lo haga y
% finalice la simulación.

%%% Hace la sumatoria de una lista
% sumatoria([],0):-!.
% sumatoria([L|Ls],C):-sumatoria(Ls,T),C is T+L.

%%% Retorna la cantidad de elementos de una lista
% cantidad([],0):-!.
% cantidad([_|Ls],C):-cantidad(Ls,T),C is T+1.

%%% Calcula el promedio de una lista
% promedio(L,P):-cantidad(L,C),C=:=0,P is 0,!.
% promedio(L,P):-sumlist(L,S), length(L,C), P is (S/C).

% datos_energia_pelear([],1):-!.
% datos_energia_pelear([D|Ds],S1):-S0 is S1-1,accionEjecutada(pelear,S0),energia(E0,S0),energia(E1,S1),D is E1-E0,datos_energia_pelear(Ds,S0),!.
% datos_energia_pelear(D,S1):-S0 is S1-1,datos_energia_pelear(D,S0),!.

% datos_energia_mover([],1):-!.
% datos_energia_mover([D|Ds],S1):-S0 is S1-1,accionMover(S0),energia(E0,S0),energia(E1,S1),D is E1-E0,datos_energia_mover(Ds,S0),!.
% datos_energia_mover(D,S1):-S0 is S1-1,datos_energia_mover(D,S0),!.

% promedioPorPelear(0,1):-!.
% promedioPorPelear(P,S):-datos_energia_pelear(Es,S),promedio(Es,P).

% promedioPorMoverse(0,1):-!.
% promedioPorMoverse(P,S):-datos_energia_mover(Es,S),promedio(Es,P).

