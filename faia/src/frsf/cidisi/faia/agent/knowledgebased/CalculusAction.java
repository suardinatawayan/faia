/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.agent.knowledgebased;

import frsf.cidisi.faia.agent.Action;

/**
 *
 * @author miltondp
 */
public abstract class CalculusAction extends Action {

    public String getLogicName() {
        return this.toString().toLowerCase();
    }
}
