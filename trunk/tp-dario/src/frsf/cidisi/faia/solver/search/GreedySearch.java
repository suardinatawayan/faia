package frsf.cidisi.faia.solver.search;
import java.util.Vector;
/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 09-Mar-2007 14:13:45
 */
public class GreedySearch extends InformedSearchStrategy {

	public GreedySearch(){

	}

	public void addNodesToExpand(Vector<NTree> nodes){
		//Add the nodes at the top of the list of nodes to expand
		nodesToExpand.addAll(0, nodes);
	}

	public void addNodeToExpand(NTree node){
		//Add the node at the top of the list of nodes to expand
		nodesToExpand.addElement(node);
	}

}