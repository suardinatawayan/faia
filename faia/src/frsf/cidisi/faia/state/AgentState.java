package frsf.cidisi.faia.state;

import frsf.cidisi.faia.agent.Perception;

/**
 * This is the internal state of the agent, his vision of the world.
 */
public abstract class AgentState extends State {

    public AgentState() {
    }
    
    /**
     * This method updates the agent's state when receive a perception
     * from the simulator. 
     */
    public abstract void updateState(Perception p);
    
}
