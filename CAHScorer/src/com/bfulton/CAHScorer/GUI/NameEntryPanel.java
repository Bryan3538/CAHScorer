package com.bfulton.CAHScorer.GUI;

import javax.swing.JPanel;

import com.bfulton.CAHScorer.Core.Game;
import com.bfulton.CAHScorer.Core.Player;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NameEntryPanel extends JPanel {
	private CAHScorerFrame parent;
	private Game game;
	JTextArea namesTextArea;
	
	/**
	 * Create the panel.
	 */
	public NameEntryPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{33, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE, 0.0};
		setLayout(gridBagLayout);
		
		JLabel titleLabel = new JLabel("Cards Against Humanity Scorer");
		titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.gridwidth = 3;
		gbc_titleLabel.insets = new Insets(0, 0, 0, 0);
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 0;
		add(titleLabel, gbc_titleLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		namesTextArea = new JTextArea();
		scrollPane.setViewportView(namesTextArea);
		
		JLabel instructionsLabel = new JLabel("Enter the names of the players. One name per line.");
		instructionsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		instructionsLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		GridBagConstraints gbc_instructionsLabel = new GridBagConstraints();
		gbc_instructionsLabel.gridwidth = 3;
		gbc_instructionsLabel.anchor = GridBagConstraints.WEST;
		gbc_instructionsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_instructionsLabel.gridx = 0;
		gbc_instructionsLabel.gridy = 1;
		add(instructionsLabel, gbc_instructionsLabel);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.anchor = GridBagConstraints.EAST;
		gbc_buttonPanel.gridx = 2;
		gbc_buttonPanel.gridy = 5;
		add(buttonPanel, gbc_buttonPanel);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				namesTextArea.setText("");
				namesTextArea.requestFocus();
			}
		});
		buttonPanel.add(resetButton);
		
		JButton nextButton = new JButton("Next >");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!namesTextArea.getText().trim().isEmpty()) {
					for(String name : namesTextArea.getText().split("\n")) {
						game.addPlayer(new Player(name));
					}
					
					parent.showScoringPanel();
				} else {
					JOptionPane.showMessageDialog(parent, 
							"You cannot leave the text area blank! You must enter some names.",
							"No names!",
							JOptionPane.ERROR_MESSAGE
					);
				}
			}
		});
		buttonPanel.add(nextButton);
		parent = null;
		game = null;
		
		this.setPreferredSize(new Dimension(400, 300));
	}
	
	public NameEntryPanel(CAHScorerFrame parent) {
		this();
		this.parent = parent;
	}
	
	public NameEntryPanel(CAHScorerFrame parent, Game game) {
		this(parent);
		this.game = game;
	}

	public void setGame(Game game) {
		this.game = game;
		namesTextArea.setText("");
		namesTextArea.requestFocus();
	}
	
	public void setParent(CAHScorerFrame parent) {
		this.parent = parent;
	}
}
