package frsf.cidisi.faia.util;

import java.util.Vector;

import frsf.cidisi.faia.solver.search.NTree;
import frsf.cidisi.faia.solver.search.Strategy;

public class LatexOutput {
	private static int fileIdx = 0;
	
	public static void printFile(NTree tree) {
		printFile(tree, "ESTRATEGIA NO SETEADA");
	}
	
	public static void printFile(NTree tree, String strategyName) {
		StringBuffer str = new StringBuffer();
		
	    // Clase del documento y opciones generales
	    str.append("\\documentclass[a0,landscale]{a0poster}\n");
	   
	    // Paquetes utilizados
	    str.append("\\usepackage{mathptmx}\n");
	    str.append("\\usepackage{colortbl}\n");
	    str.append("\\usepackage[scaled=.90]{helvet}\n");
	    str.append("\\usepackage{courier}\n");
	    str.append("\\usepackage{qtree}\n");
	    str.append("\\usepackage{nodo}\n");
	    str.append("\\usepackage[spanish]{babel}\n");
	    str.append("\\usepackage[utf8]{inputenc}\n");
	   
	    str.append("\\title{Ejecución Nº " + fileIdx + " Árbol de ejecución - Estrategia: " +
	        strategyName + "}\n");
	    str.append("\\author{}\n");
	    str.append("\\begin{document}\n");
	    str.append("\\maketitle\n");
	    
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
				str.append("\\begin{figure}[!h]\n");
			
			str.append("\\Tree " + nodo.toQtree() + "\n");
			//str.append(tree.getSonsTotal().elementAt(i).toQtree() + "\n");
			cuentaArboles++;

			if (cuentaArboles == 4) {
				cuentaArboles = 0;
				str.append("\\end{figure}\n");
			}
			
			//nivelesProcesados++;
			
//			if (nivelesProcesados >= niveles)
//				break;
		}
		
		if (cuentaArboles > 0)
			str.append("\\end{figure}");
		
		str.append("\n");
		//Busqueda.logLatex.debug(sf.toString());		
		str.append("\\end{document}");
		
		// Ahora creo el archivo
		try {
			PrintOut print = new PrintOut("src/pdflatex/" + fileIdx + ".tex", false);
			print.write(str.toString());
			print.close();
			
			fileIdx++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
