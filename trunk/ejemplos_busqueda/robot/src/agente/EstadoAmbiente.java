package agente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbiente extends EnvironmentState {

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
     * Este mapa tiene como clave a un punto del mundo (A, B, C, ...) y como valor una colección 
     * que contiene a los sucesores del punto.-
     */
    private HashMap<String, Collection<String>> mapa;
    public static final String[][] POSICIONES = new String[][]{
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

    EstadoAmbiente() {
        mapa = new HashMap<String, Collection<String>>();
    }

    public Object clone() {
        return mapa.clone();
    }

    public void initState() {
        /**
         * En esta matriz el primer elemento de cada fila representa un posicion en el mapa
         * y los siguientes elementos (del 1)
         */
        mapa = new HashMap<String, Collection<String>>();
        for (int i = 0; i < POSICIONES.length; i++) {
            ArrayList<String> sucesores = new ArrayList<String>();
            for (int j = 1; j < POSICIONES[i].length; j++) {
                sucesores.add(POSICIONES[i][j]);
            }
            mapa.put(POSICIONES[i][0], sucesores);

        }
    }

    public String toString() {
        String str = "";

        str = str + "[ \n";
        for (String punto : mapa.keySet()) {
            str = str + "[ " + punto + " --> ";
            Collection<String> sucesores = mapa.get(punto);
            if (sucesores != null) {
                for (String sucesor : sucesores) {
                    str = str + sucesor + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
    }

    public boolean equals(Object obj) {
        //TODO: Falta hacer este codigo, pero por ahora no es necesario porque no uso este metodo.-
        return true;
    }
}
