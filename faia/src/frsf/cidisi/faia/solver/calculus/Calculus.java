package frsf.cidisi.faia.solver.calculus;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.exceptions.CalculusException;
import frsf.cidisi.faia.solver.PrologConnector;
import frsf.cidisi.faia.solver.Solve;
import java.util.Hashtable;

public class Calculus extends Solve {

    @Override
    public void showSolution() {
        // TODO Auto-generated method stub
    }

    @Override
    public Action solve(Object[] params) throws CalculusException {
        KnowledgeBase kb = (KnowledgeBase) params[0];
    	
        // Query the knowledge base for the best action in the current situation.
    	Hashtable[] results =
            kb.query(kb.getBestActionPredicate() + "(X," +
            kb.getSituation() + ")");

	    // We look for the first result.
	    if (results.length == 0) {
	        throw new CalculusException("No solutions returned. Maybe there is an error in the knowledge base.");
	    }
	    
	    String bestAction = results[0].get("X").toString();
	
	    /* We convert the string 'bestAction' in an Action object */
	    return kb.getActionFactory().makeActionFromString(bestAction);
    }
}
