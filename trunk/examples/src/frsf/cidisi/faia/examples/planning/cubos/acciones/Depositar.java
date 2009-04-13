package frsf.cidisi.faia.examples.planning.cubos.acciones;

import frsf.cidisi.faia.agent.planning.PlanningAction;
import frsf.cidisi.faia.examples.planning.cubos.EstadoAmbiente;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Depositar extends PlanningAction {
	
	private String cubo;
	
	public Depositar(String[] parametros) {
		this.cubo = parametros[0];
	}
	
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoAmbiente estadoAmbiente = (EstadoAmbiente)est;
		
		estadoAmbiente.sobreMesa(this.cubo);
		
		return estadoAmbiente;
	}

	@Override
	public String toString() {
		return "depositar(" + this.cubo + ")";
	}

}
