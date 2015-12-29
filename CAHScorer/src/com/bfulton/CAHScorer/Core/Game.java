package com.bfulton.CAHScorer.Core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Game {
	private ArrayList<Player> players;
	
	public Game() {
		players = new ArrayList<Player>();
	}
	
	public Game(Player[] players) {
		this();
		
		for(Player p : players) {
			this.players.add(p);
		}
	}
	
	public Game(Collection<Player> players) {
		this.players = new ArrayList<Player>(players);
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
}
