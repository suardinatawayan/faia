package frsf.cidisi.faia.solver.search;

import java.util.Vector;
/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 18:21:43
 */
public class UniformCostSearch extends Strategy {
	private IStepCostFunction stepCostFunction;


	public UniformCostSearch(IStepCostFunction stepCostFunction){
		this.stepCostFunction = stepCostFunction;
	}

	public void addNodesToExpand(Vector<NTree> nodes){
		//Add the nodes at the bottom of the list of nodes to expand
		for (NTree nt : nodes)
			nt.setCost(nt.getParent().getCost() + stepCostFunction.calculateCost(nt));
		
		nodesToExpand.addAll(nodes);
	}

	public void addNodeToExpand(NTree node){
		//Add the node at the top of the list of nodes to expand
		node.setCost(node.getParent().getCost() + stepCostFunction.calculateCost(node));
		nodesToExpand.add(node);
	}

	public IStepCostFunction getStepCostFunction(){
		return stepCostFunction;
	}

	public void setStepCostFunction(IStepCostFunction stepCostFunction) {
		this.stepCostFunction = stepCostFunction;
	}

	@Override
	public String getStrategyName() {
		return "Uniform cost (Costo uniforme)";
	}

}