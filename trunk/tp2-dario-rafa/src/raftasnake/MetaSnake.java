package raftasnake;

import frsf.cidisi.faia.agent.problem.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class MetaSnake extends GoalTest {

	@Override
	public boolean isGoalState(AgentState agentState) {
		if (((EstadoSnake)agentState).noHayMasComida() && 
				((EstadoSnake)agentState).todoConocido() && 
				((EstadoSnake)agentState).getVivo())
			return true;
			
		return false;
	}

}
