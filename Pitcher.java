public class Pitcher {
	String name;
	int pitchProb;
	int maxpitchCount;

	public Pitcher(String name, int pitchProb, int maxpitchCount) {
		this.name = name;
		this.pitchProb = pitchProb;
		this.maxpitchCount = maxpitchCount;
	}

	public String getName() {
		return name;
	}

	public int getPitchProb() {
		return pitchProb;
	}

	public int getMaxPitchCount() {
		return maxpitchCount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPitchProb(int pitchProb) {
		this.pitchProb = pitchProb;
	}

	public void setMaxPitchCount(int pitchCount) {
		this.maxpitchCount = pitchCount;
	}
}
