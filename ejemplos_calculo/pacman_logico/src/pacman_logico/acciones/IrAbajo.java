package pacman_logico.acciones;

import frsf.cidisi.faia.agent.knowledgebased.CalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrAbajo extends CalculusAction {
    
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        return est;
    }

    @Override
    public String toString() {
        return "Abajo";
    }
}
