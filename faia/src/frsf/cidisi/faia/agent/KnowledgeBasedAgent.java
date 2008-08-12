package frsf.cidisi.faia.agent;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.solver.calculus.KnowledgeBase;

public abstract class KnowledgeBasedAgent extends GoalBasedAgent {

    public KnowledgeBasedAgent() {
        super();
    }

    public abstract void tell(Action action);
}
