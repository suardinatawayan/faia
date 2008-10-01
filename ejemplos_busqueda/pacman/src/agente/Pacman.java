package agente;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class Pacman {

    /**
     * Este es el método principal que crea el agente Pacman, su ambiente y
     * el simulador de búsqueda (que lo inicia).
     */
    public static void main(String[] args) {
        AgentePacman pacman = new AgentePacman();

        AmbientePacman ambiente = new AmbientePacman();

        SearchBasedAgentSimulator simu = new SearchBasedAgentSimulator(ambiente, pacman);

        simu.start();
    }
}
