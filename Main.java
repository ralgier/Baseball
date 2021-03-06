import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

//schedule, playoffs, check ind player stats at end of season

public class Main {

	// create all the teams
	static Team Fireballs = new Team(Pitchers.marioPitchers, Batters.mario, "Fireballs", 0, 0, 0, 0, 0, 0, 0);
	static Team Monsters = new Team(Pitchers.bowserPitchers, Batters.bowser, "Monsters", 0, 0, 0, 0, 0, 0, 0);
	static Team Roses = new Team(Pitchers.peachPitchers, Batters.peach, "Roses", 0, 0, 0, 0, 0, 0, 0);
	static Team Garlics = new Team(Pitchers.warioPitchers, Batters.wario, "Garlics", 0, 0, 0, 0, 0, 0, 0);
	static Team Explorers = new Team(Pitchers.dkPitchers, Batters.dk, "Explorers", 0, 0, 0, 0, 0, 0, 0);
	static Team Eggs = new Team(Pitchers.yoshiPitchers, Batters.yoshi, "Eggs", 0, 0, 0, 0, 0, 0, 0);

	ArrayDeque<Team> league1 = new ArrayDeque<Team>();

	static int hrMax = 0;
	static int rbiMax = 0;
	static int hitMax = 0;
	static double batAvgMax = 0;
	static int singleMax = 0;
	static int doubleMax = 0;
	static int tripleMax = 0;
	static int walkMax = 0;
	static Team oneSeed;
	static Team twoSeed;
	static Team threeSeed;
	static Team fourSeed;
	static Team victor1;
	static Team victor2;

	public static void main(String[] args) {
		// put all the teams in hashmap for season
		HashMap<Integer, Team> teams = new HashMap<Integer, Team>();
		ArrayDeque<HashMap<Integer, Player>> league1 = new ArrayDeque<HashMap<Integer, Player>>();
		teams.put(1, Fireballs);
		teams.put(2, Monsters);
		teams.put(3, Roses);
		teams.put(4, Garlics);
		teams.put(5, Explorers);
		teams.put(6, Eggs);
		// add all the batters and pitchers (This is where we fix the stats issue -- DO
		// NOT pput this in runGame)
		Batters.addBatters();
		Pitchers.addPitcher();

		// Order all the players to print stats
		HashMap<Integer, Player> FireballsMap = orderTeam(Fireballs);
		HashMap<Integer, Player> RosesMap = orderTeam(Roses);
		HashMap<Integer, Player> GarlicsMap = orderTeam(Garlics);
		HashMap<Integer, Player> EggsMap = orderTeam(Eggs);
		HashMap<Integer, Player> MonstersMap = orderTeam(Monsters);
		HashMap<Integer, Player> ExplorersMap = orderTeam(Explorers);

		// run Games
		for (int i = 1; i < 32; i++) {
			runSeasonGame.runGame(Fireballs, Roses);
			runSeasonGame.runGame(Eggs, Explorers);
			runSeasonGame.runGame(Monsters, Garlics);
			runSeasonGame.runGame(Fireballs, Eggs);
			runSeasonGame.runGame(Roses, Garlics);
			runSeasonGame.runGame(Monsters, Explorers);
			runSeasonGame.runGame(Fireballs, Monsters);
			runSeasonGame.runGame(Eggs, Roses);
			runSeasonGame.runGame(Explorers, Garlics);
			runSeasonGame.runGame(Fireballs, Explorers);
			runSeasonGame.runGame(Eggs, Garlics);
			runSeasonGame.runGame(Monsters, Roses);
			runSeasonGame.runGame(Fireballs, Garlics);
			runSeasonGame.runGame(Eggs, Monsters);
			runSeasonGame.runGame(Roses, Explorers);
		}

		// prints individual batters
		printBattingStats(FireballsMap, Fireballs);
		printBattingStats(RosesMap, Roses);
		printBattingStats(GarlicsMap, Garlics);
		printBattingStats(MonstersMap, Monsters);
		printBattingStats(EggsMap, Eggs);
		printBattingStats(ExplorersMap, Explorers);

		// prints team standings
		printTeamSeasonStats(teams);

		// Add ordered lineups to the league
		league1.add(FireballsMap);
		league1.add(RosesMap);
		league1.add(EggsMap);
		league1.add(MonstersMap);
		league1.add(ExplorersMap);
		league1.add(GarlicsMap);
		// Find the leaders of categories
		leaders(league1);
		System.out.println();
		System.out.println();
		//PLAYOFFS
		System.out.println("Playoffs have now begun.");
		System.out.println("1 Seed: "+oneSeed.teamName);
		System.out.println("2 Seed: "+twoSeed.teamName);
		System.out.println("3 Seed: "+threeSeed.teamName);
		System.out.println("4 Seed: "+fourSeed.teamName);
		System.out.println();
		oneSeed.numWins = 0;
		twoSeed.numWins = 0;
		threeSeed.numWins = 0;
		fourSeed.numWins = 0;
		Boolean seriesOver = false;
		while(seriesOver == false) {
			runSeasonGame.runGame(fourSeed, oneSeed);
			if(oneSeed.numWins == 3) {
				victor1 = oneSeed;
				System.out.println("Series over. "+oneSeed.teamName+" have advanced.");
				seriesOver = true;
			}
			else if (fourSeed.numWins == 3) {
				victor1 = fourSeed;
				System.out.println("Series over. "+fourSeed.teamName+" have advanced.");
				seriesOver = true;
			}
		}
		seriesOver = false;
		while(seriesOver == false) {
			runSeasonGame.runGame(threeSeed, twoSeed);
			if(twoSeed.numWins == 3) {
				victor2 = twoSeed;
				System.out.println("Series over. "+twoSeed.teamName+" have advanced.");
				seriesOver = true;
			}
			else if (threeSeed.numWins == 3) {
				victor2 = threeSeed;
				System.out.println("Series over. "+threeSeed.teamName+" have advanced.");
				seriesOver = true;
			}
		}
		seriesOver = false;
		while(seriesOver == false) {
			runSeasonGame.runGame(victor2, victor1);
			if(victor1.numWins == 7) {
				System.out.println("Series over. "+victor1.teamName+" have won it all.");
				seriesOver = true;
			}
			else if (victor2.numWins == 7) {
				System.out.println("Series over. "+victor2.teamName+" have won it all.");
				seriesOver = true;
			}
		}
	}

