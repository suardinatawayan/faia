/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa,
 * Luis Ignacio Larrateguy y Milton Pividori.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package frsf.cidisi.faia.examples.situationcalculus.pacman.actions;

import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.cidisi.faia.examples.situationcalculus.pacman.EstadoAmbientePacmanLogico;
import frsf.cidisi.faia.examples.situationcalculus.pacman.EstadoPacmanLogico;
import frsf.cidisi.faia.examples.situationcalculus.pacman.PercepcionPacmanLogico;

public class Comer extends SituationCalculusAction {
    
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbientePacmanLogico estA = (EstadoAmbientePacmanLogico) est;
        EstadoPacmanLogico estP = ((EstadoPacmanLogico) ast);

        int fil = estP.getFila();
        int col = estP.getColumna();

        if (estA.getMundo()[fil][col] == PercepcionPacmanLogico.PERCEPCION_COMIDA) {
            estA.setMundo(fil, col, PercepcionPacmanLogico.PERCEPCION_VACIO);
            
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
        return "comer";
    }
}
