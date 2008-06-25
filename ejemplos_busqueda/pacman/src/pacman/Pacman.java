package pacman;

import frsf.cidisi.faia.simulator.GoalBasedAgentSimulator;

public class Pacman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AgentePacman pacman = new AgentePacman();

		AmbientePacman ambiente = new AmbientePacman();
		
		GoalBasedAgentSimulator simu = new GoalBasedAgentSimulator(ambiente, pacman);

		simu.start();
	}
}
