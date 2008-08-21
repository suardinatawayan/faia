package pacman;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.searchbased.SearchAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Comer extends SearchAction {
    
    @Override
    public AgentState execute(AgentState s) {
        EstadoPacman estP = (EstadoPacman) s;

        int fil = estP.getFila();
        int col = estP.getColumna();

        if (estP.getMundo()[fil][col] == PercepcionPacman.PERCEPCION_COMIDA) {
            estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //System.out.println(" Comer@Pac - ");
            return estP;
        }


        return null;
    }
    
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbiente estA = (EstadoAmbiente) est;
        EstadoPacman estP = ((EstadoPacman) ast);

        int fil = estP.getFila();
        int col = estP.getColumna();

        if (estA.getMundo()[fil][col] == PercepcionPacman.PERCEPCION_COMIDA) {
            estA.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //System.out.println(" Comer@Amb - ");
            return estA;
        }

        return null;
    }

    @Override
    public Double getCost() {
        return new Double(0);
    }

    @Override
    public String toString() {
        return "Comer";
    }
}
