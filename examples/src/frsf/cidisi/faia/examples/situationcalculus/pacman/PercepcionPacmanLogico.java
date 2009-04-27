package frsf.cidisi.faia.examples.situationcalculus.pacman;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusPerception;
import frsf.cidisi.faia.environment.Environment;

public class PercepcionPacmanLogico extends SituationCalculusPerception {

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

    public PercepcionPacmanLogico() {
        energia = 50;
    }

    public PercepcionPacmanLogico(Agent agent, Environment environment) {
        super(agent, environment);
    }

    @Override
    public void initPerception(Agent agent, Environment environment) {
        AgentePacmanLogico pacman = (AgentePacmanLogico) agent;
        AmbientePacmanLogico ambiente = (AmbientePacmanLogico) environment;

        this.setFila(((EstadoPacmanLogico) pacman.getAgentState()).getFila());
        this.setColumna(((EstadoPacmanLogico) pacman.getAgentState()).getColumna());

        this.setSensorArriba(ambiente.getArriba(this.getFila(), this.getColumna()));
        this.setSensorIzquierda(ambiente.getIzquierda(this.getFila(), this.getColumna()));
        this.setSensorDerecha(ambiente.getDerecha(this.getFila(), this.getColumna()));
        this.setSensorAbajo(ambiente.getAbajo(this.getFila(), this.getColumna()));
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
            case PercepcionPacmanLogico.PERCEPCION_COMIDA:
                resultado = "comida";
                break;
            case PercepcionPacmanLogico.PERCEPCION_ENEMIGO:
                resultado = "enemigo";
                break;
            case PercepcionPacmanLogico.PERCEPCION_VACIO:
                resultado = "vacia";
                break;
        }

        return resultado;
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
