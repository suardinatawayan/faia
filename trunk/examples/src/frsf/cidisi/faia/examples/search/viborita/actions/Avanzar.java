package frsf.cidisi.faia.examples.search.viborita.actions;

import frsf.cidisi.faia.examples.search.viborita.*;
import java.awt.Point;

import frsf.cidisi.faia.agent.searchbased.SearchAction;
import frsf.cidisi.faia.agent.searchbased.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Avanzar extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoSnake snake = (EstadoSnake) s;
        snake.incrementarCosto(this.getCost());

        if (snake.getOrientacionDeLaCabeza() == EstadoSnake.NORTE &&
                !snake.hayObstaculo(EstadoSnake.NORTE) &&
                !snake.hayComida(EstadoSnake.NORTE) &&
                !snake.pasoNVecesPorEstaCelda(new Point(
                (int) snake.getPosicionCabeza().getX() - 1,
                (int) snake.getPosicionCabeza().getY()))) {
            snake.moverAlNorte();

            return snake;
        } else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.SUR &&
                !snake.hayObstaculo(EstadoSnake.SUR) &&
                !snake.hayComida(EstadoSnake.SUR) &&
                !snake.pasoNVecesPorEstaCelda(new Point(
                (int) snake.getPosicionCabeza().getX() + 1,
                (int) snake.getPosicionCabeza().getY()))) {
            snake.moverAlSur();

            return snake;
        } else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.ESTE &&
                !snake.hayObstaculo(EstadoSnake.ESTE) &&
                !snake.hayComida(EstadoSnake.ESTE) &&
                !snake.pasoNVecesPorEstaCelda(new Point(
                (int) snake.getPosicionCabeza().getX(),
                (int) snake.getPosicionCabeza().getY() + 1))) {
            snake.moverAlEste();

            return snake;
        } else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.OESTE &&
                !snake.hayObstaculo(EstadoSnake.OESTE) &&
                !snake.hayComida(EstadoSnake.OESTE) &&
                !snake.pasoNVecesPorEstaCelda(new Point(
                (int) snake.getPosicionCabeza().getX(),
                (int) snake.getPosicionCabeza().getY() - 1))) {
            snake.moverAlOeste();

            return snake;
        }

        return null;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbiente estA = (EstadoAmbiente) est;
        EstadoSnake snake = (EstadoSnake) ast;

        if (snake.getOrientacionDeLaCabeza() == EstadoSnake.NORTE &&
                !snake.hayObstaculo(EstadoSnake.NORTE) &&
                !snake.hayComida(EstadoSnake.NORTE) &&
                !snake.pasoNVecesPorEstaCelda(new Point(
                (int) snake.getPosicionCabeza().getX() - 1,
                (int) snake.getPosicionCabeza().getY()))) {
            snake.moverAlNorte();
            estA.moverAlNorte();
        } else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.SUR &&
                !snake.hayObstaculo(EstadoSnake.SUR) &&
                !snake.hayComida(EstadoSnake.SUR) &&
                !snake.pasoNVecesPorEstaCelda(new Point(
                (int) snake.getPosicionCabeza().getX() + 1,
                (int) snake.getPosicionCabeza().getY()))) {
            snake.moverAlSur();
            estA.moverAlSur();
        } else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.ESTE &&
                !snake.hayObstaculo(EstadoSnake.ESTE) &&
                !snake.hayComida(EstadoSnake.ESTE) &&
                !snake.pasoNVecesPorEstaCelda(new Point(
                (int) snake.getPosicionCabeza().getX(),
                (int) snake.getPosicionCabeza().getY() + 1))) {
            snake.moverAlEste();
            estA.moverAlEste();
        } else if (snake.getOrientacionDeLaCabeza() == EstadoSnake.OESTE &&
                !snake.hayObstaculo(EstadoSnake.OESTE) &&
                !snake.hayComida(EstadoSnake.OESTE) &&
                !snake.pasoNVecesPorEstaCelda(new Point(
                (int) snake.getPosicionCabeza().getX(),
                (int) snake.getPosicionCabeza().getY() - 1))) {
            snake.moverAlOeste();
            estA.moverAlOeste();
        }

        return estA;
    }

    @Override
    public Double getCost() {
        return new Double(7);
    }

    @Override
    public String toString() {
        return "Avanzar";
    }
}
