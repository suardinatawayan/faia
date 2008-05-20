package pacman;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Pelear extends Action {

	/**
	 * Permite actualizar el estado de los nodos un árbol de búsqueda durante la creación del mismo.-
	 * 
	 * @param s: Es el estado del agente en un determinado nodo del árbol de búsqueda.-
	 */
	public AgentState execute(AgentState s){
//		EstadoPacman estP = ((EstadoPacman)s.clone());
		EstadoPacman estP = (EstadoPacman)s;

		int fil = estP.getFila();
		int col = estP.getColumna();
		
		if ((estP.getMundo()[fil][col]==1) & (estP.getEnergia()>30)){
			estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
			//System.out.println(" Pelear@Pac - ");
			return estP;
		}


		return null;
	}

	/**
	 * Permite actualizar el estado real del agente y del ambiente.-
	 * 
	 * @param ast: Es el estado del agente a ser actualizado.-
	 * @param est: Es el estado del ambiente a ser actualizado.-
	 */
	public EnvironmentState execute(AgentState ast, EnvironmentState est){
//		EstadoPacman estP = ((EstadoPacman)s.clone());
		EstadoAmbiente estA = (EstadoAmbiente)est;
		EstadoPacman estP = ((EstadoPacman)ast);

		int fil = estP.getFila();
		int col = estP.getColumna();
		
		if ((estA.getMundo()[fil][col]==1) & (estP.getEnergia()>30)){
			estA.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
			estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
			//System.out.println(" Pelear@Amb - ");
			return estA;
		}
		
		return null;
	}

	public Double getCost(){
		return new Double(0);
	}

	public String toString() {
		return "Pelear";
	}

}
