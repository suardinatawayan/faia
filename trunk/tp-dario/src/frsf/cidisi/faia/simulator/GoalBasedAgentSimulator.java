package frsf.cidisi.faia.simulator;
import java.util.Vector;

import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.Problem;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.agent.problem.GoalTest;
import frsf.cidisi.faia.state.AgentState;
/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 09-Mar-2007 14:48:38
 */
public class GoalBasedAgentSimulator extends Simulator {

	/**
	 * 
	 * @param environment
	 */
	public GoalBasedAgentSimulator(Environment environment, Vector<Agent> agents){
		super(environment,agents);
	}

	public GoalBasedAgentSimulator(Environment environment, Agent agent){
		Vector<Agent> ags = new Vector<Agent>();
		ags.add(agent);

		this.environment = environment;
		this.agents = ags;
	}

	public boolean isComplete(){
		//TODO: 
		// ACA HAY QUE HACER UN BUCLE PARA CUANDO HAY MAS DE UN AGENTE DEFINIDO
		// POR AHORA EL FRAMEWORK ES MONOAGENTE :)
		GoalBasedAgent gba = (GoalBasedAgent)getAgents().firstElement();
		Problem p = gba.getProblem();
		GoalTest gt = p.getGoalState();
		AgentState aSt = p.getAgentState();
		
		if (gt.isGoalState(aSt)) {
			System.out.println("Solucion!!");
			System.out.println("Agent State: " + aSt);
			System.out.println("Environment: " + environment);
		}
		
		return gt.isGoalState(aSt);
	}

	public void start(){
		//TODO:
		// ANTES DE EMPEZAR CON LA SIMULACION HAY QUE TESTEAR QUE EL AMBIENTE ESTE
		// INICIALIZADO, ETC.
		
		Perception perception;
		Action action;
		GoalBasedAgent agent;	
		
		//TODO: Aca hay que tener en cuenta que podr�a haber m�s de un agente
		// por ahora el framework solo es monoagente :)
		agent = (GoalBasedAgent)this.getAgents().firstElement();
		
		while (!isComplete()){
			System.out.println("-----------------------------------");
			System.out.println("-----------------------------------");
			perception = this.getPercept(agent);
			agent.see(perception);
			
			if (isComplete())
				break;
			

			System.out.println("Agent State: " + agent.getAgentState());
			System.out.println("Environment: " + environment);
			System.out.println("-----------------------------------");
			System.out.println("-----------------------------------");

			
			action = agent.selectAction();
			System.out.println("Action: " + action);
			if (action!=null)
				this.updateState(action);
			else{
				System.out.println("ERROR: There is not solution for this problem. You should check the operators.");
				break;
			}
			
			showSolution();
		}
	}

	/**
	 * 
	 * @param action    action
	 */
	protected void updateState(Action action){
		this.getEnvironment().updateState(((GoalBasedAgent)agents.elementAt(0)).getAgentState(), action);
	}
	
	public void showSolution(){
		GoalBasedAgent agent = (GoalBasedAgent)this.getAgents().firstElement();
		
		agent.getSolver().showSolution();
	}

}