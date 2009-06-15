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

package frsf.cidisi.faia.simulator;

import java.util.Vector;

import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.NoAction;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.simulator.events.EventType;
import frsf.cidisi.faia.simulator.events.SimulatorEventNotifier;

public abstract class GoalBasedAgentSimulator extends Simulator {

    /**
     * 
     * @param environment
     */
    public GoalBasedAgentSimulator(Environment environment, Vector<Agent> agents) {
        super(environment, agents);
    }

    public GoalBasedAgentSimulator(Environment environment, Agent agent) {
        Vector<Agent> ags = new Vector<Agent>();
        ags.add(agent);

        this.environment = environment;
        this.agents = ags;
    }
    
    @Override
    public void start() {
    	
    	System.out.println("----------------------------------------------------");
        System.out.println("--- " + this.getSimulatorName() + " ---");
        System.out.println("----------------------------------------------------");
        System.out.println();
    	
        Perception perception;
        Action action;
        GoalBasedAgent agent;
        
        agent = (GoalBasedAgent) this.getAgents().firstElement();

        do {
        	
        	System.out.println("------------------------------------");
        	
        	System.out.println("Sending perception to agent...");
            perception = this.getPercept(agent);
            agent.see(perception);
            
            System.out.println("Agent State: " + agent.getAgentState());
            System.out.println("Environment: " + environment);
            
            System.out.println("Asking the agent for an action...");
            action = agent.selectAction();
            
            if (action == null)
            	break;
            
            System.out.println("Action returned: " + action);
            System.out.println();
            
            this.iterationFinished(agent, action);
            
        } while (!isComplete(action));

        // Check what happened, if agent has reached the goal or not.
        if (this.isComplete(action)) {
            System.out.println("Agent has reached the goal!");
        } else {
            System.out.println("ERROR: The simulation has finished, but the agent has not reached his goal.");
        }
        
        // Leave a blank line
        System.out.println();
        
        // Launch simulationFinished event
        SimulatorEventNotifier.runEventHandlers(EventType.SimulationFinished, null);
    }
    
    /**
     * Here we update the state of the agent and the real state of the
     * simulator.
     * @param action
     */
    protected void updateState(Action action) {
        this.getEnvironment().updateState(((GoalBasedAgent) agents.elementAt(0)).getAgentState(), action);
    }
    
//    private Action getAction(Action actionReturnedByAgent) {
//    	Action action = actionReturnedByAgent;
//    	
//    	if (action == null)
//    		action = NoAction.getInstance();
//    	
//    	return action;
//    }
    
    public abstract boolean isComplete(Action actionReturned);
    
    public abstract void iterationFinished(Agent agent, Action action);
    
    public abstract String getSimulatorName();
}
