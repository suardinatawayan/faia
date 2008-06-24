package frsf.cidisi.faia.agent.problem;

import frsf.cidisi.faia.solver.calculus.KnowledgeBase;

public class CalculusProblem extends Problem {
	
	public CalculusProblem(KnowledgeBase knowledgeBase) {
		super(CalculusGoalTest.getInstance(), knowledgeBase, null);
	}
	
}
