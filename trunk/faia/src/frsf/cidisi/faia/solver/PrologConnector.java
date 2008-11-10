package frsf.cidisi.faia.solver;

import java.util.Hashtable;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import jpl.JPL;
import jpl.PrologException;
import jpl.Query;

/**
 * This is the knowledge base used by the agent. It offers some methods
 * to easily consult for the agent's state, and adding new knowledge.
 */
public class PrologConnector {

	/**
	 * The knowledge base file written by the user.
	 */
    private String prologFile;
    
    public PrologConnector(String prologFile) throws PrologConnectorException {

        this.prologFile = prologFile;
        

        /* Set some JPL options */
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
        Query prologQuery;
        prologQuery = new Query("consult('" + this.prologFile + "')");

        /* TODO: Aca hay que manejar los errores de otra forma. La excepción tiene
         * que arrojarse, pero la PrologException tira un error feo.
         */
        try {
            prologQuery.hasSolution();
        } catch (PrologException e) {
            throw new PrologConnectorException("Load of prolog file failed ('" +
                    this.prologFile + "').");
        }
    }
    
    public void executeNonQuery(String nonQuery) {
    	this.queryHasSolution(nonQuery);
    }
    
    public Hashtable[] query(String query) {
    	Query prologQuery = new Query(query);
        return prologQuery.allSolutions();
    }
    
    public boolean queryHasSolution(String query) {
    	Query prologQuery = new Query(query);
        return prologQuery.hasSolution();
    }
}
