package agente;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.exceptions.KnowledgeBaseException;
import frsf.cidisi.faia.solver.calculus.CalculusActionFactory;
import frsf.cidisi.faia.solver.calculus.KnowledgeBase;
import java.util.Hashtable;

public class EstadoPacman extends KnowledgeBase {
    
    public EstadoPacman() throws KnowledgeBaseException {
        super("base_conocimiento.pl");

        this.initState();
    }
    
    public int[] getPosicion() {
        // TODO: Aca habria que hacer una consulta Prolog
        String consultaPosicion = "posicion(X,Y," + this.getSituation() + ")";

        Hashtable[] resultado = this.query(consultaPosicion);

        int x = Integer.parseInt(resultado[0].get("X").toString());
        int y = Integer.parseInt(resultado[0].get("Y").toString());

        return new int[]{x, y};
    }
    
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

    @Override
    public void updateState(Perception perception) {
        this.tell(perception);
    }

    public boolean todoConocido() {
        // TODO: Aca habria que hacer una consulta Prolog
        return true;
    }

    public int getCeldasDesconocidas() {
        // TODO: Aca habria que hacer una consulta Prolog
        return 0;
    }

    public int getComidaRestante() {
        // TODO: Aca habria que hacer una consulta Prolog
        return 0;
    }

    public boolean noHayMasComida() {
        // TODO: Aca habria que hacer una consulta Prolog
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
