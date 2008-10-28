package agente;

import frsf.cidisi.faia.exceptions.KnowledgeBaseException;
import frsf.cidisi.faia.simulator.GoalBasedAgentSimulator;
import frsf.cidisi.faia.simulator.KnowledgeBasedAgentSimulator;
import frsf.cidisi.faia.simulator.PlanningBasedAgentSimulator;

public class Pacman {

    /**
     * @param args
     */
    public static void main(String[] args) throws KnowledgeBaseException {
        AgentePlanificacion pacman = new AgentePlanificacion();

        AmbientePacman ambiente = new AmbientePacman();

        PlanningBasedAgentSimulator simu = new PlanningBasedAgentSimulator(ambiente, pacman);

        simu.start();
    }
}
