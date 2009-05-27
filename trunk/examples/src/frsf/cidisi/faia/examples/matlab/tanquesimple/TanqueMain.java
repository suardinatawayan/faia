package frsf.cidisi.faia.examples.matlab.tanquesimple;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import frsf.cidisi.faia.simulator.SimpleSimulator;

public class TanqueMain {
	
	public static void main(String[] args) {
		AgenteTanque agente = new AgenteTanque();
        AmbienteTanque ambiente = new AmbienteTanque();
        SimpleSimulator simu = new SimpleSimulator(ambiente, agente);
        simu.start();
	}

}
