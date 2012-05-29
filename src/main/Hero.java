package main;
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
	public static void setxCoord() {
		Hero.xCoord = Hero.xPixelPosition/75;
	}
	public static int getyCoord() {
		return yCoord;
	}
	public static void setyCoord() {
		Hero.yCoord = Hero.yPixelPosition/75;
	}
	public static int getxPixelPosition() {
		return xPixelPosition;
	}
	public static void setxPixelPosition(int xPixelPosition) {
		Hero.xPixelPosition = xPixelPosition;
	}
	public static int getyPixelPosition() {
		return yPixelPosition;
	}
	public static void setyPixelPosition(int yPixelPosition) {
		Hero.yPixelPosition = yPixelPosition;
	}
	
		
}
