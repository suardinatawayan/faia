package frsf.cidisi.faia.solver.calculus;

import frsf.cidisi.faia.agent.problem.Action;

public abstract class CalculusActionFactory {

    /**
     * This method is executed before stringToAction, which is overrided
     * by the user. If no action was returned by the agent, then we return
     * a NoAction object.
     * 
     * @param stringAction
     * @return The Action represented by stringAction
     */
    public Action makeActionFromString(String stringAction) {
        if (stringAction.equals(this.noActionString()))
            return NoAction.getInstance();
        
        return this.stringToAction(stringAction);
    }
    
    /**
     * This method is overrided by the user.
     * @param stringAction
     * @return The Action represented by stringAction.
     */
    public abstract Action stringToAction(String stringAction);
    
    public abstract String noActionString();
}
