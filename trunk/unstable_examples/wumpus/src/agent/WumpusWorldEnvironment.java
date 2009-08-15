package agent;

import java.util.Vector;

import agent.WumpusWorldState.CellState;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.environment.Environment;

public class WumpusWorldEnvironment extends Environment {

	public WumpusWorldEnvironment() {
		this.environmentState = new WumpusWorldState();
	}
	
	@Override
	public WumpusWorldState getEnvironmentState() {
		return (WumpusWorldState) super.getEnvironmentState();
	}
	
	@Override
	public WumpusPerception getPercept(Agent agent) {
		WumpusPerception p = new WumpusPerception();

        WumpusAgent wumpusAgent = (WumpusAgent) agent;
        WumpusAgentState wumpusAgentState = wumpusAgent.getAgentState();
        
        int[] agentPosition = wumpusAgentState.getPosition();
        
        Vector<CellState> cellState = this.getEnvironmentState()
        	.getCellState(agentPosition[0], agentPosition[1]);
        
        p.setStench(cellState.contains(CellState.STENCH));
        p.setBreeze(cellState.contains(CellState.BREEZE));
        
//        if (this.movingToWall(wumpusAgent, wumpusAgentState))
//        	p.setBump(true);
//        else
//        	p.setBump(false);
        		
        p.setBump(cellState.contains(CellState.BUMP));
        
        p.setGlitter(cellState.contains(CellState.GLITTER));
        p.setWumpusScream(cellState.contains(CellState.WUMPUS_SCREAM));
        
        p.setSituation(wumpusAgentState.getSituation());

        return p;
	}
	
//	private boolean movingToWall(WumpusAgent wumpusAgent, WumpusAgentState wumpusAgentState) {
//		if (wumpusAgent.getLastAction().toString().equals("forward") &&
//				(( wumpusAgentState.getOrientation().equals("up") && wumpusAgentState.getRow() == 0 ) ||
//				( wumpusAgentState.getOrientation().equals("right") && wumpusAgentState.getColumn() == 3 ) ||
//				( wumpusAgentState.getOrientation().equals("down") && wumpusAgentState.getRow() == 3 ) ||
//				( wumpusAgentState.getOrientation().equals("left") && wumpusAgentState.getColumn() == 0 ) ))
//			return true;
//		
//		return false;
//	}
	
	@Override
	public String toString() {
		return this.environmentState.toString();
	}
	
	
}
