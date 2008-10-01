package frsf.cidisi.faia.state;

import frsf.cidisi.faia.agent.Perception;

/**
 * This is the internal state of the agent, his vision of the world.
 */
public abstract class AgentState extends State {

    public AgentState() {
    }

    /**
     * We need to be able to clone an AgentState, because we'll use it
     * in the search process, when we apply the operations on a node.
     */
    public abstract Object clone();
    
    /**
     * This method updates the agent's state when receive a perception
     * from the simulator. 
     */
    public abstract void updateState(Perception p);
    
    /**
     * We need this method to look for repeted nodes in the same search branch.
     */
    @Override
    public abstract boolean equals(Object obj);
}
