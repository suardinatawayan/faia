package frsf.cidisi.faia.examples.planning.cubos;

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
