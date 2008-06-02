package frsf.cidisi.faia.simulator;

import java.util.Vector;

public class SimulatorEventNotifier {
	private static Vector<SimulatorEventHandler> eventHandlers = new Vector<SimulatorEventHandler>();
	
	public static void simulationFinished() {
		for (SimulatorEventHandler seh : eventHandlers)
			seh.simulationFinished();
	}
	
	public static void SubscribeEventHandler(SimulatorEventHandler seh) {
		if (!eventHandlers.contains(seh))
			eventHandlers.add(seh);
	}
	
	public static void UnsubscribeEventHandler(SimulatorEventHandler seh) {
		if (eventHandlers.contains(seh))
			eventHandlers.remove(seh);
	}
	
	public static void CleanEventHandlers() {
		eventHandlers.clear();
	}
}
