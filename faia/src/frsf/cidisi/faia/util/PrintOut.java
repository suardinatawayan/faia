package frsf.cidisi.faia.util;

import java.io.*;

class PrintOut {
	
	private File outputFile;
	private FileWriter out;

	PrintOut(String name) throws Exception {
		this(name, true);
	}
	
	PrintOut(String name, boolean append) throws Exception {
			
		outputFile = new File(name);

		try{

	        out = new FileWriter(outputFile,append);
	        
		} catch (IOException ex){
			throw new Exception (ex.getMessage());
			
		}
		
	}
	
	public void write(String texto) throws Exception {
		try{
			
			out.write(texto);
			
		} catch (IOException ex){
			throw new Exception (ex.getMessage());
		}
	}

	public void close() throws Exception {
		try{
			
			out.close();
			
		} catch (IOException ex){
			throw new Exception (ex.getMessage());
		}
	}
	
}
