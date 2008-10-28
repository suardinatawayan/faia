package agente.acciones;

import frsf.cidisi.faia.agent.planning.PlanningAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import agente.EstadoAmbiente;
import agente.EstadoPacman;
import agente.PercepcionPacman;
import agente.estados.PosicionadoEn;

public class Comer extends PlanningAction {
	
	public Comer() {
		super();
		
		this.preconditions.add(new PosicionadoEn(this));
	}
	
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbiente estA = (EstadoAmbiente) est;
        EstadoPacman estP = ((EstadoPacman) ast);

        int fil = estP.getFila();
        int col = estP.getColumna();

        if (estA.getMundo()[fil][col] == PercepcionPacman.PERCEPCION_COMIDA) {
            estA.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            
            return estA;
        }

        return null;
    }
    
    @Override
    public String toString() {
        return "Comer";
    }
}
