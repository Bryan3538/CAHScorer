package com.bfulton.CAHScorer.Core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Game {
	private LinkedList<Player> players;
	
	public Game() {
		players = new LinkedList<Player>();
	}
	
	public Game(Player[] players) {
		this();
		
		for(Player p : players) {
			this.players.add(p);
		}
	}
	
	public Game(Collection<Player> players) {
		this.players = new LinkedList<Player>(players);
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	public int getNumberOfPlayers() {
		return this.players.size();
	}
	
	public void addPlayer(Player p) {
		this.players.add(p);
	}
	
	public boolean removePlayer(Player p) {
		return players.remove(p);
	}
	
	public Player getCurrentWinner() {
		Player winner = null;
		int maxScore = -1;
		
		for(Player p : players){
			if(p.getScore() > maxScore) {
				maxScore = p.getScore();
				winner = p;
			}
		}
		
		return winner;
	}
	
	@Override
	public boolean equals(Object other) {
		boolean equal = true;
		
		if (other instanceof Game) {
			Game otherGame = (Game) other;
			
			if(this.players.size() != otherGame.players.size()) {
				equal = false;
			} else {
				for(int i = 0; i < players.size(); i++) {
					equal = equal && this.players.get(i).equals(otherGame.players.get(i));
					if(!equal)
						break;
				}
			}
		} else {
			equal = false;
		}
		
		return equal;
	}
}
