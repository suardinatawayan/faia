/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa
 * y Milton Pividori.
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

package frsf.cidisi.faia.examples.search.robot.actions;

import frsf.cidisi.faia.examples.search.robot.EstadoRobot;
import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrB extends SearchAction {

    /**
     * 
     * @param s: Es el estado del agente en un determinado nodo del �rbol de b�squeda.-
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoRobot estR = (EstadoRobot) s;

        if (estR.getPosicionesVisitadas().contains(EstadoRobot.B)) {
            return null;
        }
        ArrayList<String> sucesores = new ArrayList<String>(estR.getSucesores());
        if (sucesores != null) {
            int index = sucesores.indexOf(EstadoRobot.B);
            if (index >= 0) {
                estR.setPosicion(EstadoRobot.B);

                return estR;
            }
        }

        return null;
    }

    /**
     * Permite actualizar el estado real del agente y del ambiente.-
     * 
     * @param ast: Es el estado del agente a ser actualizado.-
     * @param est: Es el estado del ambiente a ser actualizado.-
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        this.execute((SearchBasedAgentState)ast);

        return null;
    }

    @Override
    public Double getCost() {
        return new Double(0);
    }

    @Override
    public String toString() {
        return "IrB";
    }
}
