package frsf.cidisi.faia.solver.search;

import java.util.Vector;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 09-Mar-2007 14:13:32
 */
public abstract class InformedSearchStrategy extends Strategy {

	private IStepCostFunction g;
	private IEstimatedCostFunction h;

	public InformedSearchStrategy(IStepCostFunction g, IEstimatedCostFunction h){
		this.g = g;
		this.h = h;
	}
	
	public InformedSearchStrategy(IStepCostFunction g) {
		this.g = g;
		this.h = DummyEstimatedCostFunction.getInstance();
	}
	
	@Override
	public void addNodesToExpand(Vector<NTree> nodes){
		//Add the nodes at the top of the list of nodes to expand
		for (NTree nt : nodes)
			nt.setCost(nt.getParent().getCost() + g.calculateCost(nt)
					+ h.getEstimatedCost(nt));
		
		nodesToExpand.addAll(nodes);
	}

	@Override
	public void addNodeToExpand(NTree node){
		//Add the node at the top of the list of nodes to expand
		node.setCost(node.getParent().getCost() + g.calculateCost(node)
				+ h.getEstimatedCost(node));
		nodesToExpand.add(node);
	}

	public IStepCostFunction getStepCostFunction(){
		return g;
	}
	
	public IEstimatedCostFunction getEstimatedCostFunction() {
		return h;
	}

}