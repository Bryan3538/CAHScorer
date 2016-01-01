package com.bfulton.CAHScorer.GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.bfulton.CAHScorer.Core.Game;
import com.bfulton.CAHScorer.Core.Player;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ScoringPanel extends JPanel {
	Game game;
	CAHScorerFrame parent;
	List<PlayerPanel> playerViews;
	JPanel contentPane;
	
	/**
	 * Create the panel.
	 */
	public ScoringPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{400, 0};
		gridBagLayout.rowHeights = new int[]{38, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		this.setPreferredSize(new Dimension(400, 300));
		JLabel lblThisIsScoring = new JLabel("THIS IS SCORING PANEL! CLICK BUTTONS TO CHANGE SCORES!");
		GridBagConstraints gbc_lblThisIsScoring = new GridBagConstraints();
		gbc_lblThisIsScoring.insets = new Insets(0, 0, 5, 0);
		gbc_lblThisIsScoring.fill = GridBagConstraints.BOTH;
		gbc_lblThisIsScoring.gridx = 0;
		gbc_lblThisIsScoring.gridy = 0;
		add(lblThisIsScoring, gbc_lblThisIsScoring);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(contentPane);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		playerViews = new ArrayList();
		
		ScoringButtonsPanel buttonPanel = new ScoringButtonsPanel();
		GridBagConstraints gbc_buttonsPanel = new GridBagConstraints();
		gbc_buttonsPanel.fill = GridBagConstraints.VERTICAL;
		gbc_buttonsPanel.gridx = 0;
		gbc_buttonsPanel.gridy = 2;
		add(buttonPanel, gbc_buttonsPanel);
	}
	
	public ScoringPanel(CAHScorerFrame parent) {
		this();
		this.parent = parent;
	}

	public ScoringPanel(CAHScorerFrame parent, Game game) {
		this(parent);
		this.game = game;
		displayGame();
	}
	
	private void displayGame() {
		for(Player p : game.getPlayers()) {
			PlayerPanel playerPanel = new PlayerPanel(p);
			playerViews.add(playerPanel);
			contentPane.add(playerPanel);
		}
	}

	public void setGame(Game game) {
		if(game != null) {
			this.game = game;
			playerViews.clear();
			contentPane.removeAll();
			displayGame();
		} else
			throw new IllegalArgumentException("Game cannot be null!");
	}

	public Game getGame() {
		return game;
	}
	
	private class ScoringButtonsPanel extends JPanel {
		/**
		 * Create the panel.
		 */
		private ScoringButtonsPanel() {
			
			JButton newGameButton = new JButton("New Game");
			newGameButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					parent.startNewGame();
				}
			});
			add(newGameButton);
			
			JButton resetGameButton = new JButton("Reset Game");
			resetGameButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for(Player p : game.getPlayers()) {
						p.setScore(0);
					}
					
					for(PlayerPanel p : playerViews) {
						p.refreshView();
					}
				}
			});
			add(resetGameButton);

		}
	}

}


