package frsf.cidisi.faia.solver.calculus;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.exceptions.CalculusException;
import frsf.cidisi.faia.solver.PrologConnector;
import frsf.cidisi.faia.solver.Solve;
import java.util.Hashtable;

public class Calculus extends Solve {

    public Calculus() {
    }

    @Override
    public void showSolution() {
        // TODO Auto-generated method stub
    }

    @Override
    public Action solve(Object[] params) throws CalculusException {
        
    	KnowledgeBase knowledgeBase = (KnowledgeBase)params[0];
        
    	/* We query the knowledge base, asking for the best action. This returns
         * a Hashtable with the results. In this case, it should return only
         * one. */
    	return knowledgeBase.getBestAction();
    }
}
