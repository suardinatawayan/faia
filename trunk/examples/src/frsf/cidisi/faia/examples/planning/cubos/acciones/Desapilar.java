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

package frsf.cidisi.faia.examples.planning.cubos.acciones;

import frsf.cidisi.faia.agent.planning.PlanningAction;
import frsf.cidisi.faia.examples.planning.cubos.EstadoAmbiente;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Desapilar extends PlanningAction {
	
	private String cubo1;
	private String cubo2;
	
	public Desapilar(String[] parametros) {
		this.cubo1 = parametros[0];
		this.cubo2 = parametros[1];
	}
	
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoAmbiente estadoAmbiente = (EstadoAmbiente)est;
		
		estadoAmbiente.quitarSobre(this.cubo1, this.cubo2);
		
		return estadoAmbiente;
	}

	@Override
	public String toString() {
		return "desapilar(" + this.cubo1 + "," + this.cubo2 + ")";
	}

}
