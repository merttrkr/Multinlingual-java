import java.util.*;

public class BronzeLeague extends League implements ILeague{
	private int minRank;
	
	public BronzeLeague(String language) {
		super(language);
		this.minRank = 15;
	}
	
	public int getMinRank() {
		return minRank;
	}
	
	public ArrayList<User> promoteToNextLeague() {
		ArrayList<User> promotedUsers = new ArrayList<User>();
		
		for(int i = 0 ; i < minRank ; i ++) {
			promotedUsers.add(i, this.getLeaderBoard().get(i));
			
		}
		ArrayList<User> newLeaderBoard = new ArrayList<User>(this.getLeaderBoard().subList(promotedUsers.size(), this.getLeaderBoard().size()));
		
		this.setLeaderBoard(newLeaderBoard);
		return promotedUsers;
	}
	
}

