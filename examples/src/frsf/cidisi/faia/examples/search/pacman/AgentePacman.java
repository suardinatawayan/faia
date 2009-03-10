package frsf.cidisi.faia.examples.search.pacman;

import frsf.cidisi.faia.examples.search.pacman.actions.Comer;
import frsf.cidisi.faia.examples.search.pacman.actions.IrAbajo;
import frsf.cidisi.faia.examples.search.pacman.actions.IrIzquierda;
import frsf.cidisi.faia.examples.search.pacman.actions.Pelear;
import frsf.cidisi.faia.examples.search.pacman.actions.IrArriba;
import frsf.cidisi.faia.examples.search.pacman.actions.IrDerecha;
import frsf.cidisi.faia.agent.Perception;
import java.util.Vector;

import frsf.cidisi.faia.agent.searchbased.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.searchbased.Problem;
import frsf.cidisi.faia.agent.searchbased.SearchAction;
import frsf.cidisi.faia.solver.search.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgentePacman extends SearchBasedAgent {

    public AgentePacman() {
        
        // Instancia la meta del Pacman.
        MetaPacman meta = new MetaPacman();
        
        // Instancia el estado inicial del Pacman.
        EstadoPacman estado = new EstadoPacman();
        this.setAgentState(estado);

        // Se generan las instancias de los operadores del Pacman.
        Vector<SearchAction> operadores = new Vector<SearchAction>();
        operadores.addElement(new Comer());
        operadores.addElement(new Pelear());
        operadores.addElement(new IrIzquierda());
        operadores.addElement(new IrArriba());
        operadores.addElement(new IrDerecha());
        operadores.addElement(new IrAbajo());

        // Se inicializa y asigna el problema inicial que debe resolver el Pacman.
        EstadoPacman estP = (EstadoPacman) this.getAgentState();
        Problem problema = new Problem(meta, estP, operadores);
        this.setProblem(problema);
    }
    
    /**
     * Es el método que ejecuta el simulador para pedirle una acción al agente
     */
    @Override
    public Action selectAction() {

        // Instanciación de la estrategia de búsqueda primero en profundidad.
        DepthFirstSearch estrategiaBusqueda = new DepthFirstSearch();

        /**
         * Ejemplos de instanciación de otras estrategias de búsqueda.
         * 
         * Primero en profundidad:
         * DepthFirstSearch estrategiaBusqueda = new DepthFirstSearch();
         * 
         * // Instanciación de la estrategia primero en amplitud.
         * BreathFirstSearch estrategiaBusqueda = new BreathFirstSearch();
         * 
         * // Instanciación de la estrategia de costo uniforme.
         * IStepCostFunction costo = new FuncionCosto();
         * UniformCostSearch estrategiaBusqueda = new UniformCostSearch(costo);
         * 
         * // Instanciación de la estrategia A* (A Estrella)
         * IStepCostFunction costo = new FuncionCosto();
         * IEstimatedCostFunction heuristica = new Heuristica();
         * AStarSearch estrategiaBusqueda = new AStarSearch(costo, heuristica);
         * 
         * // Instanciación de la estrategia Avara
         * IEstimatedCostFunction heuristica = new Heuristica();
         * GreedySearch estrategiaBusqueda = new GreedySearch(heuristica);
         */
        
        /* Instancia un proceso de búsqueda indicando como parámetro
         la estrategia a utilizar. */
        Search busqueda = new Search(estrategiaBusqueda);

        // Indica que el árbol de búsqueda debe ser mostrado e formato PDF.
        busqueda.setVisibleTree(Search.PDF_TREE);
        // La linea de abajo se utiliza para una salida XML, en lugar de PDF.
        //busqueda.setVisibleTree(Search.XML_TREE);

        // Le indica al Solver el proceso de búsqueda que debe ejecutar.
        this.setSolver(busqueda);

        // Se ejecuta el proceso de selección de la acción más adecuada.
        Action accionSeleccionada = null;
        try {
            accionSeleccionada =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(AgentePacman.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Retorna la acción seleccionada.
        return accionSeleccionada;
    }

    /**
     * Este método debe ser sobreescrito para recibir del simulador las
     * percepciones, y actualizar nuestro estado interno con ellas.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}
