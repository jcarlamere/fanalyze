package fanalyze.analyzer;

import java.util.HashMap;
import java.util.Vector;

import fanalyze.datasource.Almanac;
import fanalyze.datasource.Game;
import fanalyze.datasource.Player;
import fanalyze.datasource.Team;
import fanalyze.utilities.ScoreCalculator;

public class QBAnalyzer extends PlayerAnalyzer implements ScoreCalculator{

	public void analyzePlayers() {
		
		System.out.println("Analyzing QBs");
		
		analyzeGames(Almanac.getInstance().getHistoricalGames());
		analyzeGames(Almanac.getInstance().getSingleSeason("2016"));
		
	}

	@Override
	protected void analyzeGames(Vector<Game> games) {
		for (Game g : games) {
			
			Team homeTeam = g.getHomeTeam();
			Team awayTeam = g.getAwayTeam();
			
			//First do the home team
			HashMap<String, Vector<Player>> players = homeTeam.getPlayers();
			
			Object value = players.get((String) "QB");
			Vector<Player> v = null;
			if (value instanceof Vector) {
				v = (Vector<Player>) players.get((String)"QB");
			}
			
			if (v != null) {
				for (Player p : v) {
					System.out.println(g.toString() + p.getPlayerName()+" (" + homeTeam.getTeamName() + ") " +" " + calculateScore(p));
				}
			}
			
			// Now do the away team
			players = awayTeam.getPlayers();
			value = players.get((String)"QB");
			if (value instanceof Vector) {
				v = (Vector<Player>) players.get((String)"QB");
			}
			
			if (v != null) {
				for (Player p : v) {
					System.out.println(g.toString()+ p.getPlayerName()+" (" + awayTeam.getTeamName() + ") " + calculateScore(p));
				}
			}
			
			System.out.println("");
		}
	}	
	
	@Override
	public int calculateScore(Player p) {
		int passingYards = p.getPassingYards();
		int rushingYards = p.getRushingYards();
		int rushingTds   = p.getRushingTds();
		int passingTds   = p.getPassingTds();
		int picks        = p.getInterceptions();
		
		int passPts = (passingYards/25) * 1;
		int rushPts =  (rushingYards/10) * 1;
		int deductPicks = picks*1;
		int passTdPts =  passingTds*4;
		int rushTdPts = rushingTds*6;
		
		int score = passPts +  rushPts + passTdPts + rushTdPts - deductPicks;
		
		if (passingYards >= 300) {
			score = score + 1;
		}
		return score;
	}
}

