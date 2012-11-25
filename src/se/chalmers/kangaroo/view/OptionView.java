package se.chalmers.kangaroo.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
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
		int titleHeight = 100;
		int subTitleHeight = 20;
		this.setLayout(new BorderLayout());
		this.setMinimumSize(Constants.RESOLUTION);
		this.setMaximumSize(Constants.RESOLUTION);
		this.setPreferredSize(Constants.RESOLUTION);
		
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
		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		titlePanel.add(title);
		titlePanel.setOpaque(false);
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
		this.add(contentPanel, BorderLayout.SOUTH);

		// CONTENT_LEFT - KEYBINDING
		JPanel kBindingPanel = new JPanel(new BorderLayout());
		kBindingPanel.setMinimumSize(new Dimension(
				Constants.RESOLUTION_WIDTH / 3, Constants.RESOLUTION_HEIGHT
				- titleHeight));
		kBindingPanel.setMaximumSize(new Dimension(
				Constants.RESOLUTION_WIDTH / 3, Constants.RESOLUTION_HEIGHT
				- titleHeight));
		kBindingPanel.setPreferredSize(new Dimension(
				Constants.RESOLUTION_WIDTH / 3, Constants.RESOLUTION_HEIGHT
				- titleHeight));
		kBindingPanel.setOpaque(false);
		contentPanel.add(kBindingPanel, BorderLayout.WEST);

		// Key Binding - Grid
		JPanel kbGridPanel = new JPanel(new GridLayout(5, 2));
		kbGridPanel.setOpaque(false);
		Dimension buttonPanelDimension = new Dimension(
				Constants.BUTTON_RESOLUTION_WIDTH + 20,
				Constants.BUTTON_RESOLUTION_HEIGHT + 40);
		JPanel emptyPanel = new JPanel();
		JPanel emptyPanel2 = new JPanel();
		emptyPanel.setOpaque(false);
		emptyPanel2.setOpaque(false);
		kbGridPanel.add(emptyPanel);
		kbGridPanel.add(emptyPanel2);

		// Left
		JPanel leftButtonPanel = new JPanel();
		leftButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		leftButtonPanel.setOpaque(false);
		leftButton.addActionListener(this);
		leftButton.setFocusable(false);
		leftButtonPanel.add(leftButton);
		kbGridPanel.add(leftButtonPanel);
		currentLeftKey = new JLabel(ck.getLeftKeyName());
		currentLeftKey.setFont(Constants.H2);
		kbGridPanel.add(currentLeftKey);
		leftButtonPanel.setMinimumSize(buttonPanelDimension);
		leftButtonPanel.setMaximumSize(buttonPanelDimension);
		leftButtonPanel.setPreferredSize(buttonPanelDimension);
		leftButton.setMinimumSize(Constants.BUTTON_RESOLUTION);
		leftButton.setMaximumSize(Constants.BUTTON_RESOLUTION);
		leftButton.setPreferredSize(Constants.BUTTON_RESOLUTION);

		// Right
		JPanel rightButtonPanel = new JPanel();
		rightButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		rightButtonPanel.setOpaque(false);
		rightButton.addActionListener(this);
		rightButton.setFocusable(false);
		rightButtonPanel.add(rightButton);
		kbGridPanel.add(rightButtonPanel);
		currentRightKey = new JLabel(ck.getRightKeyName());
		currentRightKey.setFont(Constants.H2);
		kbGridPanel.add(currentRightKey);
		rightButtonPanel.setMinimumSize(buttonPanelDimension);
		rightButtonPanel.setMaximumSize(buttonPanelDimension);
		rightButtonPanel.setPreferredSize(buttonPanelDimension);
		rightButton.setMinimumSize(Constants.BUTTON_RESOLUTION);
		rightButton.setMaximumSize(Constants.BUTTON_RESOLUTION);
		rightButton.setPreferredSize(Constants.BUTTON_RESOLUTION);

		// Jump
		JPanel jumpButtonPanel = new JPanel();
		jumpButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		jumpButtonPanel.setOpaque(false);
		jumpButton.addActionListener(this);
		jumpButton.setFocusable(false);
		jumpButtonPanel.add(jumpButton);
		kbGridPanel.add(jumpButtonPanel);
		currentJumpKey = new JLabel(ck.getJumpKeyName());
		currentJumpKey.setFont(Constants.H2);
		kbGridPanel.add(currentJumpKey);
		jumpButtonPanel.setMinimumSize(buttonPanelDimension);
		jumpButtonPanel.setMaximumSize(buttonPanelDimension);
		jumpButtonPanel.setPreferredSize(buttonPanelDimension);
		jumpButton.setMinimumSize(Constants.BUTTON_RESOLUTION);
		jumpButton.setMaximumSize(Constants.BUTTON_RESOLUTION);
		jumpButton.setPreferredSize(Constants.BUTTON_RESOLUTION);

		// Item
		JPanel itemButtonPanel = new JPanel();
		itemButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		itemButtonPanel.setOpaque(false);
		itemButton.addActionListener(this);
		itemButton.setFocusable(false);
		itemButtonPanel.add(itemButton);
		kbGridPanel.add(itemButtonPanel);
		currentItemKey = new JLabel(ck.getItemKeyName());
		currentItemKey.setFont(Constants.H2);
		kbGridPanel.add(currentItemKey);
		itemButtonPanel.setMinimumSize(buttonPanelDimension);
		itemButtonPanel.setMaximumSize(buttonPanelDimension);
		itemButtonPanel.setPreferredSize(buttonPanelDimension);
		itemButton.setMinimumSize(Constants.BUTTON_RESOLUTION);
		itemButton.setMaximumSize(Constants.BUTTON_RESOLUTION);
		itemButton.setPreferredSize(Constants.BUTTON_RESOLUTION);

		kBindingPanel.add(kbGridPanel, BorderLayout.NORTH);

		// Placeholder
		JPanel ph = new JPanel();
		ph.setOpaque(false);
		ph.setMinimumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));
		ph.setMaximumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));
		ph.setPreferredSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));

		contentPanel.add(ph, BorderLayout.EAST);

		// Adjust Volume
		JPanel av = new JPanel(new GridLayout(5, 1));
		av.setOpaque(false);
		JPanel emptyPanel3 = new JPanel();
		JPanel emptyPanel4 = new JPanel();
		JPanel emptyPanel5 = new JPanel();
		emptyPanel3.setOpaque(false);
		emptyPanel4.setOpaque(false);
		emptyPanel5.setOpaque(false);
		av.add(emptyPanel3);
		av.setMinimumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));
		av.setMaximumSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));
		av.setPreferredSize(new Dimension(Constants.RESOLUTION_WIDTH / 3,
				Constants.RESOLUTION_HEIGHT - titleHeight));

		contentPanel.add(av, BorderLayout.CENTER);

		// Grid with the sound sliders

		bgMusicSlider = new JSlider(JSlider.HORIZONTAL, 0, 100,
				(int) (s.getBgVolume() * 100.0));
		bgMusicSlider.setOpaque(false);
		bgMusicSlider.addChangeListener(this);
		bgMusicSlider.setMajorTickSpacing(25);
		bgMusicSlider.setMinorTickSpacing(10);
		bgMusicSlider.setPaintTicks(true);
		bgMusicSlider.setPaintLabels(true);

		av.add(bgMusicSlider);

		av.add(emptyPanel5);

		sfxSlider = new JSlider(JSlider.HORIZONTAL, 0, 100,
				(int) (s.getSfxVolume() * 100.0));
		sfxSlider.setOpaque(false);
		sfxSlider.addChangeListener(this);
		sfxSlider.setMajorTickSpacing(25);
		sfxSlider.setMinorTickSpacing(10);
		sfxSlider.setPaintTicks(true);
		sfxSlider.setPaintLabels(true);

		av.add(sfxSlider);
		av.add(emptyPanel4);
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
