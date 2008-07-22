package frsf.cidisi.faia.solver.search;

import java.util.Vector;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:03
 */
public class BreathFirstSearch extends Strategy {

    public BreathFirstSearch() {
    }

    public void addNodesToExpand(Vector<NTree> nodes) {
        //Add the nodes at the bottom of the list of nodes to expand
        for (NTree nt : nodes) {
            nt.setCost(nt.getParent().getCost() + 1);
        }
        nodesToExpand.addAll(nodes);
    }

    public void addNodeToExpand(NTree node) {
        //Add the node at the top of the list of nodes to expand
        node.setCost(node.getParent().getCost() + 1);
        nodesToExpand.add(node);
    }

    @Override
    public String getStrategyName() {
        return "Breath First (Primero en amplitud)";
    }
}