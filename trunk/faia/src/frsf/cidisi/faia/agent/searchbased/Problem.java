package frsf.cidisi.faia.agent.searchbased;

import java.util.Vector;

import frsf.cidisi.faia.state.AgentState;

public class Problem {

    protected GoalTest goalTest;
    protected SearchBasedAgentState agentState;
    protected Vector<SearchAction> actions;

    /**
     * 
     * @param goalTest
     * @param initState
     * @param action
     */
    public Problem(GoalTest goalTest, SearchBasedAgentState initState, Vector<SearchAction> actions) {
        this.goalTest = goalTest;
        this.agentState = initState;
        this.actions = actions;
    }

    public Vector<SearchAction> getActions() {
        return actions;
    }

    public GoalTest getGoalState() {
        return goalTest;
    }

    public SearchBasedAgentState getAgentState() {
        return agentState;
    }

    public void setActions(Vector<SearchAction> actions) {
        this.actions = actions;
    }

    public void setGoalState(GoalTest goalTest) {
        this.goalTest = goalTest;
    }

    public void setAgentState(SearchBasedAgentState agentState) {
        this.agentState = agentState;
    }
}