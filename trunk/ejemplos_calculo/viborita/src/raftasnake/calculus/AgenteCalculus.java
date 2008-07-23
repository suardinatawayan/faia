package raftasnake.calculus;

import java.util.Vector;

import raftasnake.EstadoSnake;

import calculador.Calculador;
import frsf.cidisi.faia.agent.CalculusAgent;
import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.Problem;
import frsf.cidisi.faia.solver.calculus.Calculus;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;

public class AgenteCalculus extends CalculusAgent {

    private Calculador calculador;

    public AgenteCalculus(Calculador calculador) {
        super("base_conocimiento.pl");

        // Instancia el estado inicial del Snake.-
        EstadoSnake estado = new EstadoSnake();

        this.setAgentState(estado);

        // Instancia un proceso de búsqueda indicando como parámetro la estrategia a utilizar.-
        Calculus calculo = new Calculus(this.getKnowledgeBase(), CalculusAccion.getInstance());

        /* TODO: Habría que hacer algo para visualizar el comportamiento del agente,
         * como con latex o xml.
         */

        // Esta vez utilizamos cálculo. 
        this.setSolver(calculo);

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
}
