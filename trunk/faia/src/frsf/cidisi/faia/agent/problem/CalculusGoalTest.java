package frsf.cidisi.faia.agent.problem;

import frsf.cidisi.faia.solver.calculus.KnowledgeBase;
import frsf.cidisi.faia.state.AgentState;

public class CalculusGoalTest extends GoalTest {
	
	private static CalculusGoalTest instance;

	private CalculusGoalTest() {}
	
	public static CalculusGoalTest getInstance() {
		if (instance == null)
			instance = new CalculusGoalTest();
		
		return instance;
	}
	
	@Override
	public boolean isGoalState(AgentState agentState) {
		KnowledgeBase kb = (KnowledgeBase)agentState;
		
		return kb.goalReached();
	}

}
