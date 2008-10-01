package frsf.cidisi.faia.agent;

import frsf.cidisi.faia.environment.Environment;

/**
 * This class is used to inform the agent about perceptions of the
 * real world.
 */
public abstract class Perception {

    public Perception() {
    }

    public Perception(Agent agent, Environment environment) {
        initPerception(agent, environment);
    }

    public abstract void initPerception(Agent agent, Environment environment);
}