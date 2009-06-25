package frsf.cidisi.faia.examples.matlab.tanquesimple;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.reactive.ReactiveBasedAgentState;

public class EstadoAgenteTanque extends ReactiveBasedAgentState {
	
	private double alturaActual;
	private double caudalActual;
	private double caudalAnterior;
	private double tiempoActual;
	
	public EstadoAgenteTanque() {
		this.initState();
	}
	
	@Override
	public void updateState(Perception p) {
		PercepcionTanque percepcionTanque =
			(PercepcionTanque) p;
		
		this.tiempoActual = percepcionTanque.getTiempoActual();
		this.alturaActual = percepcionTanque.getAlturaTanque();
		this.caudalAnterior = this.caudalActual;
		this.caudalActual = percepcionTanque.getCaudalActual();
	}
	
	@Override
	public void initState() {
		this.alturaActual = 5.0;
		this.caudalActual = 0.0;
		this.tiempoActual = 0.0;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("\nTiempo actual: " + this.tiempoActual + "\n");
		sb.append("Altura actual del tanque: " + this.alturaActual + "\n");
		sb.append("Cauda actual: " + this.caudalActual + "\n");
		
		return sb.toString();
	}

	public double getAlturaActual() {
		return alturaActual;
	}

	public double getCaudalActual() {
		return caudalActual;
	}

	public double getTiempoActual() {
		return tiempoActual;
	}

	public double getCaudalAnterior() {
		return caudalAnterior;
	}

}
