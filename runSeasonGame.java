import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class runSeasonGame {

	public static void runGame(Team awayTeam, Team homeTeam) {
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
		ArrayDeque<String> awayBases = new ArrayDeque<String>();
		ArrayDeque<String> homeBases = new ArrayDeque<String>();

		while (!GameOver) {
			// away wins
			if (inning > 18 && inning % 2 == 1 && homeScore < awayScore) {
				GameOver = true;
			} else {
				// awayTeam batting
				if (inning % 2 == 1) {
					Pitcher currPitcher = homeTeam.pitchers.element();
					awayBases.clear();
					while (awayOut < 3) {
						
						Pitcher homePitcher = pitchChange(homeTeam.pitchers);
						if (currPitcher.name != homePitcher.name) {
							currPitcher = homeTeam.pitchers.element();
						}
						Player currBatter = awayTeam.batters.element();
						int value = rand.nextInt(getPitchNumber(homePitcher));
						String result = atBatResult(value, currBatter);
						if (result.equals("single")) {
							awayBases.add(currBatter.name);
							currBatter.numSingles += 1;
							currBatter.numHits += 1;
							currBatter.numAtBats += 1;
							homePitcher.pitchProb -= 6;
							awayHits += 1;
						} else if (result.equals("double")) {
							awayBases.add(currBatter.name);
							awayBases.add("0");
							homePitcher.pitchProb -= 8;
							awayHits += 1;
							currBatter.numDoubles += 1;
							currBatter.numHits += 1;
							currBatter.numAtBats += 1;
						} else if (result.equals("triple")) {
							awayBases.add(currBatter.name);
							awayBases.add("0");
							awayBases.add("0");
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
							homePitcher.pitchProb -= 6;
							currBatter.numWalks += 1;
						} else if (result.equals("error")) {
							awayBases.add(currBatter.name);
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
							currBatter.numAtBats += 1;
						}
						// get the value of #pitches from atBat and subtracts

						int PC = getPitchCountRand(pitchCountArray);
						homePitcher.maxpitchCount -= PC;
						// does bases
						int add = checkScore(awayBases, currBatter, result);
						awayScore += add;
						inningScore += add;
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
					homeBases.clear();

					// awayTeam batting
					if (inning % 2 == 0) {
						while (homeOut < 3) {
							Pitcher currPitcher = awayTeam.pitchers.element();
							Pitcher awayPitcher = pitchChange(awayTeam.pitchers);
							if (currPitcher.name != awayPitcher.name) {
								currPitcher = homeTeam.pitchers.element();
							}
							Player currBatter = homeTeam.batters.element();
							int value = rand.nextInt(getPitchNumber(awayPitcher));
							String result = atBatResult(value, currBatter);
							if (result.equals("single")) {
								homeBases.add(currBatter.name);
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
								awayPitcher.pitchProb -= 8;
								homeHits += 1;
							} else if (result.equals("triple")) {
								homeBases.add(currBatter.name);
								homeBases.add("0");
								homeBases.add("0");
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
								awayPitcher.pitchProb -= 6;
								currBatter.numWalks += 1;
							} else if (result.equals("error")) {
								homeBases.add(currBatter.name);
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
								currBatter.numAtBats += 1;
							}
							// get the value of #pitches from atBat and subtracts
							int PC = getPitchCountRand(pitchCountArray);
							awayPitcher.maxpitchCount -= PC;
							// does bases
							int add = checkScore(homeBases, currBatter, result);
							homeScore += add;
							inningScore += add;
								if (inning > 17 && homeScore > awayScore) {
									GameOver = true;
									break;
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
		
		//print the scoreboard for each game (3 line style)
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
		System.out.printf("%-6s %-6s %-6s", "  " + awayScore, " " + awayHits, "  " + awayError);
		System.out.println();
		System.out.printf("%-15s", homeTeam.teamName + " ");
		for (int i = 1; i <= HS.size(); i++) {
			if (HS.get(i - 1) != null) {
				System.out.printf("%-3s", HS.get(i - 1));
			} else {
				System.out.printf("%-3s", "");
			}
		}
		System.out.printf("%-6s %-6s %-6s", "  " + homeScore," " +  homeHits, "  " + homeError);
		System.out.println();
		orderPitchers(homeTeam, awayTeam);
		if(awayScore > homeScore) {
			awayTeam.numWins += 1;
			homeTeam.numLoss += 1;
		}else if(awayScore < homeScore) {
			awayTeam.numLoss += 1;
			homeTeam.numWins += 1;
		}
		awayTeam.RS += awayScore;
		homeTeam.RS += homeScore;
		awayTeam.RA += homeScore;
		homeTeam.RA += awayScore;
		awayTeam.RD += (awayScore - homeScore);
		homeTeam.RD += (homeScore - awayScore);
		awayTeam.gamesPlayed += 1;
		homeTeam.gamesPlayed += 1;
		awayTeam.winPct = (awayTeam.numWins / (double) awayTeam.gamesPlayed);
		homeTeam.winPct = (homeTeam.numWins / (double) homeTeam.gamesPlayed);

	} // end of big while loop
	
	// checks if you need a pitch change and changes pitcher
	public static Pitcher pitchChange(ArrayDeque<Pitcher> teamPitchers) {
		Pitcher currPitcher = teamPitchers.element();
		if (teamPitchers.size() != 1) {
			if (currPitcher.pitchProb <= 0 || currPitcher.maxpitchCount <= 0) {
				teamPitchers.remove();
				currPitcher = teamPitchers.element();
				teamPitchers.add(currPitcher);
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

	//print r
	public static String outDisplay() {
		String val = "";
		Random outRand = new Random();
		HashMap<Integer, String> outMap = new HashMap<Integer, String>();

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
	
	//put the batters in order after the game
	public static void orderBatters (Team team) {
		HashMap<Integer, Player> teamMap = new HashMap<Integer, Player>();
		for (Player lead : team.batters) {
			int a = lead.orderNum;
			teamMap.put(a, lead);
		}
		team.batters.clear();
		for(int i = 1; i <= 9; i++) {
			team.batters.add(teamMap.get(i));
		}
	}
	//put the pitchers in order after the game
	public static void orderPitchers (Team homeTeam, Team awayTeam) {
		homeTeam.pitchers.clear();
		awayTeam.pitchers.clear();
		Pitchers.addPitcher();
	}
	
}