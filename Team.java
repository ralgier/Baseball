import java.util.ArrayDeque;

public class Team {

	ArrayDeque<Pitcher> pitchers = new ArrayDeque<Pitcher>();
	ArrayDeque<Player> batters = new ArrayDeque<Player>();
	String teamName;
	int numWins;
	int numLoss;
	int RS;
	int RA;
	int RD;
	int gamesPlayed;
	double winPct;
	
	public Team(ArrayDeque<Pitcher> arms, ArrayDeque<Player> bats, String name, int numWins, int numLoss,
			int RS, int RA, int RD, int gamesPlayed, double winPct) {
		this.pitchers = arms;
		this.batters = bats;
		this.teamName = name;
		this.numWins = numWins;
		this.numLoss = numLoss;
		this.RS = RS;
		this.RA = RA;
		this.RD = RD;
		this.gamesPlayed = gamesPlayed;
		this.winPct = winPct;
	}

	public double getWinPct() {
		return winPct;
	}

	public void setWinPct(double winPct) {
		this.winPct = winPct;
	}

	public int getNumWins() {
		return numWins;
	}

	public void setNumWins(int numWins) {
		this.numWins = numWins;
	}

	public int getNumLoss() {
		return numLoss;
	}

	public void setNumLoss(int numLoss) {
		this.numLoss = numLoss;
	}

	public int getRS() {
		return RS;
	}

	public void setRS(int rS) {
		RS = rS;
	}

	public int getRA() {
		return RA;
	}

	public void setRA(int rA) {
		RA = rA;
	}

	public int getRD() {
		return RD;
	}

	public void setRD(int rD) {
		RD = rD;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public String ToString() {
		return teamName;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public ArrayDeque<Pitcher> getPitchers() {
		return pitchers;
	}

	public void setPitchers(ArrayDeque<Pitcher> pitchers) {
		this.pitchers = pitchers;
	}

	public ArrayDeque<Player> getBatters() {
		return batters;
	}

	public void setBatters(ArrayDeque<Player> batters) {
		this.batters = batters;
	}
}
