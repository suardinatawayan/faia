package frsf.cidisi.faia.state;

import frsf.cidisi.faia.agent.Perception;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:03
 */
public abstract class AgentState extends State {

    public AgentState() {
    }

    public abstract void updateState(Perception p);
}