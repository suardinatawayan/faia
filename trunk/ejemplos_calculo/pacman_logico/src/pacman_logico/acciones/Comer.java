package pacman_logico.acciones;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import pacman_logico.EstadoAmbiente;
import pacman_logico.EstadoPacman;
import pacman_logico.PercepcionPacman;

public class Comer extends Action {

    /**
     * Permite actualizar el estado de los nodos un �rbol de b�squeda durante la creaci�n del mismo.-
     * 
     * @param s: Es el estado del agente en un determinado nodo del �rbol de b�squeda.-
     */
    public AgentState execute(AgentState s) {
//		EstadoPacman estP = (EstadoPacman)s;
//
//		int fil = estP.getFila();
//		int col = estP.getColumna();
//		
//		if (estP.getMundo()[fil][col]==PercepcionPacman.PERCEPCION_COMIDA) {
//			estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
//			//System.out.println(" Comer@Pac - ");
//			return estP;
//		}


        return null;
    }

    /**
     * Permite actualizar el estado real del agente y del ambiente.-
     * 
     * @param ast: Es el estado del agente a ser actualizado.-
     * @param est: Es el estado del ambiente a ser actualizado.-
     */
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

    public Double getCost() {
        return new Double(0);
    }

    public String toString() {
        return "Comer";
    }
}
