import java.util.ArrayDeque;
import java.util.Deque;

public class Batters {

	public static void main(String[] args) {
		
		ArrayDeque<Player> mario = new ArrayDeque<Player>();
		ArrayDeque<Player> bowser = new ArrayDeque<Player>();
		ArrayDeque<Player> dk = new ArrayDeque<Player>();
		ArrayDeque<Player> peach = new ArrayDeque<Player>();
		ArrayDeque<Player> wario = new ArrayDeque<Player>();
		ArrayDeque<Player> yoshi = new ArrayDeque<Player>();
		
		//name, single, double, triple, homer, walk
		//Mario
		Player GreenNoki = new Player("GreenNoki", 200, 60, 5, 10, 70);
		mario.add(GreenNoki);
		Player Luigi = new Player("Luigi", 190, 55, 3, 40, 60);
		mario.add(Luigi);
		Player Mario = new Player("Mario", 200, 75, 4, 50, 80);
		mario.add(Mario);
		Player Pianta = new Player("Pianta", 140, 25, 1, 75, 75);
		mario.add(Pianta);
		Player Blooper = new Player("Blooper", 200, 45, 2, 20, 65);
		mario.add(Blooper);
		Player BabyMario = new Player("BabyMario",180,55,4,5,50);
		mario.add(BabyMario);
		Player BabyLuigi = new Player("BabyLuigi",190,60,4,5,55);
		mario.add(BabyLuigi);
		Player BabyNoki = new Player("BlueNoki",205,50,3,12,70);
		mario.add(BabyNoki);
		Player MontyMole = new Player("MontyMole",180,45,7,10,40);
		mario.add(MontyMole);
		
		//Bowser
		Player DarkDryBones =new Player("DarkDryBones",200,52,5,60,70);
		bowser.add(DarkDryBones);
		Player FireBro =new Player("FireBro",185,60,2,60,60);
		bowser.add(FireBro);
		Player BowserJr =new Player("BowserJr",190,75,3,65,60);
		bowser.add(BowserJr);
		Player Bowser =new Player("Bowser",155,30,1,85,70);
		bowser.add(Bowser);
		Player HammerBro =new Player("HammerBro",175,45,2,65,50);
		bowser.add(HammerBro);
		Player BoomerangBro =new Player("BoomerangBro",180,55,2,50,45);
		bowser.add(BoomerangBro);
		Player BlueDryBones =new Player("BlueDryBones",175,50,4,20,55);
		bowser.add(BlueDryBones);
		Player DryBones =new Player("DryBones",170,55,4,30,60);
		bowser.add(DryBones);
		Player GreenDryBones =new Player("GreenDryBones",155,60,5,20,66);
		bowser.add(GreenDryBones);
		
		//DK
		Player DiddyKong =new Player("DiddyKong",210,60,6,10,90);
		dk.add(DiddyKong);
		Player DixieKong =new Player("DixieKong",195,50,5,5,70);
		dk.add(DixieKong);
		Player DK =new Player("DK",190,40,2,50,40);
		dk.add(DK);
		Player KingKRool =new Player("KingKRool",175,35,1,75,40);
		dk.add(KingKRool);
		Player FunkyKong =new Player("FunkyKong",180,40,2,45,50);
		dk.add(FunkyKong);
		Player BabyDK =new Player("BabyDK",190,45,4,30,50);
		dk.add(BabyDK);
		Player TinyKong =new Player("TinyKong",185,50,4,15,75);
		dk.add(TinyKong);
		Player GreenKritter =new Player("GreenKritter",160,35,2,65,20);
		dk.add(GreenKritter);
		Player RedKritter =new Player("RedKritter",150,35,1,60,30);
		dk.add(RedKritter);
		
		//Peach
		Player Toadette =new Player("Toadette",225,80,8,8,75);
		peach.add(Toadette);
		Player Peach =new Player("Peach",210,60,3,30,60);
		peach.add(Peach);
		Player Daisy =new Player("Daisy",190,50,3,65,50);
		peach.add(Daisy);
		Player Petey =new Player("Petey",160,13,1,100,80);
		peach.add(Petey);
		Player Toad =new Player("Toad",200,55,4,60,65);
		peach.add(Toad);
		Player YellowToad =new Player("YellowToad",190,60,5,55,70);
		peach.add(YellowToad);
		Player BabyPeach =new Player("BabyPeach",160,40,4,5,50);
		peach.add(BabyPeach);
		Player BabyDaisy =new Player("BabyDaisy",170,35,4,5,55);
		peach.add(BabyDaisy);
		Player Toadsworth =new Player("Toadsworth",185,35,2,6,40);
		peach.add(Toadsworth);
		
		//Wario
		Player Koopa =new Player("Koopa",220,50,5,55,70);
		wario.add(Koopa);
		Player Boo =new Player("Boo",190,40,3,40,55);
		wario.add(Boo);
		Player Waluigi =new Player("Waluigi",200,40,2,35,80);
		wario.add(Waluigi);
		Player Wario =new Player("Wario",140,25,1,70,45);
		wario.add(Wario);
		Player KingBoo =new Player("KingBoo",185,35,2,50,45);
		wario.add(KingBoo);
		Player Paratroopa =new Player("Paratroopa",185,45,4,20,62);
		wario.add(Paratroopa);
		Player Goomba =new Player("Goomba",165,45,2,10,50);
		wario.add(Goomba);
		Player Magickoopa =new Player("Magickoopa",170,50,2,13,70);
		wario.add(Magickoopa);
		Player Paragoomba =new Player("Paragoomba",155,60,6,11,50);
		wario.add(Paragoomba);
		
		//Yoshi
		Player Yoshi =new Player("Yoshi",230,85,10,20,80);
		yoshi.add(Yoshi);
		Player YellowShyGuy =new Player("YellowShyGuy",195,50,3,50,50);
		yoshi.add(YellowShyGuy);
		Player Birdo =new Player("Birdo",160,40,2,60,80);
		yoshi.add(Birdo);
		Player Wiggler =new Player("Wiggler",170,60,3,50,75);
		yoshi.add(Wiggler);
		Player RedShyGuy =new Player("RedShyGuy",180,50,2,35,60);
		yoshi.add(RedShyGuy);
		Player BlueYoshi =new Player("BlueYoshi",200,70,6,10,55);
		yoshi.add(BlueYoshi);
		Player BlackShyGuy =new Player("BlackShyGuy",190,40,2,45,50);
		yoshi.add(BlackShyGuy);
		Player YellowYoshi =new Player("YellowYoshi",205,55,4,12,35);
		yoshi.add(YellowYoshi);
		Player BlueShyGuy =new Player("BlueShyGuy",140,40,2,25,40);
		yoshi.add(BlueShyGuy);
		
	}

}
