import java.text.DecimalFormat;
import java.util.HashMap;

//PCT to sort teams, schedule, playoffs, check ind player stats at end of season

public class main {

	static Team Fireballs = new Team(Pitchers.marioPitchers, Batters.mario, "Fireballs", 0, 0, 0, 0, 0, 0);
	static Team Monsters = new Team(Pitchers.bowserPitchers, Batters.bowser, "Monsters", 0, 0, 0, 0, 0, 0);
	static Team Roses = new Team(Pitchers.peachPitchers, Batters.peach, "Roses", 0, 0, 0, 0, 0, 0);
	static Team Garlics = new Team(Pitchers.warioPitchers, Batters.wario, "Garlics", 0, 0, 0, 0, 0, 0);
	static Team Explorers = new Team(Pitchers.dkPitchers, Batters.dk, "Explorers", 0, 0, 0, 0, 0, 0);
	static Team Eggs = new Team(Pitchers.yoshiPitchers, Batters.yoshi, "Eggs", 0, 0, 0, 0, 0, 0);

	public static void main(String[] args) {
		HashMap<Integer, Team> teams = new HashMap<Integer, Team>();
		teams.put(1, Fireballs);
		teams.put(2, Monsters);
		teams.put(3, Roses);
		teams.put(4, Garlics);
		teams.put(5, Explorers);
		teams.put(6, Eggs);

		Batters.addBatters();
		Pitchers.addPitcher();

		for (int i = 1; i < 4; i++) {
			runSeasonGame.runSeasonGame(Fireballs, Roses);
			runSeasonGame.runSeasonGame(Eggs, Explorers);
			runSeasonGame.runSeasonGame(Monsters, Garlics);
		}

		printTeamSeasonStats(teams);
	}

	public static void printTeamSeasonStats(HashMap<Integer, Team> teams) {
		DecimalFormat df = new DecimalFormat("#.###");
		System.out.println();
		System.out.printf("%-10s %-6s %-6s %-7s %-5s %-5s %-5s", "Team Name", "Wins", "Losses", " PCT", "RS", "RA",
				"RD");
		for (Team x : teams.values()) {
			System.out.println();
			System.out.printf("%-10s %-6s %-6s %-7s %-5s %-5s %-5s", x.teamName, "  " + x.numWins, "  " + x.numLoss,
					df.format((x.numWins / (double) x.gamesPlayed)), x.RS, x.RA, x.RD);
		}
	}
//	public static void seasonStat (Team team) {
//		for(Player x : team.batters) {
//			x.seasonAtBats += x.numAtBats;
//			x.setNumAtBats(0);
//			
//		}
//	}

}
