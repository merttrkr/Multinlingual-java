
public class SilverLeague extends League {
	public SilverLeague() {
		super(15);
	}
	
	public boolean isSilver(int rank) {
		if (rank > this.getMinRank()) {
			return false;
		}
		return true;
	}
}
