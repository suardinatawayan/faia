package frsf.cidisi.faia.examples.search.pacman.actions;

import frsf.cidisi.faia.examples.search.pacman.*;
import frsf.cidisi.faia.agent.searchbased.SearchAction;
import frsf.cidisi.faia.agent.searchbased.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrAbajo extends SearchAction {

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


        if (fil == 3) {
            fil = 0;
        } else {
            fil = fil + 1;
        }
        estP.setFila(fil);
        if (estP.getMundoConocido(fil, col) == 0) {
            estP.setMundoConocido(fil, col, 1);
            return estP;
        }
        //System.out.println(" Abajo@Pac - ");

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

        if (fil == 3) {
            fil = 0;
        } else {
            fil = fil + 1;
        }
        estP.setFila(fil);
        estP.setMundoConocido(fil, col, 1);
        //estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
        //System.out.println(" Abajo@Amb - ");
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
        return "Abajo";
    }
}
