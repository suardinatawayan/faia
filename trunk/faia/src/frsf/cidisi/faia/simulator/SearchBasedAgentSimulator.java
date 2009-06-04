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

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.state.AgentState;
import java.util.Vector;

public class SearchBasedAgentSimulator extends GoalBasedAgentSimulator {

    public SearchBasedAgentSimulator(Environment environment, Vector<Agent> agents) {
        super(environment, agents);
    }

    public SearchBasedAgentSimulator(Environment environment, Agent agent) {
        super(environment, agent);
    }

    public boolean isComplete() {
        //TODO: 
        // ACA HAY QUE HACER UN BUCLE PARA CUANDO HAY MAS DE UN AGENTE DEFINIDO
        // POR AHORA EL FRAMEWORK ES MONOAGENTE :)
        SearchBasedAgent sa = (SearchBasedAgent) getAgents().firstElement();
        Problem p = sa.getProblem();
        GoalTest gt = p.getGoalState();
        AgentState aSt = p.getAgentState();

        return gt.isGoalState(aSt);
    }

    @Override
    public void start() {
        //TODO:
        // ANTES DE EMPEZAR CON LA SIMULACION HAY QUE TESTEAR QUE EL AMBIENTE ESTE
        // INICIALIZADO, ETC.

        Perception perception;
        SearchAction action;
        GoalBasedAgent agent;

        //TODO: Aca hay que tener en cuenta que podr�a haber m�s de un agente
        // por ahora el framework solo es monoagente :)
        agent = (GoalBasedAgent) this.getAgents().firstElement();

        while (!isComplete()) {
            System.out.println("------------------------------------");
            System.out.println("--- Search Based Agent Simulator ---");
            System.out.println("------------------------------------");
            perception = this.getPercept(agent);
            agent.see(perception);

            System.out.println("Agent State: " + agent.getAgentState());
            System.out.println("Environment: " + environment);
            System.out.println("------------------------------------");
            System.out.println("------------------------------------");


            action = (SearchAction) agent.selectAction();
            
            System.out.println("Action: " + action);
            
            if (action != null) {
                this.updateState(action);
            } else {
                break;
            }
            showSolution();
        }

        // Check what happened, if agent has reached the goal or not.
        if (this.isComplete()) {
            System.out.println("Agent has reached the goal!");
        } else {
            System.out.println("ERROR: There is not solution for this problem. You should check the operators.");
        }
        
        // Leave a blank line
        System.out.println();
        
        // Launch simulationFinished event
        SimulatorEventNotifier.simulationFinished();
    }
}
