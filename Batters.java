import java.util.ArrayDeque;

public class Batters {
                     
                      static ArrayDeque<Player> mario = new ArrayDeque<Player>();
                      static ArrayDeque<Player> bowser = new ArrayDeque<Player>();
                      static ArrayDeque<Player> dk = new ArrayDeque<Player>();
                      static ArrayDeque<Player> peach = new ArrayDeque<Player>();
                      static ArrayDeque<Player> wario = new ArrayDeque<Player>();
                      static ArrayDeque<Player> yoshi = new ArrayDeque<Player>();
                     
                      public static void addBatters() {
                      //name, single, double, triple, homer, walk
                      //Mario
                      Player GreenNoki = new Player(1,"GreenNoki", 200, 60, 5, 15, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      mario.add(GreenNoki);
                      Player Luigi = new Player(2, "Luigi", 190, 55, 3, 43, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      mario.add(Luigi);
                      Player Mario = new Player(3, "Mario", 200, 75, 4, 55, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      mario.add(Mario);
                      Player Pianta = new Player(4, "Pianta", 140, 25, 1, 60, 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      mario.add(Pianta);
                      Player Blooper = new Player(5, "Blooper", 200, 45, 2, 20, 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      mario.add(Blooper);
                      Player BabyMario = new Player(6,"BabyMario",180,55,4,5,50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      mario.add(BabyMario);
                      Player BabyLuigi = new Player(7, "BabyLuigi",190,60,4,5,55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      mario.add(BabyLuigi);
                      Player BlueNoki = new Player(8, "BlueNoki",205,50,3,12,70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      mario.add(BlueNoki);
                      Player MontyMole = new Player(9, "MontyMole",180,45,7,10,40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      mario.add(MontyMole);
                     
                      //Bowser
                      Player DarkDryBones =new Player(1, "DarkDryBones",200,52,5,60,70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      bowser.add(DarkDryBones);
                      Player FireBro =new Player(2, "FireBro",185,50,2,56,60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      bowser.add(FireBro);
                      Player BowserJr =new Player(3, "BowserJr",190,75,3,56,60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      bowser.add(BowserJr);
                      Player Bowser =new Player(4, "Bowser",155,30,1,67,60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      bowser.add(Bowser);
                      Player HammerBro =new Player(5, "HammerBro",175,45,2,55,50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      bowser.add(HammerBro);
                      Player BoomerangBro =new Player(6, "BoomerangBro",175,55,2,50,45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      bowser.add(BoomerangBro);
                      Player BlueDryBones =new Player(7, "BlueDryBones",170,50,4,20,55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      bowser.add(BlueDryBones);
                      Player DryBones =new Player(8, "DryBones",165,55,4,20,60,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      bowser.add(DryBones);
                      Player GreenDryBones =new Player(9, "GreenDryBones",155,60,5,10,66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      bowser.add(GreenDryBones);
                     
                      //DK
                      Player DiddyKong =new Player(1, "DiddyKong",210,60,6,10,90, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      dk.add(DiddyKong);
                      Player DixieKong =new Player(2, "DixieKong",195,50,5,5,70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      dk.add(DixieKong);
                      Player DK =new Player(3, "DK",190,40,2,60,40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      dk.add(DK);
                      Player KingKRool =new Player(4, "KingKRool",175,35,1,65,40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      dk.add(KingKRool);
                      Player FunkyKong =new Player(5, "FunkyKong",180,40,2,45,50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      dk.add(FunkyKong);
                      Player BabyDK =new Player(6, "BabyDK",190,45,4,30,50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      dk.add(BabyDK);
                      Player TinyKong =new Player(7, "TinyKong",185,50,4,15,75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      dk.add(TinyKong);
                      Player GreenKritter =new Player(8, "GreenKritter",160,35,2,59,20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      dk.add(GreenKritter);
                      Player RedKritter =new Player(9, "RedKritter",150,35,1,60,30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      dk.add(RedKritter);
                     
                      //Peach
                      Player Toadette =new Player(1, "Toadette",225,80,8,8,75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      peach.add(Toadette);
                      Player Peach =new Player(2, "Peach",210,60,3,30,60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      peach.add(Peach);
                      Player Daisy =new Player(3, "Daisy",190,50,3,54,50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      peach.add(Daisy);
                      Player Petey =new Player(4, "Petey",160,13,1,70,80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      peach.add(Petey);
                      Player Toad =new Player(5, "Toad",200,55,4,52,65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      peach.add(Toad);
                      Player YellowToad =new Player(6, "YellowToad",190,60,5,48,70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      peach.add(YellowToad);
                      Player BabyPeach =new Player(7, "BabyPeach",160,40,4,5,50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      peach.add(BabyPeach);
                      Player BabyDaisy =new Player(8, "BabyDaisy",170,35,4,5,55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      peach.add(BabyDaisy);
                      Player Toadsworth =new Player(9, "Toadsworth",185,35,2,6,40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      peach.add(Toadsworth);
                     
                      //Wario
                      Player Koopa =new Player(1, "Koopa",220,50,5,50,70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      wario.add(Koopa);
                      Player Boo =new Player(2, "Boo",190,40,3,40,55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      wario.add(Boo);
                      Player Waluigi =new Player(3, "Waluigi",200,40,2,35,80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      wario.add(Waluigi);
                      Player Wario =new Player(4, "Wario",140,25,1,62,45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      wario.add(Wario);
                      Player KingBoo =new Player(5, "KingBoo",185,35,2,53,45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      wario.add(KingBoo);
                      Player Paratroopa =new Player(6, "Paratroopa",185,45,4,20,62, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      wario.add(Paratroopa);
                      Player Goomba =new Player(7, "Goomba",165,45,2,10,50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      wario.add(Goomba);
                      Player Magickoopa =new Player(8, "Magickoopa",170,50,2,13,70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      wario.add(Magickoopa);
                      Player Paragoomba =new Player(9, "Paragoomba",155,60,6,11,50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      wario.add(Paragoomba);
                     
                      //Yoshi
                      Player Yoshi =new Player(1, "Yoshi",230,85,10,20,80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      yoshi.add(Yoshi);
                      Player YellowShyGuy =new Player(2, "YellowShyGuy",195,50,3,46,50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      yoshi.add(YellowShyGuy);
                      Player Birdo =new Player(3, "Birdo",160,40,2,59,80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      yoshi.add(Birdo);
                      Player Wiggler =new Player(4, "Wiggler",170,60,3,51,75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      yoshi.add(Wiggler);
                      Player RedShyGuy =new Player(5, "RedShyGuy",180,50,2,35,60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      yoshi.add(RedShyGuy);
                      Player BlueYoshi =new Player(6, "BlueYoshi",200,70,6,10,55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      yoshi.add(BlueYoshi);
                      Player BlackShyGuy =new Player(7, "BlackShyGuy",190,40,2,43,50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      yoshi.add(BlackShyGuy);
                      Player YellowYoshi =new Player(8, "YellowYoshi",205,55,4,12,35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      yoshi.add(YellowYoshi);
                      Player BlueShyGuy =new Player(9, "BlueShyGuy",140,40,2,25,40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0);
                      yoshi.add(BlueShyGuy);
                     
                      }
                      public static void removeBatters() {
                                 mario.clear();
                                 peach.clear();
                                 wario.clear();
                                 dk.clear();
                                 bowser.clear();
                                 yoshi.clear();
                      }
}
