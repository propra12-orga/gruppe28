package board;

import java.awt.image.BufferedImage;

public class Tile {
	
	
		private BufferedImage img;
		private int TileId; 
		
		public Tile (int a) {
			this.TileId=a;
			switch (this.TileId) {
			case 1 : this.img=Tileset.getTile(0, 0);
						break;
			case 2 : this.img=Tileset.getTile(1, 0);
						break;
			case 3 : this.img=Tileset.getExit();
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
		public BufferedImage getImg() {
			return this.img;
		}
		public void setImg(BufferedImage a) {
			this.img=a;
		}
		public void setExit() {
			this.setTileId(3);
			}
		
}
