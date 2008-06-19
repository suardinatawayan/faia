package raftasnake;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Comer extends Action {

	@Override
	public AgentState execute(AgentState s) {
		EstadoSnake snake = (EstadoSnake) s;
		snake.incrementarCosto(this.getCost());
		
		if (snake.getOrientacionDeLaCabeza() == EstadoSnake.NORTE &&
				snake.hayComida(EstadoSnake.NORTE)) {
			snake.comerAlNorte();
		
			return snake;
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.SUR &&
				snake.hayComida(EstadoSnake.SUR)) {
			snake.comerAlSur();
		
			return snake;
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.ESTE &&
				snake.hayComida(EstadoSnake.ESTE)) {
			snake.comerAlEste();
		
			return snake;
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.OESTE &&
				snake.hayComida(EstadoSnake.OESTE)) {
			snake.comerAlOeste();
		
			return snake;
		}
		
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoAmbiente estA = (EstadoAmbiente)est;
		EstadoSnake snake = (EstadoSnake) ast;
		
		if (snake.getOrientacionDeLaCabeza() == EstadoSnake.NORTE &&
				snake.hayComida(EstadoSnake.NORTE)) {
			snake.comerAlNorte();
			estA.comerAlNorte();
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.SUR &&
				snake.hayComida(EstadoSnake.SUR)) {
			snake.comerAlSur();
			estA.comerAlSur();
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.ESTE &&
				snake.hayComida(EstadoSnake.ESTE)) {
			snake.comerAlEste();
			estA.comerAlEste();
		} else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.OESTE &&
				snake.hayComida(EstadoSnake.OESTE)) {
			snake.comerAlOeste();
			estA.comerAlOeste();
		}
		
		return estA;
	}

	@Override
	public Double getCost() {
		return new Double(5);
	}

	@Override
	public String toString() {
		return "Comer";
	}

	@Override
	public String getLogicName() {
		return this.toString().toLowerCase();
	}

}
