package board;

import java.awt.image.BufferedImage;
/**
 * Die Graphik jedes Tiles wird nach seiner TileId bestimmt. Die entsprechende Graphik wird aus der Klasse Tileset genommen.
 * 
 * @author Dustin
 */
public class Tile {
	
	
		private BufferedImage img;
		private int TileId; 
		public static int tileset;
		/* 0=normal
		 * 1=ice
		 * 2=space
		 * 3=lava
		 * 4=sand
		 */
		/**
		 * der Construcor setzt je nach TileId sofort das entsprechende Img.
		 * @param a
		 */
		public Tile (int a) {
			this.TileId=a;
			switch (this.TileId) {
			case 1 : this.img=Tileset.getTile(0, tileset);
						break;
			case 2 : this.img=Tileset.getTile(1, tileset);
						break;
			case 3 : this.img=Tileset.getTile(2, tileset);
						break;
			case 4 : this.img=Tileset.getTile(3, tileset);
						break;
			default: break;
			}
		}
		public int getTileId() {
			return this.TileId;
		}
		public void setTileId(int a) {
			this.TileId=a;
		}
		public static int getTileset() {
			return Tile.tileset;
		}
		public static void setTileset(int tileset) {
			Tile.tileset=tileset;
		}
		public BufferedImage getImg() {
			return this.img;
		}
		public void setImg(BufferedImage a) {
			this.img=a;
		}
		
		/**
		 * Macht ein Tile zum Exit. Die Funktion findet Anwendung in der zufälligen Bestimmung des Exits.
		 */
		public void setExit() {
			this.setTileId(3);
			this.setImg(Tileset.getTile(2, 0));
			}
		
}
