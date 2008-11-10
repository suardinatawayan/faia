package frsf.cidisi.faia.agent.searchbased;

import frsf.cidisi.faia.state.AgentState;

public abstract class SearchBasedAgentState extends AgentState {

	/**
     * We need this method to look for repeated nodes in the same search branch.
     */
    @Override
    public abstract boolean equals(Object obj);
	
	/**
     * We need to be able to clone an AgentState, because we'll use it
     * in the search process, when we apply the operations on a node.
     */
    public abstract SearchBasedAgentState clone();

}
