package board;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameSaver {
	public static int r=13;
	public static int c=21;
	
	public static void saveGame() throws IOException {
		int[][] level = new int[c][r];
		String line;
		Pattern p = Pattern.compile("(\\d)");
		Matcher m; 
		int x=0;
		int y=0;
		File save = new File("/save/save.txt");
		Writer writer;
		//writer = new Writer(save);
		for(y=0; y<c; y++){
			writer.write(level[x][y]);
			for(x=0; x<r; x++){
				writer.write(',');
				writer.write(level[x][y]);
				
			}
			writer.write("\n");
		}
	}
}
