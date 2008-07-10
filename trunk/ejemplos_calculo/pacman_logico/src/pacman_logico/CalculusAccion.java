package pacman_logico;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.solver.calculus.CalculusActionFactory;
import pacman_logico.acciones.*;

public class CalculusAccion extends CalculusActionFactory {

    private static CalculusAccion instancia;

    private CalculusAccion() {
    }

    public static CalculusAccion getInstance() {
        if (instancia == null) {
            instancia = new CalculusAccion();
        }
        return instancia;
    }

    @Override
    public Action makeActionFromString(String stringAction) {
        if (stringAction.equals("abajo")) {
            return new IrAbajo();
        } else if (stringAction.equals("arriba")) {
            return new IrArriba();
        } else if (stringAction.equals("derecha")) {
            return new IrDerecha();
        } else if (stringAction.equals("izquierda")) {
            return new IrIzquierda();
        } else if (stringAction.equals("comer")) {
            return new Comer();
        } else if (stringAction.equals("pelear")) {
            return new Pelear();
        }
        return null;
    }
}
