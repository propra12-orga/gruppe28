import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.image.ImageObserver;



public class Hero {
	static int Hp;
	static int xCoord;
	static int yCoord;
	static int xPixelPosition;
	static int yPixelPosition;
	public static int getHp() {
		return Hp;
	}
	public static void setHp(int hp) {
		Hp = hp;
	}
	public static int getxCoord() {
		return xCoord;
	}
	public void setxCoord() {
		Hero.xCoord = Hero.xPixelPosition;
	}
	public static int getyCoord() {
		return yCoord;
	}
	public void setyCoord() {
		Hero.yCoord = Hero.yPixelPosition;
	}
	public static int getxPixelPosition() {
		return xPixelPosition;
	}
	public void setxPixelPosition(int xPixelPosition) {
		Hero.xPixelPosition = xPixelPosition;
	}
	public static int getyPixelPosition() {
		return yPixelPosition;
	}
	public void setyPixelPosition(int yPixelPosition) {
		Hero.yPixelPosition = yPixelPosition;
	}
	static Image img = Toolkit.getDefaultToolkit().getImage("hero.png");
	Graphics hero;
	public void drawHero(Graphics hero){
		hero.drawImage(img, xPixelPosition, yPixelPosition, (ImageObserver) this);
	}
	
	Image gmi = Toolkit.getDefaultToolkit().getImage("nohero.png");
	Graphics nohero;
	public void eraseHero(Graphics nohero){
		nohero.drawImage(gmi, xPixelPosition, yPixelPosition, (ImageObserver) this);
	}
		
}
