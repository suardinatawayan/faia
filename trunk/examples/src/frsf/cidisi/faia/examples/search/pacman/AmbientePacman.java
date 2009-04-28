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

package frsf.cidisi.faia.examples.search.pacman;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbientePacman extends Environment {

    public AmbientePacman() {
        // Se instancia el estado del ambiente.
        this.environmentState = new EstadoAmbiente();
    }

    /**
     * Este método tiene la responsabilidad de, al recibir el objeto Agente,
     * crear una percepción apartir de su ubicación. Este método es llamado
     * por el simulador.
     * @param agent
     * @return Una percepción que será entregada al agente por el simulador.
     */
    @Override
    public Perception getPercept(Agent agent) {
        // El ambiente crea una percepción que va a ser recibida por el Pacman.
        PercepcionPacman p = new PercepcionPacman();

        // Es necesario realizar un "cast" para acceder a los métodos del agente Pacman.
        AgentePacman pacman = (AgentePacman) agent;

        // Obtiene la posición actual del pacman para saber que percepciones brindarle.
        int fil = ((EstadoPacman) pacman.getAgentState()).getFila();
        int col = ((EstadoPacman) pacman.getAgentState()).getColumna();

        // Asigna las percepciones en los sensores.
        p.setSensorArriba(this.getArriba(fil, col));
        p.setSensorIzquierda(this.getIzquierda(fil, col));
        p.setSensorDerecha(this.getDerecha(fil, col));
        p.setSensorAbajo(this.getAbajo(fil, col));

        // Retorna la nueva percepción creada.
        return p;
    }
    
    @Override
    public String toString() {
        return environmentState.toString();
    }

    // Este métodos de abajo, son internos de la clase AmbientePacman.
    public int getArriba(int fil, int col) {
        return ((EstadoAmbiente) this.environmentState).getArriba(fil, col);
    }

    public int getIzquierda(int fil, int col) {
        return ((EstadoAmbiente) this.environmentState).getIzquierda(fil, col);
    }

    public int getDerecha(int fil, int col) {
        return ((EstadoAmbiente) this.environmentState).getDerecha(fil, col);
    }

    public int getAbajo(int fil, int col) {
        return ((EstadoAmbiente) this.environmentState).getAbajo(fil, col);
    }
}
