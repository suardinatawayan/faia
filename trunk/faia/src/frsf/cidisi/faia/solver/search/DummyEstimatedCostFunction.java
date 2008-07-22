package frsf.cidisi.faia.solver.search;

public class DummyEstimatedCostFunction implements IEstimatedCostFunction {

    private static DummyEstimatedCostFunction h;

    @Override
    public double getEstimatedCost(NTree agentState) {
        return 0;
    }

    public static IEstimatedCostFunction getInstance() {
        if (h == null) {
            h = new DummyEstimatedCostFunction();
        }
        return h;
    }
}
