package fanalyze.processor.unit;

import fanalyze.analyzer.PlayerAnalyzer;
import fanalyze.analyzer.QBAnalyzer;
import fanalyze.processor.GameLoader;

public class ProcessorTester {
	public static void main(String args[]) {
		GameLoader loader = GameLoader.getInstance();
		loader.loadHistory();
		loader.loadCurrent();
		PlayerAnalyzer qb = new QBAnalyzer();
		qb.analyzePlayers();
	}

	

}
