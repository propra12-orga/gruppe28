package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import Menu.Charactereinstellungen;
import Menu.Charactereinstellungen2;


public class SortArray {
	File f = new File("res/hs.txt");
	public static HighscoreEntry[] highscore = new HighscoreEntry[5];

    public SortArray() {
        if (f.exists()) {
            try {
                FileReader fR = new FileReader(f);
                char[] c = new char[(int) f.length()];
                fR.read(c);
 
                String s = new String(c);
                String[] entrys = s.split("\n");
 
                for (int i = 0; i < entrys.length; i++) 
                {
                    if (i < 5) {
                        String[] entry = entrys[i].split(":");
                        highscore[i] = new HighscoreEntry(entry[0], Integer.parseInt(entry[1]));
                    }
                }
                fR.close();
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            highscore[0] = new HighscoreEntry(Charactereinstellungen.name1.getText(), Hero.heroliste.get(0).getscorecount());
            highscore[1] = new HighscoreEntry(Charactereinstellungen2.name2.getText(), Hero.heroliste.get(1).getscorecount());
            highscore[2] = new HighscoreEntry("XXX", 0);
            highscore[3] = new HighscoreEntry("XXX", 0);
            highscore[4] = new HighscoreEntry("XXX", 0);
        }
        if(Hero.heroliste.get(0).getscorecount() > Hero.heroliste.get(1).getscorecount()){
        		if(highscore[0].compareTo(new HighscoreEntry(Charactereinstellungen.name1.getText(), Hero.heroliste.get(0).getscorecount())) == 1){
        			highscore[4]=highscore[3];
        			highscore[3]=highscore[2];
        			highscore[2]=highscore[1];
        			highscore[1]=highscore[0];
        			highscore[0] = new HighscoreEntry(Charactereinstellungen.name1.getText(), Hero.heroliste.get(0).getscorecount());
        		}
        		else if(highscore[1].compareTo(new HighscoreEntry(Charactereinstellungen.name1.getText(), Hero.heroliste.get(0).getscorecount())) == 1){
        			highscore[4]=highscore[3];
        			highscore[3]=highscore[2];
        			highscore[2]=highscore[1];
        			highscore[1] = new HighscoreEntry(Charactereinstellungen.name1.getText(), Hero.heroliste.get(0).getscorecount());
        		}
        		else if(highscore[2].compareTo(new HighscoreEntry(Charactereinstellungen.name1.getText(), Hero.heroliste.get(0).getscorecount())) == 1){
        			highscore[4]=highscore[3];
        			highscore[3]=highscore[2];
        			highscore[2] = new HighscoreEntry(Charactereinstellungen.name1.getText(), Hero.heroliste.get(0).getscorecount());
        		}
        		else if(highscore[3].compareTo(new HighscoreEntry(Charactereinstellungen.name1.getText(), Hero.heroliste.get(0).getscorecount())) == 1){
        			highscore[4]=highscore[3];
        			highscore[3] = new HighscoreEntry(Charactereinstellungen.name1.getText(), Hero.heroliste.get(0).getscorecount());
        		}
        		else if(highscore[4].compareTo(new HighscoreEntry(Charactereinstellungen.name1.getText(), Hero.heroliste.get(0).getscorecount())) == 1){
        			highscore[4] = new HighscoreEntry(Charactereinstellungen.name1.getText(), Hero.heroliste.get(0).getscorecount());
        		}
        }
        if(Hero.heroliste.get(0).getscorecount() < Hero.heroliste.get(1).getscorecount()){
        	if(highscore[0].compareTo(new HighscoreEntry(Charactereinstellungen2.name2.getText(), Hero.heroliste.get(1).getscorecount())) == 1){
        		highscore[4]=highscore[3];
        		highscore[3]=highscore[2];
        		highscore[2]=highscore[1];
        		highscore[1]=highscore[0];
        		highscore[0] = new HighscoreEntry(Charactereinstellungen2.name2.getText(), Hero.heroliste.get(1).getscorecount());
        	}
        	else if(highscore[1].compareTo(new HighscoreEntry(Charactereinstellungen2.name2.getText(), Hero.heroliste.get(1).getscorecount())) == 1){
    			highscore[4]=highscore[3];
    			highscore[3]=highscore[2];
    			highscore[2]=highscore[1];
    			highscore[1] = new HighscoreEntry(Charactereinstellungen2.name2.getText(), Hero.heroliste.get(1).getscorecount());
    		}
    		else if(highscore[2].compareTo(new HighscoreEntry(Charactereinstellungen2.name2.getText(), Hero.heroliste.get(1).getscorecount())) == 1){
    			highscore[4]=highscore[3];
    			highscore[3]=highscore[2];
    			highscore[2] = new HighscoreEntry(Charactereinstellungen2.name2.getText(), Hero.heroliste.get(1).getscorecount());
    		}
    		else if(highscore[3].compareTo(new HighscoreEntry(Charactereinstellungen2.name2.getText(), Hero.heroliste.get(1).getscorecount())) == 1){
    			highscore[4]=highscore[3];
    			highscore[3] = new HighscoreEntry(Charactereinstellungen2.name2.getText(), Hero.heroliste.get(1).getscorecount());
    		}
    		else if(highscore[4].compareTo(new HighscoreEntry(Charactereinstellungen2.name2.getText(), Hero.heroliste.get(1).getscorecount())) == 1){
    			highscore[4] = new HighscoreEntry(Charactereinstellungen2.name2.getText(), Hero.heroliste.get(1).getscorecount());
    		}
        }
        Arrays.sort(highscore);
 
        for (int i = 0; i < highscore.length; i++) {
            System.out.println(highscore[i]);
        }
        try {
            FileWriter fW = new FileWriter(f);
            for (int i = 0; i < highscore.length; i++) {
                if (i < highscore.length - 1) {
                    fW.write(highscore[i].toString());
                    fW.write("\n");
                } else {
                    fW.write(highscore[i].toString());
                }
            }
            fW.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
