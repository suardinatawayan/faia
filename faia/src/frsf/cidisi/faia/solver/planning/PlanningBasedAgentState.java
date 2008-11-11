package frsf.cidisi.faia.solver.planning;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.solver.PrologConnector;
import frsf.cidisi.faia.state.AgentState;

public abstract class PlanningBasedAgentState extends AgentState {

	private PrologConnector prologConnector;
	
	public PlanningBasedAgentState(String prologFile) throws PrologConnectorException {
		this.prologConnector = new PrologConnector(prologFile);
	}
	
	@Override
	public void updateState(Perception p) {
		// TODO Aquí irían asserts
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
