package frsf.cidisi.faia.examples.matlab.simple_water_tank.actions;

import frsf.cidisi.faia.agent.reactive.ReactiveAction;
import frsf.cidisi.faia.examples.matlab.simple_water_tank.EstadoAgenteTanque;
import frsf.cidisi.faia.examples.matlab.simple_water_tank.EstadoAmbienteTanque;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class CambiarCaudal extends ReactiveAction {
	
	private double caudalElegido;
	
	public CambiarCaudal(double caudalElegido) {
		this.caudalElegido = caudalElegido;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoAgenteTanque estadoAgente = (EstadoAgenteTanque) ast;
		EstadoAmbienteTanque estadoAmbiente = (EstadoAmbienteTanque) est;
		
		estadoAmbiente.setCaudalActual(this.caudalElegido);
		
		return estadoAmbiente;
	}

	@Override
	public String toString() {
		return "Cambiar caudal a " + this.caudalElegido;
	}

}
