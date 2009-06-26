package frsf.cidisi.faia.examples.matlab.simple_water_tank;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbienteTanque extends EnvironmentState {

	private double altura;
	
	private double caudalActual;

	private int tiempoInicial;
	private int tiempoFinal;
	private int paso;
	
	public EstadoAmbienteTanque() {
		this.initState();
	}
	
	@Override
	public void initState() {
		this.altura = 5.0;
		this.tiempoInicial = 0;
		this.paso = 3;
		this.tiempoFinal = this.tiempoInicial + this.paso;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("\nTiempos: " + this.tiempoInicial + " -> " + this.tiempoFinal + "\n");
		sb.append("Altura del tanque: " + this.altura + "\n");
		sb.append("Caudal del tanque: " + this.caudalActual + "\n");
		
		return sb.toString();
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setCaudalActual(double caudalActual) {
		this.caudalActual = caudalActual;
	}

	public double getCaudalActual() {
		return caudalActual;
	}

	public int getTiempoInicial() {
		return tiempoInicial;
	}
	
	public void setTiempoInicial(int tiempoInicial) {
		this.tiempoInicial = tiempoInicial;
	}

	public int getTiempoFinal() {
		return tiempoFinal;
	}
	
	public void setTiempoFinal(int tiempoFinal) {
		this.tiempoFinal = tiempoFinal;
	}

	public int getPaso() {
		return paso;
	}
}
