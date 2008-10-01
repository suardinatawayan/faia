package frsf.cidisi.faia.solver.search;

/**
 * This class is used by the InformedSearchStrategy constructors to set
 * a dummy estimated cost function when making a Greedy search object.
 */
public class DummyStepCostFunction implements IStepCostFunction {

    private static DummyStepCostFunction g;

    @Override
    public double calculateCost(NTree node) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static IStepCostFunction getInstance() {
        if (g == null) {
            g = new DummyStepCostFunction();
        }
        return g;
    }
}
