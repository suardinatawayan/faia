package frsf.cidisi.faia.agent;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.solver.calculus.KnowledgeBase;

public abstract class KnowledgeBasedAgent extends GoalBasedAgent {

    public KnowledgeBasedAgent() {
        super();
    }

    public void executeSuccessorStateAxioms() {
        KnowledgeBase knowledgeBase = (KnowledgeBase) this.getAgentState();
        knowledgeBase.executeSuccessorStateAxioms();
    }

    public abstract void tell(Action action);

    public void nextSituation() {
        KnowledgeBase knowledgeBase = (KnowledgeBase) this.getAgentState();
        knowledgeBase.nextSituation();
    }
}
