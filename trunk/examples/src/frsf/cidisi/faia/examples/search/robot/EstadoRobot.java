/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa
 * y Milton Pividori.
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

package frsf.cidisi.faia.examples.search.robot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.searchbased.SearchBasedAgentState;

public class EstadoRobot extends SearchBasedAgentState {

    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";
    public static final String D = "D";
    public static final String E = "E";
    public static final String F = "F";
    public static final String G = "G";
    public static final String H = "H";
    public static final String I = "I";
    public static final String J = "J";
    public static final String K = "K";
    public static final String L = "L";
    public static final String M = "M";
    public static final String N = "N";
    public static final String O = "O";
    public static final String P = "P";
    public static final String Q = "Q";
    /**
     * Posición actual del robot.-
     */
    String posicion;
    /**
     * Este 
     * Este mapa tiene como clave a un punto del mundo (A, B, C, ...) y como valor una colección 
     * que contiene a los sucesores del punto.-
     */
    private HashMap<String, Collection<String>> mapaConocido;
    private ArrayList<String> posicionesVisitadas;

    public EstadoRobot() {
        this.initState();
    }

    public EstadoRobot clone() {
        EstadoRobot nuevoEstado = new EstadoRobot();
        nuevoEstado.setPosicion(posicion);
        ArrayList<String> posVis = (ArrayList<String>) posicionesVisitadas.clone();
        nuevoEstado.setPosicionesVisitadas(posVis);
        return nuevoEstado;
    }

    public void initState() {
        posicion = A;

        /**
         * En esta matriz el primer elemento de cada fila representa un posicion en el mapa
         * y los siguientes elementos (del 1)
         */
        String[][] posiciones = new String[][]{
            {A, C, G},
            {B, J, K, O},
            {C, D, G},
            {D, C, E},
            {E, F, H, I, D},
            {F, E, H, G, Q},
            {G, C, F, Q},
            {H, E, F, I, J},
            {I, E, H, J, L},
            {J, B, H, I, K},
            {K, J, N, L},
            {L, I, K, M},
            {M, L, N},
            {N, K, M},
            {O, B, P},
            {P, O, Q},
            {Q, B, F, G, P}
        };

        mapaConocido = new HashMap<String, Collection<String>>();
        for (int i = 0; i < posiciones.length; i++) {
            ArrayList<String> sucesores = new ArrayList<String>();
            for (int j = 1; j < posiciones[i].length; j++) {
                sucesores.add(posiciones[i][j]);
            }
            mapaConocido.put(posiciones[i][0], sucesores);

        }

        posicionesVisitadas = new ArrayList<String>();

    }

    public void updateState(Perception p) {
        posicionesVisitadas.add(posicion);
    }

    public String toString() {
        String str = "";

//		str = str + "[ \n";
//		for (String punto : mapaConocido.keySet()){
//			str = str + "[ "+punto+" --> ";
//			Collection<String> sucesores = mapaConocido.get(punto);
//			if (sucesores!=null){
//				for (String sucesor : sucesores){
//					str = str + sucesor + " ";
//				}
//			}
//			str = str + " ]\n";
//		}
//		str = str + " ]";

        str = str + "Posicion: " + posicion;

        return str;

    }

    public boolean equals(Object obj) {

        if (!(obj instanceof EstadoRobot)) {
            return false;
        }
        return posicion.equals(((EstadoRobot) obj).getPosicion());
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Collection<String> getSucesores() {
        return mapaConocido.get(posicion);
    }

    public ArrayList<String> getPosicionesVisitadas() {
        return posicionesVisitadas;
    }

    public void setPosicionesVisitadas(ArrayList<String> posicionesVisitadas) {
        this.posicionesVisitadas = posicionesVisitadas;
    }
}
