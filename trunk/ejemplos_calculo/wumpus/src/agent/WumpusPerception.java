package agent;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.environment.Environment;

public class WumpusPerception extends frsf.cidisi.faia.agent.Perception {
	
	private boolean[] sensors;
	
	public WumpusPerception() {
		super();
		
		this.sensors = new boolean[5];
		for (int i=0; i<this.sensors.length; i++) {
			this.sensors[i] = false;
		}
	}
	
	@Override
	public void initPerception(Agent agent, Environment environment) {
		// TODO Auto-generated method stub

	}

}
