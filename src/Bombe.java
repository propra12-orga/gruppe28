
public class Bombe {
int bombenreichweite = 3;
int pi = 0;
int reichweitel = 0;
int reichweiter = 0;
int reichweiteo = 0;
int reichweiteu = 0;
int bombex = Hero.getxCoord();
int bombey = Hero.getyCoord();
int i;
 while (reichweitel <= bombenreichweite && map[bombex-reichweitel][bombey].getTileId()%4!=1)
 	{
	 map[bombex-reichweitel][bombey].setTileId(1);
	 reichweitel+=1;
	}
 while (reichweiter <= bombenreichweite && map[bombex+reichweiter][bombey].getTileId()%4!=1)
	{
	 map[bombex+reichweiter][bombey].setTileId(1)
	 reichweiter+=1;
	}
 while (reichweiteu <= bombenreichweite && map[bombex][bombey+reichweiteu].getTileId()%4!=1)
	{
	 map[bombex][bombey+reichweiteu].setTileId(1)
	 reichweiteu+=1;
	}
 while (reichweiteo <= bombenreichweite && map[bombex][bombey-reichweiteo].getTileId()%4!=1)
	{
	 map[bombex][bombey-reichweiteo].getTileId(1)
	 reichweiteo+=1;
	}

}
