package frsf.cidisi.faia.examples.matlab.simple_water_tank;

import java.util.Hashtable;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.MatlabEnvironment;

public class AmbienteTanque extends MatlabEnvironment {

	private static final double AREA_TANQUE = 40.0;
	private static final double RESTRICCION_DESCARGA = 0.5;

	public AmbienteTanque() {
		super();
		
		this.environmentState = new EstadoAmbienteTanque();
	}
	
	@Override
	public EstadoAmbienteTanque getEnvironmentState() {
		return (EstadoAmbienteTanque) super.getEnvironmentState();
	}
	
	@Override
	public Perception getPercept(Agent agent) {
		PercepcionTanque percepcion = new PercepcionTanque();
		
		Hashtable<String,double[][]> retorno;
		
		// Inicio la simulación
		retorno = this.startSimulation();
		
		double[][] h = retorno.get("h");
		
		EstadoAmbienteTanque estadoAmbiente =
			this.getEnvironmentState();
		
		estadoAmbiente.setAltura(h[h.length-1][0]);
		estadoAmbiente.setTiempoInicial(estadoAmbiente.getTiempoFinal());
		estadoAmbiente.setTiempoFinal(estadoAmbiente.getTiempoInicial() +
				estadoAmbiente.getPaso());
		
		percepcion.setAlturaTanque(this.getEnvironmentState().getAltura());
		percepcion.setTiempoActual(this.getEnvironmentState().getTiempoInicial());
		percepcion.setCaudalActual(this.getEnvironmentState().getCaudalActual());
		
		return percepcion;
	}
	
	public double getAlturaTanque() {
		return this.getEnvironmentState().getAltura();
	}
	
	@Override
	public String getMatlabProjectPath() {
		return "matlab_modelo_tanques";
	}
	
	@Override
	public String toString() {
		return this.getEnvironmentState().toString();
	}
	
	@Override
	public Object[] getMatlabFunctionParameters() {
		EstadoAmbienteTanque estadoAmbiente =
			this.getEnvironmentState();
		
		return new Object[] {
				AREA_TANQUE,
				RESTRICCION_DESCARGA,
				estadoAmbiente.getAltura(),
				estadoAmbiente.getCaudalActual(),
				estadoAmbiente.getTiempoInicial(),
				estadoAmbiente.getTiempoFinal()
		};
	}

	@Override
	protected String getMatlabFunctionName() {
		return "TK_1_L";
	}

	@Override
	protected Object[] getMatlabFunctionReturnVariables() {
		return new Object[] {
				"t",
				"h"
		};
	}
}
