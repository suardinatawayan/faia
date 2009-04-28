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

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * Esta clase permite definir una función para ser utilizada en
 * alguna estrategia de búsqueda informada, como A Estrella y
 * Avara.
 */
public class Heuristica implements IEstimatedCostFunction {

	/**
	 * Esta función puede ser personalizada para calcular el costo
	 * estimado de llegar al objetivo, desde el nodo que se recibe
	 * como parámetro.
	 */
    @Override
    public double getEstimatedCost(NTree node) {
        EstadoPacman estP = (EstadoPacman) node.getAgentState();

        return (estP.getCeldasDesconocidas() + estP.getComidaRestante());
    }
}
