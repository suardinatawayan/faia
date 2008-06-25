package frsf.cidisi.faia.solver.search;
import java.util.Vector;
import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:04
 */
public class NTree implements Cloneable, Comparable<NTree> {

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

		// TODO: Ac� hay que clonar a los hijos tambi�n!!???.-
		
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
	
	public Vector<NTree> getSonsTotal() {
		Vector<NTree> temp = new Vector<NTree>();
		
		// Agrego primero mis hijos
		temp.addAll(this.sons);
		
		// Agrego después los hijos de mis hijos recursivamente
		for (int i=0;i<this.getSons().size();i++)
			temp.addAll(this.getSons().elementAt(i).getSonsTotal());
		
		return temp;
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
	
//	public String toLatex() {
//		StringBuffer str = new StringBuffer();
//		
//	    // Clase del documento y opciones generales
//	    str.append("\\documentclass[a0,landscale]{a0poster}\n");
//	   
//	    // Paquetes utilizados
//	    str.append("\\usepackage{mathptmx}\n");
//	    str.append("\\usepackage[scaled=.90]{helvet}\n");
//	    str.append("\\usepackage{courier}\n");
//	    str.append("\\usepackage{qtree}\n");
//	    str.append("\\usepackage{nodo}\n");
//	    str.append("\\usepackage[spanish]{babel}\n");
//	    str.append("\\usepackage[utf8]{inputenc}\n");
//	   
//	    str.append("\\title{Arbol de ejecucion - Estrategia: " +
//	        "NO SETEADA" + "}\n");
//	    str.append("\\author{}\n");
//	    str.append("\\begin{document}\n");
//	    str.append("\\maketitle\n");
//	}
	
	public String toQtree() {
		
		StringBuffer resultado = new StringBuffer();
		
		//resultado.append("\\begin{figure}[!h]\n");
		resultado.append("[." + this.toLatex() + " ");
		//resultado.append("\\Tree [." + this.toLatex() + " ");
		
		for (int i=0;i<getSons().size();i++) {
			resultado.append(sons.elementAt(i).toLatex() + " ");
		}
//		for (NTree hijo : this.sons) {
//			resultado.append(hijo.toLatex() + " ");
//		}
		
		resultado.append("]");
		//resultado.append("\\end{figure}\n");
		
		return resultado.toString();
	}
	
	private String toLatex() {
		String resultado;
		
		resultado = "\\nodo"
			+ "{" + this.executionOrder + "}"
			+ "{" + this.cost + "}";
		
		if (this.action != null)
			resultado += "{" + this.action.toString() + "}";
		else
			resultado += "{-}";
		
		return resultado;
	}

	@Override
	public boolean equals(Object obj) {
		return agentState.equals(((NTree)obj).getAgentState());
	}

	@Override
	public int compareTo(NTree o) {
		if (this.cost == o.cost)
			return 0;
		else if (this.cost < o.cost)
			return -1;
		else
			return 1;
	}
}