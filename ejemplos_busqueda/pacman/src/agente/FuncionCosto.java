package agente;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class FuncionCosto implements IStepCostFunction {

    @Override
    public double calculateCost(NTree node) {
        // TODO Auto-generated method stub
        return ((EstadoPacman) node.getAgentState()).getCeldasVisitadas();
    }
}
