package com.bfulton.CAHScorer.GUI;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bfulton.CAHScorer.Core.Game;

public class CAHScorerFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout cards;
	private Game game;
	private ScoringPanel scoringPanel;
	private NameEntryPanel namePanel;
	private final String NAME_ENTRY_PANEL = "names";
	private final String SCORING_PANEL = "scores";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CAHScorerFrame frame = new CAHScorerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CAHScorerFrame() {
		setTitle("CAH Scorer");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cards = new CardLayout(5, 5);
		contentPane.setLayout(cards);
		
		namePanel = new NameEntryPanel(this);
		contentPane.add(namePanel, NAME_ENTRY_PANEL );
		scoringPanel = new ScoringPanel(this);
		contentPane.add(scoringPanel, SCORING_PANEL);
		startNewGame();
	}
	
	public void startNewGame() {
		game = new Game();
		namePanel.setGame(game);
		scoringPanel.setGame(game);
		cards.show(contentPane, NAME_ENTRY_PANEL);
	}

	public void showScoringPanel() {
		scoringPanel.setGame(game);
		
		cards.show(contentPane, SCORING_PANEL);
	}

}
