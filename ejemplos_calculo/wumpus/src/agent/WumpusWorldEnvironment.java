package agent;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.environment.Environment;

public class WumpusWorldEnvironment extends Environment {

	public WumpusWorldEnvironment() {
		this.environmentState = new WumpusWorldState();
	}
	
	@Override
	public WumpusPerception getPercept(Agent agent) {
		WumpusPerception p = new WumpusPerception();

        WumpusAgent wumpusAgent = (WumpusAgent) agent;
        WumpusAgentState wumpusAgentState = wumpusAgent.getAgentState();

        return null;
	}

}
