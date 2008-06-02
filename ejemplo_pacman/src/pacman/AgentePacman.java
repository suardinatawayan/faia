package pacman;

import java.util.Vector;

import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.Problem;
import frsf.cidisi.faia.solver.search.*;

public class AgentePacman extends GoalBasedAgent {

	public AgentePacman(){
		// Instancia la meta del Pacman.-
		MetaPacman meta = new MetaPacman();
		// Instancia el estado inicial del Pacman.-
		EstadoPacman estado = new EstadoPacman();
		this.setAgentState(estado);
		
		// Se generan las instancias de los operadores del Pacman.-
		Vector<Action> operadores = new Vector<Action>();
		operadores.addElement(new Comer());
		operadores.addElement(new Pelear());
		operadores.addElement(new IrIzquierda());
		operadores.addElement(new IrArriba());
		operadores.addElement(new IrDerecha());
		operadores.addElement(new IrAbajo());

		// Se inicializa y asigna el problema inicial que debe resolver el Pacman.-
		EstadoPacman estP = (EstadoPacman)this.getAgentState();
		Problem problema = new Problem(meta,estP,operadores);
		this.setProblem(problema);
	}
	
	public Action selectAction(){
		
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
 */		
		
		// Instancia un proceso de b�squeda indicando como par�metro la estrategia a utilizar.-
		Search busqueda = new Search(estrategiaBusqueda);
		
		// Indica que el �rbol de b�squeda debe ser mostrado e formato XML.-
		busqueda.setVisibleTree(Search.PDF_TREE);
		
		// Le indica al Solver el proceso de b�squeda que debe ejecutar.- 
		this.setSolver(busqueda);
		
		// Se ejecuta el proceso de selecci�n de la acci�n m�s adecuada.-
		Action accionSeleccionada = this.getSolver().solve(this.getProblem());
		
		// Retorna la acci�n seleccionada.-
		return accionSeleccionada;
	}
}