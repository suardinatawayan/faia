package agente.acciones;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.knowledgebased.CalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import agente.EstadoAmbiente;
import agente.EstadoPacman;

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
