package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card1 extends JPanel{
	public Card1 () {
		JLabel lb_img = new JLabel();
		lb_img.setIcon(new ImageIcon(GiaoDien.class.getResource("wallpaperflare.com_wallpaper (2).jpg")));
		add(lb_img);
		
	}
	
}