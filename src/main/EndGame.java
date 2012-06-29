package main;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

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

        add(Box.createRigidArea(new Dimension(0, 50)));
        JLabel name1 = new JLabel("Wollen Sie erneut spielen?");
        name1.setFont(new Font("Serif", Font.BOLD, 13));
        name1.setAlignmentX(0.5f);
        add(name1);

        JButton again = new JButton("Ja");
        again.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
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

        setTitle("Game over.");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(250, 200);
    }
}