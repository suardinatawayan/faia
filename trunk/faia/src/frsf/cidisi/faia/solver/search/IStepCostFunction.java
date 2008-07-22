package frsf.cidisi.faia.solver.search;

import frsf.cidisi.faia.state.AgentState;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 09-Mar-2007 14:12:41
 */
public interface IStepCostFunction {

    /**
     * 
     * @param agentState
     */
    public double calculateCost(NTree node);
}