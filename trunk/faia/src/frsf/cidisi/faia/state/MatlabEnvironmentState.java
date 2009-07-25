package frsf.cidisi.faia.state;

public abstract class MatlabEnvironmentState extends EnvironmentState {

	private int startTime;
	private int endTime;
	private int step;
	
	public MatlabEnvironmentState(int startTime, int step) {
		this.startTime = startTime;
		this.step = step;
		this.endTime = this.startTime + this.step;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public int getStep() {
		return step;
	}
	
	public void nextTime() {
		this.startTime = this.endTime;
		this.endTime = this.startTime + this.step;
	}
	
}
