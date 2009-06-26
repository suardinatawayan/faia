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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.examples.planning.cubes.actions.Apilar;
import frsf.cidisi.faia.examples.planning.cubes.actions.Depositar;
import frsf.cidisi.faia.examples.planning.cubes.actions.Desapilar;
import frsf.cidisi.faia.examples.planning.cubes.actions.Tomar;
import frsf.cidisi.faia.agent.ActionFactory;

public class CubosActionFactory extends ActionFactory {
	
	private static CubosActionFactory instancia;
	private Pattern accionRegExp;
	
	private CubosActionFactory() {
		this.accionRegExp = Pattern.compile("[A-Za-z]+\\(([A-Za-z, ]+)\\)");
	}
	
	public static CubosActionFactory getInstance() {
        if (instancia == null) {
            instancia = new CubosActionFactory();
        }
        
        return instancia;
    }
	
	@Override
	protected String endActionString() {
		return "end";
	}

	@Override
	protected Action stringToAction(String stringAccion) {
		String[] parametros = this.getParametros(stringAccion);
		
		if (stringAccion.startsWith("apilar")) {
            return new Apilar(parametros);
    	} else if (stringAccion.startsWith("desapilar")) {
    		return new Desapilar(parametros);
        } else if (stringAccion.startsWith("depositar")) {
            return new Depositar(parametros);
        } else if (stringAccion.startsWith("tomar")) {
            return new Tomar(parametros);
        }
        return null;
	}
	
	private String[] getParametros(String stringAccion) {
		Matcher m = this.accionRegExp.matcher(stringAccion);
		m.find();
		String parm = m.group(1);
		
		String[] parametros = parm.split(",");
		
		for (int i=0; i<parametros.length; i++)
			parametros[i] = parametros[i].trim();
		
		return parametros;
	}

}
