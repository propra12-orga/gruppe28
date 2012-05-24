
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Menu extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Menu() {
        initUI();
    }

    public final void initUI() {

    	
       JPanel panel = new JPanel();
       getContentPane().add(panel);

       panel.setLayout(null);
       
       JButton startButton = new JButton("Spiel starten");
       startButton.setBounds(325, 50, 150, 30);
       panel.add(startButton);
       startButton.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent event) {
    		  Mainframe mf = new Mainframe();
    		  Board board = new Board();
    		  mf.add(board);
    		  mf.setVisible(true);
    		  dispose();
    	   }
       });

       		
       JButton extrasButton = new JButton("Extras");
       extrasButton.setBounds(325, 150,150,30);
       panel.add(extrasButton);
       extrasButton.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent event) {
    		   Extras ad = new Extras();
    		   ad.setVisible(true);
    	   }
       });
       
       JButton creditsButton = new JButton("Credits");
       creditsButton.setBounds(325,250,150,30);
       panel.add(creditsButton);
       creditsButton.addActionListener(new ActionListener() {

           public void actionPerformed(ActionEvent event) {
               Credits ad = new Credits();
               ad.setVisible(true);
           }
       });
       

       JButton quitButton = new JButton("Spiel verlassen");
       quitButton.setBounds(325, 350, 150, 30); //The parameters are the x, y location values and the width and height of the component. 
       quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
          }
       });

       panel.add(quitButton);

       setTitle("Menu");
       setSize(800, 500);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
   

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Menu ex = new Menu();
                ex.setVisible(true);
            }
        });
        
    }
}