package com.bfulton.CAHScorer.GUI;

import javax.swing.JPanel;

import com.bfulton.CAHScorer.Core.Player;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerPanel extends JPanel {

	Player player;
	JLabel nameLabel;
	JLabel scoreLabel;
	JButton addPointButton;
	JButton subtractPointButton;
	/**
	 * Create the panel.
	 */
	private PlayerPanel() {
		setLayout(new GridLayout(0, 4, 0, 0));
		
		nameLabel = new JLabel("Name");
		add(nameLabel);
		
		scoreLabel = new JLabel("Points");
		add(scoreLabel);
		
		addPointButton = new JButton("+");
		add(addPointButton);
		
		subtractPointButton = new JButton("-");
		add(subtractPointButton);

	}

	public PlayerPanel(Player player) {
		this();
		this.player = player;
		nameLabel.setText(player.getName());
		scoreLabel.setText(Integer.toString(player.getScore()));
		
		addPointButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.addPoints(1);
				scoreLabel.setText(Integer.toString(player.getScore()));
			}
		});
		
		subtractPointButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.subtractPoints(1);
				scoreLabel.setText(Integer.toString(player.getScore()));
			}
		});
	}
	
	public void refreshView() {
		nameLabel.setText(player.getName());
		scoreLabel.setText(Integer.toString(player.getScore()));
	}
}
