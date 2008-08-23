package agente;

import calculador.Calculador;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class Snake {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Calculador calculador = new Calculador();

        AgenteSnake snake = new AgenteSnake(calculador);

        AmbienteSnake ambiente = new AmbienteSnake(calculador);

        SearchBasedAgentSimulator simu = new SearchBasedAgentSimulator(ambiente, snake);

        simu.start();

        System.out.println("Performance: " + calculador.getPerformance());
    }
}
