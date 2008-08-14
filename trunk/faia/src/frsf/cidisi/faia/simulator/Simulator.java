package frsf.cidisi.faia.simulator;

import java.util.Vector;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

/**
 * @created 07-Mar-2007 19:34:42
 * @author Jorge M. Roa
 * @version 1.0
 */
public abstract class Simulator {

    protected Vector<Agent> agents;
    protected Environment environment;

    public Simulator() {
    }

    /**
     * 
     * @param environment
     * @param agents    agents
     */
    public Simulator(Environment environment, Vector<Agent> agents) {
        this.environment = environment;
        this.agents = agents;
    }

    /**
     * 
     * @param agent    agent
     */
    public void addAgent(Agent agent) {
        this.getAgents().addElement(agent);
    }

    public Vector<Agent> getAgents() {
        return agents;
    }

    public Environment getEnvironment() {
        return this.environment;
    }

    public Perception getPercept(Agent agent) {
        return this.getEnvironment().getPercept(agent);
    }

    /**
     * 
     * @param evm    evm
     */
    public void setEnvironment(Environment evm) {
    }

    public abstract void start();
}