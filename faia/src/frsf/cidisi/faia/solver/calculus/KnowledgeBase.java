package frsf.cidisi.faia.solver.calculus;

import java.util.Hashtable;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.exceptions.KnowledgeBaseException;
import frsf.cidisi.faia.state.AgentState;
import jpl.JPL;
import jpl.PrologException;
import jpl.Query;

public abstract class KnowledgeBase extends AgentState {

    private String knowledgeBaseFile;
    private Query prologQuery;
    /**
     * Situación actual.
     */
    private int situation;
    //VisionAmbiente visionAmbiente;
    //private int energia;
    public KnowledgeBase(String knowledgeBaseFile) throws KnowledgeBaseException {
        super();

        this.knowledgeBaseFile = knowledgeBaseFile;
        this.situation = 0;
        //this.visionAmbiente = new VisionAmbiente();

        /* Aumento la memoria disponible para el stack local, el global y el de
         * restro. */
        JPL.setDefaultInitArgs(new String[]{
                    "pl",
                    "-G128m",
                    "-L128m",
                    "-T128m",
                    "--quiet",
                    "--nosignals"
                });

        JPL.init();

        // Cargo la base de conocimiento
        this.prologQuery = new Query("consult('" + this.knowledgeBaseFile + "')");

        /* TODO: Aca hay que manejar los errores de otra forma. La excepción tiene
         * que arrojarse, pero la PrologException tira un error feo.
         */
        try {
            this.prologQuery.hasSolution();
        } catch (PrologException e) {
            throw new KnowledgeBaseException("Load of knowledge base failed ('" +
                    this.knowledgeBaseFile + "').");
        }
    }

    public void tell(Perception perception) {
        //this.situation++;

        // Le agrego a la percepción el parámetros situacional
        //p.setTiempo(this.situation);

//        this.prologQuery = new Query("assert(" + perception.toString() + ")");
//        //this.log.info("assert(" + p.toString() + ")");
//        this.prologQuery.hasSolution();
        
        this.addKnowledge(perception.toString());
    //this.energia = p.getEnergia();
    //this.visionAmbiente.actualizar(p);
    }
    
    public void executeSuccessorStateAxioms() {
        this.prologQuery = new Query("findall(X,est(" + this.getSituation() + "),L)");
        //this.log.info("findall(X,est("+this.tiempo+"),L)");
        this.prologQuery.hasSolution();
    }

    public void tell(String action) {
        if (action == null) {
            return;
        }
        
        this.addKnowledge(this.getExecutedActionPredicate() +
                "(" + action + "," + this.getSituation() + ")");
        
//		try {
//			a.ejecutar(this.visionAmbiente);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
    
//    @Override
//    public void updateState(Perception perception) {
//        this.tell(perception);
//    }

//    public String queryForBestAction() {
////		this.prologQuery = new Query("bestAction(X," + this.situation + ")");
//        //this.log.info("mejorAccion(X," + this.situation + ")"+",assert(accionEjecutada(X," + this.situation + "))");
//
////		String solution = null;
////		
////		if (this.prologQuery.hasSolution())
////			solution = this.prologQuery.oneSolution().get("X").toString();
////		else
////			return null;
//
//        return this.query("bestAction(X," + this.getSituation() + ")")[0].get("X").toString();
//    }
    public Hashtable[] query(String query) {
        this.prologQuery = new Query(query);
        return this.prologQuery.allSolutions();
    }

    public boolean queryHasSolution(String query) {
        this.prologQuery = new Query(query);
        return this.prologQuery.hasSolution();
    }
    
    public void addKnowledge(String predicate) {
        this.prologQuery = new Query("asserta(" + predicate + ")");
        this.prologQuery.hasSolution();
    }
    
//	public boolean goalReached() {
//		String s = "goalReached(" + this.situation + ")";
//		this.prologQuery = new Query(s);
//		
//		return this.prologQuery.hasSolution();
//	}
//    @Override
//    public void updateState(Perception p) {
//        this.tell(p);
//    }
    
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

//    @Override
//    public String toString() {
//        // TODO Auto-generated method stub
//        return null;
//    }
    /**
     * Returns the actual situation of the Knowledge Base
     * @return
     */
    public int getSituation() {
//        Hashtable[] resultado = this.query(this.getCurrentSituationPredicate() +
//                "(S)");
//        
//        return Integer.parseInt(resultado[0].get("S").toString());
        return this.situation;
    }
    
    public void nextSituation() {
        this.situation++;
    }
    
    public abstract CalculusActionFactory getActionFactory();
    
    public abstract String getBestActionPredicate();
    
    public abstract String getGoalReachedPredicate();
    
    public abstract String getExecutedActionPredicate();
    
    public abstract String getCurrentSituationPredicate();
}
