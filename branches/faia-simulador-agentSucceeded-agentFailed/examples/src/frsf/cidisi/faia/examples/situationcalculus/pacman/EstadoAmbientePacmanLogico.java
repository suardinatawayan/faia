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

package frsf.cidisi.faia.examples.situationcalculus.pacman;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * Esta clase es muy similar a su par correspondiente en el ejemplo
 * del 'pacman' (basado en Búsqueda). Es recomendable mirar los comentarios
 * allí primero.
 * Ver que esta clase es idéntica a la del ejemplo 'pacman', ya que el hecho
 * de que se utilice Cálculo Situacional en el agente, no hace que tengan
 * que cambiarse todas las clases, entre ellas la representación del
 * mundo real vista por el simulador.
 */
public class EstadoAmbientePacmanLogico extends EnvironmentState {

    private int[][] mundo;

    EstadoAmbientePacmanLogico(int[][] m) {
        mundo = m;
    }

    EstadoAmbientePacmanLogico() {
        mundo = new int[4][4];
        this.initState();
    }
    
    @Override
    public void initState() {

        for (int fil = 0; fil < mundo.length; fil++) {
            for (int col = 0; col < mundo.length; col++) {
                mundo[fil][col] = PercepcionPacmanLogico.PERCEPCION_VACIO;
            }
        }
        mundo[0][0] = PercepcionPacmanLogico.PERCEPCION_COMIDA;
        mundo[0][2] = PercepcionPacmanLogico.PERCEPCION_COMIDA;
        mundo[3][1] = PercepcionPacmanLogico.PERCEPCION_ENEMIGO;
        mundo[2][1] = PercepcionPacmanLogico.PERCEPCION_COMIDA;
        mundo[0][3] = PercepcionPacmanLogico.PERCEPCION_ENEMIGO;
        mundo[1][2] = PercepcionPacmanLogico.PERCEPCION_COMIDA;
    }
    
    @Override
    public String toString() {
        String str = "";

        str = str + "[ \n";
        for (int fil = 0; fil < mundo.length; fil++) {
            str = str + "[ ";
            for (int col = 0; col < mundo.length; col++) {
                str = str + this.convertirCelda(mundo[fil][col]) + " ";
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
    }

    // Estos métodos son internos de la clase EstadoAmbiente.
    
    private String convertirCelda(int p) {
    	String r = "";
    	
    	if (p == PercepcionPacmanLogico.PERCEPCION_COMIDA)
    		r = "C";
    	else if (p == PercepcionPacmanLogico.PERCEPCION_ENEMIGO)
    		r = "E";
    	else if (p == PercepcionPacmanLogico.PERCEPCION_VACIO)
    		r = " ";
    	
    	return r;
    }
    
    public int[][] getMundo() {
        return mundo;
    }

    public void setMundo(int[][] mundo) {
        this.mundo = mundo;
    }

    public void setMundo(int fil, int col, int valor) {
        this.mundo[fil][col] = valor;
    }

    public int getArriba(int fil, int col) {
        if (fil == 0) {
            return mundo[3][col];
        }
        return mundo[fil - 1][col];
    }

    public int getIzquierda(int fil, int col) {
        if (col == 0) {
            return mundo[fil][3];
        }
        return mundo[fil][col - 1];
    }

    public int getDerecha(int fil, int col) {
        if (col == 3) {
            return mundo[fil][0];
        }
        return mundo[fil][col + 1];
    }

    public int getAbajo(int fil, int col) {
        if (fil == 3) {
            return mundo[0][col];
        }
        return mundo[fil + 1][col];
    }
}
