package pacman_logico;

import frsf.cidisi.faia.agent.Action;
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
    public Action stringToAction(String stringAction) {
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

    @Override
    public String noActionString() {
        /* Retornamos el string que utilizamos en 'base_conocimiento.pl' en
         * el predicado mejorAccion cuando se ha cumplido el objetivo */
        return "noAccion";
    }
}
