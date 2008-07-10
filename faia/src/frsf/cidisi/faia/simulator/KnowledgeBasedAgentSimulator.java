/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.cidisi.faia.simulator;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.CalculusAgent;
import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.solver.calculus.KnowledgeBase;
import java.util.Vector;

/**
 *
 * @author miltondp
 */
public class KnowledgeBasedAgentSimulator extends GoalBasedAgentSimulator {

    public KnowledgeBasedAgentSimulator(Environment environment, Vector<Agent> agents) {
        super(environment, agents);
    }

    public KnowledgeBasedAgentSimulator(Environment environment, Agent agent) {
        super(environment, agent);
    }

    @Override
    public boolean isComplete() {
        CalculusAgent calculusAgent = (CalculusAgent) this.getAgents().firstElement();
        KnowledgeBase kb = (KnowledgeBase)calculusAgent.getAgentState();

        String s = kb.getGoalReachedPredicate() + "(" + kb.getSituation() + ")";
	
	return kb.queryHasSolution(s);
    }
    
    @Override
    public void start() {
        
        Perception perception;
        Action action;
        CalculusAgent agent;

        //TODO: Aca hay que tener en cuenta que podr�a haber m�s de un agente
        // por ahora el framework solo es monoagente :)
        agent = (CalculusAgent) this.getAgents().firstElement();

        while (!isComplete()) {
            
            System.out.println("-----------------------------------");
            System.out.println("-----------------------------------");
            
            // Se crea la percepcion y se la envia al agente
            perception = this.getPercept(agent);
            agent.see(perception);

            System.out.println("Agent State: " + agent.getAgentState());
            System.out.println("Environment: " + environment);
            System.out.println("-----------------------------------");
            System.out.println("-----------------------------------");

            // Pregunto al agente la accion a ejecutar
            action = agent.selectAction();
            
            System.out.println("Action: " + action);
            
            if (action != null) {
                /* Si la accion no es nula, entonces actualizo el mundo real en
                 * el simulador, y luego aviso al agente sobre la accion
                 * ejecutada, para que actualice su base de conocimiento. */
                this.updateState(action);
                agent.tell(action);
                agent.nextSituation();
                agent.executeSuccessorStateAxioms();
                
            } else {
                System.out.println("ERROR: There is not solution for this problem. You should check the operators.");
                break;
            }
        }
    }
}
