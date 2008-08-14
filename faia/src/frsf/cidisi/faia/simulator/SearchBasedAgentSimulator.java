/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.simulator;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.SearchBasedAgent;
import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.GoalTest;
import frsf.cidisi.faia.agent.problem.Problem;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.state.AgentState;
import java.util.Vector;

/**
 *
 * @author miltondp
 */
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

    public void start() {
        //TODO:
        // ANTES DE EMPEZAR CON LA SIMULACION HAY QUE TESTEAR QUE EL AMBIENTE ESTE
        // INICIALIZADO, ETC.

        Perception perception;
        Action action;
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


            action = agent.selectAction();
            System.out.println("Action: " + action);
            if (action != null) {
                this.updateState(action);
            } else {
                break;
            }
            showSolution();
        }

        // Check what happend, if agent has reached the goal or not.
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
