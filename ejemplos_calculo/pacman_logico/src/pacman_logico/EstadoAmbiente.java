package pacman_logico;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbiente extends EnvironmentState {

    private int[][] mundo;

    EstadoAmbiente(int[][] m) {
        mundo = m;
    }

    EstadoAmbiente() {
        mundo = new int[4][4];
        this.initState();
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

    public Object clone() {
        int[][] nuevoMundo = new int[4][4];

        for (int fil = 0; fil < mundo.length; fil++) {
            for (int col = 0; col < mundo.length; col++) {
                nuevoMundo[fil][col] = mundo[fil][col];
            }
        }
        EstadoAmbiente nuevoEstado = new EstadoAmbiente(nuevoMundo);

        return nuevoEstado;
    }

    public void initState() {

        for (int fil = 0; fil < mundo.length; fil++) {
            for (int col = 0; col < mundo.length; col++) {
                mundo[fil][col] = PercepcionPacman.PERCEPCION_VACIO;
            }
        }
        mundo[0][0] = PercepcionPacman.PERCEPCION_COMIDA;
        mundo[0][2] = PercepcionPacman.PERCEPCION_COMIDA;
        mundo[3][1] = PercepcionPacman.PERCEPCION_ENEMIGO;
        mundo[2][1] = PercepcionPacman.PERCEPCION_COMIDA;
        mundo[0][3] = PercepcionPacman.PERCEPCION_ENEMIGO;
        mundo[1][2] = PercepcionPacman.PERCEPCION_COMIDA;
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

    public boolean equals(Object obj) {
        //TODO: Falta hacer este codigo, pero por ahora no es necesario porque no uso este metodo.-
        return true;
    }
}
