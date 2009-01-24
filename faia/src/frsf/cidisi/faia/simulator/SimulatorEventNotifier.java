/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa
 * y Milton Pividori.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package frsf.cidisi.faia.simulator;

import java.util.Vector;

public class SimulatorEventNotifier {

    private static Vector<SimulatorEventHandler> eventHandlers = new Vector<SimulatorEventHandler>();

    public static void simulationFinished() {
        for (SimulatorEventHandler seh : eventHandlers) {
            seh.simulationFinished();
        }
    }

    public static void SubscribeEventHandler(SimulatorEventHandler seh) {
        if (!eventHandlers.contains(seh)) {
            eventHandlers.add(seh);
        }
    }

    public static void UnsubscribeEventHandler(SimulatorEventHandler seh) {
        if (eventHandlers.contains(seh)) {
            eventHandlers.remove(seh);
        }
    }

    public static void CleanEventHandlers() {
        eventHandlers.clear();
    }
}
