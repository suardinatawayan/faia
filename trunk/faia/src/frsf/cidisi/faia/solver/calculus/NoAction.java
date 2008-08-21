/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package frsf.cidisi.faia.solver.calculus;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.knowledgebased.CalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class is used by the KnowledBasedAgentSimulator to know where the
 * agent has finished.
 * 
 * @author miltondp
 */
public class NoAction extends CalculusAction {
    
    private static NoAction instance;
    
    private NoAction()
    {}
    
    public static NoAction getInstance() {
        if (instance == null)
            instance = new NoAction();
        
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
