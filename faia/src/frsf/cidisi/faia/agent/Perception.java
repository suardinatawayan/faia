package frsf.cidisi.faia.agent;

import frsf.cidisi.faia.environment.Environment;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:05
 */
public abstract class Perception {

    public Perception() {
    }

    public Perception(Agent agent, Environment environment) {
        initPerception(agent, environment);
    }

    public abstract void initPerception(Agent agent, Environment environment);
}