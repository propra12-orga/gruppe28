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

class Credits extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Credits() {

        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel name1 = new JLabel("Sebastian Alius");
        name1.setFont(new Font("Serif", Font.BOLD, 13));
        name1.setAlignmentX(0.5f);
        add(name1);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel name2 = new JLabel("Dustin Hartmann");
        name2.setFont(new Font("Serif", Font.BOLD, 13));
        name2.setAlignmentX(0.5f);
        add(name2);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel name3 = new JLabel("Sebastian Hartmann");
        name3.setFont(new Font("Serif", Font.BOLD, 13));
        name3.setAlignmentX(0.5f);
        add(name3);

        add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel name4 = new JLabel("Fabio Huuk");
        name4.setFont(new Font("Serif", Font.BOLD, 13));
        name4.setAlignmentX(0.5f);
        add(name4);
        
        add(Box.createRigidArea(new Dimension(0, 50)));

        JButton close = new JButton("Zur�ck");
        close.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        close.setAlignmentX(0.5f);
        add(close);

        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Credits");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 250);
    }
}