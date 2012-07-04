package Menu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Charactereinstellungen extends JFrame implements 
		ActionListener, ItemListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

    /*ImageIcon icon = new ImageIcon(
		ClassLoader.getSystemResource("res/Buttonimages/bm1.gif"));
*/
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
        add(Box.createRigidArea(new Dimension(0, 50)));
        display = new JLabel();
        display.setPreferredSize(new Dimension(40, 40));
        display.setMaximumSize(new Dimension(40, 40));
        display.setAlignmentX(Component.CENTER_ALIGNMENT);
        display.setBorder(LineBorder.createGrayLineBorder());
        add(display);

        add(Box.createRigidArea(new Dimension(0, 50)));

        combobox = new JComboBox(authors);
        combobox.setSelectedIndex(-1);
        combobox.setPreferredSize(new Dimension(140, 22));
        combobox.setMaximumSize(new Dimension(140, 22));
        combobox.addItemListener(this);
        add(combobox);

        add(Box.createRigidArea(new Dimension(0, 15)));

        JButton close = new JButton(new ImageIcon("res/Buttonimages/zuruck.gif"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
	    close.setVisible(true);
		close.setAlignmentX(0.5f);
        close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();

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
        }

    }
}
