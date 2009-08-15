package agent.actions;

import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class TurnRight extends SituationCalculusAction {

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		return est;
	}

	@Override
	public String toString() {
		return "turnright";
	}

}
