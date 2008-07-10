package pacman_logico.acciones;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import pacman_logico.EstadoAmbiente;
import pacman_logico.EstadoPacman;

public class IrAbajo extends Action {

    /**
     * Permite actualizar el estado de los nodos un �rbol de b�squeda durante la creaci�n del mismo.-
     * 
     * @param s: Es el estado del agente en un determinado nodo del �rbol de b�squeda.-
     */
    public AgentState execute(AgentState s) {
//		EstadoPacman estP = ((EstadoPacman)s.clone());
//		EstadoPacman estP = (EstadoPacman)s;
//		
//		estP.incCeldasVisitadas();
//
//		int fil = estP.getFila();
//		int col = estP.getColumna();
//		
//		
//		if (fil==3) 
//			fil = 0;
//		else
//			fil = fil + 1;
//				
//		estP.setFila(fil);
//		if (estP.getMundoConocido(fil, col)==0){
//			estP.setMundoConocido(fil, col, 1);
//			return estP;
//		}
//		//System.out.println(" Abajo@Pac - ");

        return null;
    }

    /**
     * Permite actualizar el estado real del agente y del ambiente.-
     * 
     * @param ast: Es el estado del agente a ser actualizado.-
     * @param est: Es el estado del ambiente a ser actualizado.-
     */
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
//		EstadoPacman estP = ((EstadoPacman)s.clone());
//		EstadoAmbiente estA = (EstadoAmbiente)est;
//		EstadoPacman estP = ((EstadoPacman)ast);
//
//		estP.incCeldasVisitadas();
//		
//		int fil = estP.getFila();
//		int col = estP.getColumna();
//		
//		if (fil==3) 
//			fil = 0;
//		else
//			fil = fil + 1;
//
//		estP.setFila(fil);
//		estP.setMundoConocido(fil, col, 1);
//		//estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
//		//System.out.println(" Abajo@Amb - ");
//		return estA;

        return est;
    }

    public Double getCost() {
        return new Double(0);
    }

    public String toString() {
        return "Abajo";
    }
}
