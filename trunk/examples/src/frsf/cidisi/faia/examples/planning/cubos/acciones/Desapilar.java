package frsf.cidisi.faia.examples.planning.cubos.acciones;

import frsf.cidisi.faia.agent.planning.PlanningAction;
import frsf.cidisi.faia.examples.planning.cubos.EstadoAmbiente;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Desapilar extends PlanningAction {
	
	private String cubo1;
	private String cubo2;
	
	public Desapilar(String[] parametros) {
		this.cubo1 = parametros[0];
		this.cubo2 = parametros[1];
	}
	
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoAmbiente estadoAmbiente = (EstadoAmbiente)est;
		
		estadoAmbiente.quitarSobre(this.cubo1, this.cubo2);
		
		return estadoAmbiente;
	}

	@Override
	public String toString() {
		return "desapilar(" + this.cubo1 + "," + this.cubo2 + ")";
	}

}
