package agente.acciones;

import agente.*;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.searchbased.SearchAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Pelear extends SearchAction {
    
    @Override
    public AgentState execute(AgentState s) {
//		EstadoPacman estP = ((EstadoPacman)s.clone());
        EstadoPacman estP = (EstadoPacman) s;

        int fil = estP.getFila();
        int col = estP.getColumna();

        if ((estP.getMundo()[fil][col] == 1) & (estP.getEnergia() > 30)) {
            estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //System.out.println(" Pelear@Pac - ");
            return estP;
        }


        return null;
    }
    
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
//		EstadoPacman estP = ((EstadoPacman)s.clone());
        EstadoAmbiente estA = (EstadoAmbiente) est;
        EstadoPacman estP = ((EstadoPacman) ast);

        int fil = estP.getFila();
        int col = estP.getColumna();

        if ((estA.getMundo()[fil][col] == 1) & (estP.getEnergia() > 30)) {
            estA.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //System.out.println(" Pelear@Amb - ");
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
        return "Pelear";
    }
}
