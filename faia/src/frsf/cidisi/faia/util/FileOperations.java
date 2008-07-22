package frsf.cidisi.faia.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {

    public static void CopyFile(String source, String dest) throws IOException {
        File inputFile = new File(source);
        File outputFile = new File(dest);

        FileReader in = new FileReader(inputFile);
        FileWriter out = new FileWriter(outputFile);
        int c;

        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();
    }
}
