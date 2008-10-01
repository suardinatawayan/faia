package frsf.cidisi.faia.environment;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.cidisi.faia.state.AgentState;

public abstract class Environment {

    protected EnvironmentState environmentState;

    /**
     * This method updates the state of the simulator, that is the real world.
     * @param ast The state of the Agent
     * @param action
     */
    public void updateState(AgentState ast, Action action) {
        environmentState = (EnvironmentState) action.execute(ast, environmentState);
    }

    public void setEnvironmentState(EnvironmentState state) {
        environmentState = state;
    }

    public EnvironmentState getEnvironmentState() {
        return environmentState;
    }

    /**
     * This method will return a perception made by the subclass of Environment
     * @param agent
     * @return
     */
    public abstract Perception getPercept(Agent agent);
}
