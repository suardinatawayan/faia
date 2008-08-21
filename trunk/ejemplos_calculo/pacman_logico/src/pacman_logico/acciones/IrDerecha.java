package pacman_logico.acciones;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.knowledgebased.CalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import pacman_logico.EstadoAmbiente;
import pacman_logico.EstadoPacman;

public class IrDerecha extends CalculusAction {
    
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        return est;
    }

    @Override
    public String toString() {
        return "Derecha";
    }
}
