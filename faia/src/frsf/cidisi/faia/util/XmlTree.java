package frsf.cidisi.faia.util;

import frsf.cidisi.faia.solver.search.NTree;

public class XmlTree {
	
	private static int fileIdx = 0;
	
    public static void printFile(NTree tree) {
    	
    	PrintOut print = null;
		
		try{
	    	print = new PrintOut("searchTrees/"+fileIdx + ".xml");
			fileIdx = fileIdx + 1;
		
			print.write(tree.toXml());
			
	    	print.close();

		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
    }	
}
