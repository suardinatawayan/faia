package frsf.cidisi.faia.agent.problem;

import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:03
 */
public abstract class Action {

    protected double cost;

    public Action() {
    }

    /**
     * This method is used internally by the framework when the "Search Process" is being executed.
     * It updates the node's state on every node of the search tree. Therefore, it doesn't updates the real
     * agent's state, it just updates the state of the agent on every node of the search tree.-
     * 
     * @param s This is the state of the agent to be updated on search tree's node.-
     */
    public abstract AgentState execute(AgentState s);

    /**
     * This method is used internally by the framework when the "Search Process" is being executed.
     * It updates the real state of the agent and the environment.-
     * 
     * @param ast This is the agent's state to be updated.-
     * @param est This is the agent's environment to be updated.-
     */
    public abstract EnvironmentState execute(AgentState ast, EnvironmentState est);

    public abstract Double getCost();

    public abstract String toString();

    public String getLogicName() {
        return this.toString().toLowerCase();
    }
}