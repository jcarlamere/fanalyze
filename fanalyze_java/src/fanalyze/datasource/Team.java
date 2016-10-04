package fanalyze.datasource;

import java.util.HashMap;
import java.util.Vector;

public class Team {
	
	private String teamName;
	private HashMap<String, Vector<Player>> players = new HashMap<String, Vector<Player>>();
	private int points;
	
	public Team(String teamName, int points) {
		
		this.teamName = teamName;
		this.points   = points;
	}
	
	public void addPlayer(Player thePlayer) {
		Vector <Player> v;
		
		String pos = thePlayer.getPosition();
		
		if (players.containsKey(pos)) {
			v = players.get(pos);
			v.add(thePlayer);
			players.put(pos, v);
		}
		else {
			v = new Vector<Player>();
			v.add(thePlayer);
			players.put(pos, v);
		}
	}
	
	public HashMap<String, Vector<Player>> getPlayers() {
		return players;
	}
	
	public int getPointsScored() {
		return points;
	}
	
	public String getTeamName() {
		return teamName;
	}
}
