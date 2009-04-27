package frsf.cidisi.faia.examples.search.pacman;

import frsf.cidisi.faia.agent.searchbased.GoalTest;
import frsf.cidisi.faia.state.AgentState;

/**
 * Esta clase se utiliza para definir una función que, recibido 
 * un objeto estado del agente, verifique si se ha llegado al objetivo o no.
 * Se utiliza en el proceso interno de búsqueda del agente y también en
 * el simulador, para saber cuándo detenerse.
 */
public class MetaPacman extends GoalTest {

    public boolean isGoalState(AgentState agentState) {
        if (((EstadoPacman) agentState).noHayMasComida() & ((EstadoPacman) agentState).todoConocido()) {
            return true;
        }
        return false;
    }
}
