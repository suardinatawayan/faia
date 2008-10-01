package frsf.cidisi.faia.solver.search;

/**
 * This interface can be used to define a function to
 * calculate some NTree's estimated cost.
 */
public interface IEstimatedCostFunction {
	
    public abstract double getEstimatedCost(NTree node);
}
