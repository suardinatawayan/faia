package frsf.cidisi.faia.solver;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.exceptions.CalculusException;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:05
 */
public abstract class Solve {

    public Solve() {
    }

    /**
     * 
     * @param problem
     */
    public abstract Action solve(Object[] params) throws Exception;

    // Tal vez no es correcto poner este m�todo en esta clase debido a que es probable
    // que en algunas tecnicas de IA no se pueda mostrar la soluci�n del problema.-
    public abstract void showSolution();
}