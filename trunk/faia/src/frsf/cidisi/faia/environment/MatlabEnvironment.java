package frsf.cidisi.faia.environment;

import java.util.Hashtable;

import jmatlink.JMatLink;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;

public abstract class MatlabEnvironment extends Environment {
	
	private JMatLink engine;
	
	public MatlabEnvironment() {
		this.engine = new JMatLink();
		this.engine.engOpen("matlab -nosplash -nojvm");
		this.engine.engEvalString("cd '" + this.getMatlabProjectPath() + "'");
	}
	
	protected void finalize() throws Throwable {
		try {
			this.engine.engClose();
		}
		catch (Exception ex) {
			
		}
		finally {
			super.finalize();
		}
	}
	
	protected Hashtable<String,double[][]> startSimulation() {
		this.engine.engEvalString(
				"[" + this.join(this.getMatlabFunctionReturnVariables(), ",") + "] = " +
				this.getMatlabFunctionName() + "(" +
				this.join(this.getMatlabFunctionParameters(), ",") + ");");
		
		Hashtable<String,double[][]> returnVariables =
			new Hashtable<String,double[][]>();
			
		double[][] matrix;
		
		for (Object obj : this.getMatlabFunctionReturnVariables()) {
			matrix = this.engine.engGetArray(obj.toString());
			
			returnVariables.put(obj.toString(), matrix);
		}
		
		return returnVariables;
	}
	
	private String join(Object[] array, String separator) {
		StringBuffer sb = new StringBuffer();
		
		sb.append(array[0].toString());
		
		for(int i=1; i<array.length; i++)
			sb.append(separator + array[i].toString());
		
		return sb.toString();
	}

	protected abstract String getMatlabProjectPath();
	
	protected abstract String getMatlabFunctionName();
	
	protected abstract Object[] getMatlabFunctionParameters();
	
	protected abstract Object[] getMatlabFunctionReturnVariables();
}
