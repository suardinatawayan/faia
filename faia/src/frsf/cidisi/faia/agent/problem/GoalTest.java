package frsf.cidisi.faia.agent.problem;

import frsf.cidisi.faia.state.AgentState;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:04
 */
public abstract class GoalTest {

    public GoalTest() {
    }

    public abstract boolean isGoalState(AgentState agentState);
}