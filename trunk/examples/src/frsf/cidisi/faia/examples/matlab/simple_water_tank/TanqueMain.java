package frsf.cidisi.faia.examples.matlab.simple_water_tank;

import frsf.cidisi.faia.simulator.ReactiveBasedAgentSimulator;

public class TanqueMain {
	
	public static void main(String[] args) {
		AgenteTanque agente = new AgenteTanque();
        AmbienteTanque ambiente = new AmbienteTanque();
        ReactiveBasedAgentSimulator simu = new ReactiveBasedAgentSimulator(ambiente, agente);
        simu.start();
	}

}
