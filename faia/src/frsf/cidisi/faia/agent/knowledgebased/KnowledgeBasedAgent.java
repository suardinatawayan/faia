package frsf.cidisi.faia.agent.knowledgebased;

import frsf.cidisi.faia.agent.*;

public abstract class KnowledgeBasedAgent extends GoalBasedAgent {

    public KnowledgeBasedAgent() {
        super();
    }

    /**
     * This method is executed by the simulator to tell the agent
     * what action was executed in the current situation.
     * @param action
     */
    public abstract void tell(CalculusAction action);
}
