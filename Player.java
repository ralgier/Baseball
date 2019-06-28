public class Player {
	public String name;
	public int singleProb;
	public int doubleProb;
	public int tripleProb;
	public int homeRunProb;
	public int walkProb;

	public Player(String name, int singleProb, int doubleProb, int tripleProb, int homeRunProb, int walkProb) {
		this.name = name;
		this.singleProb = singleProb;
		this.doubleProb = doubleProb;
		this.tripleProb = tripleProb;
		this.homeRunProb = homeRunProb;
		this.walkProb = walkProb;
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
