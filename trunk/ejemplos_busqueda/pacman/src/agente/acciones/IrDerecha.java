package agente.acciones;

import agente.*;
import frsf.cidisi.faia.agent.searchbased.SearchAction;
import frsf.cidisi.faia.agent.searchbased.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrDerecha extends SearchAction {
    
	/**
	 * Ver el comentario hecho en la clase Comer.
	 */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
//		EstadoPacman estP = ((EstadoPacman)s.clone());
        EstadoPacman estP = (EstadoPacman) s;

        estP.incCeldasVisitadas();

        int fil = estP.getFila();
        int col = estP.getColumna();


        if (col == 3) {
            col = 0;
        } else {
            col = col + 1;
        }
        estP.setColumna(col);
        if (estP.getMundoConocido(fil, col) == 0) {
            estP.setMundoConocido(fil, col, 1);
            return estP;
        }
        //System.out.println(" Derecha@Pac - ");

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

        if (col == 3) {
            col = 0;
        } else {
            col = col + 1;
        }
        estP.setColumna(col);
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
        return "Derecha";
    }
}
