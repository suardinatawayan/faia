package frsf.cidisi.faia.examples.planning.cubos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.examples.planning.cubos.acciones.Apilar;
import frsf.cidisi.faia.examples.planning.cubos.acciones.Depositar;
import frsf.cidisi.faia.examples.planning.cubos.acciones.Desapilar;
import frsf.cidisi.faia.examples.planning.cubos.acciones.Tomar;
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
