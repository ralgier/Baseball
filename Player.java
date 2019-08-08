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
	public int rbi;
	public int runs;
	public int seasonSingles;
	public int seasonDoubles;
	public int seasonTriples;
	public int seasonHomeruns;
	public int seasonWalks;
	public int seasonAtBats;
	public int seasonHits;
	public int seasonrbi;
	public int seasonruns;

	public Player(int orderNum, String name, int singleProb, int doubleProb, int tripleProb, int homeRunProb, int walkProb, 
			int numSingles, int numDoubles, int numTriples, int numHomerun, int numWalk, int numAtBats, int numHits, int rbi, int runs, 
			int seasonSingles, int seasonDoubles, int seasonTriples, int seasonHomeruns,int seasonWalks,
			int seasonAtBats, int seasonHits, int seasonrbi,int seasonruns) {
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
		this.numHomeruns = numHomerun;
		this.numHits = numHits;
		this.numWalks = numWalk;
		this.rbi = rbi;
		this.runs = runs;
		this.seasonSingles = seasonSingles;
		this.seasonDoubles = seasonDoubles;
		this.seasonTriples = seasonTriples;
		this.seasonHomeruns = seasonHomeruns;
		this.seasonWalks = seasonWalks;
		this.seasonAtBats = seasonAtBats;
		this.seasonHits = seasonHits;
		this.seasonrbi = seasonrbi;
		this.seasonruns = seasonruns;
		
	}
	public int getSeasonSingles() {
		return seasonSingles;
	}
	public void setSeasonSingles(int seasonSingles) {
		this.seasonSingles = seasonSingles;
	}
	public int getSeasonDoubles() {
		return seasonDoubles;
	}
	public void setSeasonDoubles(int seasonDoubles) {
		this.seasonDoubles = seasonDoubles;
	}
	public int getSeasonTriples() {
		return seasonTriples;
	}
	public void setSeasonTriples(int seasonTriples) {
		this.seasonTriples = seasonTriples;
	}
	public int getSeasonHomeruns() {
		return seasonHomeruns;
	}
	public void setSeasonHomeruns(int seasonHomeruns) {
		this.seasonHomeruns = seasonHomeruns;
	}
	public int getSeasonWalks() {
		return seasonWalks;
	}
	public void setSeasonWalks(int seasonWalks) {
		this.seasonWalks = seasonWalks;
	}
	public int getSeasonAtBats() {
		return seasonAtBats;
	}
	public void setSeasonAtBats(int seasonAtBats) {
		this.seasonAtBats = seasonAtBats;
	}
	public int getSeasonHits() {
		return seasonHits;
	}
	public void setSeasonHits(int seasonHits) {
		this.seasonHits = seasonHits;
	}
	public int getSeasonrbi() {
		return seasonrbi;
	}
	public void setSeasonrbi(int seasonrbi) {
		this.seasonrbi = seasonrbi;
	}
	public int getSeasonruns() {
		return seasonruns;
	}
	public void setSeasonruns(int seasonruns) {
		this.seasonruns = seasonruns;
	}
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getRbi() {
		return rbi;
	}

	public void setRbi(int rbi) {
		this.rbi = rbi;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
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
