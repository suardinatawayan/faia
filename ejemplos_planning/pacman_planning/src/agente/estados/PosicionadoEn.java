package agente.estados;

import frsf.cidisi.faia.agent.planning.PlanningAction;
import frsf.cidisi.faia.agent.planning.PlanningState;

public class PosicionadoEn extends PlanningState {
	
	public PosicionadoEn(PlanningAction action) {
		super(action);
	}
	
	@Override
	public String toPrologLiteral() {
		return "en(" +
			this.action.getVariable("X") +
			"," +
			this.action.getVariable("Y") +
			")";
	}

}
