package frsf.cidisi.faia.examples.search.pacman;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * Representa el estado del mundo.
 */
public class EstadoAmbiente extends EnvironmentState {

    private int[][] mundo;

    EstadoAmbiente(int[][] m) {
        mundo = m;
    }

    EstadoAmbiente() {
        mundo = new int[4][4];
        this.initState();
    }

//    @Override
//    public Object clone() {
//        int[][] nuevoMundo = new int[4][4];
//
//        for (int fil = 0; fil < mundo.length; fil++) {
//            for (int col = 0; col < mundo.length; col++) {
//                nuevoMundo[fil][col] = mundo[fil][col];
//            }
//        }
//        EstadoAmbiente nuevoEstado = new EstadoAmbiente(nuevoMundo);
//
//        return nuevoEstado;
//    }

    /**
     * Este método se utiliza para setear el estado inicial del mundo
     * real, visto por el simulador.
     */
    @Override
    public void initState() {
    	
    	// Pongo todas las celdas como vacías.
        for (int fil = 0; fil < mundo.length; fil++) {
            for (int col = 0; col < mundo.length; col++) {
                mundo[fil][col] = PercepcionPacman.PERCEPCION_VACIO;
            }
        }
        
        /* Coloco en algunas posiciones ciertos elementos como comida y
         * alimentos. */
        mundo[0][0] = PercepcionPacman.PERCEPCION_COMIDA;
        mundo[0][2] = PercepcionPacman.PERCEPCION_COMIDA;
        mundo[3][1] = PercepcionPacman.PERCEPCION_ENEMIGO;
        mundo[2][1] = PercepcionPacman.PERCEPCION_COMIDA;
        mundo[0][3] = PercepcionPacman.PERCEPCION_ENEMIGO;
        mundo[1][2] = PercepcionPacman.PERCEPCION_COMIDA;
    }
    
    /**
     * Para imprimir por consola una representación del mundo real.
     */
    @Override
    public String toString() {
        String str = "";

        str = str + "[ \n";
        for (int fil = 0; fil < mundo.length; fil++) {
            str = str + "[ ";
            for (int col = 0; col < mundo.length; col++) {
                str = str + mundo[fil][col] + " ";
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
    }
    
    // Estos métodos son internos de la clase EstadoAmbiente.
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
