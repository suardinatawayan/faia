package frsf.cidisi.faia.solver.planning;

import java.util.Hashtable;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.solver.PrologConnector;
import frsf.cidisi.faia.state.AgentState;

public abstract class PlanningBasedAgentState extends AgentState {

	protected PrologConnector prologConnector;
	
	public PlanningBasedAgentState(String prologFile) throws PrologConnectorException {
		this.prologConnector = new PrologConnector(prologFile);
	}
	
	public void addInitState(String state) {
		String query = "holds(" + state + ", init).";
		this.prologConnector.executeNonQuery(query);
	}
	
	public Hashtable[] query(String query) {
    	return this.prologConnector.query("holds(" + query + ", init).");
    }
	
	public boolean queryHasSolution(String query) {
    	return this.prologConnector.queryHasSolution(query);
    }
}
