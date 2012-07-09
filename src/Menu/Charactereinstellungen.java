package Menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import board.Tileset;


public class Charactereinstellungen extends JFrame implements 
		ActionListener, ItemListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public static BufferedImage[] heroes = new BufferedImage[24];
	final String[] authors = {
	"Bomberman 1", "Bomberman 2", "Bomberman 3", "Bomberman 4", 
	"Darth Vader", "Yoda", "Boba Fett", "Sturmtruppe",
	"James T. Kirk", "Spock", "Klingone", "Gorn",
	"Lucha Libre 1", "Lucha Libre 2", "Lucha Libre 3", "Lucha Libre 4",
	"Jack O'Neill", "Teal'C", "Jaffa", "Wraith"
    };

    final String[] images = {
    "res/Buttonimages/bm1.gif", "res/Buttonimages/bm2.gif", "res/Buttonimages/bm3.gif", "res/Buttonimages/bm4.gif", 
    "res/Buttonimages/vader.gif", "res/Buttonimages/yoda.gif", "res/Buttonimages/boba.gif", "res/Buttonimages/storm.gif",
    "res/Buttonimages/kirk.gif", "res/Buttonimages/spock.gif", "res/Buttonimages/klingon.gif", "res/Buttonimages/gorn.gif",
    "res/Buttonimages/ll1.gif", "res/Buttonimages/ll2.gif", "res/Buttonimages/ll3.gif", "res/Buttonimages/ll4.gif",
    "res/Buttonimages/oneill.gif", "res/Buttonimages/tealc.gif", "res/Buttonimages/jaffa.gif", "res/Buttonimages/wraith.gif"
    };

    private JLabel display = null;  
    private JComboBox combobox = null;

    ImageIcon icon = new ImageIcon("res/Buttonimages/bm1.gif");
    public static JTextField name1 = new JTextField();

    public Charactereinstellungen() {

    	JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);	
    	setSize(800, 500);
    	setContentPane(new BackGroundPane("res/Buttonimages/background.gif"));
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        Icon icon = new ImageIcon("res/Buttonimages/exploman.gif");
        JLabel label  = new JLabel(icon);
        label.setAlignmentX(0.5f);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(label);
        add(Box.createRigidArea(new Dimension(0, 25)));
        JLabel player1  = new JLabel("Spieler 1 Name:");
        player1.setFont(new Font("Bender", Font.BOLD, 20));
        player1.setAlignmentX(0.5f);
        player1.setForeground(Color.WHITE);
        add(player1);
        name1.setMaximumSize(new Dimension(200,20));
        add(name1);
        add(Box.createRigidArea(new Dimension(0, 25)));
        display = new JLabel();
        display.setPreferredSize(new Dimension(40, 40));
        display.setMaximumSize(new Dimension(40, 40));
        display.setAlignmentX(Component.CENTER_ALIGNMENT);
        //display.setBorder(LineBorder.createGrayLineBorder());
        add(display);

        add(Box.createRigidArea(new Dimension(0, 25)));

        combobox = new JComboBox(authors);
        combobox.setSelectedIndex(-1);
        combobox.setPreferredSize(new Dimension(140, 22));
        combobox.setMaximumSize(new Dimension(140, 22));
        combobox.addItemListener(this);
        add(combobox);

        add(Box.createRigidArea(new Dimension(0, 50)));
        
        JButton change = new JButton(new ImageIcon("res/Buttonimages/change.gif"));
        change.setBorderPainted(false);
        change.setContentAreaFilled(false);
		change.setVisible(true);
		change.setAlignmentX(0.5f);
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
				Charactereinstellungen2 chr2 = new Charactereinstellungen2();
				chr2.setVisible(true);
			}
		});
        add(change);
        
        add(Box.createRigidArea(new Dimension(0, 25)));

        JButton close = new JButton(new ImageIcon("res/Buttonimages/next.gif"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
	    close.setVisible(true);
		close.setAlignmentX(0.5f);
        close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
				Grafikeinstellungen gr = new Grafikeinstellungen();
				gr.setVisible(true);
			}
		});
        add(close);


    }


    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox combo = (JComboBox) e.getSource();
            int index = combo.getSelectedIndex();
            display.setIcon(new ImageIcon(images[index]));
            if(index == 0){
            	this.setHero(0,0,0);
            }
            if(index == 1){
            	this.setHero(1,0,0);
            }
            if(index == 2){
            	this.setHero(2,0,0);
            }
            if(index == 3){
            	this.setHero(3,0,0);
            }
            if(index == 4){
            	this.setHero(0,1,0);
            }
            if(index == 5){
            	this.setHero(1,1,0);
            }
            if(index == 6){
            	this.setHero(2,1,0);
            }
            if(index == 7){
            	this.setHero(3,1,0);
            }
            if(index == 8){
            	this.setHero(0,2,0);
            }
            if(index == 9){
            	this.setHero(1,2,0);
            }
            if(index == 10){
            	this.setHero(2,2,0);
            }
            if(index == 11){
            	this.setHero(3,2,0);
            }
            if(index == 12){
            	this.setHero(0,3,0);
            }
            if(index == 13){
            	this.setHero(1,3,0);
            }
            if(index == 14){
            	this.setHero(2,3,0);
            }
            if(index == 15){
            	this.setHero(3,3,0);
            }
            if(index == 16){
            	this.setHero(0,4,0);
            }
            if(index == 17){
            	this.setHero(1,4,0);
            }
            if(index == 18){
            	this.setHero(2,4,0);
            }
            if(index == 19){
            	this.setHero(3,4,0);
            }
            if(index == 20){
            	this.setHero(0,5,0);
            }
            if(index == 21){
            	this.setHero(1,5,0);
            }
            if(index == 22){
            	this.setHero(2,5,0);
            }
            if(index == 23){
            	this.setHero(3,5,0);
            }
        }

    }
    public BufferedImage setHero(int a, int b, int i) {
		Charactereinstellungen.heroes[i]=Tileset.hero[a][b];
		return Charactereinstellungen.heroes[i];
	}
}
