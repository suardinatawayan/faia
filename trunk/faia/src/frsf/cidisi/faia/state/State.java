package frsf.cidisi.faia.state;

import frsf.cidisi.faia.state.datastructure.DataStructure;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:05
 */
public abstract class State implements Cloneable {

    protected DataStructure dataStructure;

    public State() {
    }

    @Override
    public abstract Object clone();

    public abstract void initState();

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);
}