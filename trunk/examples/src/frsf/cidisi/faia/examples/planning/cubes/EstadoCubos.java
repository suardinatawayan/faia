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

package frsf.cidisi.faia.examples.planning.cubes;

import java.util.Hashtable;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.agent.ActionFactory;
import frsf.cidisi.faia.agent.planning.PlanningBasedAgentState;

public class EstadoCubos extends PlanningBasedAgentState {

	public EstadoCubos() throws PrologConnectorException {
		super("cubos.pl");
		
		this.initState();
	}

	@Override
	public ActionFactory getActionFactory() {
		return CubosActionFactory.getInstance();
	}

	@Override
	public String getBestActionPredicate() {
		return "obtenerAccion";
	}

	@Override
	public String getExecuteActionPredicate() {
		return "ejecutarAccion";
	}

	@Override
	public void updateState(Perception p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initState() {
		this.addInitState("en_mesa(a)");
		this.addInitState("sobre(b,a)");
		this.addInitState("libre(b)");
		this.addInitState("sostenido(c)");
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		
		// Cubos que están sobre la mesa
		Hashtable[] resultado = this.query("en_mesa(X)");
		Hashtable[] temp;
		
		for(Hashtable res : resultado) {
			String cuboSobreMesa = res.get("X").toString();
			
			sb.append(cuboSobreMesa + " <- ");
			sb.append(sobre(cuboSobreMesa));
			
			sb.append("\n");
		}
		
		// Cubo que el brazo está sosteniendo
		//sb.append("\n");
		String cuboSostenido = "(ninguno)";
		
		resultado = this.query("sostenido(X)");
		if (resultado.length > 0)
			cuboSostenido = resultado[0].get("X").toString();
		
		sb.append("Brazo: " + cuboSostenido);
		
		return sb.toString();
	}
	
	private String sobre(String cubo) {
		StringBuffer sb = new StringBuffer();
		
		// Busco el cubo sobre 'cubo' y armo toda la cadena
		Hashtable[] resultado = this.query("sobre(X," + cubo  + ")");
		
		if (resultado.length > 0) {
			String cuboEncima = resultado[0].get("X").toString();
			sb.append(cuboEncima + " <- ");
			sb.append(sobre(cuboEncima));
		}
		else
			sb.append("");
		
		return sb.toString();
	}

}