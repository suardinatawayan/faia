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
     * Actual situation.
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

        // Load the knowledge base
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
        this.addKnowledge(perception.toString());
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
        
        // Advance to the next situation
        this.advanceToNextSituation();
        
        // Execute successors state axioms
        this.executeSuccessorStateAxioms();
    }
    
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
    
    @Override
    public Object clone() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Returns the actual situation of the Knowledge Base
     * @return
     */
    public int getSituation() {
        return this.situation;
    }

    public void advanceToNextSituation() {
        this.situation++;
    }

    public abstract CalculusActionFactory getActionFactory();

    public abstract String getBestActionPredicate();

    public abstract String getGoalReachedPredicate();

    public abstract String getExecutedActionPredicate();

    public abstract String getCurrentSituationPredicate();
}
