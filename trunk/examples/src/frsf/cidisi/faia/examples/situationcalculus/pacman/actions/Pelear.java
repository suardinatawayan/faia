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

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.cidisi.faia.examples.situationcalculus.pacman.EstadoAmbientePacmanLogico;
import frsf.cidisi.faia.examples.situationcalculus.pacman.EstadoPacmanLogico;
import frsf.cidisi.faia.examples.situationcalculus.pacman.PercepcionPacmanLogico;

public class Pelear extends SituationCalculusAction {

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbientePacmanLogico estA = (EstadoAmbientePacmanLogico) est;
        EstadoPacmanLogico estP = ((EstadoPacmanLogico) ast);

        int fil = estP.getFila();
        int col = estP.getColumna();

        if ((estA.getMundo()[fil][col] == 1) & (estP.getEnergia() > 30)) {
            estA.setMundo(fil, col, PercepcionPacmanLogico.PERCEPCION_VACIO);
            //estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //System.out.println(" Pelear@Amb - ");
            return estA;
        }

        return null;
    }

    @Override
    public String toString() {
        return "pelear";
    }
}
