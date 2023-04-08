import java.util.Random;

public class User {
	private String username;
    private String password;
    private int currentUnit;
    private String league;
    private int quizzesCompleted;
    private int streakNumber;
    private int point;
    private String languageChoice;

    public User(String username, String password) {
        this(username, password, 0, "", 0, 0, 0, "");
    }
    
    public User(String username, String password, int currentUnit, String league, int quizzesCompleted,int StreakNumber, int point, String languageChoice) {
    	Random rand = new Random();
    	this.username = username;
        this.password = password;
        this.league = "Bronze";
        this.streakNumber = rand.nextInt(0, 365);
        this.languageChoice = generateRandomUserLanguageChoice();
    }
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCurrentUnit() {
		return currentUnit;
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

	
	public static String generateRandomUserLanguageChoice() {
    	LanguageEnum[] languages = LanguageEnum.values();
        Random rand = new Random();
        int randomIndex = rand.nextInt(1, languages.length);
        return languages[randomIndex].getName();
	}
 }    