import java.util.ArrayList;

public class SaphireLeague extends League{
	private int minStreakNumber;
	private int minUnitNumber;
	private int minPoint;
	
	public SaphireLeague(String language) {
		super(language);
		this.minStreakNumber = 30;
		this.minUnitNumber = 10;
		this.minPoint = 5000 ;	
	}
	
	public int getMinStreakNumber() {
		return minStreakNumber;
	}

	public int getMinUnitNumber() {
		return minUnitNumber;
	}

	public int getMinPoint() {
		return minPoint;
	}
	
	public ArrayList<User> promoteToSaphire() {
		ArrayList<User> promotedUsers = new ArrayList<User>();		
		int count = 0;
	
		for(int i = 0 ; i < this.getLeaderBoard().size() ; i ++) {
			if(minStreakNumber <= this.getLeaderBoard().get(i).getStreakNumber()) {
				if((minUnitNumber <= this.getLeaderBoard().get(i).getStreakNumber()) || (minPoint <= this.getLeaderBoard().get(i).getStreakNumber()))
				promotedUsers.add(count, this.getLeaderBoard().get(i));
				count ++;
			}
		}
		
		ArrayList<User> newLeaderBoard = new ArrayList<User>(promotedUsers.subList(0, promotedUsers.size()));
		this.setLeaderBoard(newLeaderBoard);
		return promotedUsers;
	}
	
}
