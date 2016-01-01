package com.bfulton.CAHScorer.GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoringButtonsPanel extends JPanel {
	/**
	 * Create the panel.
	 */
	private ScoringButtonsPanel() {
		
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(newGameButton);
		
		JButton resetGameButton = new JButton("Reset Game");
		resetGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(resetGameButton);

	}
}
