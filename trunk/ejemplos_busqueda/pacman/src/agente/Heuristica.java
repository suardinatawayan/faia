package agente;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * Esta clase permite definir una función para ser utilizada en
 * alguna estrategia de búsqueda informada, como A Estrella y
 * Avara.
 */
public class Heuristica implements IEstimatedCostFunction {

	/**
	 * Esta función puede ser personalizada para calcular el costo
	 * estimado de llegar al objetivo, desde el nodo que se recibe
	 * como parámetro.
	 */
    @Override
    public double getEstimatedCost(NTree node) {
        EstadoPacman estP = (EstadoPacman) node.getAgentState();

        return (estP.getCeldasDesconocidas() + estP.getComidaRestante());
    }
}
