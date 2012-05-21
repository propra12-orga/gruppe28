import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Tileset {
	final static int width = 75;
	final static int height = 75;
	final static int rows = 1;
	final static int cols = 2;
	static BufferedImage[][] tile = new BufferedImage[rows][cols];
	
	public Tileset() throws IOException {
		BufferedImage bigImg = ImageIO.read(new File("tiletest.png"));

		

		for (int i = 0; i < rows; i++)	{
		    for (int j = 0; j < cols; j++) {
		        tile[(i * rows)][j * cols] = bigImg.getSubimage(i * width, j * height, width, height);
		    }
		}
	}
	public static BufferedImage getTile(int a, int b) {
		return tile[a][b];
	}
}
