package frsf.cidisi.faia.agent.problem;

import java.util.Vector;

import frsf.cidisi.faia.state.AgentState;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:05
 */
public class Problem {

    protected GoalTest goalTest;
    protected AgentState agentState;
    protected Vector<Action> actions;

    /**
     * 
     * @param goalTest
     * @param initState
     * @param action
     */
    public Problem(GoalTest goalTest, AgentState initState, Vector<Action> actions) {
        this.goalTest = goalTest;
        this.agentState = initState;
        this.actions = actions;
    }

    public Vector<Action> getActions() {
        return actions;
    }

    public GoalTest getGoalState() {
        return goalTest;
    }

    public AgentState getAgentState() {
        return agentState;
    }

    public void setActions(Vector<Action> actions) {
        this.actions = actions;
    }

    public void setGoalState(GoalTest goalTest) {
        this.goalTest = goalTest;
    }

    public void setAgentState(AgentState agentState) {
        this.agentState = agentState;
    }
}