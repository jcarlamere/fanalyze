package fanalyze.datasource;

public class Player {
	
	private String playerName;
	private String position;
	private int passingYards;
	private int rushingYards;
	private int receivingYards;
	private int points;
	private int rushingTDS;
	private int receivingTDS;
	private int passingTDS;
	private int interceptions;
	private int fumbles;
	private int puntReturnYards;
	private int puntReturnTDS;
	
	public Player(String[] playerData) {
		playerName = playerData[0];
		position   = playerData[2];
		passingYards = Integer.parseInt(playerData[6]);
		rushingYards = Integer.parseInt(playerData[7]);
		points = Integer.parseInt(playerData[8]);
		rushingTDS = Integer.parseInt(playerData[9]);
		receivingTDS = Integer.parseInt(playerData[10]);
		receivingYards = Integer.parseInt(playerData[11]);
		passingTDS = Integer.parseInt(playerData[12]);
		interceptions = Integer.parseInt(playerData[13]);
		fumbles = Integer.parseInt(playerData[14]);
		puntReturnYards = Integer.parseInt(playerData[15]);
		puntReturnTDS = Integer.parseInt(playerData[16]);
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public int getPassingYards() {
		return passingYards;
	}
	public int getRushingYards() {
		return rushingYards;
	}
	public int getPoints() {
		return points;
	}
	public int getRushingTds() {
		return rushingTDS;
	}
	public int getReceivingYards() {
		return receivingYards;
	}
	public int getPassingTds() {
		return passingTDS;
	}
	public int getInterceptions() {
		return interceptions;
	}
	public int getFumbles() {
		return fumbles;
	}
	public int getPuntReturnYards() {
		return puntReturnYards;
	}
	public int getPuntReturnTds() {
		return puntReturnTDS;
	}
	public String getPosition() {
		return position;
	}
	public int getReceivingTds() {
		return receivingTDS;
	}
	
	public String toString() {
		StringBuffer playerStr = new StringBuffer();
		playerStr.append("NAME ");
		playerStr.append(getPlayerName());
		playerStr.append(" POSITION ");
		playerStr.append(getPosition());
		playerStr.append(" PASSING YARDS ");
		playerStr.append(getPassingYards());
		playerStr.append(" RUSHING YARDS ");
		playerStr.append(getRushingYards());
		playerStr.append(" RECEIVING YARDS ");
		playerStr.append(getReceivingYards());
		playerStr.append(" PUNT RETURN YARDS ");
		playerStr.append(getPuntReturnYards());
		playerStr.append(" PASSING TDS ");
		playerStr.append(getPassingTds());
		playerStr.append(" RUSHING TDS ");
		playerStr.append(getRushingTds());
		playerStr.append(" RECEIVING TDS ");
		playerStr.append(getReceivingTds());
		playerStr.append(" POINTS ");
		playerStr.append(getPoints());
		playerStr.append(" PUNT RETURN TDS ");
		playerStr.append(getPuntReturnTds());
		playerStr.append(" FUMBLES ");
		playerStr.append(getFumbles());
		playerStr.append(" INTERCEPTIONS ");
		playerStr.append(getInterceptions());
		
		return playerStr.toString();
	}
	

}
