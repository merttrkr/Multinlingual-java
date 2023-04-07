
public class BronzeLeague extends League{
	public BronzeLeague() {
		super(0);
	}
	
	public boolean isSilver(int rank) {
		if (rank > this.getMinRank()) {
			return false;
		}
		return true;
	}
}

