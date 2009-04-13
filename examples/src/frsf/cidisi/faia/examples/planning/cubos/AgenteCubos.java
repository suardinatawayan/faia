package frsf.cidisi.faia.examples.planning.cubos;

import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.planning.PlanningBasedAgent;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.solver.planning.Planning;

public class AgenteCubos extends PlanningBasedAgent {

	public AgenteCubos() throws PrologConnectorException {
		EstadoCubos estadoCubos = new EstadoCubos();
		this.setAgentState(estadoCubos);
	}
	
	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
	}

	@Override
	public Action selectAction() {
		Planning planning = new Planning();
        this.setSolver(planning);
        
        Action accionSeleccionada = null;
        try {
            accionSeleccionada =
                    this.getSolver().solve(new Object[]{this});
        } catch (Exception ex) {
            Logger.getLogger(AgenteCubos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return accionSeleccionada;
	}
	
	@Override
	public EstadoCubos getAgentState() {
		EstadoCubos estado = (EstadoCubos)super.getAgentState();
		
		return estado;
	}

}
