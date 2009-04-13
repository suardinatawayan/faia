package frsf.cidisi.faia.examples.planning.cubos;

import java.util.ArrayList;
import java.util.Hashtable;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbiente extends EnvironmentState {

	private Hashtable<String,String> sobre;
	private ArrayList<String> sobreMesa;
	
	public EstadoAmbiente() {
		this.initState();
	}
	
	@Override
	public void initState() {
		this.sobre = new Hashtable<String,String>();
		this.sobreMesa = new ArrayList<String>();
		
		// B sobre A:
		// B
		// A
		this.sobreMesa("a");
		this.sobre("b", "a");
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		
		for(String cuboSobreMesa : this.sobreMesa) {
			sb.append(cuboSobreMesa + " <- ");
			sb.append(getCubosSbbre(cuboSobreMesa));
			
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * Método interno para obtener, dado un cubo, todos los cubos sobre el mismo
	 * @param cubo
	 * @return
	 */
	private String getCubosSbbre(String cubo) {
		StringBuffer sb = new StringBuffer();
		
		if (this.sobre.containsKey(cubo)) {
			String cuboEncima = this.sobre.get(cubo);
			
			sb.append(cuboEncima + " <- ");
			sb.append(getCubosSbbre(cuboEncima));
		}
		else
			sb.append("");
		
		return sb.toString();
	}
	
	public void sobreMesa(String cubo) {
		this.sobreMesa.add(cubo);
	}
	
	public void quitarSobreMesa(String cubo) {
		this.sobreMesa.remove(cubo);
	}
	
	public void sobre(String cubo1, String cubo2) {
		this.sobre.put(cubo2, cubo1);
	}
	
	public void quitarSobre(String cubo1, String cubo2) {
		this.sobre.remove(cubo2);
	}

}
