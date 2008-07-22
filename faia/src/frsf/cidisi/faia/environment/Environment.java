package frsf.cidisi.faia.environment;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.cidisi.faia.state.AgentState;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:04
 */
public abstract class Environment {

    protected EnvironmentState environmentState;

    public void updateState(AgentState ast, Action action) {
        //State state = (State)environmentState;
        environmentState = (EnvironmentState) action.execute(ast, environmentState);
    }

    public void setEnvironmentState(EnvironmentState state) {
        environmentState = state;
    }

    public EnvironmentState getEnvironmentState() {
        return environmentState;
    }

    public abstract Perception getPercept(Agent agent);
}