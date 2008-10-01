package agente.acciones;

import agente.*;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.searchbased.SearchAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrArriba extends SearchAction {
    
	/**
	 * Ver el comentario hecho en la clase Comer.
	 */
    @Override
    public AgentState execute(AgentState s) {
//		EstadoPacman estP = ((EstadoPacman)s.clone());
        EstadoPacman estP = (EstadoPacman) s;

        estP.incCeldasVisitadas();

        int fil = estP.getFila();
        int col = estP.getColumna();

        if (fil == 0) {
            fil = 3;
        } else {
            fil = fil - 1;
        }
        estP.setFila(fil);
        if (estP.getMundoConocido(fil, col) == 0) {
            estP.setMundoConocido(fil, col, 1);
            return estP;
        }
        //System.out.println(" Arriba@Pac - ");

        return null;
    }
    
    /**
	 * Ver el comentario hecho en la clase Comer.
	 */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
//		EstadoPacman estP = ((EstadoPacman)s.clone());
        EstadoAmbiente estA = (EstadoAmbiente) est;
        EstadoPacman estP = ((EstadoPacman) ast);

        estP.incCeldasVisitadas();

        int fil = estP.getFila();
        int col = estP.getColumna();

        if (fil == 0) {
            fil = 3;
        } else {
            fil = fil - 1;
        }
        estP.setFila(fil);
        estP.setMundoConocido(fil, col, 1);
        //estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
        //System.out.println(" Arriba@Amb - ");
        return estA;
    }

    /**
	 * Ver el comentario hecho en la clase Comer.
	 */
    @Override
    public Double getCost() {
        return new Double(0);
    }

    /**
	 * Ver el comentario hecho en la clase Comer.
	 */
    @Override
    public String toString() {
        return "Arriba";
    }
}
