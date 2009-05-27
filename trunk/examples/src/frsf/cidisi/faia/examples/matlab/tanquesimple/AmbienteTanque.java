package frsf.cidisi.faia.examples.matlab.tanquesimple;

import jmatlink.JMatLink;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteTanque extends Environment {
	
	// ---8<---
	private JMatLink engine;
	// ---8<---

	private boolean primeraEjecucion;
	
	private static final double AREA_TANQUE = 40.0;
	private static final double RESTRICCION_DESCARGA = 0.5;

	public AmbienteTanque() {
		// ---8<--- Esto podría ir en una clase de FAIA
		this.engine = new JMatLink();
		this.engine.engOpen("matlab -nosplash -nojvm");
		this.engine.engEvalString("cd '" + this.getMatlabProjectPath() + "'");
		// ---8<---
		
		this.environmentState = new EstadoAmbienteTanque();
		this.primeraEjecucion = true;
	}
	
	// ---8<---
	protected void finalize() throws Throwable {
		try {
			this.engine.engClose();
		}
		catch (Exception ex) {
			
		}
		finally {
			super.finalize();
		}
	}
	// ---8<---
	
	@Override
	public EstadoAmbienteTanque getEnvironmentState() {
		return (EstadoAmbienteTanque) super.getEnvironmentState();
	}
	
	@Override
	public Perception getPercept(Agent agent) {
		AgenteTanque agente = (AgenteTanque) agent;
		PercepcionTanque percepcion = new PercepcionTanque();
		
		// Inicio la simulación
		if (!this.primeraEjecucion)
			this.iniciarSimulacion();
		else
			this.primeraEjecucion  = false;
		
		percepcion.setAlturaTanque(this.getEnvironmentState().getAltura());
		percepcion.setTiempoActual(this.getEnvironmentState().getTiempoInicial());
		percepcion.setCaudalActual(this.getEnvironmentState().getCaudalActual());
		
		return percepcion;
	}
	
	private void iniciarSimulacion() {
		EstadoAmbienteTanque estadoAmbiente =
			this.getEnvironmentState();
		
		// Ejecuto mi función
		this.engine.engEvalString("[t,h] = TK_1_L(" +
				 this.join(this.getMatlabFunctionParameters(), ",") + ");");
		
		double[][] t = this.engine.engGetArray("t");
		double[][] h = this.engine.engGetArray("h");
		
		estadoAmbiente.setAltura(h[h.length-1][0]);
		estadoAmbiente.setTiempoInicial(estadoAmbiente.getTiempoFinal());
		estadoAmbiente.setTiempoFinal(estadoAmbiente.getTiempoInicial() +
				estadoAmbiente.getPaso());
	}
	
	public double getAlturaTanque() {
		return this.getEnvironmentState().getAltura();
	}
	
	public String getMatlabProjectPath() {
		return "/home/miltondp/Facultad/becas/faia/trabajo_2009/jorge_vega/modelo_tanques2";
	}
	
	@Override
	public String toString() {
		return this.getEnvironmentState().toString();
	}
	
	public Object[] getMatlabFunctionParameters() {
		
		EstadoAmbienteTanque estadoAmbiente =
			this.getEnvironmentState();
		
		Object[] parametros = new Object[] {
				AREA_TANQUE,
				RESTRICCION_DESCARGA,
				estadoAmbiente.getAltura(),
				estadoAmbiente.getCaudalActual(),
				estadoAmbiente.getTiempoInicial(),
				estadoAmbiente.getTiempoFinal()
		};
		
		return parametros;
	}
	
	private String join(Object[] array, String separator) {
		StringBuffer sb = new StringBuffer();
		
		sb.append(array[0].toString());
		
		for(int i=1; i<array.length; i++)
			sb.append(separator + array[i].toString());
		
		return sb.toString();
	}
}
