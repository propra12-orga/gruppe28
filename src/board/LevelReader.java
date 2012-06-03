package board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LevelReader {
	
	public static int[][] readLevel(File file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("1.txt"));
		int level[][] = new int[14][12];
		String line;
		Pattern p = Pattern.compile("(\\d)");
		Matcher m; 
			for(int y=1;(line = in.readLine()) != null; y++){
				m = p.matcher(line);
				for(int x=1; m.find();x++){
					level[y][x]=Integer.parseInt(m.group());
				}
			}

		return level;
	}
	
	public static void ausgabe(int[][] a) {
		System.out.println(a.toString());
	}
}
