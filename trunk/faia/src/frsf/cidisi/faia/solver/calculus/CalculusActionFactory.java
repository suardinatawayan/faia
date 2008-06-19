package frsf.cidisi.faia.solver.calculus;

import frsf.cidisi.faia.agent.problem.Action;

public abstract class CalculusActionFactory {
	public abstract Action makeActionFromString(String stringAction);
}
