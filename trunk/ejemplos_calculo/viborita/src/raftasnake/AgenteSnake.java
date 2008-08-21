package raftasnake;

import java.util.Vector;

import calculador.Calculador;

import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.searchbased.Problem;
import frsf.cidisi.faia.solver.search.*;

public class AgenteSnake extends GoalBasedAgent {

    private Calculador calculador;

    @Override
    public Action selectAction() {
        // Instanciación la estrategia de búsqueda primero en profundidad.-
//		DepthFirstSearch estrategiaBusqueda = new DepthFirstSearch();

        /**
         * Ejemplos de instanciación de otras estrategias de búsqueda.-
         * 
         * // Instanciación de la estrategia primero en amplitud.-
         * BreathFirstSearch estrategiaBusqueda = new BreathFirstSearch();
         * 
         * // Instanciación de la estrategia de costo uniforme.-
         * IStepCostFunction costo = new FuncionCosto();
         * UniformCostSearch estrategiaBusqueda = new UniformCostSearch(costo);
         *///		IStepCostFunction costo = new FuncionCosto();
//		UniformCostSearch estrategiaBusqueda = new UniformCostSearch(costo);
        DepthFirstSearch estrategiaBusqueda = new DepthFirstSearch();

        // Instancia un proceso de búsqueda indicando como parámetro la estrategia a utilizar.-
        Search busqueda = new Search(estrategiaBusqueda);

        // Indica que el árbol de búsqueda debe ser mostrado e formato XML.-
        busqueda.setVisibleTree(Search.XML_TREE);

        // Le indica al Solver el proceso de búsqueda que debe ejecutar.- 
        this.setSolver(busqueda);

        // Se ejecuta el proceso de selección de la acción más adecuada.-
        Action accionSeleccionada = this.getSolver().solve(this.getProblem());

        if (accionSeleccionada.toString().equals("Avanzar")) {
            this.calculador.reportarAccion(Calculador.AVANZAR);
        } else if (accionSeleccionada.toString().equals("Comer")) {
            this.calculador.reportarAccion(Calculador.COMER);
        } else {
            this.calculador.reportarAccion(Calculador.GIRAR);        // Retorna la acción seleccionada.-
        }
        return accionSeleccionada;
    }

    public AgenteSnake(Calculador calculador) {
        // Instancia la meta del Snake.-
        MetaSnake meta = new MetaSnake();
        // Instancia el estado inicial del Snake.-
        EstadoSnake estado = new EstadoSnake();

        this.setAgentState(estado);

        // Se generan las instancias de los operadores del Snake.-
        Vector<Action> operadores = new Vector<Action>();
        operadores.addElement(new Comer());
        operadores.addElement(new Avanzar());
        operadores.addElement(new GirarIzquierda());
        operadores.addElement(new GirarDerecha());

        // Se inicializa y asigna el problema inicial que debe resolver el Snake.-
        EstadoSnake estSnake = (EstadoSnake) this.getAgentState();
        Problem problema = new Problem(meta, estSnake, operadores);
        this.setProblem(problema);

        this.calculador = calculador;
    }
}
