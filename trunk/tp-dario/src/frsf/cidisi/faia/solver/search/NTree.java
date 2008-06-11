package frsf.cidisi.faia.solver.search;
import java.util.Vector;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:04
 */
public class NTree implements Cloneable {

	protected int deep;
	protected double cost;
	protected Action action;
	protected NTree parent;
	protected Vector<NTree> sons;
	protected AgentState agentState;
	protected int executionOrder;

	public NTree(){
		this.deep = 0;
		this.parent = null;
		this.sons = new Vector<NTree>();
		this.agentState = null;
		this.executionOrder = 0;
	}
	
	public NTree(NTree firstNode, Action action, AgentState ast, int order){
		this.deep = firstNode.getDeep()+1;
		this.parent = firstNode;
		this.sons = new Vector<NTree>();
		this.agentState = ast;
		this.action = action;
		this.executionOrder = order;
	}

	/**
	 * 
	 * @param son
	 */
	public void addSon(NTree son){
		this.getSons().addElement(son);
	}

	public Object clone(){

		NTree node = new NTree();

		AgentState agSt = (AgentState)agentState.clone();
/*		if (parent!=null)
			node.setParent((NTree)parent.clone());*/
		node.setParent(parent);
		node.setAction(action);
		node.setAgentState(agSt);

		// TODO: Acá hay que clonar a los hijos también!!???.-
		
/*		node.setSons((Vector<NTree>)sons.clone());*/
		node.setSons(sons);
		
		return node;
	}
	public Action getAction(){
		return action;
	}

	public double getCost(){
		return cost;
	}

	public int getDeep(){
		return deep;
	}

	public NTree getParent(){
		return parent;
	}

	public Vector<NTree> getSons(){
		return sons;
	}

	public AgentState getAgentState(){
		return agentState;
	}

	/**
	 * 
	 * @param action
	 */
	public void setAction(Action action){
		this.action = action; 
	}

	/**
	 * 
	 * @param cost
	 */
	public void setCost(double cost){
		this.cost = cost;
	}

	/**
	 * 
	 * @param deep
	 */
	public void setDeep(int deep){
		this.deep = deep;
	}

	/**
	 * 
	 * @param father
	 */
	public void setParent(NTree parent){
		this.parent = parent;
	}

	/**
	 * 
	 * @param sons
	 */
	public void setSons(Vector<NTree> sons){
		this.sons = sons;
	}

	/**
	 * 
	 * @param state
	 */
	public void setAgentState(AgentState state){
		this.agentState = state;
	}
	
	public Action getActionFromBranchsTop(){
		return action;
	}

	public String toString(){
		String eo = "Id=\"" + executionOrder + "\" ";
		String ac = "Action=\"" + action + "\" ";
//TODO: FALTA VER COMO HACEMOS CUANDO HAY FUNCIONES DE COSTO O HEURISTICAS.- 
//		String hf = "Heu: " + getHeuristicFunction() + " ";
//		String cf = "Cst: " + getCostFunction() + " ";
		
		return eo + ac;
	}
	
	public String toXml(){
		
		String str = "";

		str = "<Nodo"+action;
		str = str + ">";
//		str = str + "\n";
		str = str + toString();
		str = str + agentState.toString();
		for (int i=0;i<getSons().size();i++) {
			str = str + sons.elementAt(i).toXml(); 
		}
		str = str + "</Nodo"+action+">";
//		str = str + "\n";
		
		return str;
		
	}

	@Override
	public boolean equals(Object obj) {
		return agentState.equals(((NTree)obj).getAgentState());
	}

	

}