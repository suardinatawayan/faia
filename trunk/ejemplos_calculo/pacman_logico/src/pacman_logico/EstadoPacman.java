package pacman_logico;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.exceptions.KnowledgeBaseException;
import frsf.cidisi.faia.solver.calculus.CalculusActionFactory;
import frsf.cidisi.faia.solver.calculus.KnowledgeBase;
import frsf.cidisi.faia.state.AgentState;
import java.util.Hashtable;

public class EstadoPacman extends KnowledgeBase {

//    private int[][] mundo;
//    private int[][] mundoConocido;
//    private int[] posicion;
//    private int[] posicionInicial;
//    private int energia;
//    private int celdasVisitadas;

//    EstadoPacman(int[][] m, int fil, int col, int e) throws KnowledgeBaseException {
//        super("base_conocimiento.pl");
//
//        mundo = m;
//        posicion = new int[2];
//        posicion[0] = fil;
//        posicion[1] = col;
//        posicionInicial = new int[2];
//        posicionInicial[0] = fil;
//        posicionInicial[1] = col;
//        energia = e;
//        celdasVisitadas = 0;
//
//        mundoConocido = new int[4][4];
//        for (int f = 0; f < mundoConocido.length; f++) {
//            for (int c = 0; c < mundoConocido.length; c++) {
//                mundoConocido[f][c] = 0;
//            }
//        }
//    }
    EstadoPacman() throws KnowledgeBaseException {
        super("base_conocimiento.pl");

        this.initState();

//        mundo = new int[4][4];
//        posicion = new int[2];
//        energia = 0;
//        mundoConocido = new int[4][4];
//        this.initState();
    }

//    public int[][] getMundo() {
//        return mundo;
//    }
//
//    public void setMundo(int fil, int col, int valor) {
//        this.mundo[fil][col] = valor;
//    }
//
//    public int getMundoConocido(int fil, int col) {
//        return this.mundoConocido[fil][col];
//    }
//
//    public void setMundoConocido(int[][] mundo) {
//        this.mundoConocido = mundo;
//    }
//
//    public void setMundoConocido(int fil, int col, int valor) {
//        this.mundoConocido[fil][col] = valor;
//    }
    public int[] getPosicion() {
        // TODO: Aca habria que hacer una consulta Prolog
        String consultaPosicion = "posicion(X,Y," + this.getSituation() + ")";

        Hashtable[] resultado = this.query(consultaPosicion);

        int x = Integer.parseInt(resultado[0].get("X").toString());
        int y = Integer.parseInt(resultado[0].get("Y").toString());

        return new int[]{x, y};
    }

//    public void setFila(int valor) {
//        this.posicion[0] = valor;
//    }
//
//    public void setColumna(int valor) {
//        this.posicion[1] = valor;
//    }
    public int getFila() {
        return this.getPosicion()[0];
    }

    public int getColumna() {
        return this.getPosicion()[1];
    }

    public int getEnergia() {
        String consultaPosicion = "energia(E," + this.getSituation() + ")";

        Hashtable[] resultado = this.query(consultaPosicion);

        int energia = Integer.parseInt(resultado[0].get("E").toString());

        return energia;
    }

//    public void setEnergia(int energia) {
//        this.energia = energia;
//    }
    public Object clone() {
        return null;
//        int[][] nuevoMundo = new int[4][4];
//        int[][] nuevoMundoConocido = new int[4][4];
//
//        for (int fil = 0; fil < mundo.length; fil++) {
//            for (int col = 0; col < mundo.length; col++) {
//                nuevoMundo[fil][col] = mundo[fil][col];
//                nuevoMundoConocido[fil][col] = mundoConocido[fil][col];
//            }
//        }
//        int[] nuevaPos = new int[2];
//        nuevaPos[0] = posicion[0];
//        nuevaPos[1] = posicion[1];
//
//        EstadoPacman nuevoEstado = new EstadoPacman(nuevoMundo, this.getFila(), this.getColumna(), energia);
//        nuevoEstado.setMundoConocido(nuevoMundoConocido);
//
//        return nuevoEstado;
    }

    @Override
    public void updateState(Perception perception) {
        this.tell(perception);
    }

    public boolean todoConocido() {
        // TODO: Aca habria que hacer una consulta Prolog

//        
//        for (int fil = 0; fil < mundoConocido.length; fil++) {
//            for (int col = 0; col < mundoConocido.length; col++) {
//                if (mundoConocido[fil][col] == 0) {
//                    return false;
//                }
//            }
//        }
        return true;
    }

