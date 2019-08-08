public class main{
	
	static Team Fireballs = new Team(Pitchers.marioPitchers, Batters.mario, "Fireballs",0,0,0,0,0,0);
	static Team Monsters = new Team(Pitchers.bowserPitchers, Batters.bowser, "Monsters",0,0,0,0,0,0);
	static Team Roses = new Team(Pitchers.peachPitchers, Batters.peach, "Roses",0,0,0,0,0,0);
	static Team Garlics = new Team(Pitchers.warioPitchers, Batters.wario, "Garlics",0,0,0,0,0,0);
	static Team Explorers = new Team(Pitchers.dkPitchers, Batters.dk, "Explorers",0,0,0,0,0,0);
	static Team Eggs = new Team(Pitchers.yoshiPitchers, Batters.yoshi, "Eggs",0,0,0,0,0,0);
	
	public static void main(String[] args) {
			Batters.addBatters();
			Pitchers.addPitcher();
			for(int i = 0; i < 3; i++) {
				runGame test = new runGame (Fireballs, Roses);
			}
	}

}
