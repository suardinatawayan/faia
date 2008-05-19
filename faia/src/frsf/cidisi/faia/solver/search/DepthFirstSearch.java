package frsf.cidisi.faia.solver.search;

import java.util.Vector;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:04
 */
public class DepthFirstSearch extends Strategy {
	
	public DepthFirstSearch(){
	}
	
	public void addNodesToExpand(Vector<NTree> nodes){
		//Add the nodes at the top of the list of nodes to expand
		nodesToExpand.addAll(0, nodes);
	}

	public void addNodeToExpand(NTree node){
		//Add the node at the top of the list of nodes to expand
		nodesToExpand.add(0,node);
	}

	@Override
	public String getStrategyName() {
		return "Depth First (Primero en profundidad)";
	}
	
}