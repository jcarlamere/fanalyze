package fanalyze.datasource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;


public class NFLDB {
	
	String season;
	String seasonType;
	String week;
	BufferedReader response;
	
	public NFLDB() {
	}
	
	public Vector<String> getWeeksGames(int theSeason, String theSeason_type, int theWeek) {
		//System.out.println("Getting weeks games");
		Vector<String> gamesV = new Vector<String>();
		try{
			season = Integer.toString(theSeason);
			seasonType = theSeason_type;
			week = Integer.toString(theWeek);
			
			ProcessBuilder pb = 
					new ProcessBuilder("python",
										"/Users/jcarlamere/eclipse/fantasyfb/fanalyze/getWeeksGames.py",
										season, seasonType, week);
			Process p = pb.start();
				
			response = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = response.readLine()) != null)
				gamesV.add(line);
			
		} catch(Exception e){
			System.out.println(e);
		}
		return gamesV;
		
	}
	
	public Vector<String> getGameHistory (Vector<String> theSeason, String theSeason_type, String homeTeam,
								  String awayTeam) {
		
		Vector<String> gamesV = new Vector<String>();
		try{
			
			seasonType = theSeason_type;
			
			ProcessBuilder pb = 
					new ProcessBuilder("python",
										"/Users/jcarlamere/eclipse/fantasyfb/fanalyze/getGameHistory.py",
										theSeason.get(0), 
										theSeason.get(1), theSeason.get(2),
										theSeason.get(3),theSeason.get(4),seasonType, homeTeam, awayTeam);
			Process p = pb.start();
				
			response = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String line;
			while ((line = response.readLine()) != null)
				gamesV.add(line);
			
		} catch(Exception e){
			System.out.println(e);
		}
		return gamesV;
									
	}
	
	public Vector<String> getPlayerData(int theSeason, String theSeason_type, 
										int theWeek, String homeTeam,
										String awayTeam) {

		Vector<String> players = new Vector<String>();
		try{
			
			seasonType = theSeason_type;
			
			ProcessBuilder pb = 
					new ProcessBuilder("python",
										"/Users/jcarlamere/eclipse/fantasyfb/fanalyze/getGameStats.py",
										String.valueOf(theSeason), "Regular", String.valueOf(theWeek), homeTeam, awayTeam);
			Process p = pb.start();
				
			response = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String line;
			while ((line = response.readLine()) != null)
				players.add(line);
			
		} catch(Exception e){
			System.out.println(e);
		}
		return players;
	}
	
	public Vector<String> getGamesPlayedThisYear() {
		
		Vector <String> gamesV = new Vector<String>();
		String seasonType = "Regular";
		String season = "2016";
		
		try{
	
			ProcessBuilder pb = 
					new ProcessBuilder("python",
									"/Users/jcarlamere/eclipse/fantasyfb/fanalyze/getWeeksGames.py",
									season, seasonType);
			Process p = pb.start();
			
			response = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String line;
			while ((line = response.readLine()) != null)
				gamesV.add(line);
			
		} catch(Exception e){
			System.out.println(e);
		}
		return gamesV;
	}
	
}
