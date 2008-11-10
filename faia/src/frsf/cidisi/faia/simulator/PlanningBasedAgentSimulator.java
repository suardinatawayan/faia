package frsf.cidisi.faia.simulator;

import java.util.Vector;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.knowledgebased.CalculusAction;
import frsf.cidisi.faia.agent.knowledgebased.KnowledgeBasedAgent;
import frsf.cidisi.faia.agent.planning.PlanningAction;
import frsf.cidisi.faia.agent.planning.PlanningBasedAgent;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.solver.calculus.CalculusNoAction;

public class PlanningBasedAgentSimulator extends GoalBasedAgentSimulator {

	public PlanningBasedAgentSimulator(Environment environment, Vector<Agent> agents) {
        super(environment, agents);
    }

    public PlanningBasedAgentSimulator(Environment environment, Agent agent) {
        super(environment, agent);
    }
	
	@Override
	public void start() {
		
	}

}
