package board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LevelReader {
	
	public static int[][] readLevel(File file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		int level[][] = new int[14][12];
		String line;
		Pattern p = Pattern.compile("(\\d)");
		Matcher m; 
			for(int y=0;(line = in.readLine()) != null; y++){
				m = p.matcher(line);
				for(int x=0; m.find();x++){
					level[x][y]=Integer.parseInt(m.group());
				}
			}

		return level;
	}
	
	public static void ausgabe(int[][] a) {
		for (int j=0; j<12; j++) {
			for (int i=0; i<14; i++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
