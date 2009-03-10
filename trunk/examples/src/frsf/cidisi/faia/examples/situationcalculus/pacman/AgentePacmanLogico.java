
package frsf.cidisi.faia.examples.situationcalculus.pacman;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusAction;
import frsf.cidisi.faia.agent.situationcalculus.SituationCalculusBasedAgent;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.solver.PrologConnector;
import frsf.cidisi.faia.solver.situationcalculus.SituationCalculus;
import frsf.cidisi.faia.solver.situationcalculus.KnowledgeBase;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AgentePacmanLogico extends SituationCalculusBasedAgent {

    public AgentePacmanLogico() throws PrologConnectorException {
    	/* Creamos el objeto EstadoPacman, que es la base de conocimiento
    	 * del agente, y la seteamos al mismo.
    	 */
        EstadoPacmanLogico estadoPacman = new EstadoPacmanLogico();
        this.setState(estadoPacman);
    }

    /**
     * Es el método que ejecuta el simulador para pedirle una acción al agente
     */
    @Override
    public Action selectAction() {

    	/*
    	 * Así como en el ejemplo 'pacman' (de Búsqueda) el Solver era un
    	 * objeto de la clase Search, en este caso es uno de la clase
    	 * Calculus. Esta es la única diferencia en el código de este método
    	 * con respecto al agente basado en búsqueda.
    	 */
        SituationCalculus calculus = new SituationCalculus();
        this.setSolver(calculus);

        // Se ejecuta el proceso de seleccion de la accion mas adecuada.
        Action accionSeleccionada = null;
        try {
            accionSeleccionada =
                    this.getSolver().solve(new Object[]{this.getAgentState()});
        } catch (Exception ex) {
            Logger.getLogger(AgentePacmanLogico.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Retorna la accion seleccionada.
        return accionSeleccionada;
    }

    /**
     * Este método es llamado por el simulador para indicarle al agente
     * que la acción que ha elegido se aplica en la realidad.
     * Lo que hace este método es actualizar la base de conocimiento
     * llamando a otro método del mismo nombre.
     */
    @Override
    public void tell(SituationCalculusAction action) {
    	EstadoPacmanLogico kb = (EstadoPacmanLogico) this.getAgentState();
        kb.tell(action.getLogicName());
    }

    /**
     * Este método es llamado por el simulador para entregarle al agente una
     * percepción. Lo que se hace aquí es actualizar el estado del mismo
     * (o sea, su base de conocimiento en este caso).
     * Internamente se traduce como un 'tell(Perception)' a la KB (Knowledge
     * Base).
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}
