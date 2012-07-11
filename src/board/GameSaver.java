package board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.Hero;
import main.Mainframe;

public class GameSaver {
	private static int ro=14;
	private static int co=21;
	public static int loadlevel[][] = new int[co][ro];
	
	public static void saveGame(File file) throws IOException {
		int x=0;
		int y=0;
		//File save = new File("save/save.txt");
		FileWriter writer = new FileWriter(file);
		if(Mainframe.mapeditor==false){
			for(y=0; y<(ro-1); y++){
				for(x=0; x<co; x++){
					writer.write(""+Mainframe.beard.map[x][y].getTileId());
					writer.write(',');
				}
				writer.write("\n");
			}
			writer.write(""+(Hero.heroliste.get(0).getxPixelPosition()+10000));
			writer.write(',');
			writer.write(""+(Hero.heroliste.get(0).getyPixelPosition()+20000));
			writer.write(',');
			writer.write(""+(Hero.heroliste.get(1).getxPixelPosition()+30000));
			writer.write(',');
			writer.write(""+(Hero.heroliste.get(1).getyPixelPosition()+40000));
			writer.flush();
			writer.close();
			}
		if(Mainframe.mapeditor==true){
			for(y=0; y<(ro-1); y++){
				for(x=0; x<co; x++){
					writer.write(""+Editorboard.map[x][y].getTileId());
					writer.write(',');
				}
				writer.write("\n");
			}
			Mainframe.setStartPosition(0);
			Mainframe.setStartPosition(1);
			writer.write(""+(Hero.heroliste.get(0).getxPixelPosition()+10000));
			writer.write(',');
			writer.write(""+(Hero.heroliste.get(0).getyPixelPosition()+20000));
			writer.write(',');
			if(Mainframe.twoplayer==true){
				writer.write(""+(Hero.heroliste.get(1).getxPixelPosition()+30000));
				writer.write(',');
				writer.write(""+(Hero.heroliste.get(1).getyPixelPosition()+40000));
			}
			writer.flush();
			writer.close();
			}
	}
	public static int[][] loadGame(File file) throws NumberFormatException, IOException {
		//File save = new File("save/save.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		Pattern p = Pattern.compile("(\\d+)");
		Matcher m; 
			for(int y=0;(line = in.readLine()) != null; y++){
				m = p.matcher(line);
				for(int x=0; m.find(); x++){
					if(Integer.parseInt(m.group())<=4){
						loadlevel[x][y]=Integer.parseInt(m.group());
					}else if(Integer.parseInt(m.group())>10000 && Integer.parseInt(m.group())<=20000){
						Hero.heroliste.get(0).setxPixelPosition(Integer.parseInt(m.group()));
						Hero.heroliste.get(0).setxPixelPosition(Hero.heroliste.get(0).getxPixelPosition()-10000);
					}else if(Integer.parseInt(m.group())>20000 && Integer.parseInt(m.group())<=30000){
						Hero.heroliste.get(0).setyPixelPosition((Integer.parseInt(m.group())));
						Hero.heroliste.get(0).setyPixelPosition(Hero.heroliste.get(0).getyPixelPosition()-20000);						
					}else if(Integer.parseInt(m.group())>30000 && Integer.parseInt(m.group())<=40000 && Mainframe.twoplayer==true){
						Hero.heroliste.get(1).setxPixelPosition((Integer.parseInt(m.group())));
						Hero.heroliste.get(1).setxPixelPosition(Hero.heroliste.get(1).getxPixelPosition()-30000);
					}else if(Integer.parseInt(m.group())>40000 && Mainframe.twoplayer==true){
						Hero.heroliste.get(1).setyPixelPosition((Integer.parseInt(m.group())));
						Hero.heroliste.get(1).setyPixelPosition(Hero.heroliste.get(1).getyPixelPosition()-40000);
					}
				}	
			}
			//line = in.readLine();
			//m = p.matcher(line);
			return loadlevel;
	}
}
