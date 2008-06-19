package raftasnake;

import java.util.Vector;

import calculador.Calculador;
import frsf.cidisi.faia.agent.CalculusAgent;
import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.Problem;
import frsf.cidisi.faia.solver.calculus.Calculus;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;

public class AgenteCalculus extends CalculusAgent {
	private Calculador calculador;

	@Override
	public Action selectAction() {
		//DepthFirstSearch estrategiaBusqueda = new DepthFirstSearch();
		
		// Instancia un proceso de búsqueda indicando como parámetro la estrategia a utilizar.-
		Calculus calculo = new Calculus(this.getKnowledgeBase(), CalculusAccion.getInstance());
		
		/* TODO: Habría que hacer algo para visualizar el comportamiento del agente,
		 * como con latex o xml.
		 */
		
		// Esta vez utilizamos cálculo. 
		this.setSolver(calculo);
		
		// Se ejecuta el proceso de selección de la acción más adecuada.-
		Action accionSeleccionada = this.getSolver().solve(this.getProblem());
		
		// TODO: Esto lo tendría que hacer el simulador.
		if (accionSeleccionada.toString() == "Avanzar")
			this.calculador.reportarAccion(Calculador.AVANZAR);
		else if (accionSeleccionada.toString() == "Comer")
			this.calculador.reportarAccion(Calculador.COMER);
		else
			this.calculador.reportarAccion(Calculador.GIRAR);
		
		// Retorna la acción seleccionada.-
		return accionSeleccionada;
	}

	public AgenteCalculus(Calculador calculador) {
		super("base_conocimiento.pl");
		
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
		EstadoSnake estSnake = (EstadoSnake)this.getAgentState();
		Problem problema = new Problem(meta, estSnake, operadores);
		this.setProblem(problema);
		
		this.calculador = calculador;
	}
}
