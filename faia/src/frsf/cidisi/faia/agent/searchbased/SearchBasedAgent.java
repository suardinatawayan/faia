/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.agent.searchbased;

import frsf.cidisi.faia.agent.*;

/**
 *
 * @author miltondp
 */
public abstract class SearchBasedAgent extends GoalBasedAgent {

    private Problem problem;

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
