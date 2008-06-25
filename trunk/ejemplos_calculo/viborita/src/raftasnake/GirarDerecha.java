package raftasnake;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class GirarDerecha extends Action {

	@Override
	public AgentState execute(AgentState s) {
		EstadoSnake snake = (EstadoSnake) s;
		snake.incrementarCosto(this.getCost());
		
//		if (snake.getVecesQueSeGiroDerecha() > 4) {
//			snake.destrabaAlAgente();
//			snake.setVecesQueSeGiroDerecha(0);
//			
//			return null;
//		}
		
		if (snake.getOrientacionDeLaCabeza() == EstadoSnake.NORTE) {
			snake.setOrientacionDeLaCabeza(EstadoSnake.ESTE);
			snake.incVecesQueSeGiroDerecha();
			
			return snake;
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.OESTE) {
			snake.setOrientacionDeLaCabeza(EstadoSnake.NORTE);
			snake.incVecesQueSeGiroDerecha();
			
			return snake;
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.SUR) {
			snake.setOrientacionDeLaCabeza(EstadoSnake.OESTE);
			snake.incVecesQueSeGiroDerecha();
			
			return snake;
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.ESTE){			
			snake.setOrientacionDeLaCabeza(EstadoSnake.SUR);
			snake.incVecesQueSeGiroDerecha();
			
			return snake;
		}
		
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoAmbiente estA = (EstadoAmbiente)est;
		EstadoSnake snake = (EstadoSnake) ast;
		
		if (snake.getOrientacionDeLaCabeza() == EstadoSnake.NORTE) {
			snake.setOrientacionDeLaCabeza(EstadoSnake.ESTE);
			estA.setOrientacionDeLaCabeza(EstadoSnake.ESTE);
			snake.incVecesQueSeGiroDerecha();
			
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.OESTE) {
			snake.setOrientacionDeLaCabeza(EstadoSnake.NORTE);
			estA.setOrientacionDeLaCabeza(EstadoSnake.NORTE);
			snake.incVecesQueSeGiroDerecha();
			
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.SUR) {
			snake.setOrientacionDeLaCabeza(EstadoSnake.OESTE);
			estA.setOrientacionDeLaCabeza(EstadoSnake.OESTE);
			snake.incVecesQueSeGiroDerecha();
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.ESTE) {
			snake.setOrientacionDeLaCabeza(EstadoSnake.SUR);
			estA.setOrientacionDeLaCabeza(EstadoSnake.SUR);
			snake.incVecesQueSeGiroDerecha();
		}
		
		return estA;
	}

	@Override
	public Double getCost() {
		return new Double(10);
	}

	@Override
	public String toString() {
		return "Girar_Derecha";
	}

	@Override
	public String getLogicName() {
		return this.toString().toLowerCase();
	}

}