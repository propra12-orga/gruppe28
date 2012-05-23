import java.awt.Color;
//import java.awt.Image;
//import java.awt.Toolkit;
import java.awt.Graphics;
//import java.awt.image.ImageObserver;



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
	public static void setxPixelPosition(int xPixelPosition) {
		xPixelPosition=xPixelPosition+45;
		Hero.xPixelPosition = xPixelPosition;
	}
	public static int getyPixelPosition() {
		return yPixelPosition;
	}
	public static void setyPixelPosition(int yPixelPosition) {
		yPixelPosition=yPixelPosition+45;
		Hero.yPixelPosition = yPixelPosition;
	}
	//Image img = Toolkit.getDefaultToolkit().getImage("hero.png");
	//Graphics hero;
	public static void drawHero(Graphics hero){
		//hero.drawImage(img, xPixelPosition, yPixelPosition, (ImageObserver) this);
		hero.setColor(new Color(250, 0, 0));
        hero.fillOval(xPixelPosition, yPixelPosition, 70, 70);
	}
	
	//Image gmi = Toolkit.getDefaultToolkit().getImage("nohero.png");
	//Graphics nohero;
	public static void eraseHero(Graphics nohero){
		//nohero.drawImage(gmi, xPixelPosition, yPixelPosition, (ImageObserver) this);
		nohero.setColor(new Color(0, 0, 0));
        nohero.fillOval(xPixelPosition, yPixelPosition, 70, 70);
	}
		
}
