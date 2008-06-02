package frsf.cidisi.faia.util;

import java.io.File;

import frsf.cidisi.faia.solver.search.NTree;

public class XmlTree {
	
	private static int fileIdx = 0;
	private static final String searchTreesDir = "searchTrees/";
	
    public static void printFile(NTree tree) {
    	
    	PrintOut print = null;
		
		try{
			// Si la carpeta que necesito no existe, la creo.
			File f = new File(searchTreesDir);
			if (!f.exists())
				f.mkdir();
			
	    	print = new PrintOut(searchTreesDir + fileIdx + ".xml");
			fileIdx = fileIdx + 1;
		
			print.write(tree.toXml());
			
	    	print.close();

		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
    }	
}
