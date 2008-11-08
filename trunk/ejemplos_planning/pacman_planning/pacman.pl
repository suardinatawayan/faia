:- include(pop).
:- dynamic holds/2.

% FAIA
% Ejemplo de Pacman con Planning

%----------------------------------
% OPERADORES
%

% avanzar(Pos1,Pos2)
%preconditions( avanzar(Pos1,Pos2), [en(Pos1), adyacente(Pos1,Pos2)] ).
preconditions( avanzar(Pos1,Pos2), [en(Pos1), adyacente(Pos1,Pos2), celdaNoVisitada(Pos2)] ).
achieves( avanzar(Pos1,Pos2), en(Pos2) ).
deletes( avanzar(Pos1,Pos2), en(Pos1) ).
deletes( avanzar(Pos1,Pos2), celdaNoVisitada(Pos2) ).

% descubrir(Pos)
preconditions( descubrir(Pos), [en(Pos), desconocido(Pos)] ).
achieves( descubrir(Pos), vacio(Pos) ).
deletes( descubrir(Pos), desconocido(Pos) ).

% comer(Pos)
preconditions( comer(Pos), [en(Pos), comida(Pos)] ).
achieves( comer(Pos), vacio(Pos) ).
deletes( comer(Pos), comida(Pos) ).

% pelear(Pos)
preconditions( pelear(Pos), [en(Pos), enemigo(Pos)] ).
achieves( pelear(Pos), vacio(Pos) ).
deletes( pelear(Pos), enemigo(Pos) ).


%----------------------------------
% PREDICADOS DEL DOMINIO

primitive( en(_) ).
primitive( adyacente(_,_) ).
primitive( enemigo(_) ).
primitive( comida(_) ).
primitive( vacio(_) ).
primitive( celdaNoVisitada(_) ).
primitive( desconocido(_) ).


% Adyacencia
% 0   1   2   3
% 4   5   6   7
% 8   9   10  11
% 12  13  14  15

/*
holds(adyacente(10,6), init).
holds(adyacente(10,11), init).
holds(adyacente(10,14), init).
holds(adyacente(10,9), init).

holds(adyacente(11,7), init).
holds(adyacente(11,8), init).
holds(adyacente(11,15), init).
holds(adyacente(11,10), init).

holds(adyacente(12,8), init).
holds(adyacente(12,13), init).
holds(adyacente(12,0), init).
holds(adyacente(12,15), init).

holds(adyacente(13,9), init).
holds(adyacente(13,14), init).
holds(adyacente(13,1), init).
holds(adyacente(13,12), init).

holds(adyacente(14,10), init).
holds(adyacente(14,15), init).
holds(adyacente(14,2), init).
holds(adyacente(14,13), init).

holds(adyacente(15,11), init).
holds(adyacente(15,12), init).
holds(adyacente(15,3), init).
holds(adyacente(15,14), init).

holds(adyacente(0,12), init).
holds(adyacente(0,1), init).
holds(adyacente(0,4), init).
holds(adyacente(0,3), init).

holds(adyacente(1,13), init).
holds(adyacente(1,2), init).
holds(adyacente(1,5), init).
holds(adyacente(1,0), init).

holds(adyacente(2,14), init).
holds(adyacente(2,3), init).
holds(adyacente(2,6), init).
holds(adyacente(2,1), init).

% 0   1   2   3
% 4   5   6   7
% 8   9   10  11
% 12  13  14  15

holds(adyacente(3,15), init).
holds(adyacente(3,0), init).
holds(adyacente(3,7), init).
holds(adyacente(3,2), init).

holds(adyacente(4,0), init).
holds(adyacente(4,5), init).
holds(adyacente(4,8), init).
holds(adyacente(4,7), init).

holds(adyacente(5,6), init).
holds(adyacente(5,9), init).
holds(adyacente(5,4), init).
holds(adyacente(5,1), init).

holds(adyacente(6,2), init).
holds(adyacente(6,7), init).
holds(adyacente(6,10), init).
holds(adyacente(6,5), init).

holds(adyacente(7,3), init).
holds(adyacente(7,4), init).
holds(adyacente(7,11), init).
holds(adyacente(7,6), init).

holds(adyacente(8,4), init).
holds(adyacente(8,9), init).
holds(adyacente(8,12), init).
holds(adyacente(8,11), init).

holds(adyacente(9,5), init).
holds(adyacente(9,10), init).
holds(adyacente(9,13), init).
holds(adyacente(9,8), init).
*/

tamaño_mundo(2).

generarPosicion(0).
generarPosicion(N) :-
	generarPosicionAux(N,0).

