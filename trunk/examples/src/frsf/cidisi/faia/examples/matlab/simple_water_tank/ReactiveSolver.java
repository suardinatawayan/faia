package frsf.cidisi.faia.examples.matlab.simple_water_tank;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.examples.matlab.simple_water_tank.actions.CambiarCaudal;
import frsf.cidisi.faia.solver.Solve;

public class ReactiveSolver extends Solve {

	@Override
	public void showSolution() {
		// TODO Auto-generated method stub
	}

	@Override
	public Action solve(Object[] params) throws Exception {
		EstadoAgenteTanque estadoTanque =
			(EstadoAgenteTanque) params[0];
		
		double nuevoCaudal =
			estadoTanque.getCaudalActual();
		
		if (estadoTanque.getAlturaActual() > 30)
			nuevoCaudal = 0.50 + nuevoCaudal * 0.90;
		else if (estadoTanque.getAlturaActual() < 30)
			nuevoCaudal = 0.50 + nuevoCaudal * 1.10;
		
		Action accion = new CambiarCaudal(nuevoCaudal);
		
		return accion;
	}

}
