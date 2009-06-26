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

package frsf.cidisi.faia.examples.planning.cubes;

import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.planning.PlanningBasedAgent;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.solver.planning.Planning;

public class AgenteCubos extends PlanningBasedAgent {

	public AgenteCubos() throws PrologConnectorException {
		EstadoCubos estadoCubos = new EstadoCubos();
		this.setAgentState(estadoCubos);
	}
	
	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
	}

	@Override
	public Action selectAction() {
		Planning planning = new Planning();
        this.setSolver(planning);
        
        Action accionSeleccionada = null;
        try {
            accionSeleccionada =
                    this.getSolver().solve(new Object[]{this});
        } catch (Exception ex) {
            Logger.getLogger(AgenteCubos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return accionSeleccionada;
	}
	
	@Override
	public EstadoCubos getAgentState() {
		EstadoCubos estado = (EstadoCubos)super.getAgentState();
		
		return estado;
	}

}
