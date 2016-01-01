package com.bfulton.CAHScorer.Core;

public class Player {
	private String name;
	private int score;
	
	public Player() {
		name = "Player";
		score = 0;
	}
	
	public Player(String name) {
		this();
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(!name.isEmpty())
			this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		if(score >= 0) {
			this.score = score;
		} else {
			this.score = 0;
		}
	}

	public void addPoints(int points) {
		if(points > 0)
			score += points;
	}
	
	public void subtractPoints(int points) {
		if(points > 0)
			score -= points;
		
		if(score < 0)
			score = 0;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Player) {
			Player otherPlayer = (Player) other;
			return this.name.equals(otherPlayer.name) && 
					this.score == otherPlayer.score;
		} else {
			return false;
		}
	}
}
