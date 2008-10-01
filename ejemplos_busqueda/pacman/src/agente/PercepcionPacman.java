package agente;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PercepcionPacman extends Perception {

    public static int PERCEPCION_DESCONOCIDO = -1;
    public static int PERCEPCION_VACIO = 0;
    public static int PERCEPCION_ENEMIGO = 1;
    public static int PERCEPCION_COMIDA = 2;
    private int sensorIzquierda;
    private int sensorArriba;
    private int sensorDerecha;
    private int sensorAbajo;
    private int energia;

    public PercepcionPacman() {
        energia = 50;
    }

    public PercepcionPacman(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * Método utilizado para inicializar una percepción.
     */
    @Override
    public void initPerception(Agent agent, Environment environment) {
        AgentePacman pacman = (AgentePacman) agent;
        AmbientePacman ambiente = (AmbientePacman) environment;

        int fil = ((EstadoPacman) pacman.getAgentState()).getFila();
        int col = ((EstadoPacman) pacman.getAgentState()).getColumna();

        setSensorArriba(ambiente.getArriba(fil, col));
        setSensorIzquierda(ambiente.getIzquierda(fil, col));
        setSensorDerecha(ambiente.getDerecha(fil, col));
        setSensorAbajo(ambiente.getAbajo(fil, col));
    }

    // Estos métodos son internos de la clase PercepcionPacman.
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
}
