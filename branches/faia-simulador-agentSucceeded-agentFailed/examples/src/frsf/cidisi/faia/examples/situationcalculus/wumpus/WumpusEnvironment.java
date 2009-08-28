package frsf.cidisi.faia.examples.situationcalculus.wumpus;

import java.util.Vector;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.examples.situationcalculus.wumpus.WumpusEnvironmentState.CellState;

public class WumpusEnvironment extends Environment {

    public WumpusEnvironment() {
        this.environmentState = new WumpusEnvironmentState();
    }

    @Override
    public WumpusEnvironmentState getEnvironmentState() {
        return (WumpusEnvironmentState) super.getEnvironmentState();
    }

    @Override
    public WumpusPerception getPercept(Agent agent) {
        WumpusPerception p = new WumpusPerception();

        WumpusAgent wumpusAgent = (WumpusAgent) agent;
        WumpusAgentState wumpusAgentState = wumpusAgent.getAgentState();

        int[] agentPosition = wumpusAgentState.getPosition();

        Vector<CellState> cellState = this.getEnvironmentState().getCellState(agentPosition[0], agentPosition[1]);

        p.setStench(cellState.contains(CellState.STENCH));
        p.setBreeze(cellState.contains(CellState.BREEZE));
        p.setBump(cellState.contains(CellState.BUMP));
        p.setGlitter(cellState.contains(CellState.GLITTER));
        p.setWumpusScream(cellState.contains(CellState.WUMPUS_SCREAM));

        p.setSituation(wumpusAgentState.getSituation());

        return p;
    }
    
    @Override
    public String toString() {
        return this.environmentState.toString();
    }
}
