package frsf.cidisi.faia.solver.search;
import java.util.Vector;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.Problem;
import frsf.cidisi.faia.simulator.SimulatorEventNotifier;
import frsf.cidisi.faia.solver.Solve;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.agent.problem.GoalTest;
import frsf.cidisi.faia.util.LatexOutput;
import frsf.cidisi.faia.util.XmlTree;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:05
 */
public class Search extends Solve {

	public static final int WHITHOUT_TREE = 0;
	public static final int XML_TREE = 1;
	public static final int PDF_TREE = 2;
	public static final int GRAPHICAL_TREE = 3;
	
	private NTree tree;
	private NTree goalNode;
	private Strategy searchStrategy;
	private int visibleTree = Search.WHITHOUT_TREE;
	

/*	public Search(){
		
	}
*/
	/**
	 * 
	 * @param strategy
	 * @param p
	 */
	public Search(Strategy strategy){
		searchStrategy = strategy;
	}

	public Strategy getStrategy(){
		return searchStrategy;
	}

	/**
	 * 
	 * @param s
	 */
	public void setStrategy(Strategy s){
		this.searchStrategy = s;
	}

	/**
	 * 
	 * @param problem
	 */
	public Action solve(Problem problem){

		Vector<Action> actionList = problem.getActions();
		AgentState agentState = (AgentState)problem.getAgentState();//.clone();
		GoalTest goalTest = problem.getGoalState();
		
		int nodeIdx = 1;
		
		tree = new NTree();
		
		tree.setAgentState(agentState);

		searchStrategy.initNodesToExpandList(tree);
		
		boolean goal = false;
		
		// This iteration will occur while nodesToExpand have nodes and the actual node is not a goal node.-
		while (searchStrategy.getNodesToExpandSize()>0 & !goal){
			// This is the first node of the node's queue that will be expanded
			NTree firstNode = (NTree)searchStrategy.getNode();

			//System.out.println("Profundidad: " + firstNode.getDeep());
			
			// If the actual node is a goal node then the search must finish.-
			if (goalTest.isGoalState(firstNode.getAgentState())) {
				goal = true;
				goalNode = firstNode;
			}
			else {	// If the actual node is not a goal node then it must be expanded.-
			
				// Every item in the action list represents a possible son for the actual node.-
				for (int i=0;i<actionList.size();i++) {
					// The state of the selected node must be cloned to assure consistence.-
					AgentState ast = (AgentState)firstNode.getAgentState().clone();
					// This is the action that can generate a new node.- 
					Action action = actionList.elementAt(i);
					ast = (AgentState)action.execute(ast);
					// TODO: HAY QUE VER SI CONVIENE QUE CUANDO EL OPERADOR NO PUEDA SER 
					// EJECUTADO DEVUELVA UN OBJETO EN LUGAR DE NULL.
					if (ast!=null){	// If the action was correctly executed.-
						NTree n = new NTree(firstNode,actionList.elementAt(i),ast,nodeIdx);
						// If the node is not repeated in his search's tree branch
						// then it can be added to the end of the branch.-
						if (!existsNode(n,n.getParent())){
							firstNode.addSon(n);
							nodeIdx++;
							//System.out.println("Nodo nro: " + nodeIdx);
						}
		 			}
				}
				// The nodes are added to the queue of "nodes to expand", 
				// so they can be expanded in the next cycles.-
				searchStrategy.addNodesToExpand(firstNode.getSons());
			}
		}			
		
		if (goal){
			// This variable store the branch's path where the node belongs.-
			Vector<NTree> path = getBestPath();
			
			//System.out.println("Camino: " + path);
			
			//this.printTree();
			
			// The first node of the branch has the action that must be executed by the agent.-
			return path.elementAt(0).getAction();
		}
		
		return null;
		
	}
	
	private boolean existsNode(NTree node, NTree parent){
		NTree p = (NTree)parent;//.clone();
		
		// This is an iteration through the node's parent (and ancestors) looking for a repeated node 
		// in the same branch of the Search Tree.-  
		while (p!=null){
			// If node already exists in the actual branch then the function return true.-
			if (node.equals(p)){
				return true;
			}
			p = (NTree)p.getParent();
			//if (p!=null)
			//	p = (NTree)p.clone();
		}
		
		// At this point it's sure that the node does not exists in the branch of the Search Tree.-  
		return false;	
	}
	
	
	private Vector<NTree> getBestPath(){
		Vector<NTree> path = new Vector<NTree>();
		
		NTree node = (NTree)goalNode;//.clone();

		// This iteration will occur until the branch's top is reached.
		// The branch's top is not the root node of the tree. This is because there is no action 
		// associated with the root node. So, the branch's top is a son of the root node.-
		while (node.getParent()!=null) {
			// I insert every node at the first position, therefore I get the path from rootNode to lastNode
			path.insertElementAt(node,0);
			node = (NTree)node.getParent(); //.clone();
		}
		
		return path;
	}
	
	public void showTree(){
		switch (visibleTree){
		case Search.WHITHOUT_TREE:
			break;
		case Search.XML_TREE:
			XmlTree.printFile(tree);
/*			String arbol = this.toXml();
			System.out.println("Arbol:");
			System.out.println(arbol);
*/
			break;
		case Search.PDF_TREE:
			LatexOutput.getInstance().printFile(tree, this.searchStrategy.getStrategyName());
			break;
		case Search.GRAPHICAL_TREE:
			break;
		}
	}
	
	public NTree getTree(){
		return tree;
	}

	private String toXml() {
		return tree.toXml();
	}

	public int getVisibleTree() {
		return visibleTree;
	}

	public void setVisibleTree(int visibleTree) {
		// Remove all objects subscribed to simulator events
		SimulatorEventNotifier.CleanEventHandlers();
		
		if (visibleTree == Search.PDF_TREE)
			SimulatorEventNotifier.SubscribeEventHandler(LatexOutput.getInstance());
		
		this.visibleTree = visibleTree;
	}

	public void showSolution(){
		this.showTree();
	}
	
	public String getPath(){
		return this.getBestPath().toString();
	}
	
}