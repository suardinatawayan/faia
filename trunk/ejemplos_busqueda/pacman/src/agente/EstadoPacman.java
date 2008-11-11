package agente;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.searchbased.SearchBasedAgentState;

/**
 * Representa el estado interno del Pacman, su visión del mundo.
 */
public class EstadoPacman extends SearchBasedAgentState {

    private int[][] mundo;
    private int[][] mundoConocido;
    private int[] posicion;
    private int[] posicionInicial;
    private int energia;
    private int celdasVisitadas;

    EstadoPacman(int[][] m, int fil, int col, int e) {
        mundo = m;
        posicion = new int[2];
        posicion[0] = fil;
        posicion[1] = col;
        posicionInicial = new int[2];
        posicionInicial[0] = fil;
        posicionInicial[1] = col;
        energia = e;
        celdasVisitadas = 0;

        mundoConocido = new int[4][4];
        for (int f = 0; f < mundoConocido.length; f++) {
            for (int c = 0; c < mundoConocido.length; c++) {
                mundoConocido[f][c] = 0;
            }
        }
    }

    EstadoPacman() {
        mundo = new int[4][4];
        posicion = new int[2];
        energia = 0;
        mundoConocido = new int[4][4];
        this.initState();
    }
    
    /**
     * Este método es necesario, ya que necesitamos poder clonar los estados
     * en el proceso de búsqueda, al armar el árbol.
     */
    @Override
    public SearchBasedAgentState clone() {
        int[][] nuevoMundo = new int[4][4];
        int[][] nuevoMundoConocido = new int[4][4];

        for (int fil = 0; fil < mundo.length; fil++) {
            for (int col = 0; col < mundo.length; col++) {
                nuevoMundo[fil][col] = mundo[fil][col];
                nuevoMundoConocido[fil][col] = mundoConocido[fil][col];
            }
        }
        
        int[] nuevaPos = new int[2];
        nuevaPos[0] = posicion[0];
        nuevaPos[1] = posicion[1];

        EstadoPacman nuevoEstado = new EstadoPacman(nuevoMundo, this.getFila(), this.getColumna(), energia);
        nuevoEstado.setMundoConocido(nuevoMundoConocido);

        return nuevoEstado;
    }
    
    /**
     * Este método se utiliza para actualizar el estado del agente al recibir
     * una percepción desde el simulador.
     */
    @Override
    public void updateState(Perception p) {
        PercepcionPacman pp = (PercepcionPacman) p;

        int fil = this.getFila();
        int col = this.getColumna();

        if (col == 0) {
            col = 3;
        } else {
            col = col - 1;
        }
        mundo[fil][col] = pp.getSensorIzquierda();
        //mundoConocido[fil][col]=1;

        fil = this.getFila();
        col = this.getColumna();

        if (col == 3) {
            col = 0;
        } else {
            col = col + 1;
        }
        mundo[fil][col] = pp.getSensorDerecha();
        //mundoConocido[fil][col]=1;

        fil = this.getFila();
        col = this.getColumna();

        if (fil == 0) {
            fil = 3;
        } else {
            fil = fil - 1;
        }
        mundo[fil][col] = pp.getSensorArriba();
        //mundoConocido[fil][col]=1;


        fil = this.getFila();
        col = this.getColumna();

        if (fil == 3) {
            fil = 0;
        } else {
            fil = fil + 1;
        }
        mundo[fil][col] = pp.getSensorAbajo();
        //mundoConocido[fil][col]=1;

        energia = pp.getEnergia();
    }
    
    /**
     * Este método setea el estado inicial del agente en el mundo.
     */
    @Override
    public void initState() {
        for (int fil = 0; fil < mundo.length; fil++) {
            for (int col = 0; col < mundo.length; col++) {
                mundo[fil][col] = PercepcionPacman.PERCEPCION_DESCONOCIDO;
                mundoConocido[fil][col] = 0;
            }
        }
        this.setFila(1);
        this.setColumna(1);

        this.setEnergia(50);

    }
    
    /**
     * Este método se utiliza para imprimir en consola el estado del agente.
     */
    @Override
    public String toString() {
        String str = "";

        str = str + " posicion=\"(" + getFila() + "," + "" + getColumna() + ")\"";
        str = str + " energia=\"" + energia + "\"\n";

        str = str + "mundo=\"[ \n";
        for (int fil = 0; fil < mundo.length; fil++) {
            str = str + "[ ";
            for (int col = 0; col < mundo.length; col++) {
                if (mundo[fil][col] == -1) {
                    str = str + "* ";
                } else {
                    str = str + mundo[fil][col] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";

        return str;
    }

    /**
     * Utilizamos este método para verificar, en el proceso de búsqueda, si
     * un nodo ya existe en la rama de búsqueda actual.
     */
    @Override
    public boolean equals(Object obj) {
        int[][] mundoObj = ((EstadoPacman) obj).getMundo();
        int[] posicionObj = ((EstadoPacman) obj).getPosicion();
//		int energiaObj = ((EstadoPacman)obj).getEnergia();

        for (int fil = 0; fil < mundo.length; fil++) {
            for (int col = 0; col < mundo.length; col++) {
                if (mundo[fil][col] != mundoObj[fil][col]) {
                    return false;
                }
            }
        }
        if (posicion[0] != posicionObj[0] | posicion[1] != posicionObj[1]) {
            return false;
        /*		if (energia!=energiaObj)
        return false;
         */
        }
        return true;
    }

    // Estos métodos son internos a la clase EstadoPacman.
    public int[][] getMundo() {
        return mundo;
    }

    public void setMundo(int fil, int col, int valor) {
        this.mundo[fil][col] = valor;
    }

    public int getMundoConocido(int fil, int col) {
        return this.mundoConocido[fil][col];
    }

    public void setMundoConocido(int[][] mundo) {
        this.mundoConocido = mundo;
    }

    public void setMundoConocido(int fil, int col, int valor) {
        this.mundoConocido[fil][col] = valor;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public void setFila(int valor) {
        this.posicion[0] = valor;
    }

    public void setColumna(int valor) {
        this.posicion[1] = valor;
    }

    public int getFila() {
        return posicion[0];
    }

    public int getColumna() {
        return posicion[1];
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public boolean todoConocido() {
        for (int fil = 0; fil < mundoConocido.length; fil++) {
            for (int col = 0; col < mundoConocido.length; col++) {
                if (mundoConocido[fil][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getCeldasDesconocidas() {
        int resultado = 0;

        for (int fil = 0; fil < mundoConocido.length; fil++) {
            for (int col = 0; col < mundoConocido.length; col++) {
                if (mundoConocido[fil][col] == 0) {
                    resultado++;
                }
            }
        }
        return resultado;
    }

    public int getComidaRestante() {
        int resultado = 0;

        for (int fil = 0; fil < mundo.length; fil++) {
            for (int col = 0; col < mundo.length; col++) {
                if (mundo[fil][col] == PercepcionPacman.PERCEPCION_COMIDA) {
                    resultado++;
                }
            }
        }
        return resultado;
    }

    public boolean noHayMasComida() {
        for (int fil = 0; fil < mundo.length; fil++) {
            for (int col = 0; col < mundo.length; col++) {
                if (mundo[fil][col] == PercepcionPacman.PERCEPCION_COMIDA) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getCeldasVisitadas() {
        return celdasVisitadas;
    }

    public void incCeldasVisitadas() {
        this.celdasVisitadas = +20;
    }
}
