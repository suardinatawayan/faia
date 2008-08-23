package agente.acciones;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.knowledgebased.CalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import agente.EstadoAmbiente;
import agente.EstadoPacman;
import agente.PercepcionPacman;

public class Pelear extends CalculusAction {

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbiente estA = (EstadoAmbiente) est;
        EstadoPacman estP = ((EstadoPacman) ast);

        int fil = estP.getFila();
        int col = estP.getColumna();

        if ((estA.getMundo()[fil][col] == 1) & (estP.getEnergia() > 30)) {
            estA.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //System.out.println(" Pelear@Amb - ");
            return estA;
        }

        return null;
    }

    @Override
    public String toString() {
        return "Pelear";
    }
}
