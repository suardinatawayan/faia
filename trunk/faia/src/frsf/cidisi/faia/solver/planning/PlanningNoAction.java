/*
 * Copyright 2007-2008 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa
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

package frsf.cidisi.faia.solver.planning;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.planning.PlanningAction;
import frsf.cidisi.faia.solver.NoAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class PlanningNoAction extends PlanningAction {

	private static PlanningNoAction instance;
	
    private PlanningNoAction() {
    	
    }
    
    public static PlanningNoAction getInstance() {
        if (instance == null)
            instance = new PlanningNoAction();
        
        return instance;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String toString() {
        return "NoAction";
    }
}
