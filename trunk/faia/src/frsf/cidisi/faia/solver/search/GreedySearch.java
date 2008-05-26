package frsf.cidisi.faia.solver.search;
/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 09-Mar-2007 14:13:45
 */
public class GreedySearch extends InformedSearchStrategy {

	public GreedySearch(IEstimatedCostFunction h){
		super(h);
	}

	@Override
	public String getStrategyName() {
		// TODO Auto-generated method stub
		return "Greedy (Avara)";
	}

}