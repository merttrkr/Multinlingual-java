import java.util.ArrayList;

public class GoldenLeague extends League implements ILeague {
	private int minRank;
	private int minStreakNumber;
	
	public GoldenLeague(String language) {
		super(language);
		this.minRank = 5;
		this.minStreakNumber = 7;
	}
	
	public int getMinRank() {
		return minRank;
	}
	
	public int getMinStreakNumber() {
		return minStreakNumber;
	}

	public ArrayList<User> promoteToNextLeague() {
		ArrayList<User> promotedUsers = new ArrayList<User>();		
		int count = 0;
	
		for(int i = 0 ; i < minRank ; i ++) {
			if(minStreakNumber <= this.getLeaderBoard().get(i).getStreakNumber()) {
				promotedUsers.add(count, this.getLeaderBoard().get(i));
				count ++;
			}
		}
		
		ArrayList<User> newLeaderBoard = new ArrayList<User>(this.getLeaderBoard().subList(promotedUsers.size(), this.getLeaderBoard().size()));
		this.setLeaderBoard(newLeaderBoard);
		return promotedUsers;
	}

}
