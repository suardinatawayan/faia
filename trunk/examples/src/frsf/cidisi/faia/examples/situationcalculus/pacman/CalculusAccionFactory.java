/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa,
 * Luis Ignacio Larrateguy y Milton Pividori.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package frsf.cidisi.faia.examples.situationcalculus.pacman;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.ActionFactory;
import frsf.cidisi.faia.examples.situationcalculus.pacman.actions.*;

/**
 * Cuando el Solver (en este caso la clase Calculus) pide la mejor acción
 * al agente (ver el método solve()), recibe de la base de conocimiento
 * un string que representa a la acción elegida. Sin embargo, el método
 * solve debe devolver un *objeto* Action.
 * Esta clase es utilizada para transformar un string en un objeto Action, y
 * debe ser implementada por el usuario.
 * Se utiliza el patrón Singleton.
 */
public class CalculusAccionFactory extends ActionFactory {
	
    private static CalculusAccionFactory instancia;

    private CalculusAccionFactory() {
    }

    public static CalculusAccionFactory getInstance() {
        if (instancia == null) {
            instancia = new CalculusAccionFactory();
        }
        return instancia;
    }

    /**
     * El método es sencillo: recibe un string y devuelve un objeto
     * Action, dependiendo del valor de ese string.
     */
    @Override
    public Action stringToAction(String stringAction) {
        if (stringAction.equals("abajo")) {
            return new IrAbajo();
        } else if (stringAction.equals("arriba")) {
            return new IrArriba();
        } else if (stringAction.equals("derecha")) {
            return new IrDerecha();
        } else if (stringAction.equals("izquierda")) {
            return new IrIzquierda();
        } else if (stringAction.equals("comer")) {
            return new Comer();
        } else if (stringAction.equals("pelear")) {
            return new Pelear();
        }
        
        return null;
    }

    /** Retornamos el string que utilizamos en 'base_conocimiento.pl'
     * (el archivo prolog) en el predicado mejorAccion cuando se ha
     * cumplido el objetivo.
     * Esta es la línea donde, en el ejemplo, se utiliza una acción
     * tipo 'noAccion' para indicar que hemos llegado al objetivo:
     * 
     *   mejorAccion(noAccion,S):-cumplioObjetivo(S),!.
     *   
     */
    @Override
    public String endActionString() {
        return "noAccion";
    }
}
