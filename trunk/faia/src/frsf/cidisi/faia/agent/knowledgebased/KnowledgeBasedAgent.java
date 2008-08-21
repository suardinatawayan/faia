package frsf.cidisi.faia.agent.knowledgebased;

import frsf.cidisi.faia.agent.*;

public abstract class KnowledgeBasedAgent extends GoalBasedAgent {

    public KnowledgeBasedAgent() {
        super();
    }

    public abstract void tell(CalculusAction action);
}
