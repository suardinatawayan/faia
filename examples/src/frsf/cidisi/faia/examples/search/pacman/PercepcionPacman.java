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

public class PercepcionPacman extends Perception {

    public static int PERCEPCION_DESCONOCIDO = -1;
    public static int PERCEPCION_VACIO = 0;
    public static int PERCEPCION_ENEMIGO = 1;
    public static int PERCEPCION_COMIDA = 2;
    private int sensorIzquierda;
    private int sensorArriba;
    private int sensorDerecha;
    private int sensorAbajo;
    private int energia;

    public PercepcionPacman() {
        energia = 50;
    }

    public PercepcionPacman(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * Método utilizado para inicializar una percepción.
     */
    @Override
    public void initPerception(Agent agent, Environment environment) {
        AgentePacman pacman = (AgentePacman) agent;
        AmbientePacman ambiente = (AmbientePacman) environment;

        int fil = ((EstadoPacman) pacman.getAgentState()).getFila();
        int col = ((EstadoPacman) pacman.getAgentState()).getColumna();

        setSensorArriba(ambiente.getArriba(fil, col));
        setSensorIzquierda(ambiente.getIzquierda(fil, col));
        setSensorDerecha(ambiente.getDerecha(fil, col));
        setSensorAbajo(ambiente.getAbajo(fil, col));
    }

    // Estos métodos son internos de la clase PercepcionPacman.
    public int getSensorIzquierda() {
        return sensorIzquierda;
    }

    public void setSensorIzquierda(int sensorIzquierda) {
        this.sensorIzquierda = sensorIzquierda;
    }

    public int getSensorArriba() {
        return sensorArriba;
    }

    public void setSensorArriba(int sensorArriba) {
        this.sensorArriba = sensorArriba;
    }

    public int getSensorDerecha() {
        return sensorDerecha;
    }

    public void setSensorDerecha(int sensorDerecha) {
        this.sensorDerecha = sensorDerecha;
    }

    public int getSensorAbajo() {
        return sensorAbajo;
    }

    public void setSensorAbajo(int sensorAbajo) {
        this.sensorAbajo = sensorAbajo;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
}
