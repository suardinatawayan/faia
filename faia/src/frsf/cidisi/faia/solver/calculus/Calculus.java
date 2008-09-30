package frsf.cidisi.faia.solver.calculus;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.exceptions.CalculusException;
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
        Hashtable[] results =
                knowledgeBase.query(knowledgeBase.getBestActionPredicate() + "(X," +
                knowledgeBase.getSituation() + ")");

        // We look for the first result.
        if (results.length == 0) {
            throw new CalculusException("No solutions returned. Maybe there is an error in the knowledge base.");
        }
        String mejorAccion = results[0].get("X").toString();

        /* We convert the string 'bestAction' in an Action object */
        return knowledgeBase.getActionFactory().makeActionFromString(mejorAccion);
    }
}
