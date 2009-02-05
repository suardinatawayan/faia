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

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusAction;
import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusBasedAgent;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.solver.NoAction;

import java.util.Vector;

public class SituationCalculusBasedAgentSimulator extends GoalBasedAgentSimulator {

    public SituationCalculusBasedAgentSimulator(Environment environment, Vector<Agent> agents) {
        super(environment, agents);
    }

    public SituationCalculusBasedAgentSimulator(Environment environment, Agent agent) {
        super(environment, agent);
    }

    @Override
    public void start() {

        Perception perception;
        Action action;
        SituationCalculusBasedAgent agent;

        //TODO: Aca hay que tener en cuenta que podría haber más de un agente
        // por ahora el framework solo es monoagente :)
        agent = (SituationCalculusBasedAgent) this.getAgents().firstElement();

        do {

            System.out.println("------------------------------------------------");
            System.out.println("--- Situation Calculus Based Agent Simulator ---");
            System.out.println("------------------------------------------------");

            // We make the perception and send it to the agent.
            perception = this.getPercept(agent);
            agent.see(perception);

            System.out.println("Agent State: " + agent.getAgentState());
            System.out.println("Environment: " + environment);
            System.out.println("---------------------------------------");
            System.out.println("---------------------------------------");

            // Ask agent for an action
            action = agent.selectAction();

            System.out.println("Action: " + action);

            /* Check if agent has reached the goal or not, or if we must
             * go on */
            if (action != null && ! (action instanceof NoAction)) {
                /* If the action is not a NoAction instance, then we update
                 * the real world on the simulator. Finally we tell the agent
                 * the action chosen. */
                this.updateState(action);
                agent.tell((SituationCalculusAction)action);
            }
        } while (! (action instanceof NoAction || action == null));

        if (action instanceof NoAction) {
            // If there is no action, then the agent has reached the goal.
            System.out.println("Agent has reached the goal!");
        } else {
            // If action is null, then there was an error.
            System.out.println("ERROR: There is not solution for this problem. You should check the operators.");
        }

        // Leave a blank line
        System.out.println();
    }
}
