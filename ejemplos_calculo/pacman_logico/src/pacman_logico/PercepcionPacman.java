package pacman_logico;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PercepcionPacman extends Perception {

    public static final int PERCEPCION_DESCONOCIDO = -1;
    public static final int PERCEPCION_VACIO = 0;
    public static final int PERCEPCION_ENEMIGO = 1;
    public static final int PERCEPCION_COMIDA = 2;
    
    private int sensorIzquierda;
    private int sensorArriba;
    private int sensorDerecha;
    private int sensorAbajo;
    private int energia;
    
    private int fila;
    private int columna;
    
    private int tiempo;

    public PercepcionPacman() {
        energia = 50;
    }

    public PercepcionPacman(Agent agent, Environment environment) {
        super(agent, environment);
    }

    public void initPerception(Agent agent, Environment environment) {
        AgenteLogico pacman = (AgenteLogico) agent;
        AmbientePacman ambiente = (AmbientePacman) environment;

        this.setFila(((EstadoPacman) pacman.getAgentState()).getFila());
        this.setColumna(((EstadoPacman) pacman.getAgentState()).getColumna());

        setSensorArriba(ambiente.getArriba(this.getFila(), this.getColumna()));
        setSensorIzquierda(ambiente.getIzquierda(this.getFila(), this.getColumna()));
        setSensorDerecha(ambiente.getDerecha(this.getFila(), this.getColumna()));
        setSensorAbajo(ambiente.getAbajo(this.getFila(), this.getColumna()));
    }

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
    
    private String convertirEstadoCelda(int estadoCelda) {
        String resultado = null;
        
        switch (estadoCelda) {
            case PercepcionPacman.PERCEPCION_COMIDA:
                resultado = "comida";
                break;
            case PercepcionPacman.PERCEPCION_ENEMIGO:
                resultado = "enemigo";
                break;
            case PercepcionPacman.PERCEPCION_VACIO:
                resultado = "vacia";
                break;
        }
        
        return resultado;
    }

    @Override
    public String toString() {
        StringBuffer resultado = new StringBuffer("percepcion([");

        // Celdas adyacentes
        resultado.append(this.convertirEstadoCelda(this.sensorIzquierda));
        resultado.append(",");
        resultado.append(this.convertirEstadoCelda(this.sensorDerecha));
        resultado.append(",");
        resultado.append(this.convertirEstadoCelda(this.sensorArriba));
        resultado.append(",");
        resultado.append(this.convertirEstadoCelda(this.sensorAbajo));
        resultado.append("],");

        // Posición del agente
        resultado.append(this.getFila());
        resultado.append(",");
        resultado.append(this.getColumna());
        resultado.append(",");

        // Energía del agente
        resultado.append(this.getEnergia());
        resultado.append(",");

        // Tiempo
        resultado.append(this.getTiempo());

        resultado.append(")");

        return resultado.toString();
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
