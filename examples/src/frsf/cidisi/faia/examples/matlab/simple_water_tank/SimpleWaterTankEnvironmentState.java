package frsf.cidisi.faia.examples.matlab.simple_water_tank;

import frsf.cidisi.faia.state.EnvironmentState;

public class SimpleWaterTankEnvironmentState extends EnvironmentState {

	private double tankHeight;
	
	private double volumeFlow;

	private int startTime;
	private int endTime;
	private int step;
	
	public SimpleWaterTankEnvironmentState() {
		this.initState();
	}
	
	@Override
	public void initState() {
		this.tankHeight = 5.0;
		this.startTime = 0;
		this.step = 3;
		this.endTime = this.startTime + this.step;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("\nTimes: " + this.startTime + " -> " + this.endTime + "\n");
		sb.append("Tank height: " + this.tankHeight + "\n");
		sb.append("Volume flow: " + this.volumeFlow + "\n");
		
		return sb.toString();
	}
	
	public double getTankHeight() {
		return tankHeight;
	}
	
	public void setTankHeight(double altura) {
		this.tankHeight = altura;
	}
	
	public double getVolumeFlow() {
		return volumeFlow;
	}
	
	public void setVolumeFlow(double volumeFlow) {
		this.volumeFlow = volumeFlow;
	}

	public int getStartTime() {
		return startTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}
	
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getStep() {
		return step;
	}
}
