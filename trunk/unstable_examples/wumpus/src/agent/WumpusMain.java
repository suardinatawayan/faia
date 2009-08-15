package agent;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SituationCalculusBasedAgentSimulator;

public class WumpusMain {

	/**
	 * @param args
	 * @throws PrologConnectorException 
	 */
	public static void main(String[] args) throws PrologConnectorException {
		
//        System.out.println("milton".substring(0, "milton".length() - 1));

		WumpusAgent agent = new WumpusAgent();
		WumpusWorldEnvironment wumpusWorld = new WumpusWorldEnvironment();

		SituationCalculusBasedAgentSimulator simulator =
			new SituationCalculusBasedAgentSimulator(wumpusWorld, agent);

		simulator.start();
	}

}
