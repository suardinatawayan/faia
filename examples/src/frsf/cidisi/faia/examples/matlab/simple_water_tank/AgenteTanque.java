package frsf.cidisi.faia.examples.matlab.simple_water_tank;

import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.NoAction;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.reactive.ReactiveBasedAgent;
import frsf.cidisi.faia.examples.matlab.simple_water_tank.actions.CambiarCaudal;
import frsf.cidisi.faia.examples.search.pacman.AgentePacman;

// TODO: Ver si no conviene hacer a este agente reactivo simple

public class AgenteTanque extends ReactiveBasedAgent {
	
	public AgenteTanque() {
		this.setAgentState(new EstadoAgenteTanque());
	}
	
	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
	}
	
	@Override
	public EstadoAgenteTanque getAgentState() {
		return (EstadoAgenteTanque) super.getAgentState();
	}

	@Override
	public Action selectAction() {
		ReactiveSolver solver = new ReactiveSolver();
		
		this.setSolver(solver);
		
		// Se ejecuta el proceso de selección de la acción más adecuada.
        Action selectedAction = null;
        try {
        	selectedAction =
                    this.getSolver().solve(new Object[]{ this.getAgentState() });
        } catch (Exception ex) {
            Logger.getLogger(AgentePacman.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return selectedAction;
	}

}
