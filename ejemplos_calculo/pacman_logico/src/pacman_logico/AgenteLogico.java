/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_logico;

import frsf.cidisi.faia.agent.knowledgebased.KnowledgeBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.knowledgebased.CalculusAction;
import frsf.cidisi.faia.exceptions.CalculusException;
import frsf.cidisi.faia.exceptions.KnowledgeBaseException;
import frsf.cidisi.faia.solver.calculus.Calculus;
import frsf.cidisi.faia.solver.calculus.KnowledgeBase;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miltondp
 */
public class AgenteLogico extends KnowledgeBasedAgent {

    public AgenteLogico() throws KnowledgeBaseException {
        EstadoPacman estadoPacman = new EstadoPacman();
        this.setState(estadoPacman);
    }

    @Override
    public Action selectAction() {

        Calculus calculus = new Calculus();
        this.setSolver(calculus);

        // Se ejecuta el proceso de seleccion de la accion mas adecuada.-
        Action accionSeleccionada = null;
        try {
            accionSeleccionada =
                    this.getSolver().solve(new Object[] { this.getAgentState() });
        } catch (Exception ex) {
            Logger.getLogger(AgenteLogico.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Retorna la accion seleccionada.-
        return accionSeleccionada;
    }

    @Override
    public void tell(CalculusAction action) {
        KnowledgeBase kb = (KnowledgeBase) this.getAgentState();
        kb.tell(action.getLogicName());
    }
}
