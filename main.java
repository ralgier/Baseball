
public class main{

	public static void main(String[] args) {
		
		Team Fireballs = new Team(Pitchers.marioPitchers, Batters.mario, "Fireballs");
		Team Monsters = new Team(Pitchers.bowserPitchers, Batters.bowser, "Monsters");
		Team Roses = new Team(Pitchers.peachPitchers, Batters.peach, "Roses");
		Team Garlics = new Team(Pitchers.warioPitchers, Batters.wario, "Garlics");
		Team Explorers = new Team(Pitchers.dkPitchers, Batters.dk, "Explorers");
		Team Eggs = new Team(Pitchers.yoshiPitchers, Batters.yoshi, "Eggs");
		
		runGame test = new runGame (Fireballs, Roses);
		System.out.println("Main class");
	}

}
