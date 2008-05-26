package frsf.cidisi.faia.solver.search;
import java.util.Vector;
/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 09-Mar-2007 14:27:40
 */
public class AStarSearch extends InformedSearchStrategy {

	public AStarSearch(IStepCostFunction g, IEstimatedCostFunction h){
		super(g, h);
	}

	@Override
	public String getStrategyName() {
		return "A Star (A Estrella)";
	}

}