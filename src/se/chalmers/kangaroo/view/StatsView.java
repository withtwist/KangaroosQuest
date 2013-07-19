package se.chalmers.kangaroo.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import se.chalmers.kangaroo.io.Highscore;
import se.chalmers.kangaroo.io.Stats;

public class StatsView extends JPanelWithBackground implements
MouseListener{
	
	private ChangeView cv;
	private Stats stats;
	private Menubutton back;

	public StatsView(String imagepath, ChangeView cv){
		super(imagepath);
		this.cv = cv;
		stats = Stats.getInstance();
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
		JLabel title = new JLabel("");
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
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(3, 2));
		contentPanel.setOpaque(false);
		this.add(contentPanel, BorderLayout.CENTER);
		
		JLabel empty = new JLabel(" ");
		
		Font statsFont = new Font("Sans-Serif", Font.PLAIN, 20);
		String leftTextWest = "<html><body><p style='margin-left:0;'>";
		String leftTextEast = "<html><body><p style='margin-left:0;'>";
		String rightText = "</p></body></html>";
		
//		leftC.add(empty);
//		centerC.add(empty);
//		rightC.add(empty);
		
		JLabel jump = new JLabel(leftTextWest + stats.getJumps() + rightText);
		jump.setFont(statsFont);
		jump.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(jump);
		JLabel courseFinished = new JLabel(leftTextEast + stats.getFinishedCourses() + rightText);
		courseFinished.setFont(statsFont);
		courseFinished.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(courseFinished);
		
		int hours = (int)((stats.getTime()/1000)/60)/60;
		int minutes = (int)(((stats.getTime()/1000)-(hours*60*60))/60);
		int seconds = (int) ((stats.getTime()/1000)-(hours*60*60)-(minutes*60));
		
		JLabel time = new JLabel(leftTextWest + hours + "h " + minutes + "m " + seconds + "s" + rightText);
		time.setFont(statsFont);
		time.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(time);
		JLabel enemyKilled = new JLabel(leftTextEast + stats.getEnemyKilled() + rightText);
		enemyKilled.setFont(statsFont);
		enemyKilled.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(enemyKilled);
		
		JLabel killedByEnemy = new JLabel(leftTextWest + stats.getKilledByEnemy() + rightText);
		killedByEnemy.setFont(statsFont);
		killedByEnemy.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(killedByEnemy);		
		JLabel killedByRespawn = new JLabel(leftTextEast + stats.getKilledByRespawn() + rightText);
		killedByRespawn.setFont(statsFont);
		killedByRespawn.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(killedByRespawn);
		
		
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
			cv.back();
		}

	}

}
