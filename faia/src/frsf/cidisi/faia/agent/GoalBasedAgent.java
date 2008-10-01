package frsf.cidisi.faia.agent;

import frsf.cidisi.faia.solver.Solve;
import frsf.cidisi.faia.state.AgentState;

public abstract class GoalBasedAgent extends Agent {

    protected Solve solver;
    protected AgentState state;

    public GoalBasedAgent() {
    }

    /**
     * This method must be overrode by the agent to receive perceptions
     * from the simulator.
     * @param p
     */
    public abstract void see(Perception p);

    public Solve getSolver() {
        return solver;
    }

    public void setSolver(Solve solver) {
        this.solver = solver;
    }

    public AgentState getAgentState() {
        return state;
    }

    public void setAgentState(AgentState agentState) {
        this.state = agentState;
    }

    public AgentState getState() {
        return state;
    }

    public void setState(AgentState state) {
        this.state = state;
    }
}