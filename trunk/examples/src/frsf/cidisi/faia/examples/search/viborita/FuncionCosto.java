package frsf.cidisi.faia.examples.search.viborita;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;
import frsf.cidisi.faia.state.AgentState;

public class FuncionCosto implements IStepCostFunction {

    public double calculateCost(AgentState agentState) {
        return ((EstadoSnake) agentState).getCosto();
    }

    @Override
    public double calculateCost(NTree node) {
        // TODO Auto-generated method stub
        return 0;
    }
}
