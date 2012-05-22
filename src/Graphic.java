import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Graphic {
	final static int width = 75;
	final static int height = 75;
	final static int rows = 1;
	final static int cols = 2;
	static BufferedImage[] tile = new BufferedImage[rows * cols];
	
	public Graphic() throws IOException {
		BufferedImage bigImg = ImageIO.read(new File("tiletest.png"));
		// The above line throws an checked IOException which must be caught.

		

		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        tile[(i * cols) + j] = bigImg.getSubimage(
		            i * width,
		            j * height,
		            width,
		            height
		        );
		    }
		}
	}
	public static BufferedImage getTile(int a) {
		return tile[a];
	}
}