package Menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sound extends JFrame implements ActionListener {
	public Sound() {
		
		JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(null);	
		setSize(800, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        JCheckBox hintergrundmusikButton = new JCheckBox("Hintergrundmusik an");
        hintergrundmusikButton.setFocusable(false);
        hintergrundmusikButton.addActionListener(this);
        add(hintergrundmusikButton);
        
        JCheckBox EffektsoundButton = new JCheckBox("Effektsound an");
        EffektsoundButton.setFocusable(false);
        EffektsoundButton.addActionListener(this);
        add(EffektsoundButton);
        
        add(Box.createRigidArea(new Dimension (0,50)));
        JButton close = new JButton("Zurück");
	    close.setVisible(true);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		close.setAlignmentX(0.5f);
		add(close);
		
		add(Box.createRigidArea(new Dimension (0,300)));

	}
	
	public void actionPerformed(ActionEvent e) {

		JCheckBox source = (JCheckBox) e.getSource();
        boolean state = source.isSelected();

        if (state) {
            this.setTitle("JCheckbox example");
        } else {
            this.setTitle("");
        }
        
        // BRAUCHT VERBESSERUNG!!!

       
    }

}
