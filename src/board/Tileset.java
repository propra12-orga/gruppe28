package board;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Tileset {
	final static int width = 75;
	final static int height = 75;
	final static int x = 2;
	final static int y = 1;
	static BufferedImage[][] tile = new BufferedImage[x][y];
	
	public static void initTileset() throws IOException {
		
		//BufferedImage bigImg = ImageIO.read(url);
		//tile[0][0] = ImageIO.read(Tileset.class.getResource("gras.png"));
		//tile[0][1] = ImageIO.read(Tileset.class.getResource("wall.png"));
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
}
