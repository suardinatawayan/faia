package agent;

import frsf.cidisi.faia.simulator.SituationCalculusBasedAgentSimulator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		WumpusAgent agent = new WumpusAgent();
		WumpusWorldEnvironment wumpusWorld = new WumpusWorldEnvironment();
		
		SituationCalculusBasedAgentSimulator simulator =
			new SituationCalculusBasedAgentSimulator(wumpusWorld, agent);
		
		simulator.start();
	}

}
