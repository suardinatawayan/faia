package frsf.cidisi.faia.solver.calculus;

import java.util.Hashtable;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;
import jpl.JPL;
import jpl.PrologException;
import jpl.Query;

public class KnowledgeBase extends AgentState {
	
	private String knowledgeBaseFile;
	private Query prologQuery;
	
	/**
	 * Situación actual.
	 */
	public int situation;
	
	//VisionAmbiente visionAmbiente;
	//private int energia;
	
	public KnowledgeBase(String knowledgeBaseFile) {
		super();
		
		this.knowledgeBaseFile = knowledgeBaseFile;
		this.situation = 0;
		//this.visionAmbiente = new VisionAmbiente();
		
		/* Aumento la memoria disponible para el stack local, el global y el de
		 * restro. */
		JPL.setDefaultInitArgs(new String[] {
				"swipl",
				"-G128m",
				"-L128m",
				"-T128m",
				"-nosignals"
		});
		
		JPL.init();
		
		// Cargo la base de conocimiento
		this.prologQuery = new Query("consult('" + this.knowledgeBaseFile + "')");
		
		/* TODO: Aca hay que manejar los errores de otra forma. La excepción tiene
		 * que arrojarse, pero la PrologException tira un error feo.
		 */
		try {
			this.prologQuery.hasSolution();
		}
		catch(PrologException e) {
			System.out.println("ERROR: Load of knowledge base failed.");
		}
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
//		this.prologQuery = new Query("bestAction(X," + this.situation + ")");
		//this.log.info("mejorAccion(X," + this.situation + ")"+",assert(accionEjecutada(X," + this.situation + "))");
		
//		String solution = null;
//		
//		if (this.prologQuery.hasSolution())
//			solution = this.prologQuery.oneSolution().get("X").toString();
//		else
//			return null;
		
		return this.askFor("bestAction(X," + this.situation + ")")[0].get("X").toString();
	}
	
	public Hashtable[] askFor(String query) {
		this.prologQuery = new Query(query);
		
		return this.prologQuery.allSolutions();
	}
	
	public boolean goalReached() {
		String s = "goalReached(" + this.situation + ")";
		this.prologQuery = new Query(s);
		
		return this.prologQuery.hasSolution();
	}


	@Override
	public void updateState(Perception p) {
		this.tell(p);
	}


	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
