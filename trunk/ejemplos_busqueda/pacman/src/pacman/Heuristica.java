package pacman;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class Heuristica implements IEstimatedCostFunction {

	@Override
	public double getEstimatedCost(NTree node) {
		EstadoPacman estP = (EstadoPacman)node.getAgentState();
		
		return (estP.getCeldasDesconocidas() + estP.getComidaRestante());
	}

}
