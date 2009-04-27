package frsf.cidisi.faia.agent.situationcalculus;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public abstract class SituationCalculusPerception extends Perception {
	
	public SituationCalculusPerception() {
	}
	
	public SituationCalculusPerception(Agent agent, Environment environment) {
		super(agent, environment);
	}
	
	public abstract String toString();

}
