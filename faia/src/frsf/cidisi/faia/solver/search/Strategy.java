package frsf.cidisi.faia.solver.search;
import java.util.Vector;
/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:05
 */
/**
 * @author JR
 *
 */
public abstract class Strategy {

	protected Vector<NTree> nodesToExpand;
	/** It is used to determine if the list of nodes to expand is
	 *  initialized (true) or not (false).-
	 */ 
	private boolean isInitialized;
	

	public Strategy(){
		nodesToExpand = new Vector<NTree>();
		//nodesToExpand.addElement(tree);
		isInitialized = false;
	}

	public int getNodesToExpandSize(){
		return nodesToExpand.size();
	}

	/**
	 * @return Returns the first node of the list of nodes to expand and then removes it.
	 *  If the list is empty then returns null 
	 */
	public NTree getNode(){
		if (nodesToExpand.size() > 0)
			return nodesToExpand.remove(0);
		
		return null;
	}

	/**
	 * Initialize the list of nodes to expand.
	 * The first node of the list should be the root of the search tree.
	 * @param node should be the root of the search tree
	 */
	public void initNodesToExpandList(NTree node){
		if (!isInitialized){
			nodesToExpand.addElement(node);
			isInitialized = true;
		}
	}
	
	public abstract void addNodesToExpand(Vector<NTree> nodes);

	public abstract void addNodeToExpand(NTree node);
	
	public abstract String getStrategyName();

}