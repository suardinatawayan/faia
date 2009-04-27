/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.examples.search.robot;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

/**
 *
 * @author miltondp
 */
public class RobotMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PrologConnectorException {
        AgenteRobot agente = new AgenteRobot();
        AmbienteRobot ambiente = new AmbienteRobot();
        SearchBasedAgentSimulator simu = new SearchBasedAgentSimulator(ambiente, agente);
        simu.start();
    }
}
