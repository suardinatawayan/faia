:- include(pop).
:- dynamic holds/2.

% OPERADORES

% apilar(X,Y) : colocar el cubo X sobre el cubo Y
preconditions( apilar(X,Y), [sostenido(X), libre(Y)] ).
achieves( apilar(X,Y), sobre(X,Y) ).
achieves( apilar(X,_Y), libre(X) ).
achieves( apilar(_X,_Y), brazo_libre ).
deletes( apilar(X,_Y), sostenido(X) ).
deletes( apilar(_X,Y), libre(Y) ).

% desapilar(X,Y) : tomar el cubo X que se encuentra sobre el cubo Y
preconditions( desapilar(X,Y), [sobre(X,Y), libre(X), brazo_libre] ).
achieves( desapilar(X,_Y), sostenido(X) ).
achieves( desapilar(_X,Y), libre(Y) ).
deletes( desapilar(X,Y), sobre(X,Y) ).
deletes( desapilar(X,_Y), libre(X) ).
deletes( desapilar(_X,_Y), brazo_libre ).

% depositar(X) : depositar el cubo X en la mesa
preconditions( depositar(X), [sostenido(X)] ).
achieves( depositar(X), en_mesa(X) ).
achieves( depositar(X), libre(X) ).
achieves( depositar(_X), brazo_libre ).
deletes( depositar(X), sostenido(X) ).

% tomar(X) : levantar el cubo X de la mesa
preconditions( tomar(X), [en_mesa(X), libre(X), brazo_libre] ).
achieves( tomar(X), sostenido(X) ).
deletes( tomar(X), en_mesa(X) ).
deletes( tomar(X), libre(X) ).
deletes( tomar(_X), brazo_libre ).


%----------------------------------
% PREDICADOS DEL DOMINIO

primitive( sobre(_,_) ).
primitive( en_mesa(_) ).
primitive( sostenido(_) ).
primitive( libre(_) ).
primitive( brazo_libre ).


%----------------------------------
% ESTADO INICIAL

holds(en_mesa(a),init).
holds(sobre(b,a),init).
holds(libre(b),init).
holds(sostenido(c),init).

achieves(init,X) :-
   holds(X,init).
   

% obtenerAccion(X)
obtenerAccion(Accion) :-
	solve([sobre(a,b)],P,6),
	seq(P,[Init,Accion|S]),!.


%
% ejecutarAccion(X)
%
% X es alguna acción. Ejecuta la acción efectivamente, para que así al
% correr otra vez 'obtenerAccion' se realice el paso siguiente. Quita
% o agrega holds(...)
%

ejecutarAccion(apilar(Cubo1,Cubo2)) :-
	retract(holds(sostenido(Cubo1),init)),
	retract(holds(libre(Cubo2),init)),
	assert(holds(sobre(Cubo1,Cubo2),init)),
	assert(holds(libre(Cubo1),init)),
	assert(holds(brazo_libre,init)).
	
ejecutarAccion(desapilar(Cubo1,Cubo2)) :-
	assert(holds(sostenido(Cubo1),init)),
	assert(holds(libre(Cubo2),init)),
	retract(holds(sobre(Cubo1,Cubo2),init)),
	retract(holds(libre(Cubo1),init)),
	retract(holds(brazo_libre,init)).

ejecutarAccion(depositar(Cubo1)) :-
	assert(holds(en_mesa(Cubo1),init)),
	assert(holds(libre(Cubo1),init)),
	assert(holds(brazo_libre,init)),
	retract(holds(sostenido(Cubo1),init)).

ejecutarAccion(tomar(Cubo1)) :-
	retract(holds(en_mesa(Cubo1),init)),
	retract(holds(libre(Cubo1),init)),
	retract(holds(brazo_libre,init)),
	assert(holds(sostenido(Cubo1),init)).

ejecutarAccion(end).



% Pruebas:
% solve([sostenido(a)],P,4),seq(P,S).
% solve([sostenido(a)],P,6),seq(P,S).
% solve([sobre(a,b)],P,6),seq(P,S).
% solve([sobre(a,c),sobre(c,b)],P,8),seq(P,S).
% solve([sobre(c,a)],P,6),seq(P,S).