    public int getCeldasDesconocidas() {
        // TODO: Aca habria que hacer una consulta Prolog

//        int resultado = 0;
//
//        for (int fil = 0; fil < mundoConocido.length; fil++) {
//            for (int col = 0; col < mundoConocido.length; col++) {
//                if (mundoConocido[fil][col] == 0) {
//                    resultado++;
//                }
//            }
//        }
//        return resultado;

        return 0;
    }

    public int getComidaRestante() {
        // TODO: Aca habria que hacer una consulta Prolog

//        int resultado = 0;
//
//        for (int fil = 0; fil < mundo.length; fil++) {
//            for (int col = 0; col < mundo.length; col++) {
//                if (mundo[fil][col] == PercepcionPacman.PERCEPCION_COMIDA) {
//                    resultado++;
//                }
//            }
//        }
//        return resultado;

        return 0;
    }

    public boolean noHayMasComida() {
        // TODO: Aca habria que hacer una consulta Prolog

//        for (int fil = 0; fil < mundo.length; fil++) {
//            for (int col = 0; col < mundo.length; col++) {
//                if (mundo[fil][col] == PercepcionPacman.PERCEPCION_COMIDA) {
//                    return false;
//                }
//            }
//        }
//        return true;

        return false;
    }

    private int getMundoLength() {
        return 4;
    }

    private int getEstadoPosicion(int fila, int col) {

        // Veo si conozco el estado de la celda
        String consultaEstadoCelda = "conoce(" + fila + "," +
                col + "," + this.getSituation() + ")";

        if (!this.queryHasSolution(consultaEstadoCelda)) {
            return PercepcionPacman.PERCEPCION_DESCONOCIDO;        // Veo si hay un enemigo
        }
        consultaEstadoCelda = "enemigo(" + fila + "," +
                col + "," + this.getSituation() + ")";

        if (this.queryHasSolution(consultaEstadoCelda)) {
            return PercepcionPacman.PERCEPCION_ENEMIGO;        // Veo si hay comida
        }
        consultaEstadoCelda = "comida(" + fila + "," +
                col + "," + this.getSituation() + ")";

        if (this.queryHasSolution(consultaEstadoCelda)) {
            return PercepcionPacman.PERCEPCION_COMIDA;        // Veo si esta vacia
        }
        consultaEstadoCelda = "vacia(" + fila + "," +
                col + "," + this.getSituation() + ")";

        if (this.queryHasSolution(consultaEstadoCelda)) {
            return PercepcionPacman.PERCEPCION_VACIO;        // TODO: No deberia llegar aca nunca
        }
        return 9;
    }

    public String toString() {
        String str = "";

        str = str + " posicion=\"(" + getFila() + "," + "" + getColumna() + ")\"";
        str = str + " energia=\"" + this.getEnergia() + "\"\n";

        str = str + "mundo=\"[ \n";
        for (int fil = 0; fil < this.getMundoLength(); fil++) {
            str = str + "[ ";
            for (int col = 0; col < this.getMundoLength(); col++) {

                if (this.getFila() == fil && this.getColumna() == col) {
                    str = str + "P" + " ";
                    continue;
                }

                if (this.getEstadoPosicion(fil, col) == PercepcionPacman.PERCEPCION_DESCONOCIDO) {
                    str = str + "* ";
                } else {
                    str = str + this.getEstadoPosicion(fil, col) + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";

        return str;
    }

    public int getCeldasVisitadas() {
        // TODO: Aca habria que hacer una consulta Prolog

        return 0;
    }

    @Override
    public CalculusActionFactory getActionFactory() {
        return CalculusAccion.getInstance();
    }

    @Override
    public String getBestActionPredicate() {
        return "mejorAccion";
    }

    @Override
    public String getGoalReachedPredicate() {
        return "cumplioObjetivo";
    }

    @Override
    public void initState() {
        this.addKnowledge("situacionActual(0)");
        this.addKnowledge("posicion(1,2,0)");
        this.addKnowledge("energia(50,0)");
    }

    @Override
    public String getExecutedActionPredicate() {
        return "accionEjecutada";
    }

    @Override
    public String getCurrentSituationPredicate() {
        return "situacionActual";
    }
}
