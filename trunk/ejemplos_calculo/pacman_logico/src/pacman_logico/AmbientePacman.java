package pacman_logico;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.solver.calculus.KnowledgeBase;

public class AmbientePacman extends Environment {

    public AmbientePacman() {
        // Se instancia el estado del ambiente.-
        this.environmentState = new EstadoAmbiente();
    }

    public Perception getPercept(Agent agent) {
        // El ambiente crea una percepción que va a ser recibida por el Pacman.- 
        PercepcionPacman p = new PercepcionPacman();

        // Es necesario realizar un "cast" para acceder a los métodos del agente Pacman.- 
        AgenteLogico pacman = (AgenteLogico) agent;

        // Obtiene la posición actual del pacman para saber que percepciones brindarle.-

        p.setFila(((EstadoPacman) pacman.getAgentState()).getFila());
        p.setColumna(((EstadoPacman) pacman.getAgentState()).getColumna());

        // Asigna las percepciones en los sensores.-
        p.setSensorArriba(this.getArriba(p.getFila(), p.getColumna()));
        p.setSensorIzquierda(this.getIzquierda(p.getFila(), p.getColumna()));
        p.setSensorDerecha(this.getDerecha(p.getFila(), p.getColumna()));
        p.setSensorAbajo(this.getAbajo(p.getFila(), p.getColumna()));

        KnowledgeBase kb = (KnowledgeBase) pacman.getAgentState();

        p.setTiempo(kb.getSituation());

        // Retorna la nueva percepción creada.-
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

    @Override
    public String toString() {

        return environmentState.toString();
    }
}
