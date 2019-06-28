import java.util.ArrayDeque;

public class Team {

	ArrayDeque<Pitcher> pitchers = new ArrayDeque<Pitcher>();
	ArrayDeque<Player> batters = new ArrayDeque<Player>();
	String teamName;
	
	public Team(ArrayDeque<Pitcher> arms, ArrayDeque<Player> bats, String name) {
		this.pitchers = arms;
		this.batters = bats;
		this.teamName = name;
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
