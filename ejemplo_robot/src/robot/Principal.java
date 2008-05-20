package robot;

import frsf.cidisi.faia.simulator.GoalBasedAgentSimulator;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AgenteRobot pacman = new AgenteRobot();

		AmbienteRobot ambiente = new AmbienteRobot();
		
		GoalBasedAgentSimulator simu = new GoalBasedAgentSimulator(ambiente, pacman);

		simu.start();
		

	}

}
