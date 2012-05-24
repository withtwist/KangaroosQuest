package se.chalmers.kangaroo.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class FinishedView extends JPanelWithBackground{
	
	private JLabel btnNewGame;
	private JLabel exitButton;
	
	public FinishedView(final ChangeView cv) {
		super("resources/gfx/misc/victory_background.png");
		setSize(new Dimension(1024,576));
		setPreferredSize(new Dimension(1024,576));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblCongratulations = new JLabel("Congratulations!");
		lblCongratulations.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblCongratulations.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCongratulations, BorderLayout.NORTH);
		
		JTextArea txtrByFinishingThis = new JTextArea();
		txtrByFinishingThis.setOpaque(false);
		txtrByFinishingThis.setWrapStyleWord(true);
		txtrByFinishingThis.setLineWrap(true);
		txtrByFinishingThis.setEditable(false);
		txtrByFinishingThis.setAlignmentX(CENTER_ALIGNMENT);
		txtrByFinishingThis.setText("\n\n\n\n\n\n\n"+"By finishing this game you establish yourself as a true nerd and a pr0 g4m3r. Now the question is, can you do it faster?");
		txtrByFinishingThis.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(txtrByFinishingThis, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel lblCreators = new JLabel("Creators:");
		panel.add(lblCreators);
		
		JLabel lblSeanPavlov = new JLabel("Sean Pavlov");
		panel.add(lblSeanPavlov);
		
		JLabel lblHenrikAlburg = new JLabel("Henrik Alburg");
		panel.add(lblHenrikAlburg);
		
		JLabel lblSimonAlmgren = new JLabel("Simon Almgren");
		panel.add(lblSimonAlmgren);
		
		JLabel lblArvidKarlsson = new JLabel("Arvid Karlsson");
		panel.add(lblArvidKarlsson);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		add(panel_1, BorderLayout.SOUTH);
		
		btnNewGame = new JLabel();
		btnNewGame.setIcon(new ImageIcon("resources/gfx/buttons/newgame.png"));
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewGame.setIcon(new ImageIcon("resources/gfx/buttons/newgame_onSelect.png"));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnNewGame.setIcon(new ImageIcon("resources/gfx/buttons/newgame.png"));
				cv.gameView();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewGame.setIcon(new ImageIcon("resources/gfx/buttons/newgame_onHover.png"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnNewGame.setIcon(new ImageIcon("resources/gfx/buttons/newgame.png"));
			}
		});
		panel_1.add(btnNewGame);
		
		exitButton = new JLabel();
		exitButton.setIcon(new ImageIcon("resources/gfx/buttons/exitgame.png"));
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				exitButton.setIcon(new ImageIcon("resources/gfx/buttons/exitgame_onSelect.png"));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				exitButton.setIcon(new ImageIcon("resources/gfx/buttons/exitgame.png"));
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				exitButton.setIcon(new ImageIcon("resources/gfx/buttons/exitgame_onHover.png"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				exitButton.setIcon(new ImageIcon("resources/gfx/buttons/exitgame.png"));
			}
		
		});
		JPanel space = new JPanel();
		space.setSize(75, 1);
		space.setOpaque(false);
		panel_1.add(space);
		panel_1.add(exitButton);
	}
}


