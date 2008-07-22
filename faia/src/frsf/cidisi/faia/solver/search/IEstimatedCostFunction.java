package frsf.cidisi.faia.solver.search;

import frsf.cidisi.faia.state.AgentState;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 09-Mar-2007 14:13:17
 */
public interface IEstimatedCostFunction {

    /**
     * 
     * @param agentState
     */
    public abstract double getEstimatedCost(NTree node);
}