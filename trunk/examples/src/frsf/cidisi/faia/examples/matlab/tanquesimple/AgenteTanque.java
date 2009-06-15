package frsf.cidisi.faia.examples.matlab.tanquesimple;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.NoAction;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.reactive.ReactiveBasedAgent;
import frsf.cidisi.faia.examples.matlab.tanquesimple.acciones.CambiarCaudal;

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
		EstadoAgenteTanque estadoTanque =
			this.getAgentState();
		
		double nuevoCaudal =
			estadoTanque.getCaudalActual();
		
		if (estadoTanque.getAlturaActual() > 30)
			nuevoCaudal = 0.50 + nuevoCaudal * 0.90;
		else if (estadoTanque.getAlturaActual() < 30)
			nuevoCaudal = 0.50 + nuevoCaudal * 1.10;
		
		Action accion = new CambiarCaudal(nuevoCaudal);
		
		return accion;
	}

}
