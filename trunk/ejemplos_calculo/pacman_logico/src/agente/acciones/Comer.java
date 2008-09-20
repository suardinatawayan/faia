package agente.acciones;

import frsf.cidisi.faia.agent.knowledgebased.CalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import agente.EstadoAmbiente;
import agente.EstadoPacman;
import agente.PercepcionPacman;

public class Comer extends CalculusAction {
    
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbiente estA = (EstadoAmbiente) est;
        EstadoPacman estP = ((EstadoPacman) ast);

        int fil = estP.getFila();
        int col = estP.getColumna();

        if (estA.getMundo()[fil][col] == PercepcionPacman.PERCEPCION_COMIDA) {
            estA.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //System.out.println(" Comer@Amb - ");
            return estA;
        }

        return null;
    }

    @Override
    public String toString() {
        /* El nombre de la acción se pasará a minúsculas para trabajar
         * con la base de conocimiento, por lo tanto se debe utilizar el mismo
         * nombre aquí */
        return "Comer";
    }
}
