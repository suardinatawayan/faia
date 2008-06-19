package frsf.cidisi.faia.agent;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.solver.calculus.CalculusActionFactory;
import frsf.cidisi.faia.solver.calculus.KnowledgeBase;

public abstract class CalculusAgent extends GoalBasedAgent {
	
	private CalculusActionFactory actionFactory;
	private KnowledgeBase knowledgeBase;
	
	public CalculusAgent(String knowledgeBaseFile) {
		super();
		this.actionFactory = actionFactory;
		this.knowledgeBase = new KnowledgeBase(knowledgeBaseFile);
	}

	public KnowledgeBase getKnowledgeBase() {
		return this.knowledgeBase;
	}

}
