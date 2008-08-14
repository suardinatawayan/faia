package robot;

import java.util.Vector;

import frsf.cidisi.faia.agent.SearchBasedAgent;
import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.Problem;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.Search;

public class AgenteRobot extends SearchBasedAgent {

    public AgenteRobot() {
        // Instancia la meta del Pacman.-
        MetaRobot meta = new MetaRobot();
        // Instancia el estado inicial del Pacman.-
        EstadoRobot estado = new EstadoRobot();
        this.setAgentState(estado);

        // Se generan las instancias de los operadores del Pacman.-
        Vector<Action> operadores = new Vector<Action>();
        operadores.addElement(new IrA());
        operadores.addElement(new IrB());
        operadores.addElement(new IrC());
        operadores.addElement(new IrD());
        operadores.addElement(new IrE());
        operadores.addElement(new IrF());
        operadores.addElement(new IrG());
        operadores.addElement(new IrH());
        operadores.addElement(new IrI());
        operadores.addElement(new IrJ());
        operadores.addElement(new IrK());
        operadores.addElement(new IrL());
        operadores.addElement(new IrM());
        operadores.addElement(new IrN());
        operadores.addElement(new IrO());
        operadores.addElement(new IrP());
        operadores.addElement(new IrQ());

        // Se inicializa y asigna el problema inicial que debe resolver el Pacman.-
        EstadoRobot estR = (EstadoRobot) this.getAgentState();
        Problem problema = new Problem(meta, estR, operadores);
        this.setProblem(problema);
    }

    @Override
    public Action selectAction() {

//		// Instanciación la estrategia de búsqueda primero en profundidad.-
//		DepthFirstSearch estrategiaBusqueda = new DepthFirstSearch();

        // Instanciación de la estrategia primero en amplitud.-
        BreathFirstSearch estrategiaBusqueda = new BreathFirstSearch();

        /**
         * Ejemplos de instanciación de otras estrategias de búsqueda.-
         * 
         * // Instanciación de la estrategia primero en amplitud.-
         * BreathFirstSearch estrategiaBusqueda = new BreathFirstSearch();
         * 
         * // Instanciación de la estrategia de costo uniforme.-
         * IStepCostFunction costo = new FuncionCosto();
         * UniformCostSearch estrategiaBusqueda = new UniformCostSearch(costo);
         */        // Instancia un proceso de búsqueda indicando como parámetro la estrategia a utilizar.-

        Search busqueda = new Search(estrategiaBusqueda);

        // Indica que el árbol de búsqueda debe ser mostrado e formato XML.-
        busqueda.setVisibleTree(Search.XML_TREE);

        // Le indica al Solver el proceso de búsqueda que debe ejecutar.- 
        this.setSolver(busqueda);

        // Se ejecuta el proceso de selección de la acción más adecuada.-
        Action accionSeleccionada = this.getSolver().solve(this.getProblem());

        // Retorna la acción seleccionada.-
        return accionSeleccionada;
    }
}