import java.util.ArrayDeque;
import java.util.Random;

public class Game {

	static boolean GameOver;

	public static void main(String[] args) {
		Random rand = new Random();
		// the essentials
		int inning = 1;
		int awayScore = 0;
		int homeScore = 0;
		int awayOut = 0;
		int homeOut = 0;
		int awayPitchCount = 0;
		int homePitchCount = 0;
		int awayPitcherStamina = 0;
		int homePitcherStamina = 0;
		int homeHits = 0;
		int homeError = 0;
		int awayHits = 0;
		int awayError = 0;
		int randSize = 0;

		// maybe more later

		// adds in all the batters to the array deques which represent the teams
		Batters.addBatters();
		Pitchers.addPitcher();
		GameOver = false;

		Team awayTeam = getTeam();
		Team homeTeam = getTeam();
		while (awayTeam.teamName.equals(homeTeam.teamName)) {
			homeTeam = getTeam();
		}

		ArrayDeque<Pitcher> homePitchers = homeTeam.getPitchers();
		ArrayDeque<Pitcher> awayPitchers = awayTeam.getPitchers();

		// Creating the ArrayDeque for the away score.
		ArrayDeque<String> awayBases = new ArrayDeque<String>();
		// Creating the ArrayDeque for the home score.
		ArrayDeque<Integer> homeBases = new ArrayDeque<Integer>();

		while (!GameOver) {
			// start the game
			// awayTeam batting
			if (inning % 2 == 1) {
				while (awayOut < 3) {
					Pitcher homePitcher = pitchChange(homePitchers);
					Player currBatter = awayTeam.batters.element();
					int value = rand.nextInt(getPitchNumber(homePitcher));
					String result = atBatResult(value, currBatter);
					System.out.println(result);
					if (result.equals("single")) {
						awayBases.add(currBatter.name);
						System.out.println("he hit single");
						homePitcher.pitchProb -= 4;
					} else if (result.equals("double")) {
						awayBases.add(currBatter.name);
						awayBases.add("0");
						System.out.println("he hit doub");
						homePitcher.pitchProb -= 8;
					} else if (result.equals("triple")) {
						awayBases.add(currBatter.name);
						awayBases.add("0");
						awayBases.add("0");
						System.out.println("he hit trip");
						homePitcher.pitchProb -= 10;
					} else if (result.equals("homerun")) {
						awayBases.add(currBatter.name);
						awayBases.add("0");
						awayBases.add("0");
						awayBases.add("0");
						System.out.println("he hit homer");
						homePitcher.pitchProb -= 12;
					} else if (result.equals("walk")) {
						String firstBase = awayBases.peekLast();
						if (firstBase == "0") {
							awayBases.pollLast();
							awayBases.add(currBatter.name);
						} else if (awayBases.size() == 3) {
							String thirdBase = awayBases.pollFirst();
							String secondBase = awayBases.pollFirst();
							if (thirdBase != "0" && secondBase == "0") {
								awayBases.add(thirdBase);
								awayBases.add(firstBase);
								awayBases.add(currBatter.name);
							}
						} else {
							awayBases.add(currBatter.name);
						}
						System.out.println("he hit walk");
						homePitcher.pitchProb -= 6;
					} else if (result.equals("out")) {
						System.out.println("he hit out");
					}
					checkScore(awayBases, awayScore);
					Player tempBatter = awayTeam.batters.remove();
					awayTeam.batters.add(tempBatter);

				}

			}
			inning++;
		}

		// homeTeam batting
		if (inning % 2 == 0)

		{
			while (awayOut < 3) {
				Pitcher awayPitcher = pitchChange(awayPitchers);

			}
			inning++;

		} // end of big while loop
	}

	// need 2 teams with their lineups and pitchers
	public static Team getTeam() {
		Random rand = new Random();
		int x = rand.nextInt(6);
		Team team = null;
		if (x == 0) {
			team = new Team(Pitchers.marioPitchers, Batters.mario, "Fireballs");
		} else if (x == 1) {
			team = new Team(Pitchers.bowserPitchers, Batters.bowser, "Monsters");
		} else if (x == 2) {
			team = new Team(Pitchers.peachPitchers, Batters.peach, "Roses");
		} else if (x == 3) {
			team = new Team(Pitchers.warioPitchers, Batters.wario, "Garlics");
		} else if (x == 4) {
			team = new Team(Pitchers.dkPitchers, Batters.dk, "Explorers");
		} else if (x == 5) {
			team = new Team(Pitchers.yoshiPitchers, Batters.yoshi, "Eggs");
		}
		return team;
	}

	// checks if you need a pitch change and changes pitcher
	public static Pitcher pitchChange(ArrayDeque<Pitcher> teamPitchers) {
		Pitcher currPitcher = teamPitchers.element();
		if (teamPitchers.size() != 1) {
			if (currPitcher.pitchProb <= 0 || currPitcher.maxpitchCount <= 0) {
				teamPitchers.remove();
				currPitcher = teamPitchers.element();
			}
		}
		return currPitcher;
	}

	// get the value of the pitch
	public static int getPitchNumber(Pitcher currPitcher) {
		int pitchNum = 0;
		pitchNum = 1000 + currPitcher.getPitchProb();
		return pitchNum;
	}

	// returns what happened with the current atBat
	public static String atBatResult(int pitchValue, Player currBatter) {
		String result = "";
		int s = currBatter.singleProb;
		int d = currBatter.doubleProb;
		int t = currBatter.tripleProb;
		int h = currBatter.homeRunProb;
		int w = currBatter.walkProb;
		if (pitchValue > 0 && pitchValue <= s) {
			result = "single";
		} else if (pitchValue > s && pitchValue <= s + d) {
			result = "double";
		} else if (pitchValue > s + d && pitchValue <= s + d + t) {
			result = "triple";
		} else if (pitchValue > s + d + t && pitchValue <= s + d + t + h) {
			result = "homerun";
		} else if (pitchValue > s + d + t + h && pitchValue <= s + d + t + h + w) {
			result = "walk";
		} else {
			result = "out";
		}
		return result;
	}
	
	public static void checkScore(ArrayDeque<String> bases, int score){
		while(bases.size() > 3) {
			String curr = bases.pollFirst();
			if(curr != "0") {
				score += 1;
			}
		}
	}

}
