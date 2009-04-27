/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.examples.planning.cubos;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.PlanningBasedAgentSimulator;

/**
 *
 * @author miltondp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PrologConnectorException {
        AgenteCubos agente = new AgenteCubos();
        AmbienteCubos ambiente = new AmbienteCubos();
        PlanningBasedAgentSimulator simu = new PlanningBasedAgentSimulator(ambiente, agente);
        simu.start();
    }
}
