import java.util.ArrayDeque;
import java.util.HashMap;
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
		int[] pitchCountArray = { 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9, 10 };
		int pitchCountArrRand = rand.nextInt(pitchCountArray.length);

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
		ArrayDeque<String> homeBases = new ArrayDeque<String>();

		System.out.println(awayTeam.teamName + " vs " + homeTeam.teamName);

		while (!GameOver) {
			// away wins
			if (inning > 18 && inning % 2 == 1 && homeScore < awayScore) {
				GameOver = true;
			} else {
				System.out.println(awayTeam.teamName + " are up to bat.");
				// awayTeam batting
				if (inning % 2 == 1) {
					System.out.println(" ");
					System.out.println("INNING: " + inning);
					System.out.println("Score is now " + awayTeam.teamName + ":" + awayScore + " " + homeTeam.teamName
							+ ":" + homeScore);
					System.out.println(" ");
					awayBases.clear();
					while (awayOut < 3) {
						Pitcher homePitcher = pitchChange(homePitchers);
						Player currBatter = awayTeam.batters.element();
						int value = rand.nextInt(getPitchNumber(homePitcher));
						String result = atBatResult(value, currBatter);
						System.out.println(currBatter.name + " batting against " + homePitcher.name);
						if (result.equals("single")) {
							awayBases.add(currBatter.name);
							System.out.println(currBatter.name + " singled" + singleDisplay());
							homePitcher.pitchProb -= 4;
						} else if (result.equals("double")) {
							awayBases.add(currBatter.name);
							awayBases.add("0");
							System.out.println(currBatter.name + " doubled" + XBHDisplay());
							homePitcher.pitchProb -= 8;
						} else if (result.equals("triple")) {
							awayBases.add(currBatter.name);
							awayBases.add("0");
							awayBases.add("0");
							System.out.println(currBatter.name + " tripled" + XBHDisplay());
							homePitcher.pitchProb -= 10;
						} else if (result.equals("homerun")) {
							awayBases.add(currBatter.name);
							awayBases.add("0");
							awayBases.add("0");
							awayBases.add("0");
							System.out.println(currBatter.name + " homered" + XBHDisplay());
							homePitcher.pitchProb -= 12;
						} else if (result.equals("walk")) {

							String firstBase = awayBases.peekLast();
							if (firstBase == "0") {
								awayBases.pollLast();
								awayBases.add(currBatter.name);
							} else if (awayBases.size() == 3) {
								String thirdBase = awayBases.pollFirst();
								System.out.println("whos on third: " + thirdBase);
								String secondBase = awayBases.pollFirst();
								System.out.println("whos on second: " + secondBase);
								firstBase = awayBases.pollFirst();
								System.out.println("whos on first: " + firstBase);
								// guy on 3rd & 1st
								if (thirdBase != "0" && secondBase == "0") {
									awayBases.add(thirdBase);
									awayBases.add(firstBase);
									awayBases.add(currBatter.name);
									System.out.println("awayBases: " + awayBases);
									// guy on 1st, 2nd, 3rd
								} else if (thirdBase != "0" && secondBase != "0") {
									awayBases.add(thirdBase);
									awayBases.add(secondBase);
									awayBases.add(firstBase);
									awayBases.add(currBatter.name);
									System.out.println("away bases" + awayBases);
									// guy on 1st
								} else if (thirdBase == "0" && secondBase == "0") {
									awayBases.add(firstBase);
									awayBases.add(currBatter.name);
									// guy on 1st, 2nd
								} else if (thirdBase == "0" && secondBase != "0") {
									awayBases.add(secondBase);
									awayBases.add(firstBase);
									awayBases.add(currBatter.name);
								}

							} else {
								awayBases.add(currBatter.name);
							}
							System.out.println(currBatter.name + " walked.");
							System.out.println("WALKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
							homePitcher.pitchProb -= 6;
						} else if (result.equals("out")) {

							String display = outDisplay();
							if (display.equals(" struck out.")) {
								homePitcher.maxpitchCount -= 2;
								homePitcher.pitchProb += 10;
							} else {
								homePitcher.pitchProb += 3;
							}
							System.out.println(currBatter.name + display);
							awayOut++;

						}
						// get the value of #pitches from atBat and subtracts
						int PC = getPitchCountRand(pitchCountArray);
						homePitcher.maxpitchCount -= PC;
						// does bases
						int tempAway = awayScore;
						awayScore += checkScore(awayBases);
						if (tempAway != awayScore) {
							System.out.println("Score is now " + awayTeam.teamName + ":" + awayScore + " "
									+ homeTeam.teamName + ":" + homeScore);
						}
						System.out.println("away bases" + awayBases);
						System.out.println();
						// does batters
						Player tempBatter = awayTeam.batters.remove();
						awayTeam.batters.add(tempBatter);
					}

				}
				awayOut = 0;
				inning++;

				// homeTeam batting
				if (inning > 17 && homeScore > awayScore) {
					GameOver = true;
				} else {
					System.out.println();
					System.out.println("INNING: " + inning);
					System.out.println("Score is now " + awayTeam.teamName + ":" + awayScore + " " + homeTeam.teamName
							+ ":" + homeScore);
					System.out.println(" ");
					homeBases.clear();
					System.out.println(homeTeam.teamName + " are up to bat.");
					// awayTeam batting
					if (inning % 2 == 0) {
						while (homeOut < 3) {
							Pitcher awayPitcher = pitchChange(awayPitchers);
							Player currBatter = homeTeam.batters.element();
							int value = rand.nextInt(getPitchNumber(awayPitcher));
							String result = atBatResult(value, currBatter);
							System.out.println(currBatter.name + " batting against " + awayPitcher.name);
							if (result.equals("single")) {
								homeBases.add(currBatter.name);
								System.out.println(currBatter.name + " singled" + singleDisplay());
								awayPitcher.pitchProb -= 4;
							} else if (result.equals("double")) {
								homeBases.add(currBatter.name);
								homeBases.add("0");
								System.out.println(currBatter.name + " doubled" + XBHDisplay());
								awayPitcher.pitchProb -= 8;
							} else if (result.equals("triple")) {
								homeBases.add(currBatter.name);
								homeBases.add("0");
								homeBases.add("0");
								System.out.println(currBatter.name + " tripled" + XBHDisplay());
								awayPitcher.pitchProb -= 10;
							} else if (result.equals("homerun")) {
								homeBases.add(currBatter.name);
								homeBases.add("0");
								homeBases.add("0");
								homeBases.add("0");
								System.out.println(currBatter.name + " homered" + XBHDisplay());
								awayPitcher.pitchProb -= 12;
							} else if (result.equals("walk")) {
								String firstBase = homeBases.peekLast();
								if (firstBase == "0") {
									homeBases.pollLast();
									homeBases.add(currBatter.name);
								} else if (homeBases.size() == 3) {
									String thirdBase = homeBases.pollFirst();
									System.out.println("whos on third: " + thirdBase);
									String secondBase = homeBases.pollFirst();
									System.out.println("whos on second: " + secondBase);
									firstBase = homeBases.pollFirst();
									System.out.println("whos on first: " + firstBase);
									// guy on 3rd & 1st
									if (thirdBase != "0" && secondBase == "0") {
										homeBases.add(thirdBase);
										homeBases.add(firstBase);
										homeBases.add(currBatter.name);
										System.out.println("homeBases: " + homeBases);
										// guy on 1st, 2nd, 3rd
									} else if (thirdBase != "0" && secondBase != "0") {
										homeBases.add(thirdBase);
										homeBases.add(secondBase);
										homeBases.add(firstBase);
										homeBases.add(currBatter.name);
										System.out.println("home bases" + homeBases);
										// guy on 1st
									} else if (thirdBase == "0" && secondBase == "0") {
										homeBases.add(firstBase);
										homeBases.add(currBatter.name);
										// guy on 1st, 2nd
									} else if (thirdBase == "0" && secondBase != "0") {
										homeBases.add(secondBase);
										homeBases.add(firstBase);
										homeBases.add(currBatter.name);
									}

								} else {
									homeBases.add(currBatter.name);
								}
								System.out.println(currBatter.name + " walked.");
								awayPitcher.pitchProb -= 6;
							} else if (result.equals("out")) {

								String display = outDisplay();
								if (display.equals(" struck out.")) {
									awayPitcher.maxpitchCount -= 2;
									awayPitcher.pitchProb += 10;
								} else {
									awayPitcher.pitchProb += 3;
								}
								System.out.println(currBatter.name + display);
								homeOut++;

							}
							// get the value of #pitches from atBat and subtracts
							int PC = getPitchCountRand(pitchCountArray);
							awayPitcher.maxpitchCount -= PC;
							// does bases
							int tempHome = homeScore;
							homeScore += checkScore(homeBases);
							if (tempHome != homeScore) {
								System.out.println("Score is now " + awayTeam.teamName + ":" + awayScore + " "
										+ homeTeam.teamName + ":" + homeScore);
								if (inning > 17 && homeScore > awayScore) {
									GameOver = true;
									System.out.println(currBatter.name + " walked off! The game is over!");
									break;
								}
							}
							// does batters
							Player tempBatter = homeTeam.batters.remove();
							homeTeam.batters.add(tempBatter);
						}

					}
					homeOut = 0;
					inning++;
				}
			}
		}
		System.out.println("Game over.");
		System.out.println(
				"Final Score is " + awayTeam.teamName + ":" + awayScore + " " + homeTeam.teamName + ":" + homeScore);
	} // end of big while loop

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

	public static int checkScore(ArrayDeque<String> bases) {
		int val = 0;
		while (bases.size() > 3) {
			String curr = bases.pollFirst();
			if (curr != "0") {
				val += 1;
			}
		}
		return val;
	}

	public static int getPitchCountRand(int[] pitchCountArray) {
		Random rand = new Random();
		int pitchCountArrRand = rand.nextInt(pitchCountArray.length);
		int val = pitchCountArray[pitchCountArrRand];
		return val;
	}

	public static String outDisplay() {
		String val = "";
		Random outRand = new Random();
		HashMap<Integer, String> outMap = new HashMap<Integer, String>();

		// double play????
		outMap.put(1, " grounded out to first.");
		outMap.put(2, " grounded out to second.");
		outMap.put(3, " grounded out to third.");
		outMap.put(4, " grounded out to short.");
		outMap.put(5, " grounded out to the pitcher.");
		outMap.put(6, " popped up to center.");
		outMap.put(7, " popped up to right field.");
		outMap.put(8, " popped up to left field.");
		outMap.put(9, " hit it foul and it was caught by the catcher.");
		outMap.put(10, " struck out.");

		int key = outRand.nextInt(10) + 1;
		val = outMap.get(key);
		return val;
	}

	public static String singleDisplay() {
		String val = "";
		Random outRand = new Random();
		HashMap<Integer, String> singleMap = new HashMap<Integer, String>();

		singleMap.put(1, " up the middle.");
		singleMap.put(2, " to right field.");
		singleMap.put(3, " to left field.");

		int key = outRand.nextInt(3) + 1;
		val = singleMap.get(key);
		return val;

	}

	public static String XBHDisplay() {
		String val = "";
		Random outRand = new Random();
		HashMap<Integer, String> XBHMap = new HashMap<Integer, String>();

		XBHMap.put(1, " to left center.");
		XBHMap.put(2, " to right center.");
		XBHMap.put(3, " down the left field line.");
		XBHMap.put(4, " down the right field line.");
		XBHMap.put(5, " to deep left.");
		XBHMap.put(6, " to deep center.");
		XBHMap.put(7, " to deep right.");

		int key = outRand.nextInt(7) + 1;
		val = XBHMap.get(key);
		return val;
	}

}