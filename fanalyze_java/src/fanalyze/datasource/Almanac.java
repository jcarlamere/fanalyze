package fanalyze.datasource;

import java.util.HashMap;
import java.util.Vector;

public class Almanac {

	private Vector<Game> historicalGames;
	private static Almanac instance;
	private HashMap<Integer,Vector<Game>> singleSeason;
	
	public Almanac() {
		historicalGames = new Vector<Game>();
		singleSeason    = new HashMap<Integer, Vector<Game>>();
	}
	
	public static Almanac getInstance() {
		if (instance == null) {
			instance = new Almanac();
		}
		return instance;
	}
	
	public void addHistoricGame(Game g) {
		historicalGames.addElement(g);
	}
	
	public Vector<Game> getHistoricalGames() {
		return historicalGames;
	}
	
	public void addSingleSeasonEntry(String theYear, Game theGame) {
		Integer workingYear = new Integer(theYear);
		
		Vector<Game> theVect;
		if (singleSeason.containsKey(workingYear)) {
			theVect = singleSeason.get(workingYear);
		}
		else {
			theVect = new Vector<Game>();
		}
	
		theVect.add(theGame);
		singleSeason.put(workingYear, theVect);
	}
	
	public Vector<Game> getSingleSeason(String theYear) {
		return singleSeason.get(new Integer(theYear));
	}
}
