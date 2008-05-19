package frsf.cidisi.faia.solver.search;

import java.util.Vector;
/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 18:21:43
 */
public class UniformCostSearch extends Strategy {
	private IStepCostFunction stepCostFunction;


	public UniformCostSearch(IStepCostFunction stepCostFunction){
		this.stepCostFunction = stepCostFunction;
	}

	public void addNodesToExpand(Vector<NTree> nodes){
		
		// Add each node in nodes to the list of nodes to expand.- 
		for (NTree node : nodes)
			addNodeToExpand(node);
		
	}

	public void addNodeToExpand(NTree node){

		// If the list of nodes to expand was empty at the beginning.-  
		if (nodesToExpand.size()==0){
			nodesToExpand.addElement(node);	// Just add the node to the empty list.-
			return;	// Exit from the method.- 
		}
		else{	// If the list of nodes to expand was not empty, 
				// is necessary to find the right place to add the new node.-
		
			// Calculate the cost of the new node.-
			double nodeValue = stepCostFunction.calculateCost(node.getAgentState());
	
			// Iterate through the list of nodes to expand and find the position to insert the new node on the list.-
			for (int i=0;i<nodesToExpand.size();i++){
				double iValue = stepCostFunction.calculateCost(nodesToExpand.elementAt(i).getAgentState());
				//TODO: ACA HAY QUE TENER EN CUENTA QUE ES POSIBLE QUE EL ORDEN DE COSTO SEA AL REV�S
				//ES DECIR, VA UN > EN LUGAR DE UN < EN LA PREGUNTA DEL IF.-
				if (nodeValue >= iValue)
					nodesToExpand.add(i, node);
			}
		}

	}

	public IStepCostFunction getStepCostFunction(){
		return stepCostFunction;
	}

	public void setStepCostFunction(IStepCostFunction stepCostFunction) {
		this.stepCostFunction = stepCostFunction;
	}

	@Override
	public String getStrategyName() {
		return "Uniform cost (Costo uniforme)";
	}

}