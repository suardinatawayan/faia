package agent;

import frsf.cidisi.faia.state.EnvironmentState;

public class WumpusWorldState extends EnvironmentState {

	private int[][] world;
	
	public WumpusWorldState() {
		this.world = new int[4][4];
		this.initState();
	}
	
	@Override
	public void initState() {
		// TODO Auto-generated method stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
