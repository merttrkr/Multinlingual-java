
public abstract class League {
	private int minRank;
	private User[] leaderBoard;
	
	public League(int minRank) {
		this.minRank = minRank;
	}

	public int getMinRank() {
		return minRank;
	}

	public User[] getLeaderBoard() {
		return leaderBoard;
	}

	public void setLeaderBoard(User[] leaderBoard) {
		this.leaderBoard = leaderBoard;
	}

	
}
