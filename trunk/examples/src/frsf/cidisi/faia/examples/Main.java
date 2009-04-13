/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.examples;

import calculador.Calculador;
import frsf.cidisi.faia.examples.planning.cubos.AgenteCubos;
import frsf.cidisi.faia.examples.planning.cubos.AmbienteCubos;
import frsf.cidisi.faia.examples.search.pacman.AgentePacman;
import frsf.cidisi.faia.examples.search.pacman.AmbientePacman;
import frsf.cidisi.faia.examples.search.robot.AgenteRobot;
import frsf.cidisi.faia.examples.search.robot.AmbienteRobot;
import frsf.cidisi.faia.examples.search.viborita.AgenteSnake;
import frsf.cidisi.faia.examples.search.viborita.AmbienteSnake;
import frsf.cidisi.faia.examples.situationcalculus.pacman.AgentePacmanLogico;
import frsf.cidisi.faia.examples.situationcalculus.pacman.AmbientePacmanLogico;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.PlanningBasedAgentSimulator;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import frsf.cidisi.faia.simulator.SituationCalculusBasedAgentSimulator;

/**
 *
 * @author miltondp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PrologConnectorException {
        // Ejemplo de búsqueda 'robot'
//        AgenteRobot agente = new AgenteRobot();
//        AmbienteRobot ambiente = new AmbienteRobot();
//        SearchBasedAgentSimulator simu = new SearchBasedAgentSimulator(ambiente, agente);
//        simu.start();
        
        // Ejemplo de búsqueda 'pacman' con generación de archivos PDF
        // de los árboles de búsqueda. Estos archivos se generan en la carpeta
        // 'pdflatex'
//        AgentePacman agente = new AgentePacman();
//        AmbientePacman ambiente = new AmbientePacman();
//        SearchBasedAgentSimulator simu = new SearchBasedAgentSimulator(ambiente, agente);
//        simu.start();
        
        AgenteCubos agente = new AgenteCubos();
        AmbienteCubos ambiente = new AmbienteCubos();
        PlanningBasedAgentSimulator simu = new PlanningBasedAgentSimulator(ambiente, agente);
        simu.start();


        // Ejemplo de búsqueda 'viborita'
//        Calculador calculador = new Calculador();
//        AgenteSnake snake = new AgenteSnake(calculador);
//        AmbienteSnake ambiente = new AmbienteSnake(calculador);
//        SearchBasedAgentSimulator simu = new SearchBasedAgentSimulator(ambiente, snake);
//        simu.start();
//        System.out.println("Performance: " + calculador.getPerformance());

        
        // Ejemplo de cálculo situacional 'pacman'
//        AgentePacmanLogico agente = new AgentePacmanLogico();
//        AmbientePacmanLogico ambiente = new AmbientePacmanLogico();
//        SituationCalculusBasedAgentSimulator simu = new SituationCalculusBasedAgentSimulator(ambiente, agente);
//        simu.start();
    }
}
