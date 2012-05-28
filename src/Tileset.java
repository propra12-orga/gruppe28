
import java.awt.image.BufferedImage;



import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;



public class Tileset {
	final static int width = 75;
	final static int height = 75;
	final static int rows = 1;
	final static int cols = 2;
	static BufferedImage[][] tile = new BufferedImage[cols][rows];
	
	public static void initTileset() throws IOException {
		URL url = Tileset.class.getResource("tiletest.png");
		BufferedImage bigImg = ImageIO.read(url);

		

		
		 for (int j = 0; j < rows; j++) {
			 for (int i = 0; i < cols; i++)	{
		        tile[i][(j] = bigImg.getSubimage(i * width, j * height, width, height);
		    }
		}
	}
	public static BufferedImage getTile(int a, int b) {
		return tile[a][b];
	}
}
