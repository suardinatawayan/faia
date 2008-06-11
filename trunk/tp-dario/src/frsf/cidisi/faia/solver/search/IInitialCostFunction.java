package frsf.cidisi.faia.solver.search;
import frsf.cidisi.faia.state.AgentState;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 09-Mar-2007 14:13:07
 */
public interface IInitialCostFunction {

	/**
	 * 
	 * @param agentState
	 */
	public abstract double getInitialCost(AgentState agentState);

}