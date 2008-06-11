package raftasnake;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.state.AgentState;

public class FuncionCosto implements IStepCostFunction {

	public double calculateCost(AgentState agentState) {
		return ((EstadoSnake)agentState).getCosto();
	}

}
