/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa,
 * Luis Ignacio Larrateguy y Milton Pividori.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package frsf.cidisi.faia.solver.situationcalculus;

import java.util.Hashtable;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.solver.ActionFactory;
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
	
    public KnowledgeBase(String knowledgeBaseFile) throws PrologConnectorException {
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
    	this.prologConnector.addPredicate(predicate);
    }
    
    public Hashtable[] query(String query) {
    	return this.prologConnector.query(query);
    }
    
    public boolean queryHasSolution(String query) {
    	return this.prologConnector.queryHasSolution(query);
    }
	
	public abstract ActionFactory getActionFactory();
	
    public abstract String getBestActionPredicate();
    
    public abstract String getExecutedActionPredicate();

}
