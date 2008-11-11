package agente;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.GoalBasedAgentSimulator;
import frsf.cidisi.faia.simulator.KnowledgeBasedAgentSimulator;

public class Pacman {

    /**
     * @param args
     */
    public static void main(String[] args) throws PrologConnectorException {
        AgenteLogico pacman = new AgenteLogico();

        AmbientePacman ambiente = new AmbientePacman();

        KnowledgeBasedAgentSimulator simu = new KnowledgeBasedAgentSimulator(ambiente, pacman);

        simu.start();
    }
}
