package board;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Tileset {
	private final static int width = 75;
	private final static int height = 75;
	private final static int x = 2;
	private final static int y = 1;
	private static BufferedImage[][] tile = new BufferedImage[x][y];
	private static BufferedImage bomb;
	private static BufferedImage exit;

	
	public static void initTileset() throws IOException {
		bomb = ImageIO.read(Tileset.class.getResource("Bombe.png"));
		exit = ImageIO.read(Tileset.class.getResource("exit.png"));
		BufferedImage bigImg = ImageIO.read(Tileset.class.getResource("tiletest.png"));

		
		 for (int j = 0; j < y; j++) {
			 for (int i = 0; i < x; i++)	{
		        tile[i][j] = bigImg.getSubimage(i * width, j * height, width, height);
		    }
		}
	}
	public static BufferedImage getTile(int a, int b) {
		return tile[a][b];
	}
	public static Image getBomb() {
		return bomb;
	}
	public static BufferedImage getExit() {
		return exit;
	}
}
