package board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class LevelReader {
	
	public static int[][] readLevel(File file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("1.txt"));
		int level[][] = new int[14][12];
		String[] input = null;
		
				Pattern p = Pattern.compile(",+");
				for (int j=0; j<12; j++) {
					for (int i=0;i<14; i++) {
						input[j]=in.readLine();
						String[] result=p.split(input[j]);
						level[i][j]= Integer.parseInt(result[j]);
								 
					}
				}
		return level;
	}
}
