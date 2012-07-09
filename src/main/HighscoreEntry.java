package main;


public class HighscoreEntry implements Comparable<Object> {
	 
    private String name;
    private int points;

    public HighscoreEntry(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public int compareTo(Object o) {
        HighscoreEntry hE = (HighscoreEntry) o;
        if (this.points > hE.getPoints()) {
            return -1;
        } else if (this.points < hE.getPoints()) {
            return 1;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String toString() {
        return this.name + ": " + this.points;
    }
}