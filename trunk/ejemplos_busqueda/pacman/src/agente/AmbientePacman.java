package agente;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbientePacman extends Environment {

    public AmbientePacman() {
        // Se instancia el estado del ambiente.-
        this.environmentState = new EstadoAmbiente();
    }

    public Perception getPercept(Agent agent) {
        // El ambiente crea una percepción que va a ser recibida por el Pacman.- 
        PercepcionPacman p = new PercepcionPacman();

        // Es necesario realizar un "cast" para acceder a los métodos del agente Pacman.- 
        AgentePacman pacman = (AgentePacman) agent;

        // Obtiene la posici�n actual del pacman para saber que percepciones brindarle.- 
        int fil = ((EstadoPacman) pacman.getAgentState()).getFila();
        int col = ((EstadoPacman) pacman.getAgentState()).getColumna();

        // Asigna las percepciones en los sensores.-
        p.setSensorArriba(this.getArriba(fil, col));
        p.setSensorIzquierda(this.getIzquierda(fil, col));
        p.setSensorDerecha(this.getDerecha(fil, col));
        p.setSensorAbajo(this.getAbajo(fil, col));

        // Retorna la nueva percepci�n creada.-
        return p;
    }

    public int getArriba(int fil, int col) {
        return ((EstadoAmbiente) this.environmentState).getArriba(fil, col);
    }

    public int getIzquierda(int fil, int col) {
        return ((EstadoAmbiente) this.environmentState).getIzquierda(fil, col);
    }

    public int getDerecha(int fil, int col) {
        return ((EstadoAmbiente) this.environmentState).getDerecha(fil, col);
    }

    public int getAbajo(int fil, int col) {
        return ((EstadoAmbiente) this.environmentState).getAbajo(fil, col);
    }

    public String toString() {

        return environmentState.toString();
    }
}
