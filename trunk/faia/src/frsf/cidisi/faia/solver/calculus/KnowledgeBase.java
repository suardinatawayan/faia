package frsf.cidisi.faia.solver.calculus;

import java.util.Hashtable;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.exceptions.CalculusException;
import frsf.cidisi.faia.exceptions.KnowledgeBaseException;
import frsf.cidisi.faia.solver.PrologConnector;
import frsf.cidisi.faia.state.AgentState;

public abstract class KnowledgeBase extends AgentState {

	/**
     * Current situation.
     */
    private int situation;
    
    /**
     * Prolog connector
     */
    protected PrologConnector prologConnector;
	
    public KnowledgeBase(String knowledgeBaseFile) throws KnowledgeBaseException {
    	this.prologConnector = new PrologConnector(knowledgeBaseFile);
    	this.situation = 0;
    }
    
	/**
     * Returns the actual situation of the Knowledge Base
     * @return
     */
    public int getSituation() {
        return this.situation;
    }

    public void advanceToNextSituation() {
        this.situation++;
    }
    
    public void executeSuccessorStateAxioms() {
        this.prologConnector.executeNonQuery("findall(X,est(" + this.getSituation() + "),L)");
    }
    
    public void tell(Perception perception) {
        this.addKnowledge(perception.toString());
    }
    
    public void tell(String action) {
        if (action == null) {
            return;
        }
        
        this.addKnowledge(this.getExecutedActionPredicate() +
                "(" + action + "," + this.getSituation() + ")");
        
        // Advance to the next situation
        this.advanceToNextSituation();
        
        // Execute successors state axioms
        this.executeSuccessorStateAxioms();
    }
    
    public void addKnowledge(String predicate) {
    	this.prologConnector.executeNonQuery("asserta(" + predicate + ")");
    }
    
    public Hashtable[] query(String query) {
    	return this.prologConnector.query(query);
    }
    
    public boolean queryHasSolution(String query) {
    	return this.prologConnector.queryHasSolution(query);
    }
    
    /**
     * Returns the best action for the current situation.
     * @return
     * @throws CalculusException
     */
    public Action getBestAction() throws CalculusException {
        Hashtable[] results =
                this.prologConnector.query(this.getBestActionPredicate() + "(X," +
                this.getSituation() + ")");

        // We look for the first result.
        if (results.length == 0) {
            throw new CalculusException("No solutions returned. Maybe there is an error in the knowledge base.");
        }
        
        String bestAction = results[0].get("X").toString();

        /* We convert the string 'bestAction' in an Action object */
        return this.getActionFactory().makeActionFromString(bestAction);
    }
	
	@Override
	public Object clone() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean equals(Object obj) {
		throw new UnsupportedOperationException();
	}
	
	public abstract CalculusActionFactory getActionFactory();
	
    public abstract String getBestActionPredicate();
    
    public abstract String getExecutedActionPredicate();

}
