/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package frsf.cidisi.faia.solver.calculus;

import frsf.cidisi.faia.agent.knowledgebased.CalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class is used by the KnowledBasedAgentSimulator to know when the
 * agent has finished.
 */
public class CalculusNoAction extends CalculusAction {
    
    private static CalculusNoAction instance;
    
    private CalculusNoAction() {
    	
    }
    
    public static CalculusNoAction getInstance() {
        if (instance == null)
            instance = new CalculusNoAction();
        
        return instance;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String toString() {
        return "NoAction";
    }
}
