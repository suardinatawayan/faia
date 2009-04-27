package frsf.cidisi.faia.examples.situationcalculus.pacman.actions;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.cidisi.faia.examples.situationcalculus.pacman.EstadoAmbientePacmanLogico;
import frsf.cidisi.faia.examples.situationcalculus.pacman.EstadoPacmanLogico;
import frsf.cidisi.faia.examples.situationcalculus.pacman.PercepcionPacmanLogico;

public class Pelear extends SituationCalculusAction {

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbientePacmanLogico estA = (EstadoAmbientePacmanLogico) est;
        EstadoPacmanLogico estP = ((EstadoPacmanLogico) ast);

        int fil = estP.getFila();
        int col = estP.getColumna();

        if ((estA.getMundo()[fil][col] == 1) & (estP.getEnergia() > 30)) {
            estA.setMundo(fil, col, PercepcionPacmanLogico.PERCEPCION_VACIO);
            //estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //System.out.println(" Pelear@Amb - ");
            return estA;
        }

        return null;
    }

    @Override
    public String toString() {
        return "pelear";
    }
}
