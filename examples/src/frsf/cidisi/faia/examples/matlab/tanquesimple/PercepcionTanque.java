package frsf.cidisi.faia.examples.matlab.tanquesimple;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PercepcionTanque extends Perception {

	private double alturaTanque;
	private double tiempoActual;
	private double caudalActual;

	@Override
	public void initPerception(Agent agent, Environment environment) {
		// TODO Auto-generated method stub
		
	}
	
	public double getCaudalActual() {
		return caudalActual;
	}

	public void setCaudalActual(double caudalActual) {
		this.caudalActual = caudalActual;
	}
	
	public double getAlturaTanque() {
		return alturaTanque;
	}

	public void setAlturaTanque(double alturaTanque) {
		this.alturaTanque = alturaTanque;
	}

	public double getTiempoActual() {
		return tiempoActual;
	}

	public void setTiempoActual(double tiempoActual) {
		this.tiempoActual = tiempoActual;
	}
}
