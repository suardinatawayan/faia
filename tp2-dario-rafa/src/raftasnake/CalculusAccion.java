package raftasnake;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.solver.calculus.CalculusActionFactory;

public class CalculusAccion extends CalculusActionFactory {
	
	private static CalculusAccion instancia;
	
	private CalculusAccion() {}
	
	public static CalculusAccion getInstance() {
		if (instancia == null)
			instancia = new CalculusAccion();
		
		return instancia;
	}
	
	@Override
	public Action makeActionFromString(String stringAction) {
		if (stringAction.equals("avanzar")) return new Avanzar();
		else if (stringAction.equals("comer")) return new Comer();
		else if (stringAction.equals("girarIzquierda")) return new GirarIzquierda();
		else if (stringAction.equals("girarDerecha")) return new GirarDerecha();
		
		return null;
	}

}
