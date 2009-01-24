package agente;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.GoalBasedAgentSimulator;
import frsf.cidisi.faia.simulator.SituationCalculusBasedAgentSimulator;

public class Pacman {

    /**
     * @param args
     */
    public static void main(String[] args) throws PrologConnectorException {
        AgenteLogico pacman = new AgenteLogico();

        AmbientePacman ambiente = new AmbientePacman();

        SituationCalculusBasedAgentSimulator simu = new SituationCalculusBasedAgentSimulator(ambiente, pacman);

        simu.start();
    }
}
