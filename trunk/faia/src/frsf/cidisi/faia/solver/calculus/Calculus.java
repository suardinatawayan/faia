package frsf.cidisi.faia.solver.calculus;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.Problem;
import frsf.cidisi.faia.solver.Solve;

public class Calculus extends Solve {
	
	private KnowledgeBase kb;
	private CalculusActionFactory actionFactory;
	
	public Calculus(KnowledgeBase kb, CalculusActionFactory actionFactory) {
		this.kb = kb;
		this.actionFactory = actionFactory;
	}

	@Override
	public void showSolution() {
		// TODO Auto-generated method stub
	}

	/**
	 * Acá el Problem no es utilizado. 
	 */
	@Override
	public Action solve(Problem problem) {
		String stringAction = this.kb.askForBestAction();
		
		return this.actionFactory.makeActionFromString(stringAction);
	}
}
