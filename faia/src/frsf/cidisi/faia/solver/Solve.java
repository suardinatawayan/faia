package frsf.cidisi.faia.solver;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.exceptions.CalculusException;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:05
 */
public abstract class Solve {

    public Solve() {
    }

    /**
     * 
     * @param problem
     */
    public abstract Action solve(Object[] params) throws Exception;
    
    /* Maybe it's not correct to leave this method here, due to it's probable
     * some AI techniques could not show the solution */
    public abstract void showSolution();
}