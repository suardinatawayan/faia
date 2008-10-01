package frsf.cidisi.faia.agent;

public abstract class Agent {

    public Agent() {
    }
    
    /**
     * This is a method executed by the simulator to ask the agent for an
     * action.
     * @return The action chosen by the agent.
     */
    public abstract Action selectAction();
}