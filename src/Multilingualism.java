import java.util.Collections;
import java.util.Map;
import java.io.File;
import java.util.*;

public class Multilingualism {
    public static void main(String[] args) {
    	// Read users from CSV file
    	String csvFile = "users.csv";
    	FileIO fileIO = new FileIO();
        ArrayList<User> userList = new ArrayList<>();
        userList = fileIO.readUsersCSV(csvFile);
        
        // Check if languages.csv file exists
        String fileName = "languages.csv"; // file name or path to check
        File file = new File(fileName); // create a File object
        
        // If languages.csv file doesn't exist, create it with default languages
        if (! file.exists()) {
        	Language spanish = new Language(LanguageEnum.SPANISH.getName());
        	Language german = new Language(LanguageEnum.GERMAN.getName());
        	Language italian = new Language(LanguageEnum.ITALIAN.getName());
        	Language turkish = new Language(LanguageEnum.TURKISH.getName()); 
        	
        	Language[] languagesArray = {spanish, german, italian, turkish};
        	fileIO.createLanguagesCSV(languagesArray);
        } else {
            System.out.println(fileName +" file already exists.");
        }
          
        // Get quiz numbers map from fileIO
        Map<String, Integer> quizNumbersMap = fileIO.getQuizNumbers();
      
        // Randomly assign quizzes completed for each user and get quizzes array
        for(User user: userList) {
        	Random rand = new Random();
        	user.setQuizzesCompleted(rand.nextInt(6, quizNumbersMap.get(userList.get(0).getLanguageChoice())));
        	fileIO.getQuizzesArrayAndSolve(user);
        }

        // Sort users by points, streak, and unit completed
        Comparator<User> byPointThenStreakThenUnit = Comparator.comparing(User::getPoint)
                                                        .thenComparing(User::getStreakNumber)
                                                        .reversed();
        Collections.sort(userList, byPointThenStreakThenUnit);

        
	     // Create separate user lists for each language
	     ArrayList<User> turkishUsers = new ArrayList<>();
	     ArrayList<User> spanishUsers = new ArrayList<>();
	     ArrayList<User> germanUsers = new ArrayList<>();
	     ArrayList<User> italianUsers = new ArrayList<>();
	
	     // Populate each language's user list
	     for (User user : userList) {
	         switch (user.getLanguageChoice()) {
	             case "Turkish":
	                 turkishUsers.add(user);
	                 break;
	             case "Spanish":
	                 spanishUsers.add(user);
	                 break;
	             case "German":
	                 germanUsers.add(user);
	                 break;
	             case "Italian":
	                 italianUsers.add(user);
	                 break;
	             default:
	                 break;
	         }
	     }
 
        // Create leagues for each language and get user placement in leagues
        LeagueOperations leagueOperations = new LeagueOperations();
        League[] spanishLeagues = leagueOperations.leaguePlacement(LanguageEnum.SPANISH, spanishUsers);
        League[] germanLeagues = leagueOperations.leaguePlacement(LanguageEnum.GERMAN, spanishUsers); // should be germanUsers instead of spanishUsers
        League[] italianLeagues = leagueOperations.leaguePlacement(LanguageEnum.ITALIAN, spanishUsers); // should be italianUsers instead of spanishUsers
        League[] turkishLeagues = leagueOperations.leaguePlacement(LanguageEnum.TURKISH, spanishUsers);
        
        System.out.println("1- " + userList.get(0).getUsername() + " " + userList.get(0).getPoint() + " points" );

        int maxUnitNumber = Integer.MIN_VALUE;
        User bestGermanUser = new User("", "");
        for (User user : germanUsers) {
            if (user.getCurrentUnit() > maxUnitNumber) {
                bestGermanUser = user;
                maxUnitNumber = user.getCurrentUnit();
            }
        }
        System.out.println("2- " + bestGermanUser.getUsername() + " Unit " + bestGermanUser.getCurrentUnit());

        Map<String, Integer> unitNumbersOfLanguages = fileIO.getUnitNumbers();
        String maxKeyUnit = "";
        int maxValueUnit = Integer.MIN_VALUE;

        // Finding the language with the most number of units
        for (Map.Entry<String, Integer> entry : unitNumbersOfLanguages.entrySet()) {
            if (entry.getValue() > maxValueUnit) {
                maxValueUnit = entry.getValue();
                maxKeyUnit = entry.getKey();
            }
        }

        System.out.println("3- " + maxKeyUnit + " " + maxValueUnit);

        String maxKeyQuiz = "";
        int maxValueQuiz = Integer.MIN_VALUE;

        // Finding the quiz with the highest number of attempts
        for (Map.Entry<String, Integer> entry : quizNumbersMap.entrySet()) {
            if (entry.getValue() > maxValueQuiz) {
                maxValueQuiz = entry.getValue();
                maxKeyQuiz = entry.getKey();
            }
        }
        System.out.println("4- " + maxKeyQuiz + " " + maxValueQuiz);

        List<User> firstThreeInItalian = italianLeagues[1].getLeaderBoard().subList(0, 3);
        System.out.print("5- Italian Silver League Top : ");

        // Printing the usernames of the top three users in the Italian Silver League
        for(User user: firstThreeInItalian) {
            System.out.print(user.getUsername() + " ");
        }
        System.out.println();
        }
}
