public class Player {
	public String name;
	public int singleProb;
	public int doubleProb;
	public int tripleProb;
	public int homeRunProb;
	public int walkProb;
	public int numSingles;
	public int numDoubles;
	public int numTriples;
	public int numHomeruns;
	public int numWalks;
	public int numAtBats;
	public int numHits;
	public int orderNum;

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public Player(int orderNum, String name, int singleProb, int doubleProb, int tripleProb, int homeRunProb, int walkProb, 
			int numSingles, int numDoubles, int numTriples, int numHomerun, int numWalk, int numAtBats, int numHits) {
		this.orderNum = orderNum;
		this.name = name;
		this.singleProb = singleProb;
		this.doubleProb = doubleProb;
		this.tripleProb = tripleProb;
		this.homeRunProb = homeRunProb;
		this.walkProb = walkProb;
		this.numSingles = numSingles;
		this.numAtBats = numAtBats;
		this.numDoubles = numDoubles;
		this.numTriples = numTriples;
		this.numHomeruns = numHomeruns;
		this.numHits = numHits;
		this.numWalks = numWalks;
		
	}

	public int getNumSingles() {
		return numSingles;
	}

	public void setNumSingles(int numSingles) {
		this.numSingles = numSingles;
	}

	public int getNumDoubles() {
		return numDoubles;
	}

	public void setNumDoubles(int numDoubles) {
		this.numDoubles = numDoubles;
	}

	public int getNumTriples() {
		return numTriples;
	}

	public void setNumTriples(int numTriples) {
		this.numTriples = numTriples;
	}

	public int getNumHomeruns() {
		return numHomeruns;
	}

	public void setNumHomeruns(int numHomeruns) {
		this.numHomeruns = numHomeruns;
	}

	public int getNumWalks() {
		return numWalks;
	}

	public void setNumWalks(int numWalks) {
		this.numWalks = numWalks;
	}

	public int getNumAtBats() {
		return numAtBats;
	}

	public void setNumAtBats(int numAtBats) {
		this.numAtBats = numAtBats;
	}

	public int getNumHits() {
		return numHits;
	}

	public void setNumHits(int numHits) {
		this.numHits = numHits;
	}

	public String getName() {
		return name;
	}

	public int getSingleProb() {
		return singleProb;
	}

	public int getDoubleProb() {
		return doubleProb;
	}

	public int getTripleProb() {
		return tripleProb;
	}

	public int getHomeRunProb() {
		return homeRunProb;
	}

	public int getWalkProb() {
		return walkProb;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSingleProb(int singleProb) {
		this.singleProb = singleProb;
	}

	public void setDoubleProb(int doubleProb) {
		this.doubleProb = doubleProb;
	}

	public void setTripleProb(int tripleProb) {
		this.tripleProb = tripleProb;
	}

	public void setHomeRunProb(int homeRunProb) {
		this.homeRunProb = homeRunProb;
	}

	public void setWalkProb(int walkProb) {
		this.walkProb = walkProb;
	}

	public String toString() {
		return name;
	}
}
