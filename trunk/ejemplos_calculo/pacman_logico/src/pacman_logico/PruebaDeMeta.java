/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman_logico;

import frsf.cidisi.faia.agent.problem.GoalTest;
import frsf.cidisi.faia.solver.calculus.KnowledgeBase;
import frsf.cidisi.faia.state.AgentState;

/**
 *
 * @author miltondp
 */
public class PruebaDeMeta extends GoalTest {

    @Override
    public boolean isGoalState(AgentState agentState) {
        KnowledgeBase kb = (KnowledgeBase) agentState;
        
        String consulta = "cumplioObjetivo(" + kb.getSituation() + ")";
        
        return kb.queryHasSolution(consulta);
    }

}
