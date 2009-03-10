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
    
//  public Object clone() {
//  int[][] nuevoMundo = new int[4][4];
//
//  for (int fil = 0; fil < mundo.length; fil++) {
//      for (int col = 0; col < mundo.length; col++) {
//          nuevoMundo[fil][col] = mundo[fil][col];
//      }
//  }
//  EstadoAmbiente nuevoEstado = new EstadoAmbiente(nuevoMundo);
//
//  return nuevoEstado;
//}
    
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
