import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class runGame {

	public runGame(Team awayTeam, Team homeTeam) {
		boolean GameOver;
		Random rand = new Random();
		// the essentials
		int inning = 1;
		int awayScore = 0;
		int homeScore = 0;
		int awayOut = 0;
		int homeOut = 0;
		int homeHits = 0;
		int homeError = 0;
		int awayHits = 0;
		int awayError = 0;
		int inningScore = 0;
		ArrayList<Integer> AS = new ArrayList<Integer>();
		ArrayList<Integer> HS = new ArrayList<Integer>();
		// adds in all the batters to the array deques which represent the teams
		GameOver = false;
		int[] pitchCountArray = { 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9, 10 };

		ArrayDeque<Pitcher> homePitchers = homeTeam.getPitchers();
		ArrayDeque<Pitcher> awayPitchers = awayTeam.getPitchers();
		ArrayDeque<String> awayBases = new ArrayDeque<String>();
		ArrayDeque<String> homeBases = new ArrayDeque<String>();

		System.out.println(awayTeam.teamName + " vs " + homeTeam.teamName);

		while (!GameOver) {
			// away wins
			if (inning > 18 && inning % 2 == 1 && homeScore < awayScore) {
				GameOver = true;
			} else {
				// awayTeam batting
				if (inning % 2 == 1) {
					Pitcher currPitcher = homePitchers.element();
					printScoreboard(inning, awayTeam, awayScore, awayHits, awayError, homeTeam, homeScore, homeHits,
							homeError);
					awayBases.clear();
					while (awayOut < 3) {
						
						Pitcher homePitcher = pitchChange(homePitchers);
						if (currPitcher.name != homePitcher.name) {
							currPitcher = homePitchers.element();
							System.out.printf("%30s", "Pitching Change. " + homePitcher.name + " is now pitching." + "\n");
						}
						Player currBatter = awayTeam.batters.element();
						int value = rand.nextInt(getPitchNumber(homePitcher));
						String result = atBatResult(value, currBatter);
						
						if (result.equals("single")) {
							awayBases.add(currBatter.name);
							System.out.printf("%-65s %1s", currBatter.name + " singled" + singleDisplay(), awayBases + "\n");
							currBatter.numSingles += 1;
							currBatter.numHits += 1;
							currBatter.numAtBats += 1;
							homePitcher.pitchProb -= 6;
							awayHits += 1;
						} else if (result.equals("double")) {
							awayBases.add(currBatter.name);
							awayBases.add("0");
							System.out.printf("%-65s %1s", currBatter.name + " doubled" + XBHDisplay(),
									awayBases + "\n");
							homePitcher.pitchProb -= 8;
							awayHits += 1;
							currBatter.numDoubles += 1;
							currBatter.numHits += 1;
							currBatter.numAtBats += 1;
						} else if (result.equals("triple")) {
							awayBases.add(currBatter.name);
							awayBases.add("0");
							awayBases.add("0");
							System.out.printf("%-65s %1s", currBatter.name + " tripled" + XBHDisplay(),
									awayBases + "\n");
							homePitcher.pitchProb -= 10;
							awayHits += 1;
							currBatter.numTriples += 1;
							currBatter.numHits += 1;
							currBatter.numAtBats += 1;
						} else if (result.equals("homerun")) {
							awayBases.add(currBatter.name);
							awayBases.add("0");
							awayBases.add("0");
							awayBases.add("0");
							System.out.printf("%-65s %1s", currBatter.name + " homered" + XBHDisplay(),
									awayBases + "\n");
							homePitcher.pitchProb -= 12;
							awayHits += 1;
							currBatter.numHomeruns += 1;
							currBatter.numHits += 1;
							currBatter.numAtBats += 1;
						} else if (result.equals("walk")) {

							String firstBase = awayBases.peekLast();
							if (firstBase == "0") {
								awayBases.pollLast();
								awayBases.add(currBatter.name);
							} else if (awayBases.size() == 3) {
								String thirdBase = awayBases.pollFirst();
								String secondBase = awayBases.pollFirst();
								firstBase = awayBases.pollFirst();
								// guy on 3rd & 1st
								if (thirdBase != "0" && secondBase == "0") {
									awayBases.add(thirdBase);
									awayBases.add(firstBase);
									awayBases.add(currBatter.name);
									// guy on 1st, 2nd, 3rd
								} else if (thirdBase != "0" && secondBase != "0") {
									awayBases.add(thirdBase);
									awayBases.add(secondBase);
									awayBases.add(firstBase);
									awayBases.add(currBatter.name);
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
							System.out.printf("%-65s %1s", currBatter.name + " walked.", awayBases + "\n");
							homePitcher.pitchProb -= 6;
							currBatter.numWalks += 1;
						} else if (result.equals("error")) {
							awayBases.add(currBatter.name);
							System.out.printf("%-65s %1s", currBatter.name + " reached on error.", awayBases + "\n");
							homePitcher.pitchProb -= 8;
							homeError += 1;
							currBatter.numWalks += 1;
						} else if (result.equals("out")) {

							String display = outDisplay();
							if (display.equals(" struck out.")) {
								homePitcher.maxpitchCount -= 2;
								homePitcher.pitchProb += 10;
							} else {
								homePitcher.pitchProb += 3;
							}
							awayOut++;
							System.out.printf("%-65s %1s", currBatter.name + display, awayOut + " out(s)." + "\n");
							currBatter.numAtBats += 1;
						}
						// get the value of #pitches from atBat and subtracts

						int PC = getPitchCountRand(pitchCountArray);
						homePitcher.maxpitchCount -= PC;
						// does bases
						int tempAway = awayScore;
						int add = checkScore(awayBases, currBatter, result);
						awayScore += add;
						inningScore += add;

						if (tempAway != awayScore) {
							System.out.printf("%66s", "Score is now " + awayTeam.teamName + ":" + awayScore + " "
									+ homeTeam.teamName + ":" + homeScore + "\n");
						}
						// does batters
						Player tempBatter = awayTeam.batters.remove();
						awayTeam.batters.add(tempBatter);
					}

				}
				awayOut = 0;
				AS.add(inningScore);
				inningScore = 0;
				inning++;

				// homeTeam batting
				if (inning > 17 && homeScore > awayScore) {
					HS.add(null);
					GameOver = true;
				} else {
					printScoreboard(inning, awayTeam, awayScore, awayHits, awayError, homeTeam, homeScore, homeHits,
							homeError);
					homeBases.clear();

					// awayTeam batting
					if (inning % 2 == 0) {
						while (homeOut < 3) {
							Pitcher currPitcher = awayPitchers.element();
							Pitcher awayPitcher = pitchChange(awayPitchers);
							if (currPitcher.name != awayPitcher.name) {
								currPitcher = homePitchers.element();
								System.out.println("Pitching Change. " + awayPitcher.name + " is now pitching.");
							}
							Player currBatter = homeTeam.batters.element();
							int value = rand.nextInt(getPitchNumber(awayPitcher));
							String result = atBatResult(value, currBatter);
							if (result.equals("single")) {
								homeBases.add(currBatter.name);
								System.out.printf("%-65s %1s", currBatter.name + " singled" + singleDisplay(),
										homeBases + "\n");
								awayPitcher.pitchProb -= 4;
								homeHits += 1;
								currBatter.numSingles += 1;
								currBatter.numHits += 1;
								currBatter.numAtBats += 1;
							} else if (result.equals("double")) {
								homeBases.add(currBatter.name);
								homeBases.add("0");
								currBatter.numDoubles += 1;
								currBatter.numHits += 1;
								currBatter.numAtBats += 1;
								System.out.printf("%-65s %1s", currBatter.name + " doubled" + XBHDisplay(),
										homeBases + "\n");
								awayPitcher.pitchProb -= 8;
								homeHits += 1;
							} else if (result.equals("triple")) {
								homeBases.add(currBatter.name);
								homeBases.add("0");
								homeBases.add("0");
								System.out.printf("%-65s %1s", currBatter.name + " tripled" + XBHDisplay(),
										homeBases + "\n");
								awayPitcher.pitchProb -= 10;
								homeHits += 1;
								currBatter.numTriples += 1;
								currBatter.numHits += 1;
								currBatter.numAtBats += 1;
							} else if (result.equals("homerun")) {
								homeBases.add(currBatter.name);
								homeBases.add("0");
								homeBases.add("0");
								homeBases.add("0");
								System.out.printf("%-65s %1s", currBatter.name + " homered" + XBHDisplay(),
										homeBases + "\n");
								awayPitcher.pitchProb -= 12;
								homeHits += 1;
								currBatter.numHomeruns += 1;
								currBatter.numHits += 1;
								currBatter.numAtBats += 1;
							} else if (result.equals("walk")) {
								String firstBase = homeBases.peekLast();
								if (firstBase == "0") {
									homeBases.pollLast();
									homeBases.add(currBatter.name);
								} else if (homeBases.size() == 3) {
									String thirdBase = homeBases.pollFirst();
									String secondBase = homeBases.pollFirst();
									firstBase = homeBases.pollFirst();
									// guy on 3rd & 1st
									if (thirdBase != "0" && secondBase == "0") {
										homeBases.add(thirdBase);
										homeBases.add(firstBase);
										homeBases.add(currBatter.name);
										// guy on 1st, 2nd, 3rd
									} else if (thirdBase != "0" && secondBase != "0") {
										homeBases.add(thirdBase);
										homeBases.add(secondBase);
										homeBases.add(firstBase);
										homeBases.add(currBatter.name);
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
								System.out.printf("%-65s %1s", currBatter.name + " walked.", homeBases + "\n");
								awayPitcher.pitchProb -= 6;
								currBatter.numWalks += 1;
							} else if (result.equals("error")) {
								homeBases.add(currBatter.name);
								System.out.printf("%-65s %1s", currBatter.name + " reached on error.",
										homeBases + "\n");
								awayPitcher.pitchProb -= 8;
								awayError += 1;
								currBatter.numAtBats += 1;
							} else if (result.equals("out")) {

								String display = outDisplay();
								if (display.equals(" struck out.")) {
									awayPitcher.maxpitchCount -= 2;
									awayPitcher.pitchProb += 10;
								} else {
									awayPitcher.pitchProb += 3;
								}
								homeOut++;
								System.out.printf("%-65s %1s", currBatter.name + display, homeOut + " out(s)." + "\n");
								currBatter.numAtBats += 1;
							}
							// get the value of #pitches from atBat and subtracts
							int PC = getPitchCountRand(pitchCountArray);
							awayPitcher.maxpitchCount -= PC;
							// does bases
							int tempHome = homeScore;
							int add = checkScore(homeBases, currBatter, result);
							homeScore += add;
							inningScore += add;
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
					HS.add(inningScore);
					inningScore = 0;
					inning++;
				}
			}
		}
		System.out.println();
		System.out.printf("%65s", "GAME OVER." + "\n");
		System.out.printf("%-16s", "" + "\n");
		for (int i = 1; i <= AS.size(); i++) {
			System.out.printf("%-3s", i);
		}
		System.out.printf("%-6s %-6s %-6s", "Score", "Hits", "Errors");
		System.out.println();
		System.out.printf("%-15s", awayTeam.teamName + " ");
		for (int i = 1; i <= AS.size(); i++) {
			System.out.printf("%-3s", AS.get(i - 1));
		}
		System.out.printf("%-6s %-6s %-6s", awayScore, awayHits, awayError);
		System.out.println();
		System.out.printf("%-15s", homeTeam.teamName + " ");
		for (int i = 1; i <= HS.size(); i++) {
			if (HS.get(i - 1) != null) {
				System.out.printf("%-3s", HS.get(i - 1));
			} else {
				System.out.printf("%-3s", "");
			}
		}
		System.out.printf("%-6s %-6s %-6s", homeScore, homeHits, homeError);
		System.out.println();

		HashMap<Integer, Player> awayTeamMap = orderTeam(awayTeam);
		HashMap<Integer, Player> homeTeamMap = orderTeam(homeTeam);
		printBattingStats(awayTeamMap, homeTeamMap, awayTeam, homeTeam);
	} // end of big while loop

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
		} else if (pitchValue > s + d + t + h + w && pitchValue <= s + d + t + h + w + 10) {
			result = "error";
		} else {
			result = "out";
		}
		return result;
	}

	public static int checkScore(ArrayDeque<String> bases, Player currBatter, String result) {
		int val = 0;
		while (bases.size() > 3) {
			String curr = bases.pollFirst();
			if (curr != "0") {
				val += 1;
			}
			//Error is not an RBI
			if(curr != "0" && result != "error") {
				currBatter.rbi += 1;
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

	public static void printBattingStats(HashMap<Integer, Player> awayTeamMap, HashMap<Integer, Player> homeTeamMap,
			Team awayTeam, Team homeTeam) {

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
		System.out.println(awayTeam.teamName + " stats:");
		System.out.printf("%15s %10s %10s %10s %10s %10s %10s %10s", "PlayerName", "Hits-AtBats", "Singles", "Doubles",
				"Triples", "Homeruns", "Walks", "RBIs");
		for (int i = 1; i <= 9; i++) {
			System.out.println();
			Player lead = awayTeamMap.get(i);
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
		System.out.printf("%15s %10s %10s %10s %10s %10s %10s %10s", "Total", hits + "-" + atBats, singles, doubles, triples,
				homeruns, walks, rbi);
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
		System.out.println(homeTeam.teamName + " stats:");
		System.out.printf("%15s %10s %10s %10s %10s %10s %10s %10s", "PlayerName", "Hits-AtBats", "Singles", "Doubles",
				"Triples", "Homeruns", "Walks", "RBIs");
		for (int i = 1; i <= 9; i++) {
			System.out.println();
			Player lead = homeTeamMap.get(i);
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
		System.out.printf("%15s %10s %10s %10s %10s %10s %10s %10s", "Total", hits + "-" + atBats, singles, doubles, triples,
				homeruns, walks, rbi);
		battingAvg = (double) hits / (double) atBats;
		System.out.println();
		System.out.printf("Team Average: %.3f", battingAvg);
	}

	public static HashMap<Integer, Player> orderTeam(Team team) {
		HashMap<Integer, Player> teamMap = new HashMap<Integer, Player>();
		for (Player lead : team.batters) {
			int a = lead.orderNum;
			teamMap.put(a, lead);
		}
		return teamMap;
	}

	public static void printScoreboard(int inning, Team awayTeam, int awayScore, int awayHits, int awayError,
			Team homeTeam, int homeScore, int homeHits, int homeError) {
		System.out.println(" ");
		System.out.println("Top of inning: " + (inning + 1) / 2);
		System.out.printf("%-15s %5s %5s %6s", "", "Runs", "Hits", "Errors");
		System.out.println();
		System.out.printf("%-15s %5s %5s %5s", awayTeam.teamName, awayScore, awayHits, awayError);
		System.out.println();
		System.out.printf("%-15s %5s %5s %5s", homeTeam.teamName, homeScore, homeHits, homeError);
		System.out.println();
		System.out.println();
	}

}
