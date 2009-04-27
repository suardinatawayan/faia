/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.examples.situationcalculus.pacman;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SituationCalculusBasedAgentSimulator;

/**
 *
 * @author miltondp
 */
public class PacmanMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PrologConnectorException {
        AgentePacmanLogico agente = new AgentePacmanLogico();
        AmbientePacmanLogico ambiente = new AmbientePacmanLogico();
        SituationCalculusBasedAgentSimulator simu = new SituationCalculusBasedAgentSimulator(ambiente, agente);
        simu.start();
    }
}
