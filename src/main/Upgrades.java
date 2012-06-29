package main;

import java.util.Vector;

public class Upgrades {
	public static Vector<Upgrades> upgradeliste = new Vector<Upgrades>();
	boolean rüstung = false;
	boolean reichweite = false;
	boolean munition = false;
	private int upgradex = 0;
	private int upgradey = 0;
	boolean gedropt = true;
	boolean geschwindigkeit =false;
	
	public int getupgradex()
	{
		return upgradex;
	}
	public int getupgradey()
	{
		return upgradey;
	}
		public void setupgradex(int upgradex)
	{
		this.upgradex=upgradex;				
	}
	public void setupgradey(int upgradey)
	{
		this.upgradey=upgradey;				
	}	
	public boolean getrüstung() {
		return rüstung;
	}
	public boolean getreichweite() {
		return reichweite;
	}
	public boolean getmunition() {
		return munition;
	}
	public void setrüstung(boolean rüstung) {
		this.rüstung = rüstung;
	}
	public void setreichweite(boolean reichweite) {
		this.reichweite = reichweite;
	}
	public void setmunition(boolean munition) {
		this.munition = munition;
	}
	public void run()
	{
		double w=Math.random();
		 if(w<0.25)
		 {
			 rüstung=true;							 
		 }
		 if(w>0.25 &&w<0.5)
		 {
			 munition=true;							 
		 }
		 if(w>0.5 && w<0.75)
		 {
			 reichweite=true;				 
		 }		 
		 if(w> 0.75)
		 {
			 geschwindigkeit=true;
		 }
		System.out.println("Upgrade wurde gelegt "+upgradex+ " , "+ upgradey +" "+munition+" "+rüstung+" "+reichweite+" "+geschwindigkeit);
		while(gedropt==true)
		{
			for (int i=0; i<Hero.heroliste.size(); i++)
			{ 
				if (Hero.heroliste.get(i).getxCoord() == upgradex && Hero.heroliste.get(i).getyCoord() ==upgradey)
				{					
					if(munition==true)
					{
						Hero.heroliste.get(i).setammo();
						System.out.println("muni aufgenommen");
					}				
					if(rüstung == true)
					{
						Hero.heroliste.get(i).setarmored(true);
						System.out.println(" rüstung aufgenommen");
					}
					if(reichweite ==true)
					{
						Hero.heroliste.get(i).setreach();
						System.out.println("reichweite aufgenommen");
					}
					if(geschwindigkeit == true)
					{
						Hero.heroliste.get(i).setspeed();
						System.out.println("geschwindigkeit aufgenommen");
					}
					gedropt=false;					
				}
			}
		}	
		upgradeliste.remove(this);
		
	}
	
	}
