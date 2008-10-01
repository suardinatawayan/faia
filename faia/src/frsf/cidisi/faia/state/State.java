package frsf.cidisi.faia.state;

import frsf.cidisi.faia.state.datastructure.DataStructure;

public abstract class State implements Cloneable {

    protected DataStructure dataStructure;

    public State() {
    }

    /**
     * This method is used in two places:
     *   1. To set the initial state (the real one) of the world, seen
     *      by the simulator.
     *   2. To set the initial state of the agent.
     */
    public abstract void initState();

    /**
     * This method is used to print the state in the console.
     */
    @Override
    public abstract String toString();
}