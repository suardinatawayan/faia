package agente;

import frsf.cidisi.faia.agent.searchbased.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class MetaPacman extends GoalTest {

    public boolean isGoalState(AgentState agentState) {
        if (((EstadoPacman) agentState).noHayMasComida() & ((EstadoPacman) agentState).todoConocido()) {
            return true;
        }
        return false;
    }
}
