package frsf.cidisi.faia.simulator;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.NoAction;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.environment.Environment;

public class ReactiveBasedAgentSimulator extends GoalBasedAgentSimulator {

	public ReactiveBasedAgentSimulator(Environment environment, Agent agent) {
		super(environment, agent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		Perception perception;
        Action action;
        SearchBasedAgent agent;

        //TODO: Aca hay que tener en cuenta que podría haber más de un agente
        // por ahora el framework solo es monoagente :)
        agent = (SearchBasedAgent) this.getAgents().firstElement();

        do {

            System.out.println("------------------------------------------------");
            System.out.println("--- Simple Simulator ---");
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
            if (action != null) {
                this.updateState(action);
            } else {
                break;
            }
        } while (! (action instanceof NoAction || action == null));

//        if (action instanceof NoAction) {
//            // If there is no action, then the agent has reached the goal.
            System.out.println("Agent has reached the goal!");
//        } else {
//            // If action is null, then there was an error.
//            System.out.println("ERROR: There is not solution for this problem. You should check the operators.");
//        }

        // Leave a blank line
        System.out.println();
	}

}
