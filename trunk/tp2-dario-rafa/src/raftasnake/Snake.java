package raftasnake;

import raftasnake.calculus.AgenteCalculus;
import calculador.Calculador;
import frsf.cidisi.faia.simulator.GoalBasedAgentSimulator;

public class Snake {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calculador calculador = new Calculador();
		
		AgenteCalculus snake = new AgenteCalculus(calculador);

		AmbienteSnake ambiente = new AmbienteSnake(calculador);
		
		GoalBasedAgentSimulator simu = new GoalBasedAgentSimulator(ambiente, snake);

		simu.start();
		
		System.out.println("Performance: " + calculador.getPerformance());
	}

}
