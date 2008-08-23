package agente;

import agente.acciones.Comer;
import agente.acciones.IrAbajo;
import agente.acciones.IrIzquierda;
import agente.acciones.Pelear;
import agente.acciones.IrArriba;
import agente.acciones.IrDerecha;
import frsf.cidisi.faia.exceptions.CalculusException;
import java.util.Vector;

import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.searchbased.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.searchbased.Problem;
import frsf.cidisi.faia.agent.searchbased.SearchAction;
import frsf.cidisi.faia.solver.search.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgentePacman extends SearchBasedAgent {

    public AgentePacman() {
        // Instancia la meta del Pacman.-
        MetaPacman meta = new MetaPacman();
        // Instancia el estado inicial del Pacman.-
        EstadoPacman estado = new EstadoPacman();
        this.setAgentState(estado);

        // Se generan las instancias de los operadores del Pacman.-
        Vector<SearchAction> operadores = new Vector<SearchAction>();
        operadores.addElement(new Comer());
        operadores.addElement(new Pelear());
        operadores.addElement(new IrIzquierda());
        operadores.addElement(new IrArriba());
        operadores.addElement(new IrDerecha());
        operadores.addElement(new IrAbajo());

        // Se inicializa y asigna el problema inicial que debe resolver el Pacman.-
        EstadoPacman estP = (EstadoPacman) this.getAgentState();
        Problem problema = new Problem(meta, estP, operadores);
        this.setProblem(problema);
    }

    @Override
    public Action selectAction() {

        // Instanciaci�n la estrategia de b�squeda primero en profundidad.-
        DepthFirstSearch estrategiaBusqueda = new DepthFirstSearch();

        /**
         * Ejemplos de instanciaci�n de otras estrategias de b�squeda.-
         * 
         * Primero en profundidad:
         * DepthFirstSearch estrategiaBusqueda = new DepthFirstSearch();
         * 
         * // Instanciaci�n de la estrategia primero en amplitud.-
         * BreathFirstSearch estrategiaBusqueda = new BreathFirstSearch();
         * 
         * // Instanciaci�n de la estrategia de costo uniforme.-
         * IStepCostFunction costo = new FuncionCosto();
         * UniformCostSearch estrategiaBusqueda = new UniformCostSearch(costo);
         * 
         * A Estrella:
         * IStepCostFunction costo = new FuncionCosto();
         * IEstimatedCostFunction heuristica = new Heuristica();
         * AStarSearch estrategiaBusqueda = new AStarSearch(costo, heuristica);
         * 
         * Avara:
         * IEstimatedCostFunction heuristica = new Heuristica();
         * GreedySearch estrategiaBusqueda = new GreedySearch(heuristica);
         */        // Instancia un proceso de b�squeda indicando como par�metro la estrategia a utilizar.-
        Search busqueda = new Search(estrategiaBusqueda);

        // Indica que el �rbol de b�squeda debe ser mostrado e formato XML.-
        busqueda.setVisibleTree(Search.PDF_TREE);

        // Le indica al Solver el proceso de búsqueda que debe ejecutar.- 
        this.setSolver(busqueda);

        // Se ejecuta el proceso de selección de la acción más adecuada.-
        Action accionSeleccionada = null;
        try {
            accionSeleccionada =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(AgentePacman.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Retorna la acci�n seleccionada.-
        return accionSeleccionada;
    }
}