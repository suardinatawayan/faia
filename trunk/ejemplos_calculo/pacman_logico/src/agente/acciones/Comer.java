package agente.acciones;

import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import agente.EstadoAmbiente;
import agente.EstadoPacman;
import agente.PercepcionPacman;

public class Comer extends SituationCalculusAction {
    
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

    /**
     * Si bien el uso de éste método no es muy importante cuando se crea un
     * agente basado en búsqueda, sí es vital establecer correctamente el nombre
     * de la acción cuando se crea un agente basado en cálculo situacional, como
     * en este caso.
     * Mirar el código del método CalculusAction.toLogicName(). Lo que hace ese
     * método es pasar el resultado de éste a minúsculas, y supone que en el
     * archivo prolog se está utilizando ese string (en minúsculas) para indicar
     * la acción.
     * 
     * En este ejemplo, en el archivo 'base_conocimiento.pl' (al que llamamos
     * archivo prolog) se utiliza el string 'comer' para indicar este acción.
     * Por lo tanto es correcto utilizar aquí tanto 'Comer', como 'COMER', pero
     * no 'AccionComer', ya que se transformaría a 'accioncomer' y esa no es
     * la representación correcta de la acción Comer en el archivo prolog.
     */
    @Override
    public String toString() {
        return "Comer";
    }
}
