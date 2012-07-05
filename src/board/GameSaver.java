package board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.Hero;

public class GameSaver {
	public static int r=13;
	public static int c=21;
	
	public static void saveGame() throws IOException {
		int x=0;
		int y=0;
		File save = new File("save/save.txt");
		FileWriter writer = new FileWriter(save);
		for(y=0; y<r; y++){
			for(x=0; x<c; x++){
				writer.write(Board.map[x][y].getTileId());
				writer.write(',');
			}
			writer.write("\n");
		}
		writer.write(Hero.heroliste.get(0).getxPixelPosition());
		writer.write(',');
		writer.write(Hero.heroliste.get(0).getyPixelPosition());
		writer.write(',');
		writer.write(Hero.heroliste.get(1).getxPixelPosition());
		writer.write(',');
		writer.write(Hero.heroliste.get(1).getyPixelPosition());
		writer.close();
	}
	public static void loadGame() throws NumberFormatException, IOException {
		File save = new File("save/save.txt");
		BufferedReader in = new BufferedReader(new FileReader(save));
		String line;
		Pattern p = Pattern.compile("(\\d)");
		Matcher m; 
			for(int y=0;(line = in.readLine()) != null; y++){
				m = p.matcher(line);
				for(int x=0; m.find(); x++){
					Board.map[x][y].setTileId(Integer.parseInt(m.group()));
					
				}
			}
			line = in.readLine();
			m = p.matcher(line);
			for(int i=0; i<4; i++) {
				Hero.heroliste.get(0).setxPixelPosition(Integer.parseInt(m.group()));
				Hero.heroliste.get(0).setyPixelPosition(Integer.parseInt(m.group()));
				Hero.heroliste.get(1).setxPixelPosition(Integer.parseInt(m.group()));
				Hero.heroliste.get(1).setyPixelPosition(Integer.parseInt(m.group()));
			}
	}
}
