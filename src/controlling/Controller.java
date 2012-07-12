package controlling;

//import java.util.LinkedList;

//import java.awt.Rectangle;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import board.JukeBox;

import main.Bombe;
import main.EditorHero;
import main.EndGame;
import main.Hero;
import main.Mainframe;
import main.SortArray;
import main.Upgrades;

/**
 * Die Controller-Klasse enthält den Bewegungslogarithmus der Spielfigur.
 * Den Bewegungs-methoden wird ein int Wert übergeben um zu bestimmen, welche Spielfigur bewegt werden soll.
 * 
 * @author Sebastian
 *
 */

public class Controller extends JFrame {	
	
	private static final long serialVersionUID = 1L;
	
	public static void movement(int i, int j, int nextx1, int nexty1, int nextx2, int nexty2, String axes){
		if (Mainframe.beard.map[nextx1][nexty1].getTileId()%2 != 0 && Mainframe.beard.map[nextx2][nexty2].getTileId()%2 != 0) {
			if(axes=="x"){
				Hero.heroliste.get(i).setxPixelPosition(Hero.heroliste.get(i).getxPixelPosition()+(Hero.heroliste.get(i).getSpeed()*j));
				Hero.heroliste.get(i).setxCoord();
			}
			if(axes=="y"){
				Hero.heroliste.get(i).setyPixelPosition(Hero.heroliste.get(i).getyPixelPosition()+(Hero.heroliste.get(i).getSpeed()*j));
				Hero.heroliste.get(i).setyCoord();
			}
		}
		if(Mainframe.beard.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			Hero.heroliste.get(i).exitreached=true;
			for(int n=0; n<Hero.heroliste.size(); n++) {
				if(Mainframe.sound==true){
				try {
					JukeBox.playSoundeffect("gatewalk");
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				}
				Mainframe.setStartPosition(n);
				Hero.heroliste.get(n).setscorecount();	
			}
			Bombe.bombenliste.clear();
			Upgrades.upgradeliste.clear();
			new SortArray();
			InputController.keys.clear();
			EndGame end = new EndGame();
 		   end.setVisible(true);
		}
	}
	
	public static void movementEditor(int i, int j, int coord, int wall, String axes) {
		if(coord != wall)
		{
			if(axes=="x"){
				EditorHero.heroliste.get(i).setxPixelPosition(EditorHero.heroliste.get(i).getxPixelPosition()+(50*j));
				EditorHero.heroliste.get(i).setxCoord();
			}
			if(axes=="y"){
				EditorHero.heroliste.get(i).setyPixelPosition(EditorHero.heroliste.get(i).getyPixelPosition()+(50*j));
				EditorHero.heroliste.get(i).setyCoord();
			}		
		}
	}
}
