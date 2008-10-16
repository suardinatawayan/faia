/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.agent.searchbased;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.state.AgentState;

public abstract class SearchAction extends Action {

	/**
	 * This method is used internally by the framework when the "Search Process"
	 * is being executed. It updates the node's state on every node of the
	 * search tree. Therefore, it doesn't updates the real agent's state, it
	 * just updates the state of the agent on every node of the search tree.
	 * 
	 * @param s
	 *            This is the state of the agent to be updated on search tree's
	 *            node.
	 */
	public abstract AgentState execute(AgentState s);

	/**
	 * Depending on the strategy used by the agent, this method can be overrode
	 * by the agent's actions to return its cost.
	 */
	public abstract Double getCost();
}
