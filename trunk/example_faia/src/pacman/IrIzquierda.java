package pacman;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrIzquierda extends Action {

	/**
	 * Permite actualizar el estado de los nodos un árbol de búsqueda durante la creación del mismo.-
	 * 
	 * @param s: Es el estado del agente en un determinado nodo del árbol de búsqueda.-
	 */
	public AgentState execute(AgentState s){
//		EstadoPacman estP = ((EstadoPacman)s.clone());
		EstadoPacman estP = (EstadoPacman)s;

		estP.incCeldasVisitadas();

		int fil = estP.getFila();
		int col = estP.getColumna();

			
		if (col==0) 
			col = 3;
		else
			col = col - 1;

		estP.setColumna(col);
		if (estP.getMundoConocido(fil, col)==0){
			estP.setMundoConocido(fil, col, 1);
			return estP;
		}
		//System.out.println(" Izquierda@Pac - ");

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

		estP.incCeldasVisitadas();

		int fil = estP.getFila();
		int col = estP.getColumna();
		
		if (col==0) 
			col = 3;
		else
			col = col - 1;

		estP.setColumna(col);
		estP.setMundoConocido(fil, col, 1);

		//estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
		//System.out.println(" Izquierda@Amb - ");
		return estA;
	}

	public Double getCost(){
		return new Double(0);
	}

	public String toString() {
		return "Izquierda";
	}

}
