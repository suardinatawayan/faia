package frsf.cidisi.faia.examples.situationcalculus.pacman;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

/**
 * Esta clase es muy similar a su correspondiente en el ejemplo 'pacman', basado
 * en búsqueda. Es recomendable mirar los comentarios allí primero.
 */
public class AmbientePacmanLogico extends Environment {

    public AmbientePacmanLogico() {
        // Se instancia el estado del ambiente.
        this.environmentState = new EstadoAmbientePacmanLogico();
    }

    /**
     * Este método es muy similar, como se dijo anteriormente, a su par
     * correspondiente al ejemplo 'pacman' (basado en búsqueda). La diferencia
     * radica en que los datos del agente, como la fila y columna en donde
     * actualmente se ubica, si bien parecen ser obtenidos de la misma forma,
     * internamente se utiliza prolog.
     * Ver el código del método EstadoPacman.getFila() para darse una idea.
     */
    @Override
    public Perception getPercept(Agent agent) {
        // El ambiente crea una percepción que va a ser recibida por el Pacman lógico.
        PercepcionPacmanLogico p = new PercepcionPacmanLogico();

        // Es necesario realizar un "cast" para acceder a los métodos del agente Pacman lógico
        AgentePacmanLogico pacman = (AgentePacmanLogico) agent;
        EstadoPacmanLogico estadoPacman = (EstadoPacmanLogico)pacman.getAgentState();

        // Obtiene la posición actual del pacman lógico para saber qué percepciones brindarle.
        int fil = estadoPacman.getFila();
        int col = estadoPacman.getColumna();

        // Asigna las percepciones en los sensores.-
        p.setSensorArriba(this.getArriba(fil, col));
        p.setSensorIzquierda(this.getIzquierda(fil, col));
        p.setSensorDerecha(this.getDerecha(fil, col));
        p.setSensorAbajo(this.getAbajo(fil, col));
        
        p.setFila(fil);
        p.setColumna(col);
        
        p.setTiempo(estadoPacman.getSituation());

        // Retorna la nueva percepción creada.-
        return p;
    }
    
    @Override
    public String toString() {
        return environmentState.toString();
    }

    //////////////////////////////////////////////////////////////////
    // Estos métodos de abajo son internos de la clase AmbientePacman.
    //////////////////////////////////////////////////////////////////
    
    public int getArriba(int fil, int col) {
        return ((EstadoAmbientePacmanLogico) this.environmentState).getArriba(fil, col);
    }

    public int getIzquierda(int fil, int col) {
        return ((EstadoAmbientePacmanLogico) this.environmentState).getIzquierda(fil, col);
    }

    public int getDerecha(int fil, int col) {
        return ((EstadoAmbientePacmanLogico) this.environmentState).getDerecha(fil, col);
    }

    public int getAbajo(int fil, int col) {
        return ((EstadoAmbientePacmanLogico) this.environmentState).getAbajo(fil, col);
    }
}
