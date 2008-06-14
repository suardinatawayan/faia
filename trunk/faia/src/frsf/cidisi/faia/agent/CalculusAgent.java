package frsf.cidisi.faia.agent;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.solver.calculus.KnowledgeBase;

public class CalculusAgent extends GoalBasedAgent {
	KnowledgeBase kb;
	
	public CalculusAgent() throws Exception {
		super();
		this.kb = new KnowledgeBase();
	}
	
	@Override
	public Action selectAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
