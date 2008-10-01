package frsf.cidisi.faia.solver.search;

/**
 * This interface can be used to define a custom function
 * to calculate some NTree's cost.
 */
public interface IStepCostFunction {
	
    public double calculateCost(NTree node);
}