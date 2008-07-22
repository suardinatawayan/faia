package pacman_logico;

import frsf.cidisi.faia.exceptions.KnowledgeBaseException;
import frsf.cidisi.faia.simulator.GoalBasedAgentSimulator;
import frsf.cidisi.faia.simulator.KnowledgeBasedAgentSimulator;

public class Pacman {

    /**
     * @param args
     */
    public static void main(String[] args) throws KnowledgeBaseException {
        AgenteLogico pacman = new AgenteLogico();

        AmbientePacman ambiente = new AmbientePacman();

        KnowledgeBasedAgentSimulator simu = new KnowledgeBasedAgentSimulator(ambiente, pacman);

        simu.start();
    }
}
