package pacman;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrDerecha extends Action{

	/**
	 * Permite actualizar el estado de los nodos un �rbol de b�squeda durante la creaci�n del mismo.-
	 * 
	 * @param s: Es el estado del agente en un determinado nodo del �rbol de b�squeda.-
	 */
	public AgentState execute(AgentState s){
//		EstadoPacman estP = ((EstadoPacman)s.clone());
		EstadoPacman estP = (EstadoPacman)s;

		estP.incCeldasVisitadas();

		int fil = estP.getFila();
		int col = estP.getColumna();
		

		if (col==3)
			col = 0;
		else
			col = col + 1;

		estP.setColumna(col);
		if (estP.getMundoConocido(fil, col)==0){
			estP.setMundoConocido(fil, col, 1);
			return estP;
		}
		//System.out.println(" Derecha@Pac - ");

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
		
		if (col==3)
			col = 0;
		else
			col = col + 1;

		estP.setColumna(col);
		estP.setMundoConocido(fil, col, 1);

		//estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
		//System.out.println(" Arriba@Amb - ");
		return estA;
	}
	
	public Double getCost(){
		return new Double(0);
	}
	
	public String toString() {
		return "Derecha";
	}

	@Override
	public String getLogicName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
