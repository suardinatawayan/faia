package agent;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class WumpusWorldEnvironment extends Environment {

	public WumpusWorldEnvironment() {
		this.environmentState = new WumpusWorldState();
	}
	
	@Override
	public Perception getPercept(Agent agent) {
		// TODO Auto-generated method stub
		return null;
	}

}
