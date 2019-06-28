import java.util.ArrayDeque;
import java.util.Random;

public class Game {

	static boolean GameOver;
	
	public static void main(String[] args) {
		//the essentials
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
		
		//maybe more later

		// adds in all the batters to the array deques which represent the teams
		Batters.addBatters();
		GameOver = false;
		while (!GameOver) {
			Team awayTeam = getTeam();
			Team homeTeam = getTeam();
			while (awayTeam.teamName.equals(homeTeam.teamName)) {
				homeTeam = getTeam();
			}			
			//up to here -> gotten 2 teams
			
			//start the game 
			//awayTeam batting
			if(inning %2 == 1) {
				while(awayOut < 3) {
					ArrayDeque<Pitcher> homePitchers = homeTeam.getPitchers();
					homePitchers.remove();
					
				}
				inning ++;
			}
			
			//homeTeam batting 
			if(inning %2 == 0) {
				while(awayOut < 3) {
					ArrayDeque<Pitcher> awayPitchers = awayTeam.getPitchers();
					awayPitchers.remove();
					
				}
				inning ++;
			}
			
			

		}//end of big while loop
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
}
