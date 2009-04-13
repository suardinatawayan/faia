package frsf.cidisi.faia.examples.planning.cubos;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteCubos extends Environment {
	
	public AmbienteCubos() {
		this.environmentState = new EstadoAmbiente();
	}
	
	@Override
	public Perception getPercept(Agent agent) {
		return null;
	}
	
	@Override
	public String toString() {
		return environmentState.toString();
	}

}
