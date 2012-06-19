package board;


//mport java.awt.Rectangle;
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
	
	private final static int width = 50;
	private final static int height = 50;
	private final static int width2 = 40;
	private final static int height2 = 40;
	private final static int x = 4;
	private final static int y = 2;
	private final static int m = 10;
	private final static int n = 1;
	private final static int a = 4;
	private final static int b = 4;
	private static BufferedImage[][] tile = new BufferedImage[x][y];
	private static BufferedImage[][] bomb = new BufferedImage[m][n];
	private static BufferedImage[][] hero = new BufferedImage[a][b];

	
	/**
	 * initialisiert die ensprechenden Images. Die for-Schleife zerlegt das Tileset in einzelne Graphiken f�r die Tiles und speichert sie
	 * in einem Array, wodurch sie leicht abrufbar sind.
	 * @throws IOException
	 */
	public static void initTileset() throws IOException {

		BufferedImage tileImg = ImageIO.read(new File("res/tileset.gif"));

		
		 for (int j = 0; j < y; j++) {
			 for (int i = 0; i < x; i++)	{
		        tile[i][j] = tileImg.getSubimage(i * width, j * height, width, height);
		    }
		}
		 
	}
	public static void initBombset() throws IOException {
		BufferedImage bombImg = ImageIO.read(new File("res/bombset.gif"));
		for (int l = 0; l < n; l++) {
			 for (int k = 0; k < m; k++)	{
		        bomb[k][l] = bombImg.getSubimage(k * width, l * height, width, height);
		    }
		}
		
	}
	
	public static void initHeroset() throws IOException {
		BufferedImage heroImg = ImageIO.read(new File("res/heroset.gif"));
		for (int l = 0; l < b; l++) {
			 for (int k = 0; k < a; k++)	{
		        hero[k][l] = heroImg.getSubimage(k * width2, l * height2, width2, height2);
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
	public static BufferedImage getHero(int a, int b) {
		return hero[a][b];
	}
	/*public static Rectangle getBounds(int i) {
        return new Rectangle(Hero.heroliste.get(i).getxPixelPosition()-9, Hero.heroliste.get(i).getyPixelPosition()-9, hero.getWidth(null), hero.getHeight(null));
    }*/
}
