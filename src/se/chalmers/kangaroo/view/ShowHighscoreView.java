package se.chalmers.kangaroo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import se.chalmers.kangaroo.constants.Constants;
import se.chalmers.kangaroo.io.Highscore;

/**
 * This is the view that show you who has the best score on a specific level. It
 * specifically show the level you have chosen in HighscoreView.
 * 
 * @author pavlov
 * 
 */
public class ShowHighscoreView extends JPanelWithBackground implements
		MouseListener {
	private Menubutton back;
	private ChangeView cv;
	private String[] names;
	private int[] times;
	private int[] deaths;
	private Highscore hs;

	/**
	 * Constructor that sets the design that is used.
	 * 
	 * @param imagepath
	 *            is the background used for this view.
	 * @param cv
	 *            is the class for changing view.
	 * @param level
	 *            is the level that you want to show highscore for.
	 */
	public ShowHighscoreView(String imagepath, ChangeView cv, int level) {
		super(imagepath);
		this.cv = cv;
		hs = Highscore.getInstance();
		this.setFocusable(true);
		back = new Menubutton("resources/gfx/buttons/back.png");
		back.addMouseListener(this);
		this.setLayout(new BorderLayout());

		// TOP
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new BorderLayout());
		headerPanel.setOpaque(false);
		this.add(headerPanel, BorderLayout.NORTH);

		// TOP-LEFT - Back Button
		JPanel backPanel = new JPanel();
		backPanel.add(back);
		backPanel.setMinimumSize(new Dimension(100, 100));
		backPanel.setMaximumSize(new Dimension(100, 100));
		backPanel.setPreferredSize(new Dimension(100, 100));
		backPanel.setOpaque(false);
		headerPanel.add(backPanel, BorderLayout.WEST);

		// TOP-CENTER - Title
		Menubutton title = new Menubutton("resources/gfx/misc/level_name/level" + level + ".png");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		headerPanel.add(title, BorderLayout.CENTER);

		// TOP-RIGHT
		JPanel emptyWeightPanel = new JPanel();
		emptyWeightPanel.setMinimumSize(new Dimension(100, 100));
		emptyWeightPanel.setMaximumSize(new Dimension(100, 100));
		emptyWeightPanel.setPreferredSize(new Dimension(100, 100));
		emptyWeightPanel.setOpaque(false);
		headerPanel.add(emptyWeightPanel, BorderLayout.EAST);

		// CONTENT
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setOpaque(false);
		this.add(contentPanel, BorderLayout.CENTER);

		JPanel contentLeft = new JPanel();
		JPanel contentRight = new JPanel();
		JPanel contentCenter = new JPanel(new GridLayout(6, 2));
		contentLeft.setOpaque(false);
		contentRight.setOpaque(false);
		contentCenter.setOpaque(false);
		contentPanel.add(contentLeft, BorderLayout.WEST);
		contentPanel.add(contentCenter, BorderLayout.CENTER);
		contentPanel.add(contentRight, BorderLayout.EAST);

		names = hs.getNames(level);
		times = hs.getTimes(level);
		deaths = hs.getDeaths(level);
		for (int i = 0; i < 5; i++) {
			contentCenter.add(getRankLabel(i, names[i], times[i], deaths[i]));
			contentCenter.add(getRankLabel(i+5, names[i+5], times[i+5], deaths[i+5]));
		}
	}
	
	private JLabel getRankLabel(int nbr, String name, int time, int deaths){
		String s = "<html><body><table width='500'><tr>";
		if(nbr < 5){
			s += "<td width='35%'></td>";
		}
		s += "<td width='35%'>" + name + "</td><td width='15%'>" + time
				/ 1000.0 + "</td><td width='15%'>" + deaths
				+ "</td>";
		if(nbr >= 5){
			s += "<td width='35%'></td>";
		}
		s += "</tr></table>";
		JLabel l = new JLabel(s);
		l.setFont(Constants.P_RANK);
		return l;
	}
	
	private JPanel getEmptyPanel(){
		JPanel p = new JPanel();
		p.setOpaque(false);
		return p;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Nothing to do here..
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == back)
			back.setIcon(new ImageIcon("resources/gfx/buttons/back_onHover.png"));

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == back) {
			back.setIcon(new ImageIcon("resources/gfx/buttons/back.png"));
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == back) {
			back.setIcon(new ImageIcon(
					"resources/gfx/buttons/back_onSelect.png"));
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == back) {
			back.setIcon(new ImageIcon("resources/images/buttons/back.png"));
			cv.highscoreView();
		}

	}

}
