package raftasnake;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class GirarIzquierda extends Action {

	@Override
	public AgentState execute(AgentState s) {
		EstadoSnake snake = (EstadoSnake) s;
		snake.incrementarCosto(this.getCost());
		
//		if (snake.getVecesQueSeGiro() > 4) {
//			snake.destrabaAlAgente();
//			snake.setVecesQueSeGiro(0);
//			
//			return null;
//		}
		
		if (snake.getOrientacionDeLaCabeza() == EstadoSnake.NORTE) {
			snake.incVecesQueSeGiro();
			
			snake.setOrientacionDeLaCabeza(EstadoSnake.OESTE);
			
			return snake;
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.OESTE) {
			snake.incVecesQueSeGiro();
			
			snake.setOrientacionDeLaCabeza(EstadoSnake.SUR);
			
			return snake;
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.SUR) {
			snake.incVecesQueSeGiro();
			
			snake.setOrientacionDeLaCabeza(EstadoSnake.ESTE);
			
			return snake;
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.ESTE) {
			snake.incVecesQueSeGiro();
			
			snake.setOrientacionDeLaCabeza(EstadoSnake.NORTE);
			
			return snake;
		}
		
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoAmbiente estA = (EstadoAmbiente)est;
		EstadoSnake snake = (EstadoSnake) ast;
		
		if (snake.getOrientacionDeLaCabeza() == EstadoSnake.NORTE) {
			snake.incVecesQueSeGiro();
			
			snake.setOrientacionDeLaCabeza(EstadoSnake.OESTE);
			estA.setOrientacionDeLaCabeza(EstadoSnake.OESTE);
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.OESTE) {
			snake.incVecesQueSeGiro();
			
			snake.setOrientacionDeLaCabeza(EstadoSnake.SUR);
			estA.setOrientacionDeLaCabeza(EstadoSnake.SUR);
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.SUR) {
			snake.incVecesQueSeGiro();
			
			snake.setOrientacionDeLaCabeza(EstadoSnake.ESTE);
			estA.setOrientacionDeLaCabeza(EstadoSnake.ESTE);
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.ESTE) {
			snake.incVecesQueSeGiro();
			
			snake.setOrientacionDeLaCabeza(EstadoSnake.NORTE);
			estA.setOrientacionDeLaCabeza(EstadoSnake.NORTE);
		}
		
		return estA;
	}

	@Override
	public Double getCost() {
		return new Double(10);
	}

	@Override
	public String toString() {
		return "Girar_Izquierda";
	}

	@Override
	public String getLogicName() {
		// TODO Auto-generated method stub
		return null;
	}

}
