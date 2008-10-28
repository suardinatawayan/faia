package agente;

import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.planning.PlanningBasedAgent;
import frsf.cidisi.faia.exceptions.KnowledgeBaseException;
import frsf.cidisi.faia.solver.planning.EndAction;
import frsf.cidisi.faia.solver.planning.InitAction;
import frsf.cidisi.faia.solver.planning.Planning;

public class AgentePlanificacion extends PlanningBasedAgent {
	
	public AgentePlanificacion() throws KnowledgeBaseException {
    	/* Creamos el objeto EstadoPacman, que es la base de conocimiento
    	 * del agente, y la seteamos al mismo.
    	 */
        EstadoPacman estadoPacman = new EstadoPacman();
        this.setState(estadoPacman);
    }
	
	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
	}

	@Override
	public Action selectAction() {
        Planning planning = new Planning();
        this.setSolver(planning);

        // Se ejecuta el proceso de seleccion de la accion mas adecuada.
        Action accionSeleccionada = null;
        try {
            accionSeleccionada =
                    this.getSolver().solve(new Object[]{this});
        } catch (Exception ex) {
            Logger.getLogger(AgentePlanificacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Retorna la accion seleccionada.
        return accionSeleccionada;
	}

	@Override
	public EndAction getEndAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InitAction getInitAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
