/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.agent;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.Problem;

/**
 *
 * @author miltondp
 */
public abstract class SearchBasedAgent extends GoalBasedAgent {

    private Problem problem;
    
    @Override
    public Action selectAction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
