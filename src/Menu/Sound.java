package Menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import main.Mainframe;

public class Sound extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Sound() {
		
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
        
        add(Box.createRigidArea(new Dimension (0,25)));
        add(label);
        add(Box.createRigidArea(new Dimension (0,50)));
        JPanel sound = new JPanel();
        sound.setAlignmentX(1f);
        sound.setLayout(new BoxLayout(sound, BoxLayout.Y_AXIS));
        
        Icon onon = new ImageIcon("res/Buttonimages/soundon.gif");
        JRadioButton soundOn = new JRadioButton();
        soundOn.setFocusable(false);
        soundOn.addActionListener(this);
        soundOn.setBorderPainted(false);
        soundOn.setContentAreaFilled(false);
        soundOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Mainframe.sound=true;
			}
		});

        sound.add(soundOn);
        sound.add(Box.createRigidArea(new Dimension (5,0)));
        JLabel on  = new JLabel(onon);
        sound.add(on);
        
        Icon offoff = new ImageIcon("res/Buttonimages/soundoff.gif");
        JRadioButton soundOff = new JRadioButton();
        soundOff.setFocusable(false);
        soundOff.addActionListener(this);
        soundOff.setBorderPainted(false);
        soundOff.setContentAreaFilled(false);
        soundOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Mainframe.sound=false;
			}
		});
        sound.add(soundOff);
        JLabel off  = new JLabel(offoff);
        sound.add(off);
        
        ButtonGroup group = new ButtonGroup();
        group.add(soundOn);
        group.add(soundOff);

        
        add(Box.createRigidArea(new Dimension (0,50)));
        JButton close = new JButton(new ImageIcon("res/Buttonimages/zuruck.gif"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
	    close.setVisible(true);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		close.setAlignmentX(0.5f);
		add(sound);
		add(close);
		
		add(Box.createRigidArea(new Dimension (0,150)));

	}
	
	public void actionPerformed(ActionEvent e) {

		JCheckBox source = (JCheckBox) e.getSource();
        boolean state = source.isSelected();

        if(state){
			Mainframe.sound=true;
		}else{
			Mainframe.sound=false;
        }
    }

}
