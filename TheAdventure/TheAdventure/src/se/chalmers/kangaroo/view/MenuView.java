package se.chalmers.kangaroo.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import se.chalmers.kangaroo.constants.Constants;
import se.chalmers.kangaroo.utils.GameSound;

/**
 * The view of the menu. Will create the menu that shows when the game is
 * started. The menu will allow the user to start the game, see high score or do
 * some changes in the menu.
 * 
 * @author twist3r
 * @modifiedby arvidk
 * 
 */
public class MenuView extends JPanelWithBackground implements MouseListener {
	private Menubutton newGame, highScore, options, exitGame;

	private ChangeView cv;
	private GameSound s;
	private String viewName = "menuview";

	/**
	 * The constructor for the MenuView. Takes a String and a Changeview as
	 * parameters. The String is the path to the specified background.
	 * ChangeView is used to change between the diffrent views in the game.
	 * 
	 * @param bgpath
	 *            , cv
	 */
	public MenuView(String bgpath, ChangeView cv) {
		super(bgpath);
		this.cv = cv;
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		this.setSize(Constants.RESOLUTION_WIDTH, Constants.RESOLUTION_WIDTH);
		s = GameSound.getInstance();
		s.playBgMusic("menumusic");
		newGame = new Menubutton("resources/gfx/buttons/newgame.png");
		highScore = new Menubutton("resources/gfx/buttons/highscore.png");
		options = new Menubutton("resources/gfx/buttons/options.png");
		exitGame = new Menubutton("resources/gfx/buttons/exitgame.png");

		this.add(Box.createVerticalGlue());
		this.add(new Menubutton("resources/gfx/misc/menu_logo.gif"));
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
		this.add(newGame);
		this.add(Box.createVerticalGlue());
		this.add(highScore);
		this.add(Box.createVerticalGlue());
		this.add(options);
		this.add(Box.createVerticalGlue());
		this.add(exitGame);
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());

		newGame.addMouseListener(this);
		highScore.addMouseListener(this);
		options.addMouseListener(this);
		exitGame.addMouseListener(this);
	}

	/**
	 * unused method
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Not needed
	}

	/**
	 * Changes the button when the mouse hovers over the button. Changes the
	 * image on the button to the given string.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == newGame)
			newGame.setIcon(new ImageIcon(
					"resources/gfx/buttons/newgame_onHover.png"));
		if (e.getSource() == highScore)
			highScore.setIcon(new ImageIcon(
					"resources/gfx/buttons/highscore_onHover.png"));
		if (e.getSource() == options)
			options.setIcon(new ImageIcon(
					"resources/gfx/buttons/options_onHover.png"));
		if (e.getSource() == exitGame)
			exitGame.setIcon(new ImageIcon(
					"resources/gfx/buttons/exitgame_onHover.png"));
	}

	/**
	 * Changes the button when the mouse exits the button. Changes the image on
	 * the button to the given string.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == newGame)
			newGame.setIcon(new ImageIcon("resources/gfx/buttons/newgame.png"));
		if (e.getSource() == highScore)
			highScore.setIcon(new ImageIcon(
					"resources/gfx/buttons/highscore.png"));
		if (e.getSource() == options)
			options.setIcon(new ImageIcon("resources/gfx/buttons/options.png"));
		if (e.getSource() == exitGame)
			exitGame.setIcon(new ImageIcon("resources/gfx/buttons/exitgame.png"));

	}

	/**
	 * Changes the button when you press the button. Changes the image on the
	 * button to the given string.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == newGame)
			newGame.setIcon(new ImageIcon(
					"resources/gfx/buttons/newgame_onSelect.png"));
		if (e.getSource() == highScore)
			highScore.setIcon(new ImageIcon(
					"resources/gfx/buttons/highscore_onSelect.png"));
		if (e.getSource() == options)
			options.setIcon(new ImageIcon(
					"resources/gfx/buttons/options_onSelect.png"));
		if (e.getSource() == exitGame)
			exitGame.setIcon(new ImageIcon(
					"resources/gfx/buttons/exitgame_onSelect.png"));
	}

	/**
	 * Changes the button when you release the button. Changes the image on the
	 * button to the given string and also changes the view to the one that says
	 * on the button or exits the game.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == newGame) {
			newGame.setIcon(new ImageIcon("resources/gfx/buttons/newgame.png"));
			s.playBgMusic("level_1");
			cv.gameView();

		}
		if (e.getSource() == highScore) {
			highScore.setIcon(new ImageIcon(
					"resources/gfx/buttons/highscore.png"));
			cv.highscoreView(viewName);
		}

		if (e.getSource() == options) {
			options.setIcon(new ImageIcon("resources/gfx/buttons/options.png"));
			cv.optionView(viewName);

		}
		if (e.getSource() == exitGame) {
			exitGame.setIcon(new ImageIcon("resources/gfx/buttons/exitGame.png"));
			System.exit(0);
		}
	}

}
