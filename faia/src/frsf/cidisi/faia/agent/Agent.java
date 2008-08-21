package frsf.cidisi.faia.agent;

/**
 * @created 07-Mar-2007 19:34:40
 * @author Jorge M. Roa
 * @version 1.0
 */
public abstract class Agent {

    public Agent() {
    }
    
    public abstract Action selectAction();
}