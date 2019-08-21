import java.util.ArrayDeque;

public class Pitchers {
	
	static ArrayDeque<Pitcher> marioPitchers = new ArrayDeque<Pitcher>();
	static ArrayDeque<Pitcher> bowserPitchers = new ArrayDeque<Pitcher>();
	static ArrayDeque<Pitcher> dkPitchers = new ArrayDeque<Pitcher>();
	static ArrayDeque<Pitcher> peachPitchers = new ArrayDeque<Pitcher>();
	static ArrayDeque<Pitcher> warioPitchers = new ArrayDeque<Pitcher>();
	static ArrayDeque<Pitcher> yoshiPitchers = new ArrayDeque<Pitcher>();
	
	public static void addPitcher() {
	//Mario
	Pitcher MarioStarter = new Pitcher("MarioStarter", 60, 105,1);
	marioPitchers.add(MarioStarter);
	Pitcher MarioReliever1 = new Pitcher("MarioReliever1", 35, 25,2);
	marioPitchers.add(MarioReliever1);
	Pitcher MarioReliever2 = new Pitcher("MarioReliever2", 30, 25,3);
	marioPitchers.add(MarioReliever2);
	Pitcher MarioReliever3 = new Pitcher("MarioReliever3", 30, 20,4);
	marioPitchers.add(MarioReliever3);
	Pitcher MarioCloser = new Pitcher("MarioCloser", 50, 15,5);
	marioPitchers.add(MarioCloser);
	Pitcher MarioBasePitcher = new Pitcher("MarioBasePitcher", 0, 9999999,6);
	marioPitchers.add(MarioBasePitcher);
	
	//Bowser
	Pitcher BowserStarter = new Pitcher("BowserStarter", 55, 95,1);
	bowserPitchers.add(BowserStarter);
	Pitcher BowserReliever1 = new Pitcher("BowserReliever1", 40, 15,2);
	bowserPitchers.add(BowserReliever1);
	Pitcher BowserReliever2 = new Pitcher("BowserReliever2", 35, 15,3);
	bowserPitchers.add(BowserReliever2);
	Pitcher BowserReliever3 = new Pitcher("BowserReliever3", 30, 15,4);
	bowserPitchers.add(BowserReliever3);
	Pitcher BowserCloser = new Pitcher("BowserCloser", 20, 15,5);
	bowserPitchers.add(BowserCloser);
	Pitcher BowserBasePitcher = new Pitcher("BowserBasePitcher", 0, 9999999,6);
	bowserPitchers.add(BowserBasePitcher);
	
	//DK
	Pitcher DKStarter = new Pitcher("DKStarter", 57, 100,1);
	dkPitchers.add(DKStarter);
	Pitcher DKReliever1 = new Pitcher("DKReliever1", 30, 20,2);
	dkPitchers.add(DKReliever1);
	Pitcher DKReliever2 = new Pitcher("DKReliever2", 30, 20,3);
	dkPitchers.add(DKReliever2);
	Pitcher DKReliever3 = new Pitcher("DKReliever3", 30, 20,4);
	dkPitchers.add(DKReliever3);
	Pitcher DKCloser = new Pitcher("DKCloser", 70, 15,5);
	dkPitchers.add(DKCloser);
	Pitcher DKBasePitcher = new Pitcher("DKBasePitcher", 0, 9999999,6);
	dkPitchers.add(DKBasePitcher);
	
	//Peach
	Pitcher PeachStarter = new Pitcher("PeachStarter", 75, 110,1);
	peachPitchers.add(PeachStarter);
	Pitcher PeachReliever1 = new Pitcher("PeachReliever1", 40, 30,2);
	peachPitchers.add(PeachReliever1);
	Pitcher PeachReliever2 = new Pitcher("PeachReliever2", 40, 30,3);
	peachPitchers.add(PeachReliever2);
	Pitcher PeachReliever3 = new Pitcher("PeachReliever3", 40, 30,4);
	peachPitchers.add(PeachReliever3);
	Pitcher PeachCloser = new Pitcher("PeachCloser", 60, 20,5);
	peachPitchers.add(PeachCloser);
	Pitcher PeachBasePitcher = new Pitcher("PeachBasePitcher", 0, 9999999,6);
	peachPitchers.add(PeachBasePitcher);
	
	//Wario
	Pitcher WarioStarter = new Pitcher("WarioStarter", 70, 95,1);
	warioPitchers.add(WarioStarter);
	Pitcher WarioReliever1 = new Pitcher("WarioReliever1", 45, 25,2);
	warioPitchers.add(WarioReliever1);
	Pitcher WarioReliever2 = new Pitcher("WarioReliever2", 40, 25,3);
	warioPitchers.add(WarioReliever2);
	Pitcher WarioReliever3 = new Pitcher("WarioReliever3", 45, 25,4);
	warioPitchers.add(WarioReliever3);
	Pitcher WarioCloser = new Pitcher("WarioCloser", 55, 15,5);
	warioPitchers.add(WarioCloser);
	Pitcher WarioBasePitcher = new Pitcher("WarioBasePitcher", 0, 9999999,6);
	warioPitchers.add(WarioBasePitcher);
	
	//Yoshi
	Pitcher YoshiStarter = new Pitcher("YoshiStarter", 50, 100,1);
	yoshiPitchers.add(YoshiStarter);
	Pitcher YoshiReliever1 = new Pitcher("YoshiReliever1", 25, 30,2);
	yoshiPitchers.add(YoshiReliever1);
	Pitcher YoshiReliever2 = new Pitcher("YoshiReliever2", 25, 30,3);
	yoshiPitchers.add(YoshiReliever2);
	Pitcher YoshiReliever3 = new Pitcher("YoshiReliever3", 25, 30,4);
	yoshiPitchers.add(YoshiReliever3);
	Pitcher YoshiCloser = new Pitcher("YoshiCloser", 40, 20,5);
	yoshiPitchers.add(YoshiCloser);
	Pitcher YoshiBasePitcher = new Pitcher("YoshiBasePitcher", 0, 9999999,6);
	yoshiPitchers.add(YoshiBasePitcher);
	
	}
}
