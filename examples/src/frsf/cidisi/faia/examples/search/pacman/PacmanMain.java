/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.examples.search.pacman;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

/**
 *
 * @author miltondp
 */
public class PacmanMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PrologConnectorException {
        AgentePacman agente = new AgentePacman();
        AmbientePacman ambiente = new AmbientePacman();
        SearchBasedAgentSimulator simu = new SearchBasedAgentSimulator(ambiente, agente);
        simu.start();
    }
}
