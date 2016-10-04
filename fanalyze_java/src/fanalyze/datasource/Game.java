package fanalyze.datasource;

public class Game {

	private int year;
	private int week;
	private String homeTeamName;
	private String awayTeamName;
	private Team homeTeam;
	private Team awayTeam;
	
	public Game(String gameSpecifics) {
		String[] gameSp = gameSpecifics.split("\\s+");
		
		year = Integer.parseInt(gameSp[1]);
		week = Integer.parseInt(gameSp[3]);
		
		awayTeamName = gameSp[8];
		String awayPointsStr = gameSp[9];
		
		int index1 = awayPointsStr.indexOf('(');
		int index2 = awayPointsStr.lastIndexOf(')');
		
		int awayPoints = Integer.parseInt(awayPointsStr.substring(index1+1,index2));
		
		homeTeamName = gameSp[11];
		String homePointsStr = gameSp[12];
		
		index1 =  homePointsStr.indexOf('(');
		index2 =  homePointsStr.lastIndexOf(')');
		
		int homePoints = Integer.parseInt(homePointsStr.substring(index1+1,index2));
		
		homeTeam = new Team(homeTeamName, homePoints);
		awayTeam = new Team(awayTeamName, awayPoints);
	}
	
	public String getHomeTeamName() {
		return homeTeamName;
	}
	public String getAwayTeamName() {
		return awayTeamName;
	}
	
	public Team getHomeTeam() {
		return homeTeam;
	}
	public Team getAwayTeam() {
		return awayTeam;
	}
	
	public int getWeek() {
		return week; 
	}
	public int getSeason() {
		return year;
	}
	
	public void setPlayerData(String data) {
		
		String[] keyvalue = data.split(":");
		Player p = new Player (keyvalue);
		String team = keyvalue[1];
		
		if (team.equalsIgnoreCase(homeTeamName)) {
			homeTeam.addPlayer(p);
		}
		else if (team.equalsIgnoreCase(awayTeamName)) {
			awayTeam.addPlayer(p);
		}
	}
	
	public String toString() {
		return awayTeam.getTeamName()+" @ "+homeTeam.getTeamName()+" ";
	}
}
