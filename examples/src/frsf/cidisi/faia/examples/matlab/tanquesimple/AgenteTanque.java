package frsf.cidisi.faia.examples.matlab.tanquesimple;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.searchbased.SearchBasedAgent;
import frsf.cidisi.faia.examples.matlab.tanquesimple.acciones.CambiarCaudal;

// TODO: Ver si no conviene hacer a este agente reactivo simple

public class AgenteTanque extends SearchBasedAgent {
	
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
		
		double ultimoCaudalElegido =
			estadoTanque.getUltimoCaudalElegido();
		
		if (estadoTanque.getAlturaActual() > 30)
			ultimoCaudalElegido = 0.50 + ultimoCaudalElegido * 0.90;
		else if (estadoTanque.getAlturaActual() < 30)
			ultimoCaudalElegido = 0.50 + ultimoCaudalElegido * 1.10;
		
		CambiarCaudal accion = new CambiarCaudal(ultimoCaudalElegido);
		
		return accion;
	}

}