	// method to print season stats
	public static void printTeamSeasonStats(HashMap<Integer, Team> teams) {
		System.out.println();
		System.out.printf("%-10s %-6s %-6s %-7s %-5s %-5s %-5s", "Team Name", "Wins", "Losses", " PCT", "RS", "RA",
				"RD");
		HashMap<Team, Double> standings = new HashMap<Team, Double>();
		for (Team x : teams.values()) {
			standings.put(x, x.winPct);
		}
		// calls sorting method
		sortHashMapByValues(standings);
	}

	// method to sort the teams by win pct
	public static <T> LinkedHashMap<Team, Double> sortHashMapByValues(HashMap<Team, Double> passedMap) {
		List<Team> mapKeys = new ArrayList<>(passedMap.keySet());
		List<Double> mapValues = new ArrayList<>(passedMap.values());
		Collections.sort(mapValues, Collections.reverseOrder());

		LinkedHashMap<Team, Double> sortedMap = new LinkedHashMap<>();

		Iterator<Double> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Double val = valueIt.next();
			Iterator<Team> keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				Team key = keyIt.next();
				Double comp1 = passedMap.get(key);
				Double comp2 = val;

				if (comp1.equals(comp2)) {
					keyIt.remove();
					sortedMap.put(key, val);
					break;
				}
			}
		}
		for (Team x : sortedMap.keySet()) {
			System.out.println();
			DecimalFormat df = new DecimalFormat("#.###");
			System.out.printf("%-10s %-6s %-6s %-7s %-5s %-5s %-5s", x.teamName, "  " + x.numWins, "  " + x.numLoss,
					df.format(x.winPct), x.RS, x.RA, x.RD);
		}
		return sortedMap;
	}

	// prints individual stats method (one team at a time)
	public static void printBattingStats(HashMap<Integer, Player> teamMap, Team team) {

		int hits = 0;
		int atBats = 0;
		int singles = 0;
		int doubles = 0;
		int triples = 0;
		int homeruns = 0;
		int walks = 0;
		int rbi = 0;
		double battingAvg;

		System.out.println();
		System.out.println(team.teamName + " stats:");
		System.out.printf("%15s %10s %10s %10s %10s %10s %10s %10s", "PlayerName", "Hits-AtBats", "Singles", "Doubles",
				"Triples", "Homeruns", "Walks", "RBIs");
		for (int i = 1; i <= 9; i++) {
			System.out.println();
			Player lead = teamMap.get(i);
			System.out.printf("%15s %10s %10s %10s %10s %10s %10s %10s", lead.name, lead.numHits + "-" + lead.numAtBats,
					lead.numSingles, lead.numDoubles, lead.numTriples, lead.numHomeruns, lead.numWalks, lead.rbi);
			hits += lead.numHits;
			atBats += lead.numAtBats;
			singles += lead.numSingles;
			doubles += lead.numDoubles;
			triples += lead.numTriples;
			homeruns += lead.numHomeruns;
			walks += lead.numWalks;
			rbi += lead.rbi;
		}

		System.out.println();
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------");
		System.out.printf("%15s %10s %10s %10s %10s %10s %10s %10s", "Total", hits + "-" + atBats, singles, doubles,
				triples, homeruns, walks, rbi);
		battingAvg = (double) hits / (double) atBats;
		System.out.println();
		System.out.printf("Team Average: %.3f", battingAvg);
		System.out.println();
		System.out.println();
		hits = 0;
		atBats = 0;
		singles = 0;
		doubles = 0;
		triples = 0;
		homeruns = 0;
		walks = 0;
		rbi = 0;
	}

	// method to order the teams by batting order
	public static HashMap<Integer, Player> orderTeam(Team team) {
		HashMap<Integer, Player> teamMap = new HashMap<Integer, Player>();
		for (Player lead : team.batters) {
			int a = lead.orderNum;
			teamMap.put(a, lead);
		}
		return teamMap;
	}

	// Method to get batting leaders in stats categories
	public static void leaders(ArrayDeque<HashMap<Integer, Player>> league) {

		// create lists to add the leaders in each category to
		ArrayList<Player> HRLeaders = new ArrayList<Player>();
		ArrayList<Player> RBILeaders = new ArrayList<Player>();
		ArrayList<Player> HitLeaders = new ArrayList<Player>();
		ArrayList<Player> BattingAvgLeaders = new ArrayList<Player>();
		ArrayList<Player> SingleLeaders = new ArrayList<Player>();
		ArrayList<Player> DoubleLeaders = new ArrayList<Player>();
		ArrayList<Player> TripleLeaders = new ArrayList<Player>();
		ArrayList<Player> WalkLeaders = new ArrayList<Player>();

		int leagueSize = league.size();

		DecimalFormat df = new DecimalFormat("#.###");
		for (int i = 0; i < leagueSize; i++) {
			for (int j = 1; j <= 9; j++) {
				Player x = league.getFirst().get(j);
				int hrTemp = x.numHomeruns;
				int rbiTemp = x.rbi;
				int hitTemp = x.numHits;
				double batAvgTemp = ((double) x.numHits / (double) x.numAtBats);
				int singleTemp = x.numSingles;
				int doubleTemp = x.numDoubles;
				int tripleTemp = x.numTriples;
				int walkTemp = x.numWalks;

				if (hrTemp > hrMax || hrTemp == hrMax) {
					hrMax = hrTemp;
					HRLeaders.add(x);
				}
				if (rbiTemp > rbiMax || rbiTemp == rbiMax) {
					rbiMax = rbiTemp;
					RBILeaders.add(x);
				}
				if (hitTemp > hitMax || hitTemp == hitMax) {
					hitMax = hitTemp;
					HitLeaders.add(x);
				}
				if (batAvgTemp > batAvgMax || batAvgTemp == batAvgMax) {
					batAvgMax = batAvgTemp;
					BattingAvgLeaders.add(x);
				}
				if (singleTemp > singleMax || singleTemp == singleMax) {
					singleMax = singleTemp;
					SingleLeaders.add(x);
				}
				if (doubleTemp > doubleMax || doubleTemp == doubleMax) {
					doubleMax = doubleTemp;
					DoubleLeaders.add(x);
				}
				if (tripleTemp > tripleMax || tripleTemp == tripleMax) {
					tripleMax = tripleTemp;
					TripleLeaders.add(x);
				}
				if (walkTemp > walkMax || walkTemp == walkMax) {
					walkMax = walkTemp;
					WalkLeaders.add(x);
				}
			}
			league.remove();
		}

		System.out.println();
		System.out.println("Season Leaders: ");

		System.out.print("HR Leaders with " + hrMax + " homeruns:				");
		for (Player test : HRLeaders) {
			if (test.numHomeruns == hrMax) {
				System.out.print(test.name + " ");
			}
		}
		System.out.println();
		System.out.print("Single Leaders with " + singleMax + " singles:			");
		for (Player test : SingleLeaders) {
			if (test.numSingles == singleMax) {
				System.out.print(test.name + " ");
			}
		}
		System.out.println();
		System.out.print("Double Leaders with " + doubleMax + " doubles:				");
		for (Player test : DoubleLeaders) {
			if (test.numDoubles == doubleMax) {
				System.out.print(test.name + " ");
			}
		}
		System.out.println();
		System.out.print("Triple Leaders with " + tripleMax + " triples:				");
		for (Player test : TripleLeaders) {
			if (test.numTriples == tripleMax) {
				System.out.print(test.name + " ");
			}
		}
		System.out.println();
		System.out.print("Walk Leaders with " + walkMax + " walks:				");
		for (Player test : WalkLeaders) {
			if (test.numWalks == walkMax) {
				System.out.print(test.name + " ");
			}
		}
		System.out.println();
		System.out.print("RBI Leaders with " + rbiMax + " RBIs:				");
		for (Player test : RBILeaders) {
			if (test.rbi == rbiMax) {
				System.out.print(test.name + " ");
			}
		}
		System.out.println();
		System.out.print("Hit Leaders with " + hitMax + " hits:				");
		for (Player test : HitLeaders) {
			if (test.numHits == hitMax) {
				System.out.print(test.name + " ");
			}
		}
		System.out.println();
		System.out.printf("Batting Average Leaders with a " + df.format(batAvgMax) + " batting average:	");
		for (Player test : BattingAvgLeaders) {
			double batAvgTemp = ((double) test.numHits / (double) test.numAtBats);
			if (batAvgTemp == batAvgMax) {
				System.out.print(test.name + " ");
			}
		}
		System.out.println();
	}


}
