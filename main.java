import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;


//schedule, playoffs, check ind player stats at end of season

public class main {

	static Team Fireballs = new Team(Pitchers.marioPitchers, Batters.mario, "Fireballs", 0, 0, 0, 0, 0, 0, 0);
	static Team Monsters = new Team(Pitchers.bowserPitchers, Batters.bowser, "Monsters", 0, 0, 0, 0, 0, 0, 0);
	static Team Roses = new Team(Pitchers.peachPitchers, Batters.peach, "Roses", 0, 0, 0, 0, 0, 0, 0);
	static Team Garlics = new Team(Pitchers.warioPitchers, Batters.wario, "Garlics", 0, 0, 0, 0, 0, 0, 0);
	static Team Explorers = new Team(Pitchers.dkPitchers, Batters.dk, "Explorers", 0, 0, 0, 0, 0, 0, 0);
	static Team Eggs = new Team(Pitchers.yoshiPitchers, Batters.yoshi, "Eggs", 0, 0, 0, 0, 0, 0, 0);

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

		printTeamSeasonStats(teams);
	}

	public static void printTeamSeasonStats(HashMap<Integer, Team> teams) {
		DecimalFormat df = new DecimalFormat("#.###");
		System.out.println();
		System.out.printf("%-10s %-6s %-6s %-7s %-5s %-5s %-5s", "Team Name", "Wins", "Losses", " PCT", "RS", "RA",
				"RD");
		HashMap<Team, Double> standings = new HashMap<Team, Double>();
		for (Team x : teams.values()) {
			standings.put(x, x.winPct); 
		}
		sortHashMapByValues(standings);
		//for (Team x : teams.values()) {
		//	printBattingStats(x); 
		//}
	}
	
	public static void printBattingStats(Team Team) {
		for(Player x : Team.batters) {
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
			System.out.println(Team.teamName + " stats:");
			System.out.printf("%15s %10s %10s %10s %10s %10s %10s %10s", "PlayerName", "Hits-AtBats", "Singles", "Doubles",
					"Triples", "Homeruns", "Walks", "RBIs");
			for (int i = 1; i <= 9; i++) {
				System.out.println();
				Player lead = Team.getBatters().element();
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
				Team.batters.remove(lead);
			}
	
			System.out.println();
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------");
			System.out.printf("%15s %10s %10s %10s %10s %10s %10s %10s", "Total", hits + "-" + atBats, singles, doubles, triples,
					homeruns, walks, rbi);
			battingAvg = (double) hits / (double) atBats;
			System.out.println();
			System.out.printf("Value: %.3f", battingAvg);
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
			System.out.println();
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------");
			System.out.printf("%15s %10s %10s %10s %10s %10s %10s %10s", "Total", hits + "-" + atBats, singles, doubles, triples,
					homeruns, walks, rbi);
			battingAvg = (double) hits / (double) atBats;
			System.out.println();
			System.out.printf("Value: %.3f", battingAvg);
		}
	}
//	public static void seasonStat (Team team) {
//		for(Player x : team.batters) {
//			x.seasonAtBats += x.numAtBats;
//			x.setNumAtBats(0);
//			
//		}
//	}
	public static <T> LinkedHashMap<Team, Double> sortHashMapByValues(
	        HashMap<Team, Double> passedMap) {
	    List<Team> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<Double> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapValues, Collections.reverseOrder());

	    LinkedHashMap<Team, Double> sortedMap =
	        new LinkedHashMap<>();

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
	

}
