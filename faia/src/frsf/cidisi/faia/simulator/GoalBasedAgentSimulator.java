package frsf.cidisi.faia.simulator;

import java.util.Vector;

import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.environment.Environment;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 09-Mar-2007 14:48:38
 */
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
    public abstract void start();
    
    /**
     * Here we update the state of the agent and the real state of the
     * simulator.
     * @param action
     */
    protected void updateState(Action action) {
        this.getEnvironment().updateState(((GoalBasedAgent) agents.elementAt(0)).getAgentState(), action);
    }

    public void showSolution() {
        GoalBasedAgent agent = (GoalBasedAgent) this.getAgents().firstElement();

        agent.getSolver().showSolution();
    }
}
