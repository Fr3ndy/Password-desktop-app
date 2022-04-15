package Gui;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class inizializzazione {

	///cerca il file
	public static void cercafile() {
		Path k=Paths.get("file.txt");
		
		//se il file è presente
			if(Files.exists(k)){
				System.out.println("presente");
				
			}
			//se il file non è presente lo crea
			else {
				System.out.println("non presente creo il file");
				try {
					FileOutputStream fout = new FileOutputStream("file.txt");
					PrintStream pout = new PrintStream(fout);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
	}
  
}