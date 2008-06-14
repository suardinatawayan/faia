package frsf.cidisi.faia.solver.calculus;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.problem.Action;
import jpl.JPL;
import jpl.Query;

public class KnowledgeBase {
	
	private final String KNOWLEDGE_BASE_FILE = "knowledge_file.pl";
	
	private Query prologQuery;
	
	/**
	 * Situación actual.
	 */
	public int situation;
	
	//VisionAmbiente visionAmbiente;
	//private int energia;
	
	public KnowledgeBase() throws Exception {
		super();
		
		this.situation = 0;
		//this.visionAmbiente = new VisionAmbiente();
		
		/* Aumento la memoria disponible para el stack local, el global y el de
		 * restro. */
		JPL.setDefaultInitArgs(new String[] {
				"pl",
				"-G128m",
				"-L128m",
				"-T128m",
				"-nosignals"
		});
		
		JPL.init();
		
		// Cargo la base de conocimiento
		this.prologQuery = new Query("consult('" + KNOWLEDGE_BASE_FILE + "')");
		
		if (!this.prologQuery.hasSolution())
			throw new Exception("Failure loading knowledge base: " + KNOWLEDGE_BASE_FILE);
	}

	
	public void tell(Perception p) {
		this.situation++;
		
		// Le agrego a la percepción el parámetros situacional
		//p.setTiempo(this.situation);
		
		this.prologQuery = new Query("assert(" + p.toString() + ")");
		//this.log.info("assert(" + p.toString() + ")");
		this.prologQuery.hasSolution();
		this.prologQuery = new Query("findall(X,est("+this.situation+"),L)");
		//this.log.info("findall(X,est("+this.tiempo+"),L)");
		this.prologQuery.hasSolution();
		//this.energia = p.getEnergia();
		//this.visionAmbiente.actualizar(p);
	}
	
	public void tell(Action a) {
		if (a == null)
			return;
		
		this.prologQuery = new Query("assert(executedAction(" + a.getLogicName()
				+ "," + this.situation + "))");
		
		this.prologQuery.hasSolution();
		
//		try {
//			a.ejecutar(this.visionAmbiente);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public String askForBestAction() {
		Action a = null;
		
		this.prologQuery = new Query("bestAction(X," + this.situation + ")");
		//this.log.info("mejorAccion(X," + this.situation + ")"+",assert(accionEjecutada(X," + this.situation + "))");
		
		String solution = null;
		
		if (this.prologQuery.hasSolution())
			solution = this.prologQuery.oneSolution().get("X").toString();
		else
			return null;
		
		// TODO: Hay que ver de una forma de armar las acciones independientemente.
		//return Action.getAccion(solution);
		
		return solution;
	}

	public boolean goalReached() {
		String s = "goalReached(" + this.situation + ")";
		this.prologQuery = new Query(s);
		
		return this.prologQuery.hasSolution();
	}
}
