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

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

/**
 * Esta clase se utiliza para definir una función que, recibido 
 * un objeto estado del agente, verifique si se ha llegado al objetivo o no.
 * Se utiliza en el proceso interno de búsqueda del agente y también en
 * el simulador, para saber cuándo detenerse.
 */
public class MetaPacman extends GoalTest {

    public boolean isGoalState(AgentState agentState) {
        if (((EstadoPacman) agentState).noHayMasComida() & ((EstadoPacman) agentState).todoConocido()) {
            return true;
        }
        return false;
    }
}
