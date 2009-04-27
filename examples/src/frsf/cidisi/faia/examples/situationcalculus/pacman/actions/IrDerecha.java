package frsf.cidisi.faia.examples.situationcalculus.pacman.actions;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.cidisi.faia.examples.situationcalculus.pacman.EstadoAmbientePacmanLogico;
import frsf.cidisi.faia.examples.situationcalculus.pacman.EstadoPacmanLogico;

public class IrDerecha extends SituationCalculusAction {
    
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        return est;
    }

    @Override
    public String toString() {
        return "derecha";
    }
}
