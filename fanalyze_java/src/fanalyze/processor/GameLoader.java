package fanalyze.processor;

import java.util.Vector;


import fanalyze.datasource.Almanac;
import fanalyze.datasource.Game;
import fanalyze.datasource.NFLDB;
import fanalyze.utilities.SystemUtils;

public class GameLoader {
	
	private static GameLoader instance;
	
	public GameLoader() {
	}
	
	public static GameLoader getInstance() {
		if (instance == null) {
			instance = new GameLoader();
		}
		return instance;
	}
	
	public void loadHistory() {
		System.out.println("Loading History");
		
		NFLDB db = new NFLDB();
		
		Vector<String> weeksGames = db.getWeeksGames(2016, "Regular", 4);
		
		for (String x : weeksGames) {
		
			Game g = new Game(x);
			
			Vector<String> seasons = new Vector<String>();
			
			// Get the past 5 years of history
			int currentYear = SystemUtils.getCurrentYearMinValue();
			
			seasons.add(String.valueOf(currentYear));
			seasons.add(String.valueOf(currentYear+1));
			seasons.add(String.valueOf(currentYear+2));
			seasons.add(String.valueOf(currentYear+3));
			seasons.add(String.valueOf(currentYear+4));
			seasons.add(String.valueOf(currentYear+5));
			
			//Get the game's history
			Vector<String> gameHistory = db.getGameHistory(seasons, "Regular", 
											g.getHomeTeamName(), g.getAwayTeamName());
			for (String y : gameHistory) {
				Game newGame = new Game(y);
				Almanac.getInstance().addHistoricGame(newGame);
			}
		}
			
		for (Game g : Almanac.getInstance().getHistoricalGames()) {
			
			String homeTeam = g.getHomeTeamName();
			String awayTeam = g.getAwayTeamName();
			
			int season = g.getSeason();
			int week = g.getWeek();

			Vector<String> gamePlayerHistory = 
					db.getPlayerData(season,"Regular",week,homeTeam,awayTeam);
		
			for (String z : gamePlayerHistory) {
				g.setPlayerData(z);
			}
			
		}
	
		System.out.println("History Loaded");
		
	}
	
	public void loadCurrent() {
		
		System.out.println("Loading Current");
		
		NFLDB db = new NFLDB();
		
		Vector<String> allGames = db.getGamesPlayedThisYear();
		
		for (String x : allGames) {
			
			Game g = new Game(x);
			
			String homeTeam = g.getHomeTeamName();
			String awayTeam = g.getAwayTeamName();
			
			int season = g.getSeason();
			int week = g.getWeek();
	
			Vector<String> gamePlayerHistory = 
						db.getPlayerData(season,"Regular",week,homeTeam,awayTeam);
			
			for (String z : gamePlayerHistory) {
				g.setPlayerData(z);
			}
		
			Almanac.getInstance().addSingleSeasonEntry(String.valueOf(season), g);
			
		}
		System.out.println("Current Year Loaded");
	}
}
