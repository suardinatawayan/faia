package frsf.cidisi.faia.solver.planning;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.planning.PlanningAction;
import frsf.cidisi.faia.solver.calculus.CalculusNoAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class PlanningNoAction extends PlanningAction {

	private static PlanningNoAction instance;
	
    private PlanningNoAction() {
    	
    }
    
    public static PlanningNoAction getInstance() {
        if (instance == null)
            instance = new PlanningNoAction();
        
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
