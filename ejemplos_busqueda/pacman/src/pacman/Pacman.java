package pacman;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class Pacman {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AgentePacman pacman = new AgentePacman();

        AmbientePacman ambiente = new AmbientePacman();

        SearchBasedAgentSimulator simu = new SearchBasedAgentSimulator(ambiente, pacman);

        simu.start();
    }
}
