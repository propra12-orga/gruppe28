package board;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * Die Klasse Tileset verwaltet alle Graphiken. Dabei gibt es Einzelgraphiken, wie den Hero oder die Bombe und Graphiktemplates, aus 
 * welchen die einzelnen Tilegraphiken herausgeschnitten werden.
 * 
 * @author Dustin
 */
public class Tileset {
	
	private final static int width = 75;
	private final static int height = 75;
	private final static int x = 4;
	private final static int y = 1;
	private static BufferedImage[][] tile = new BufferedImage[x][y];
	private static BufferedImage bomb;
	private static BufferedImage exit;
	private static BufferedImage hero;
	private static BufferedImage hero2;

	
	/**
	 * initialisiret die ensprechenden Images. Die for-Schleife zerlegt das Tileset in einzelne Graphiken für die Tiles und speichert sie
	 * in einem Array, wodurch sie leicht abrufbar sind.
	 * @throws IOException
	 */
	public static void initTileset() throws IOException {
		//bomb = ImageIO.read(Tileset.class.getResource("Bombe.gif"));
		bomb = ImageIO.read(new File("res/Bombe.gif"));
		hero = ImageIO.read(new File("res/hero.gif"));
		hero2 = ImageIO.read(new File("res/hero2.gif"));
		BufferedImage bigImg = ImageIO.read(new File("res/tileset.gif"));

		
		 for (int j = 0; j < y; j++) {
			 for (int i = 0; i < x; i++)	{
		        tile[i][j] = bigImg.getSubimage(i * width, j * height, width, height);
		    }
		}
	}
	
	/**
	 * Diese Funktionen geben die entsprechenden Bilder zurück.
	 * @param a
	 * @param b
	 * @return
	 */
	public static BufferedImage getTile(int a, int b) {
		return tile[a][b];
	}
	public static Image getBomb() {
		return bomb;
	}
	
	public static Image getHero() {
		return hero;
	}
	public static Image getHero2() {
		return hero2;
	}
}
