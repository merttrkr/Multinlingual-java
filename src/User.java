
public class User {
	private String username;
    private String password;
    private int unitsCompleted;
    private String league;
    private int quizzesCompleted;
    private int streakNumber;
    private int point;
    private String languageChoice;

    public User(String username, String password) {
        this(username, password, 0, "", 0, 0, 0, "");
    }
    
    // Constructor
    public User(String username, String password, int unitsCompleted, String league, int quizzesCompleted, int streakNumber, int point, String languageChoice) {
        this.username = username;
        this.password = password;
        this.unitsCompleted = unitsCompleted;
        this.league = league;
        this.quizzesCompleted = quizzesCompleted;
        this.streakNumber = streakNumber;
        this.point = point;
        this.languageChoice = languageChoice;
    }
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUnitsCompleted() {
		return unitsCompleted;
	}

	public void setUnitsCompleted(int unitsCompleted) {
		this.unitsCompleted = unitsCompleted;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public int getQuizzesCompleted() {
		return quizzesCompleted;
	}

	public void setQuizzesCompleted(int quizzesCompleted) {
		this.quizzesCompleted = quizzesCompleted;
	}

	public int getStreakNumber() {
		return streakNumber;
	}

	public void setStreakNumber(int streakNumber) {
		this.streakNumber = streakNumber;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getLanguageChoice() {
		return languageChoice;
	}

	public void setLanguageChoice(String languageChoice) {
		this.languageChoice = languageChoice;
	}
 }    