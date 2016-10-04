package fanalyze.analyzer;

import java.util.Vector;

import fanalyze.datasource.Game;

public abstract class PlayerAnalyzer {
	
	protected abstract void analyzeGames(Vector<Game> games);
	public abstract void analyzePlayers();

}
