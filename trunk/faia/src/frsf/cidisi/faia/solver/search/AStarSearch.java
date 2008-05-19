package frsf.cidisi.faia.solver.search;
import java.util.Vector;
/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 09-Mar-2007 14:27:40
 */
public class AStarSearch extends InformedSearchStrategy {

	private IEstimatedCostFunction h;

	public AStarSearch(){

	}

	public void addNodesToExpand(Vector<NTree> nodes){
		//Add the nodes at the top of the list of nodes to expand
		nodesToExpand.addAll(0, nodes);
	}

	public void addNodeToExpand(NTree node){
		//Add the node at the top of the list of nodes to expand
		nodesToExpand.addElement(node);
	}

	public IEstimatedCostFunction getEstimatedCostFunction(){
		return null;
	}

	@Override
	public String getStrategyName() {
		return "A Star (A Estrella)";
	}

}