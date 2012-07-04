package board;


//mport java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Menu.Charactereinstellungen;



/**
 * Die Klasse Tileset verwaltet alle Graphiken. Dabei gibt es Einzelgraphiken, wie den Hero oder die Bombe und Graphiktemplates, aus 
 * welchen die einzelnen Tilegraphiken herausgeschnitten werden.
 * 
 * @author Dustin
 */
public class Tileset {
	
	private final static int width = 50;
	private final static int height = 50;
	private final static int width2 = 40;
	private final static int height2 = 40;
	private final static int x = 4;
	private final static int y = 5;
	private final static int m = 11;
	private final static int n = 1;
	private final static int p = 4;
	private final static int q = 1;
	private final static int a = 4;
	private final static int b = 5;
	private static BufferedImage[][] tile = new BufferedImage[x][y];
	private static BufferedImage[][] bomb = new BufferedImage[m][n];
	public static BufferedImage[][] hero = new BufferedImage[a][b];
	private static BufferedImage[][] upgrade = new BufferedImage[p][q];
	public static BufferedImage[] heroes = new BufferedImage[4];

	
	/**
	 * initialisiert die ensprechenden Images. Die for-Schleife zerlegt das Tileset in einzelne Graphiken f�r die Tiles und speichert sie
	 * in einem Array, wodurch sie leicht abrufbar sind.
	 * @throws IOException
	 */
	public static void initTileset() throws IOException {

		BufferedImage tileImg = ImageIO.read(new File("res/Images/tileset.gif"));

		
		 for (int j = 0; j < y; j++) {
			 for (int i = 0; i < x; i++)	{
		        tile[i][j] = tileImg.getSubimage(i * width, j * height, width, height);
		    }
		}
		 
	}
	public static void initBombset() throws IOException {
		BufferedImage bombImg = ImageIO.read(new File("res/Images/bombset.gif"));
		for (int l = 0; l < n; l++) {
			 for (int k = 0; k < m; k++)	{
		        bomb[k][l] = bombImg.getSubimage(k * width, l * height, width, height);
		    }
		}
		
	}
	
	public static void initHeroset() throws IOException {
		BufferedImage heroImg = ImageIO.read(new File("res/Images/heroset.gif"));
		for (int l = 0; l < b; l++) {
			 for (int k = 0; k < a; k++)	{
		        hero[k][l] = heroImg.getSubimage(k * width2, l * height2, width2, height2);
		    }
		}
		
	}
	
	public static void initUpgradeset() throws IOException {
		BufferedImage upgradeImg = ImageIO.read(new File("res/Images/upgradeset.gif"));
		for (int l = 0; l < q; l++) {
			 for (int k = 0; k < p; k++)	{
		        upgrade[k][l] = upgradeImg.getSubimage(k * width2, l * height2, width2, height2);
		    }
		}
		
	}
	
	/**
	 * Diese Funktionen geben die entsprechenden Bilder zur�ck.
	 * @param a
	 * @param b
	 * @return
	 */
	public static BufferedImage getTile(int a, int b) {
		return tile[a][b];
	}
	public static BufferedImage getBomb(int a) {
		return bomb[a][0];
	}
	public static BufferedImage getUpgrade(int a) {
		return upgrade[a][0];
	}
	public static BufferedImage setHero(int a, int b, int i) {
		heroes[i]=hero[a][b];
		return heroes[i];
	}
	public static BufferedImage getHero(int i){
		return Charactereinstellungen.heroes[i];
	}
	public static BufferedImage getHero2(){
		return heroes[1];
	}
	
	/* [0,0] Bomberman 1, [1,0] Bomberman 2, [2,0] Bomberman 3, [3,0] Bomberman 4 
	 * [0,1] Darth Vader, [1,1] Yoda, [2,1] Boba Fett, [3,1] Stormtrooper
	 * [0,2] James T. Kirk, [1,2] Spock, [2,2] Klingon, [3,2] Gorn
	 * [0,3] Lucha Libre 1, [1,3] Lucha Libre 2, [2,3] Lucha Libre 3, [3,3] Lucha Libre 4
	 */
}
