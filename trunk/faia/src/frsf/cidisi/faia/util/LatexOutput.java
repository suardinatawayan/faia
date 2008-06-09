package frsf.cidisi.faia.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Vector;

import frsf.cidisi.faia.simulator.SimulatorEventHandler;
import frsf.cidisi.faia.solver.search.NTree;

public class LatexOutput implements SimulatorEventHandler {
	private static final String lineSeparator = System.getProperty("line.separator");
	private final String faiaPdflatexDir = "../faia/pdflatex/";
	private final String pdflatexDir = "pdflatex/";
	
	private int fileIdx = 0;
	private static LatexOutput instance;
	
	LatexOutput() {
	}
	
	public static LatexOutput getInstance() {
		if (instance == null)
			instance = new LatexOutput();
		
		return instance;
	}
	
	public void compileLatexFiles(boolean removeTexFiles) {
		// Copio los archivos necesarios para poder compilar con pdflatex
		// FIXME: Estoy suponiendo acÃ¡ que FAIA se encuentra en la carpeta "..faia"
		try {
			FileOperations.CopyFile("../faia/pdflatex/a0poster.cls", pdflatexDir + "a0poster.cls");
			FileOperations.CopyFile("../faia/pdflatex/a0size.sty", pdflatexDir + "a0size.sty");
			FileOperations.CopyFile("../faia/pdflatex/nodo.sty", pdflatexDir + "nodo.sty");
			FileOperations.CopyFile("../faia/pdflatex/qtree.sty", pdflatexDir + "qtree.sty");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Process p;
		String[] comando;
		
		// Creo el objeto que representa la carpeta pdfLatex
		File carpetaPdflatex = new File(pdflatexDir);
		
		System.out.println("Compilando archivos Latex...");
		
		// Por cada archivo .tex compilo a PDF
		for (File archivoTex : carpetaPdflatex.listFiles(new TexFilter())) {
			
			System.out.print("  " + archivoTex.getName());
			comando = new String[] {"pdflatex", "-quiet", "-halt-on-error", archivoTex.getName()};
			
			try {
				// Ejecuto el comando para la compilaciÃ³n
				p = Runtime.getRuntime().exec(comando, null, carpetaPdflatex);
				
				// Espero que termine de compilar y muestro el estado de la ejecuciÃ³n (si
				// fue exitoso o no)
				p.waitFor();
				if (p.exitValue() == 0)
					System.out.print(" -> Ok");
				else
					System.out.print(" -> Error");
					
					
			} catch (IOException e) {
				System.out.print(" -> Error: Posiblemente no exista el comando 'pdflatex': " + e.getMessage());
				return;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Compilación finalizada.");
		
		// Ahora elimino los archivos temporales que creÃ³ pdflatex
		for (File archivoTemporal : carpetaPdflatex.listFiles(new TempFilesFilter()))
			archivoTemporal.delete();
		
		// Si se ha indicado borrar tmabiÃ©n los archivos tex, los borro
		for (File archivoTex : carpetaPdflatex.listFiles(new TexFilter()))
			archivoTex.delete();
		
		System.out.println("Archivos temporales eliminados.");
	}
	
	public void printFile(NTree tree) {
		printFile(tree, "ESTRATEGIA NO SETEADA");
	}
	
	public void printFile(NTree tree, String strategyName) {
		StringBuffer str = new StringBuffer();
		
	    // Clase del documento y opciones generales
	    str.append("\\documentclass[a0,landscale]{a0poster}" + lineSeparator);
	   
	    // Paquetes utilizados
	    str.append("\\usepackage{mathptmx}" + lineSeparator);
	    str.append("\\usepackage{qtree}" + lineSeparator);
	    str.append("\\usepackage{nodo}" + lineSeparator);
	    str.append("\\usepackage[spanish]{babel}" + lineSeparator);
	    //str.append("\\usepackage[utf8]{inputenc}" + lineSeparator);
	   
	    str.append("\\title{Ejecución NÂº " + fileIdx + " Árbol de ejecución - Estrategia: " +
	        strategyName + "}" + lineSeparator);
	    str.append("\\author{}" + lineSeparator);
	    str.append("\\begin{document}" + lineSeparator);
	    str.append("\\maketitle" + lineSeparator);
	    
	    //StringBuffer sf = new StringBuffer();
		int cuentaArboles = 0;
		//int nivelesProcesados = 0;
		
		Vector<NTree> nodosAProcesar = new Vector<NTree>();
		nodosAProcesar.add(tree);
		nodosAProcesar.addAll(tree.getSonsTotal());
		
		for (int i=0;i<nodosAProcesar.size();i++) {
			NTree nodo = nodosAProcesar.elementAt(i);
			
			if (nodo.getSons().isEmpty())
				continue;
			
			if (cuentaArboles == 0)
				str.append("\\begin{figure}[!h]" + lineSeparator);
			
			str.append("\\Tree " + nodo.toQtree() + lineSeparator);
			//str.append(tree.getSonsTotal().elementAt(i).toQtree() + "\n");
			cuentaArboles++;

			if (cuentaArboles == 4) {
				cuentaArboles = 0;
				str.append("\\end{figure}" + lineSeparator);
			}
			
			//nivelesProcesados++;
			
//			if (nivelesProcesados >= niveles)
//				break;
		}
		
		if (cuentaArboles > 0)
			str.append("\\end{figure}" + lineSeparator);
		
		str.append(lineSeparator);
		//Busqueda.logLatex.debug(sf.toString());		
		str.append("\\end{document}" + lineSeparator);
		
		// Ahora creo el archivo
		try {
			// Si la carpeta que necesito no existe, la creo.
			File f = new File(pdflatexDir);
			if (!f.exists())
				f.mkdir();
			
			PrintOut print = new PrintOut(pdflatexDir + fileIdx + ".tex", false);
			print.write(str.toString());
			print.close();
			
			fileIdx++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void simulationFinished() {
		this.compileLatexFiles(true);
	}
}

class TexFilter implements FilenameFilter {

	@Override
	public boolean accept(File arg0, String arg1) {
		return (arg1.endsWith(".tex"));
	}
	
}

class TempFilesFilter implements FilenameFilter {

	@Override
	public boolean accept(File arg0, String arg1) {
		return (arg1.endsWith(".aux") || arg1.endsWith(".log"));
	}
	
}