generarPosicionAux(Sig,Num) :-
	Sig is Num + 1.

generarPosicionAux(Sig,Num) :-
	tamaño_mundo(T),
	Num < (T * T) - 2,
	generarPosicionAux(Sig, Num + 1).


celdaCorrecta(Pos1, Pos2) :-
	generarPosicion(Pos1),
	generarPosicion(Pos2).

holds(adyacente(Pos1, Pos2), init) :-
	celdaCorrecta(Pos1,Pos2),
	tamaño_mundo(T),
	M is Pos1 mod T, M =\= T - 1,
	Pos2 is Pos1 + 1.

holds(adyacente(Pos1, Pos2), init) :-
	celdaCorrecta(Pos1,Pos2),
	tamaño_mundo(T),
	M is Pos1 mod T, M =\= 0,
	Pos2 is Pos1 - 1.

holds(adyacente(Pos1, Pos2), init) :-
	celdaCorrecta(Pos1,Pos2),
	tamaño_mundo(T),
	Pos1 < T * (T - 1),
	Pos2 is Pos1 + T.

holds(adyacente(Pos1, Pos2), init) :-
	celdaCorrecta(Pos1,Pos2),
	tamaño_mundo(T),
	Pos1 >= T,
	Pos2 is Pos1 - T.
	

% 0   1   2   3
% 4   5   6   7
% 8   9   10  11
% 12  13  14  15

% ESTADO INICIAL

holds(en(0), init).
holds(vacio(1), init).
holds(comida(0), init).
holds(vacio(2), init).
holds(vacio(3), init).
%holds(comida(4), init).
%holds(comida(3), init).
%holds(comida(12), init).

%holds(desconocido(3), init).

/*
holds(celdaNoVisitada(0), init).
holds(celdaNoVisitada(1), init).
holds(celdaNoVisitada(2), init).
holds(celdaNoVisitada(3), init).
holds(celdaNoVisitada(4), init).
holds(celdaNoVisitada(5), init).
holds(celdaNoVisitada(6), init).
holds(celdaNoVisitada(7), init).
holds(celdaNoVisitada(8), init).
holds(celdaNoVisitada(9), init).
holds(celdaNoVisitada(10), init).
holds(celdaNoVisitada(11), init).
holds(celdaNoVisitada(12), init).
holds(celdaNoVisitada(13), init).
holds(celdaNoVisitada(14), init).
holds(celdaNoVisitada(15), init).
*/

% Si no hay comida ni enemigo ni está vacía la celda, entonces
% es desconocida.

holds(desconocido(Pos), init) :-
	not(holds(enemigo(Pos), init)),
	not(holds(comida(Pos), init)),
	not(holds(vacio(Pos), init)).

holds(celdaNoVisitada(Pos), init) :-
	holds(en(P), init),
	Pos =\= P.

achieves(init,X) :-
	holds(X,init).

armarObjetivos(L) :-
	armarObjetivosAux(L, 0).

armarObjetivosAux([vacio(N)|Xs],N) :-
	tamaño_mundo(T),
	N < T * T,
	M is N + 1,
	armarObjetivosAux(Xs, M).

armarObjetivosAux([], N) :-
	tamaño_mundo(T),
	N =:= T * T.

%
% obtenerAccion(Accion)
%
% Devuelve la acción siguiente a ejecutarse.
%

obtenerAccion(Accion) :-
	resolver(Init,Accion,S).


%
% debug(S)
%
% Es igual que obtenerAccion. Lo uso para debugging.
%

debug([Init,Accion|As]) :-
	resolver(Init,Accion,As).


%
% resolver(S)
%
% Realiza la resolución principal. Es común a debug y obtenerAccion.
%

resolver(Init,Accion,S) :-
	armarObjetivos(Objetivos),
	solve(Objetivos,P,10),
	seq(P,[Init,Accion|S]),!.


%
% ejecutarAccion(X)
%
% X es alguna acción. Ejecuta la acción efectivamente, para que así al
% correr otra vez 'obtenerAccion' se realice el paso siguiente. Quita
% o agrega holds(...
%

ejecutarAccion(avanzar(Pos1,Pos2)) :-
	retract(holds(en(Pos1),init)),
	assert(holds(en(Pos2),init)).

ejecutarAccion(comer(Pos)) :-
	retract(holds(comida(Pos),init)),
	assert(holds(vacio(Pos),init)).

ejecutarAccion(pelear(Pos)) :-
	retract(holds(enemigo(Pos),init)),
	assert(holds(vacio(Pos),init)).

ejecutarAccion(descubrir(Pos)) :-
	assert(holds(vacio(Pos),init)).

ejecutarAccion(end).

