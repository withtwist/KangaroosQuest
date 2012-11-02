package se.chalmers.kangaroo.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import se.chalmers.kangaroo.constants.Constants;
import se.chalmers.kangaroo.utils.CustomKeys;
import se.chalmers.kangaroo.utils.GameSound;

/**
 * This is the class that paints the view of option.
 * 
 * @author pavlov
 * 
 */
public class OptionView extends JPanelWithBackground implements ActionListener,
		KeyListener, MouseListener, ChangeListener {
	private JLabel currentLeftKey;
	private JLabel currentRightKey;
	private JLabel currentJumpKey;
	private JLabel currentItemKey;
	private JButton leftButton = new JButton("GO LEFT");
	private JButton rightButton = new JButton("GO RIGHT");
	private JButton jumpButton = new JButton("JUMP");
	private JButton itemButton = new JButton("USE ITEM");
	private JSlider bgMusicSlider;
	private JSlider sfxSlider;
	private CustomKeys ck;
	private Menubutton back;
	private ChangeView cv;
	private Key pressedKey;
	private GameSound s = GameSound.getInstance();

	private enum Key {
		LEFT, RIGHT, JUMP, ITEM, NONE;
	}

	/**
	 * The constructor creates the view.
	 * @param imagepath
	 *            is the background image that option has.
	 * @param cv
	 *            is the ChangeView that is required to change view from option
	 */
	public OptionView(String imagepath, ChangeView cv) {
		super(imagepath);
		this.cv = cv;
		this.setFocusable(true);
		this.addKeyListener(this);
		ck = CustomKeys.getInstance();
		back = new Menubutton("resources/gfx/buttons/back.png");
		back.addMouseListener(this);
		cv.addKeyListener(this);
		this.setLayout(new BorderLayout());

		// Header
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new BorderLayout());
		int titleHeight = 100;
		int subTitleHeight = 75;

		this.add(headerPanel, BorderLayout.NORTH);
		this.setMinimumSize(Constants.RESOLUTION);
		this.setMaximumSize(Constants.RESOLUTION);
		this.setPreferredSize(Constants.RESOLUTION);

		// Back-button
		JPanel backPanel = new JPanel(new BorderLayout());
		backPanel.add(back, BorderLayout.WEST);
		backPanel.setMinimumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				titleHeight));
		backPanel.setMaximumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				titleHeight));
		backPanel.setPreferredSize(new Dimension(
				Constants.RESOLUTION_WIDTH / 3, titleHeight));
		headerPanel.add(backPanel, BorderLayout.WEST);

		// Title
		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel(Constants.TITLE_START + "Option"
				+ Constants.TITLE_END);
		titlePanel.add(title);
		headerPanel.add(title, BorderLayout.CENTER);

		headerPanel.setMinimumSize(new Dimension(Constants.RESOLUTION_WIDTH,
				titleHeight));
		title.setMaximumSize(new Dimension(Constants.RESOLUTION_WIDTH,
				titleHeight));
		title.setPreferredSize(new Dimension(Constants.RESOLUTION_WIDTH,
				titleHeight));

		// Content
		JPanel contentPanel = new JPanel(new BorderLayout());
		this.add(contentPanel, BorderLayout.SOUTH);

		// Key Binding
		JPanel kBindingPanel = new JPanel(new BorderLayout());
		contentPanel.add(kBindingPanel, BorderLayout.WEST);
		kBindingPanel.setMinimumSize(new Dimension(
				Constants.RESOLUTION_WIDTH / 3, Constants.RESOLUTION_HEIGHT
						- titleHeight));
		kBindingPanel.setMaximumSize(new Dimension(
				Constants.RESOLUTION_WIDTH / 3, Constants.RESOLUTION_HEIGHT
						- titleHeight));
		kBindingPanel.setPreferredSize(new Dimension(
				Constants.RESOLUTION_WIDTH / 3, Constants.RESOLUTION_HEIGHT
						- titleHeight));

		// Key Binding - Title
		JLabel kbLabel = new JLabel("Custom Keys");
		kBindingPanel.add(kbLabel, BorderLayout.NORTH);
		kbLabel.setMinimumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				subTitleHeight));
		kbLabel.setMaximumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				subTitleHeight));
		kbLabel.setPreferredSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				subTitleHeight));

		// Key Binding - Grid
		JPanel kbGridPanel = new JPanel(new GridLayout(4, 2));
		Dimension buttonPanelDimension = new Dimension(
				Constants.BUTTON_RESOLUTION_WIDTH + 20,
				Constants.BUTTON_RESOLUTION_HEIGHT + 40);

		// Left
		JPanel leftButtonPanel = new JPanel();
		leftButton.addActionListener(this);
		leftButton.setFocusable(false);
		leftButtonPanel.add(leftButton);
		kbGridPanel.add(leftButtonPanel);
		currentLeftKey = new JLabel(ck.getLeftKeyName());
		kbGridPanel.add(currentLeftKey);
		leftButtonPanel.setMinimumSize(buttonPanelDimension);
		leftButtonPanel.setMaximumSize(buttonPanelDimension);
		leftButtonPanel.setPreferredSize(buttonPanelDimension);
		leftButton.setMinimumSize(Constants.BUTTON_RESOLUTION);
		leftButton.setMaximumSize(Constants.BUTTON_RESOLUTION);
		leftButton.setPreferredSize(Constants.BUTTON_RESOLUTION);

		// Right
		JPanel rightButtonPanel = new JPanel();
		rightButton.addActionListener(this);
		rightButton.setFocusable(false);
		rightButtonPanel.add(rightButton);
		kbGridPanel.add(rightButtonPanel);
		currentRightKey = new JLabel(ck.getRightKeyName());
		kbGridPanel.add(currentRightKey);
		rightButtonPanel.setMinimumSize(buttonPanelDimension);
		rightButtonPanel.setMaximumSize(buttonPanelDimension);
		rightButtonPanel.setPreferredSize(buttonPanelDimension);
		rightButton.setMinimumSize(Constants.BUTTON_RESOLUTION);
		rightButton.setMaximumSize(Constants.BUTTON_RESOLUTION);
		rightButton.setPreferredSize(Constants.BUTTON_RESOLUTION);

		// Jump
		JPanel jumpButtonPanel = new JPanel();
		jumpButton.addActionListener(this);
		jumpButton.setFocusable(false);
		jumpButtonPanel.add(jumpButton);
		kbGridPanel.add(jumpButtonPanel);
		currentJumpKey = new JLabel(ck.getJumpKeyName());
		kbGridPanel.add(currentJumpKey);
		jumpButtonPanel.setMinimumSize(buttonPanelDimension);
		jumpButtonPanel.setMaximumSize(buttonPanelDimension);
		jumpButtonPanel.setPreferredSize(buttonPanelDimension);
		jumpButton.setMinimumSize(Constants.BUTTON_RESOLUTION);
		jumpButton.setMaximumSize(Constants.BUTTON_RESOLUTION);
		jumpButton.setPreferredSize(Constants.BUTTON_RESOLUTION);

		// Item
		JPanel itemButtonPanel = new JPanel();
		itemButton.addActionListener(this);
		itemButton.setFocusable(false);
		itemButtonPanel.add(itemButton);
		kbGridPanel.add(itemButtonPanel);
		currentItemKey = new JLabel(ck.getItemKeyName());
		kbGridPanel.add(currentItemKey);
		itemButtonPanel.setMinimumSize(buttonPanelDimension);
		itemButtonPanel.setMaximumSize(buttonPanelDimension);
		itemButtonPanel.setPreferredSize(buttonPanelDimension);
		itemButton.setMinimumSize(Constants.BUTTON_RESOLUTION);
		itemButton.setMaximumSize(Constants.BUTTON_RESOLUTION);
		itemButton.setPreferredSize(Constants.BUTTON_RESOLUTION);

		kBindingPanel.add(kbGridPanel, BorderLayout.SOUTH);

		// Placeholder
		JPanel ph = new JPanel();
		ph.setMinimumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));
		ph.setMaximumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));
		ph.setPreferredSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));

		contentPanel.add(ph, BorderLayout.CENTER);

		// Adjust Volume
		JPanel av = new JPanel(new GridLayout(4, 1));
		av.setMinimumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));
		av.setMaximumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));
		av.setPreferredSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));

		contentPanel.add(av, BorderLayout.EAST);

		// Grid with the sound sliders
		JLabel bgTitle = new JLabel("Background Music:");
		av.add(bgTitle);

		bgMusicSlider = new JSlider(JSlider.HORIZONTAL, 0, 100,
				(int) (s.getBgVolume() * 100.0));
		bgMusicSlider.addChangeListener(this);
		bgMusicSlider.setMajorTickSpacing(25);
		bgMusicSlider.setMinorTickSpacing(10);
		bgMusicSlider.setPaintTicks(true);
		bgMusicSlider.setPaintLabels(true);

		av.add(bgMusicSlider);

		JLabel sfxTitle = new JLabel("Soundeffects:");
		av.add(sfxTitle);

		sfxSlider = new JSlider(JSlider.HORIZONTAL, 0, 100,
				(int) (s.getSfxVolume() * 100.0));
		sfxSlider.addChangeListener(this);
		sfxSlider.setMajorTickSpacing(25);
		sfxSlider.setMinorTickSpacing(10);
		sfxSlider.setPaintTicks(true);
		sfxSlider.setPaintLabels(true);

		av.add(sfxSlider);
	}

	@Override
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == leftButton) {
			pressedKey = Key.LEFT;
			this.requestFocus();
			new Thread() {
				@Override
				public void run() {
					try {
						while (pressedKey == Key.LEFT) {
							currentLeftKey.setText("Press a key...");
							sleep(700);
							currentLeftKey.setText("");
							sleep(700);
						}
						currentLeftKey.setText(ck.getLeftKeyName());
					} catch (InterruptedException ie) {

					}
				}
			}.start();

		} else if (src == rightButton) {
			pressedKey = Key.RIGHT;
			this.requestFocus();
			new Thread() {
				@Override
				public void run() {
					try {
						while (pressedKey == Key.RIGHT) {
							currentRightKey.setText("Press a key...");
							sleep(700);
							currentRightKey.setText("");
							sleep(700);
						}
						currentRightKey.setText(ck.getRightKeyName());
					} catch (InterruptedException ie) {

					}
				}
			}.start();

		} else if (src == jumpButton) {
			pressedKey = Key.JUMP;
			this.requestFocus();
			new Thread() {
				@Override
				public void run() {
					try {
						while (pressedKey == Key.JUMP) {
							currentJumpKey.setText("Press a key...");
							sleep(700);
							currentJumpKey.setText("");
							sleep(700);
						}
						currentJumpKey.setText(ck.getJumpKeyName());
					} catch (InterruptedException ie) {

					}
				}
			}.start();

		} else if (src == itemButton) {
			pressedKey = Key.ITEM;
			this.requestFocus();
			new Thread() {
				@Override
				public void run() {
					try {
						while (pressedKey == Key.ITEM) {
							currentItemKey.setText("Press a key...");
							sleep(700);
							currentItemKey.setText("");
							sleep(700);
						}
						currentItemKey.setText(ck.getItemKeyName());
					} catch (InterruptedException ie) {

					}
				}
			}.start();
		}

	}

	public void keyPressed(KeyEvent key) {
		if (pressedKey == Key.LEFT) {
			ck.setLeftKey(key.getKeyCode());
			pressedKey = Key.NONE;
		} else if (pressedKey == Key.RIGHT) {
			ck.setRightKey(key.getKeyCode());
			pressedKey = Key.NONE;
		} else if (pressedKey == Key.JUMP) {
			ck.setJumpKey(key.getKeyCode());
			pressedKey = Key.NONE;
		} else if (pressedKey == Key.ITEM) {
			ck.setItemKey(key.getKeyCode());
			pressedKey = Key.NONE;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent key) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		//Not needed
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == back)
			back.setIcon(new ImageIcon(
					"resources/gfx/buttons/back_onHover.png"));

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
			back.setIcon(new ImageIcon("resources/gfx/buttons/back.png"));
			cv.back();
		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == bgMusicSlider) {
			s.setBgVolume((double) bgMusicSlider.getValue() / 100.0);
		} else if (e.getSource() == sfxSlider) {
			s.setSfxVolume((double) sfxSlider.getValue() / 100.0);
		}

	}

}
