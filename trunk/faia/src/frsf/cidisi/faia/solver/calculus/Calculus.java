package frsf.cidisi.faia.solver.calculus;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.Problem;
import frsf.cidisi.faia.exceptions.CalculusException;
import frsf.cidisi.faia.solver.Solve;
import frsf.cidisi.faia.state.AgentState;
import java.util.Hashtable;

public class Calculus extends Solve {

    public Calculus() {
    }

    @Override
    public void showSolution() {
        // TODO Auto-generated method stub
    }

    /**
     * Aca el Problem no es utilizado. 
     */
    @Override
    public Action solve(Problem problem) {
        throw new UnsupportedOperationException("Not supported operation.");
    }

    @Override
    public Action solve(KnowledgeBase knowledgeBase) throws CalculusException {
        
        /* Hago una consulta a la base de conocimiento, pidiendo por la mejor
         * accion. Esto me devuelve un Hashtable con todos los resultados.
         * En este caso solo deberia devolver uno. */
        Hashtable[] results =
                knowledgeBase.query(knowledgeBase.getBestActionPredicate() + "(X," +
                knowledgeBase.getSituation() + ")");
        
        // Busco el primer resultado de la consulta.
        if (results.length == 0)
            throw new CalculusException("No solutions returned. Maybe there is an error in the knowledge base.");
        
        String mejorAccion = results[0].get("X").toString();

        /* Transformo el string 'mejorAccion' que representa a la accion
         * escogida en un objeto Action */
        return knowledgeBase.getActionFactory().makeActionFromString(mejorAccion);
    }
}
