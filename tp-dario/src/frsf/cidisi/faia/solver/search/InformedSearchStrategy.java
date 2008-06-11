package frsf.cidisi.faia.solver.search;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 09-Mar-2007 14:13:32
 */
public abstract class InformedSearchStrategy extends Strategy {

	private IStepCostFunction g;

	public InformedSearchStrategy(){

	}

	public IStepCostFunction getStepCostFunction(){
		return null;
	}

}