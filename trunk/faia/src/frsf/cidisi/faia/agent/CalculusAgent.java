package frsf.cidisi.faia.agent;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.CalculusProblem;
import frsf.cidisi.faia.solver.calculus.CalculusActionFactory;
import frsf.cidisi.faia.solver.calculus.KnowledgeBase;

public abstract class CalculusAgent extends GoalBasedAgent {
	
	protected CalculusActionFactory actionFactory;
	protected KnowledgeBase knowledgeBase;
	
	public CalculusAgent(String knowledgeBaseFile) {
		super();
		this.actionFactory = actionFactory;
		this.knowledgeBase = new KnowledgeBase(knowledgeBaseFile);
		this.setProblem(new CalculusProblem(this.knowledgeBase));
	}

	public KnowledgeBase getKnowledgeBase() {
		return this.knowledgeBase;
	}
	
	@Override
	public abstract void see(Perception perception);

}
