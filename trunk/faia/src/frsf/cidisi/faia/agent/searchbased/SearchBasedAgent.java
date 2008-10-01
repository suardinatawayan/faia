package frsf.cidisi.faia.agent.searchbased;

import frsf.cidisi.faia.agent.*;

public abstract class SearchBasedAgent extends GoalBasedAgent {

    private Problem problem;

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
