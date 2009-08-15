package agent;

import java.util.Hashtable;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.NoAction;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusBasedAgent;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.solver.situationcalculus.SituationCalculus;

public class WumpusAgent extends SituationCalculusBasedAgent {

	private Action lastAction = NoAction.getInstance();
	
	public WumpusAgent() throws PrologConnectorException {
		WumpusAgentState state = new WumpusAgentState();
		this.setAgentState(state);
	}
	
	@Override
	public void tell(Action action) {
		WumpusAgentState kb = this.getAgentState();
        kb.tell(action);
	}

	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
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
		
		this.lastAction = selectedAction;
		
		return selectedAction;
	}
	
	@Override
	public WumpusAgentState getAgentState() {
		WumpusAgentState agentState = (WumpusAgentState) super.getAgentState();
		
		return agentState;
	}
	
	public Action getLastAction() {
		return this.lastAction;
	}

}
