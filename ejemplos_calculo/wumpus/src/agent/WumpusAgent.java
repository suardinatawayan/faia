package agent;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusAction;
import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusBasedAgent;
import frsf.cidisi.faia.solver.situationcalculus.SituationCalculus;

public class WumpusAgent extends SituationCalculusBasedAgent {

	@Override
	public void tell(SituationCalculusAction action) {
		// TODO Auto-generated method stub

	}

	@Override
	public void see(Perception p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Action selectAction() {
		
		SituationCalculus solver = new SituationCalculus();
		this.setSolver(solver);
		
		Action selectedAction = null;
		try {
			selectedAction = this.getSolver().solve(new Object[] {this.getAgentState()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectedAction;
	}
	
	@Override
	public WumpusAgentState getAgentState() {
		WumpusAgentState agentState = (WumpusAgentState) this.getAgentState();
		
		return agentState;
	}

}
