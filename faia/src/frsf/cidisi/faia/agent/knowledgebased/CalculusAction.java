
package frsf.cidisi.faia.agent.knowledgebased;

import frsf.cidisi.faia.agent.Action;

public abstract class CalculusAction extends Action {

    public String getLogicName() {
        return this.toString().toLowerCase();
    }
}
