package agent;

import frsf.cidisi.faia.agent.Action;

public class WumpusActionFactory extends frsf.cidisi.faia.solver.ActionFactory {

    private static WumpusActionFactory instance;

    private WumpusActionFactory() {
    }

    public static WumpusActionFactory getInstance() {
        if (instance == null) {
            instance = new WumpusActionFactory();
        }
        return instance;
    }

	@Override
	protected String endActionString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Action stringToAction(String stringAction) {
		// TODO Auto-generated method stub
		return null;
	}

}
