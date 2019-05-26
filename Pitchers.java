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
	Pitcher MarioStarter = new Pitcher("MarioStarter", 50, 105);
	marioPitchers.add(MarioStarter);
	Pitcher MarioReliever1 = new Pitcher("MarioReliever1", 30, 25);
	marioPitchers.add(MarioReliever1);
	Pitcher MarioReliever2 = new Pitcher("MarioReliever2", 30, 25);
	marioPitchers.add(MarioReliever2);
	Pitcher MarioReliever3 = new Pitcher("MarioReliever3", 30, 20);
	marioPitchers.add(MarioReliever3);
	Pitcher MarioCloser = new Pitcher("MarioCloser", 50, 15);
	marioPitchers.add(MarioCloser);
	Pitcher MarioBasePitcher = new Pitcher("MarioBasePitcher", 0, 9999999);
	marioPitchers.add(MarioBasePitcher);
	
	//Bowser
	Pitcher BowserStarter = new Pitcher("BowserStarter", 55, 95);
	bowserPitchers.add(BowserStarter);
	Pitcher BowserReliever1 = new Pitcher("BowserReliever1", 25, 20);
	bowserPitchers.add(BowserReliever1);
	Pitcher BowserReliever2 = new Pitcher("BowserReliever2", 25, 20);
	bowserPitchers.add(BowserReliever2);
	Pitcher BowserReliever3 = new Pitcher("BowserReliever3", 20, 15);
	bowserPitchers.add(BowserReliever3);
	Pitcher BowserCloser = new Pitcher("BowserMarioCloser", 30, 15);
	bowserPitchers.add(BowserCloser);
	Pitcher BowserBasePitcher = new Pitcher("BowserBasePitcher", 0, 9999999);
	bowserPitchers.add(BowserBasePitcher);
	
	//DK
	Pitcher DKStarter = new Pitcher("DKStarter", 50, 100);
	dkPitchers.add(DKStarter);
	Pitcher DKReliever1 = new Pitcher("DKReliever1", 30, 20);
	dkPitchers.add(DKReliever1);
	Pitcher DKReliever2 = new Pitcher("DKReliever2", 30, 20);
	dkPitchers.add(DKReliever2);
	Pitcher DKReliever3 = new Pitcher("DKReliever3", 30, 20);
	dkPitchers.add(DKReliever3);
	Pitcher DKCloser = new Pitcher("DKCloser", 70, 10);
	dkPitchers.add(DKCloser);
	Pitcher DKBasePitcher = new Pitcher("DKBasePitcher", 0, 9999999);
	dkPitchers.add(DKBasePitcher);
	
	//Peach
	Pitcher PeachStarter = new Pitcher("PeachStarter", 70, 110);
	peachPitchers.add(PeachStarter);
	Pitcher PeachReliever1 = new Pitcher("PeachReliever1", 40, 30);
	peachPitchers.add(PeachReliever1);
	Pitcher PeachReliever2 = new Pitcher("PeachReliever2", 40, 30);
	peachPitchers.add(PeachReliever2);
	Pitcher PeachReliever3 = new Pitcher("PeachReliever3", 40, 30);
	peachPitchers.add(PeachReliever3);
	Pitcher PeachCloser = new Pitcher("PeachCloser", 60, 20);
	peachPitchers.add(PeachCloser);
	Pitcher PeachBasePitcher = new Pitcher("PeachBasePitcher", 0, 9999999);
	peachPitchers.add(PeachBasePitcher);
	
	//Wario
	Pitcher WarioStarter = new Pitcher("WarioStarter", 75, 95);
	warioPitchers.add(WarioStarter);
	Pitcher WarioReliever1 = new Pitcher("WarioReliever1", 30, 20);
	warioPitchers.add(WarioReliever1);
	Pitcher WarioReliever2 = new Pitcher("WarioReliever2", 30, 20);
	warioPitchers.add(WarioReliever2);
	Pitcher WarioReliever3 = new Pitcher("WarioReliever3", 30, 20);
	warioPitchers.add(WarioReliever3);
	Pitcher WarioCloser = new Pitcher("WarioCloser", 50, 15);
	warioPitchers.add(WarioCloser);
	Pitcher WarioBasePitcher = new Pitcher("WarioBasePitcher", 0, 9999999);
	warioPitchers.add(WarioBasePitcher);
	
	//Yoshi
	Pitcher YoshiStarter = new Pitcher("YoshiStarter", 50, 100);
	yoshiPitchers.add(YoshiStarter);
	Pitcher YoshiReliever1 = new Pitcher("YoshiReliever1", 25, 30);
	yoshiPitchers.add(YoshiReliever1);
	Pitcher YoshiReliever2 = new Pitcher("YoshiReliever2", 25, 30);
	yoshiPitchers.add(YoshiReliever2);
	Pitcher YoshiReliever3 = new Pitcher("YoshiReliever3", 25, 30);
	yoshiPitchers.add(YoshiReliever3);
	Pitcher YoshiCloser = new Pitcher("YoshiCloser", 40, 20);
	yoshiPitchers.add(YoshiCloser);
	Pitcher YoshiBasePitcher = new Pitcher("YoshiBasePitcher", 0, 9999999);
	yoshiPitchers.add(YoshiBasePitcher);

	}
}
