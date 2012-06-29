package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;

import board.Tile;

public class IngameUI extends JFrame{
	private static final long serialVersionUID = 1L;
	static String grasString = "Gras";
	static String iceString = "Eis";
	static String spaceString = "Weltraum";
	static String alphaString = "Alpha";
	static String desertString = "Wüste";
	
	public final void initUI() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menü");
        menu.setMnemonic(KeyEvent.VK_ESCAPE);

        JMenu snd = new JMenu("Sound");
        snd.setMnemonic(KeyEvent.VK_S);
        JCheckBox toggle = new JCheckBox("Sound an/aus", true);
        toggle.setFocusable(false);
		toggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JCheckBox source =(JCheckBox) e.getSource();
				boolean state = source.isSelected();
				if(state){
					Mainframe.sound=true;
				}else{
					Mainframe.sound=false;
				}}});
        snd.add(toggle);
        
        JMenu tset = new JMenu("Grafik");
        tset.setMnemonic(KeyEvent.VK_G);
        JRadioButton gras = new JRadioButton(grasString);
        gras.setActionCommand(grasString);
        gras.setSelected(true);
        
        JRadioButton ice = new JRadioButton(iceString);
        ice.setActionCommand(iceString);
        ice.setSelected(true);
        
        JRadioButton space = new JRadioButton(spaceString);
        space.setActionCommand(spaceString);
        space.setSelected(true);
        
        JRadioButton alpha = new JRadioButton(alphaString);
        alpha.setActionCommand(alphaString);
        alpha.setSelected(true);
        
        JRadioButton desert = new JRadioButton(desertString);
        desert.setActionCommand(desertString);
        desert.setSelected(true);
        
        ButtonGroup group = new ButtonGroup();
        group.add(gras);
        group.add(ice);
        group.add(space);
        group.add(alpha);
        group.add(desert);
        
        gras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=0;
            }
        });
        ice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=1;
            }
        });
        space.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=2;
            }
        });
        alpha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=3;
            }
        });
        desert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=4;
            }
        });
        JMenuItem eMenuItem = new JMenuItem("Beenden");
        eMenuItem.setMnemonic(KeyEvent.VK_B);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        menu.add(tset);
        tset.add(gras);
        tset.add(ice);
        tset.add(desert);
        tset.add(space);
        tset.add(alpha);
        menu.add(snd);
        snd.add(toggle);
        menu.add(eMenuItem);
        menubar.add(menu);
        setJMenuBar(menubar);
	}
}
