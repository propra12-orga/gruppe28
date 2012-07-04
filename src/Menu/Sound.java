package Menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        
        JCheckBox hintergrundmusikButton = new JCheckBox("Hintergrundmusik an");
        hintergrundmusikButton.setFocusable(false);
        hintergrundmusikButton.addActionListener(this);
        //add(hintergrundmusikButton);
        
        JCheckBox EffektsoundButton = new JCheckBox("Ton an/aus");
        EffektsoundButton.setFocusable(false);
        EffektsoundButton.addActionListener(this);
        EffektsoundButton.setAlignmentX(0.5f);
        EffektsoundButton.setBorderPainted(false);
        EffektsoundButton.setContentAreaFilled(false);
        add(EffektsoundButton);
        
        add(Box.createRigidArea(new Dimension (0,50)));
        JButton close = new JButton(new ImageIcon("res/Buttonimages/zuruck.gif"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
	    close.setVisible(true);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
				Optionen opt = new Optionen();
				opt.setVisible(true);
			}
		});
		close.setAlignmentX(0.5f);
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
