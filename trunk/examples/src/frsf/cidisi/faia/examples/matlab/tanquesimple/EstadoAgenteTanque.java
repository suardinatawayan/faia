package frsf.cidisi.faia.examples.matlab.tanquesimple;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoAgenteTanque extends SearchBasedAgentState {
	
	private double alturaActual;
	private double caudalActual;
	private double tiempoActual;
	
	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateState(Perception p) {
		PercepcionTanque percepcionTanque =
			(PercepcionTanque) p;
		
		this.tiempoActual = percepcionTanque.getTiempoActual();
		this.alturaActual = percepcionTanque.getAlturaTanque();
		this.caudalActual = percepcionTanque.getCaudalActual();
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
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

	public void setUltimoCaudalElegido(double ultimoCaudalElegido) {
		this.caudalActual = ultimoCaudalElegido;
	}

	public double getUltimoCaudalElegido() {
		return caudalActual;
	}

	public double getTiempoActual() {
		return tiempoActual;
	}

}
