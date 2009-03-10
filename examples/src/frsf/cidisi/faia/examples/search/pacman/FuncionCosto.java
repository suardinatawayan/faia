package frsf.cidisi.faia.examples.search.pacman;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * Esta clase se puede utilizar en alguna estrategia de búsqueda
 * como Costo Uniforme.
 */
public class FuncionCosto implements IStepCostFunction {

	/**
	 * Este método calcula el costo de un determinado nodo que
	 * se recibe como argumento. Esto puede ser personalizado y se
	 * puede utilizar cualquier función de costo.
	 */
    @Override
    public double calculateCost(NTree node) {
        // TODO Auto-generated method stub
        return ((EstadoPacman) node.getAgentState()).getCeldasVisitadas();
    }
}
