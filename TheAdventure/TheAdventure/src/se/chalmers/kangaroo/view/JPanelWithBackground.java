package se.chalmers.kangaroo.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * A JPanel with the ability of having a picture as background.
 * 
 * @author twist3r
 * 
 */
public class JPanelWithBackground extends JPanel {
	ImageIcon background;

	/**
	 * The default constructor.
	 * 
	 * @param imagepath
	 */
	public JPanelWithBackground(String imagepath) {
		super();
		background = new ImageIcon(imagepath);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		background.paintIcon(this, g, 0, 0);

	}

}
