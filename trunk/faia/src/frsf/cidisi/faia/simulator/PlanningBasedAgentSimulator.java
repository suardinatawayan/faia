package frsf.cidisi.faia.simulator;

import java.util.Vector;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.planning.PlanningAction;
import frsf.cidisi.faia.agent.planning.PlanningBasedAgent;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.solver.planning.PlanningNoAction;

public class PlanningBasedAgentSimulator extends GoalBasedAgentSimulator {

	public PlanningBasedAgentSimulator(Environment environment, Vector<Agent> agents) {
        super(environment, agents);
    }

    public PlanningBasedAgentSimulator(Environment environment, Agent agent) {
        super(environment, agent);
    }
	
	@Override
	public void start() {
		Perception perception;
        PlanningAction action;
        PlanningBasedAgent agent;

        //TODO: Aca hay que tener en cuenta que podría haber más de un agente
        // por ahora el framework solo es monoagente :)
        agent = (PlanningBasedAgent) this.getAgents().firstElement();

        do {

            System.out.println("--------------------------------------");
            System.out.println("--- Planning Based Agent Simulator ---");
            System.out.println("--------------------------------------");

            // We make the perception and send it to the agent.
            perception = this.getPercept(agent);
            agent.see(perception);

            System.out.println("Agent State: " + agent.getAgentState());
            System.out.println("Environment: " + environment);
            System.out.println("---------------------------------------");
            System.out.println("---------------------------------------");

            // Ask agent for an action
            action = (PlanningAction) agent.selectAction();

            System.out.println("Action: " + action);

            /* Check if agent has reached the goal or not, or if we must
             * go on */
            if (action != null && ! (action instanceof PlanningNoAction)) {
                /* If the action is not a NoAction instance, then we update
                 * the real world on the simulator. */
                this.updateState(action);
            }
        } while (! (action instanceof PlanningNoAction || action == null));

        if (action instanceof PlanningNoAction) {
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
