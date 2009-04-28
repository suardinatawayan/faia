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

package frsf.cidisi.faia.examples.search.pacman;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * Esta clase se puede utilizar en alguna estrategia de búsqueda
 * como Costo Uniforme.
 */
public class FuncionCosto implements IStepCostFunction {

	/**
	 * Este método calcula el costo de un determinado nodo que
	 * se recibe como argumento. Esto puede ser personalizado y se
	 * puede utilizar cualquier función de costo.
	 */
    @Override
    public double calculateCost(NTree node) {
        // TODO Auto-generated method stub
        return ((EstadoPacman) node.getAgentState()).getCeldasVisitadas();
    }
}
