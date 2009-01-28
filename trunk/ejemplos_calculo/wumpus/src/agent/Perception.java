package agent;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.environment.Environment;

public class Perception extends frsf.cidisi.faia.agent.Perception {
	
	public static final int STENCH = 0;
	public static final int BREEZE = 1;
	public static final int GLITTER = 2;
	public static final int BUMP = 3;
	public static final int WUMPUS_SCREAM = 4;
	
	private boolean[] sensors;
	
	public Perception() {
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
