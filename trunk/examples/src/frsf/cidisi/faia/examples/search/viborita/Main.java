/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.examples.search.viborita;

import calculador.Calculador;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

/**
 *
 * @author miltondp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PrologConnectorException {
        Calculador calculador = new Calculador();
        AgenteSnake snake = new AgenteSnake(calculador);
        AmbienteSnake ambiente = new AmbienteSnake(calculador);
        SearchBasedAgentSimulator simu = new SearchBasedAgentSimulator(ambiente, snake);
        simu.start();
        System.out.println("Performance: " + calculador.getPerformance());
    }
}
