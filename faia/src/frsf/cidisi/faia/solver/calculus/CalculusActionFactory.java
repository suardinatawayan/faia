package frsf.cidisi.faia.solver.calculus;

import frsf.cidisi.faia.agent.Action;

/**
 * Calculus (a Solver subclass) receives an string representation
 * of the best action when invoking the knowledge base, in the
 * solve() method. This string must be converted to an Action object.
 * This is class must be implemented by the user to carry out this
 * conversion.
 */
public abstract class CalculusActionFactory {

    /**
     * This method is executed before stringToAction, which is overrode
     * by the user. If no action was returned by the agent, then we return
     * a NoAction object.
     * 
     * @param stringAction
     * @return The Action represented by stringAction
     */
    public Action makeActionFromString(String stringAction) {
        if (stringAction.equals(this.noActionString()))
            return CalculusNoAction.getInstance();
        
        return this.stringToAction(stringAction);
    }
    
    /**
     * This method is overrode by the user.
     * @param stringAction
     * @return The Action represented by stringAction.
     */
    public abstract Action stringToAction(String stringAction);
    
    /**
     * This method must return the string representation of a NoAction,
     * used by the user in the prolog file.
     */
    public abstract String noActionString();
}
