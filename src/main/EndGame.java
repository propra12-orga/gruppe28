package main;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import board.LevelReader;

import Menu.BackGroundPane;
import Menu.Spielstart;

import controlling.InputController;

public class EndGame extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EndGame() {

        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setContentPane(new BackGroundPane("res/Buttonimages/background.gif"));
        add(Box.createRigidArea(new Dimension(0, 50)));
        JLabel name1 = new JLabel("Wollen Sie erneut spielen?");
        name1.setForeground(Color.WHITE);
        name1.setFont(new Font("Bender", Font.BOLD, 13));
        name1.setAlignmentX(0.5f);
        add(name1);
        add(Box.createRigidArea(new Dimension(0, 10)));
        JButton again = new JButton("Ja");
        again.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
            	Mainframe.beard.setHasExit(false);
            	for(Hero hero : Hero.heroliste) {
    				hero.resettilecount();
    				hero.resetkillcount();
    				hero.resetscorecount();
    				hero.resetdeathcount();
    				hero.resetsuicidecount();
    			}
            	InputController.keys.clear();
                dispose();
                Spielstart start = new Spielstart();
                start.setVisible(true);
                File test = new File("res/Maps/1.txt");
                try {
					Mainframe.beard.createLevel(LevelReader.readLevel(test));
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
        
        again.setAlignmentX(0.5f);
        add(again);
        
        JButton close = new JButton("Nein");
        close.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
            	System.exit(0);
            }
        });

        close.setAlignmentX(0.5f);
        add(close);

        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Spiel vorbei.");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(250, 200);
    }
}