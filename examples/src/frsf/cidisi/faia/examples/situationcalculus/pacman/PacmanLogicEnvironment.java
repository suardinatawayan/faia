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
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

/**
 * This class is similar to PacmanEnvironment class in the Pacman (Search)
 * example.
 */
public class PacmanLogicEnvironment extends Environment {

    public PacmanLogicEnvironment() {
        // Create the environment state
        this.environmentState = new PacmanLogicEnvironmentState();
    }
    
    /**
     * This method is similar to the one explained in the Pacman (Search)
     * example. The difference is that here we use Prolog to query the agent
     * state.
     */
    @Override
    public Perception getPercept(Agent agent) {
        PacmanLogicPerception perception = new PacmanLogicPerception();

        // Get the agent and the agent state objects
        PacmanLogicAgent pacmanAgent = (PacmanLogicAgent) agent;
        PacmanLogicAgentState agentState = (PacmanLogicAgentState) pacmanAgent.getAgentState();

        // Get the actual position of the agent
        int row = agentState.getRow();
        int col = agentState.getColumn();

        // Set the sensors
        perception.setTopSensor(this.getTopCell(row, col));
        perception.setLeftSensor(this.getLeftCell(row, col));
        perception.setRightSensor(this.getRightCell(row, col));
        perception.setBottomSensor(this.getBottomCell(row, col));

        perception.setRow(row);
        perception.setColumn(col);

        perception.setSituation(agentState.getSituation());
        
        // Return the new perception
        return perception;
    }

    @Override
    public String toString() {
        return environmentState.toString();
    }

    @Override
    public boolean agentFailed(Action actionReturned) {
        // TODO: This method is not implemented yet
        return false;
    }
    
    // These methods are internal
    
    public int getTopCell(int row, int col) {
        return ((PacmanLogicEnvironmentState) this.environmentState).getTopCell(row, col);
    }

    public int getLeftCell(int row, int col) {
        return ((PacmanLogicEnvironmentState) this.environmentState).getLeftCell(row, col);
    }

    public int getRightCell(int row, int col) {
        return ((PacmanLogicEnvironmentState) this.environmentState).getRightCell(row, col);
    }

    public int getBottomCell(int row, int col) {
        return ((PacmanLogicEnvironmentState) this.environmentState).getBottomCell(row, col);
    }
}
