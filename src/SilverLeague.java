import java.util.ArrayList;

public class SilverLeague extends League {
	private int minRank;
	
	public SilverLeague(String language) {
		super(language);
		this.minRank = 10;		
	}
	

	public int getMinRank() {
		return minRank;
	}
	
	public ArrayList<User> promoteToGolden() {
		ArrayList<User> promotedUsers = new ArrayList<User>();

		for(int i = 0 ; i < minRank ; i ++) {
			promotedUsers.add(i, this.getLeaderBoard().get(i));
		}
		
		ArrayList<User> newLeaderBoard = new ArrayList<User>(promotedUsers.subList(0, minRank));
		this.setLeaderBoard(newLeaderBoard);
		return promotedUsers;
	}
	
}
