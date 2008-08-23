package agente;

import calculador.Calculador;
import frsf.cidisi.faia.agent.knowledgebased.CalculusAction;
import frsf.cidisi.faia.agent.knowledgebased.KnowledgeBasedAgent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.calculus.Calculus;

public class AgenteCalculus extends KnowledgeBasedAgent {

    private Calculador calculador;

    public AgenteCalculus(Calculador calculador) {
        this.calculador = calculador;
    }

    @Override
    public Action selectAction() {
        // Se ejecuta el proceso de selección de la acción más adecuada.-
        Action accionSeleccionada = this.getSolver().solve(this.getProblem());

        this.knowledgeBase.tell(accionSeleccionada);

        // TODO: Esto lo tendría que hacer el simulador.
        if (accionSeleccionada.toString() == "Avanzar") {
            this.calculador.reportarAccion(Calculador.AVANZAR);
        } else if (accionSeleccionada.toString() == "Comer") {
            this.calculador.reportarAccion(Calculador.COMER);
        } else {
            this.calculador.reportarAccion(Calculador.GIRAR);        // Retorna la acción seleccionada.-
        }
        return accionSeleccionada;
    }

    @Override
    public void see(Perception perception) {
        this.knowledgeBase.tell(perception);
    }

    @Override
    public void tell(CalculusAction action) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
