package agent;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.solver.ActionFactory;
import frsf.cidisi.faia.solver.situationcalculus.KnowledgeBase;

public class WumpusAgentState extends KnowledgeBase {

	public WumpusAgentState() throws PrologConnectorException {
		super("wumpus_world.pl");
		
		this.initState();
	}
	
	@Override
	public ActionFactory getActionFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBestActionPredicate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExecutedActionPredicate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateState(Perception p) {
		this.tell(p);
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
