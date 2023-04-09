import java.util.*;


public abstract class League {
	private String language;
	private ArrayList<User> leaderBoard;
	
	public League(String language) {
		this.language = language;
	}

	public ArrayList<User> getLeaderBoard() {
		return leaderBoard;
	}

	public void setLeaderBoard(ArrayList<User> leaderBoard) {
		this.leaderBoard = leaderBoard;
	}

	public String getLanguage() {
		return language;
	}

	
}
