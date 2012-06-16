package board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Die Klasse liest mittels regul�ren Ausdrucks ein Textdokument ein, extrahiert die durch Kommate getrennten Zahlen
 * und speichert die Zahlen als int-Array. Aus diesem Array wird dann in Board das Spielfeld erzeugt.
 * @author Dustin
 */
public class LevelReader {
	/**
	 * Liest Zeile f�r Zeile das Dokument ein und fischt die Zahlen heraus, bis keine mehr gefunden werden. Dabei wird jeweils iteriert und 
	 * die gefundene Zahl im level-Array abgespeichert.
	 * @param file
	 * @return
	 * @throws IOException
	 */
	
	
	
	public static int[][] readLevel(File file) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		int level[][] = new int[13][13];
		String line;
		Pattern p = Pattern.compile("(\\d)");
		Matcher m; 
			for(int y=0;(line = in.readLine()) != null; y++){
				m = p.matcher(line);
				for(int x=0; m.find(); x++){
					level[x][y]=Integer.parseInt(m.group());
					
				}
			}

		return level;
	}
	
	/**
	 * Testfunktion zur Ausgabe des Arrays.
	 * @param a
	 */
	public static void ausgabe(int[][] a) {
		for (int j=0; j<13; j++) {
			for (int i=0; i<13; i++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		System.out.println("Number of destructables: " + Board.getDestructableCounter());
	}
}
