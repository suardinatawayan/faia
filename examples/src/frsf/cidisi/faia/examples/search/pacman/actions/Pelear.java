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

package frsf.cidisi.faia.examples.search.pacman.actions;

import frsf.cidisi.faia.examples.search.pacman.*;
import frsf.cidisi.faia.agent.searchbased.SearchAction;
import frsf.cidisi.faia.agent.searchbased.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Pelear extends SearchAction {
    
	/**
	 * Ver el comentario hecho en la clase Comer.
	 */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
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
    
    /**
	 * Ver el comentario hecho en la clase Comer.
	 */
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
        return "Pelear";
    }
}
