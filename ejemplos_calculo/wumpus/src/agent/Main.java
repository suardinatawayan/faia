package agent;

import frsf.cidisi.faia.simulator.SituationCalculusBasedAgentSimulator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Agent agent = new Agent();
		WumpusWorldEnvironment wumpusWorld = new WumpusWorldEnvironment();
		
		SituationCalculusBasedAgentSimulator simulator =
			new SituationCalculusBasedAgentSimulator(wumpusWorld, agent);
		
		simulator.start();
	}

}
