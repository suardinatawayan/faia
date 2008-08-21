package frsf.cidisi.faia.agent;

import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:03
 */
public abstract class Action {

    public Action() {
    }
    
    /**
     * This method updates the real state of the agent and the environment.-
     * 
     * @param ast This is the agent's state to be updated.-
     * @param est This is the agent's environment to be updated.-
     */
    public abstract EnvironmentState execute(AgentState ast, EnvironmentState est);

    @Override
    public abstract String toString();
}