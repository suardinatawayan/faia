package frsf.cidisi.faia.simulator;

import java.util.Arrays;
import java.util.Vector;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.NoAction;
import frsf.cidisi.faia.environment.Environment;

public class ReactiveBasedAgentSimulator extends GoalBasedAgentSimulator {

	public ReactiveBasedAgentSimulator(Environment environment, Vector<Agent> agent) {
		super(environment, agent);
		// TODO Auto-generated constructor stub
	}
	
	public ReactiveBasedAgentSimulator(Environment environment, Agent agent) {
		this(environment, new Vector<Agent>(Arrays.asList(agent)) );
	}

	@Override
	public String getSimulatorName() {
		return "Reactive Based Simulator";
	}

	@Override
	public boolean isComplete(Action actionReturned) {
		if (actionReturned instanceof NoAction)
			return true;
		
		return false;
	}

	@Override
	public void actionReturned(Agent agent, Action action) {
		this.updateState(action);
	}

}
