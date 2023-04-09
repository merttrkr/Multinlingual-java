import java.io.File;
import java.util.*;
import java.util.stream.Collectors; 

public class Multilingualism {
    public static void main(String[] args) {
    	String csvFile = "users.csv";
    	FileIO fileIO = new FileIO();
        ArrayList<User> userList = new ArrayList<>();
        userList = fileIO.readUsersCSV(csvFile);

        
        String fileName = "languages.csv"; // file name or path to check
        File file = new File(fileName); // create a File object
        
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
          
        Map<String, Integer> quizNumbersMap = fileIO.getQuizNumbers();

        for(User user: userList) {
        	
        	Random rand = new Random();
        	user.setQuizzesCompleted(rand.nextInt(6, quizNumbersMap.get(userList.get(0).getLanguageChoice())));
        	fileIO.getQuizzesArray(user);
        }

                
        Comparator<User> byPointThenStreakThenUnit = Comparator.comparing(User::getPoint)
                                                        .thenComparing(User::getStreakNumber)
                                                        .reversed();
        Collections.sort(userList, byPointThenStreakThenUnit);
        for (User user : userList) {
            System.out.println(user.getUsername() + "Lang: " + user.getLanguageChoice() + " Point: " + user.getPoint() + " StreakNum: " + user.getStreakNumber() + " CurrentUnit: " + user.getCurrentUnit() + " Quizzes Completed: " +user.getQuizzesCompleted());
        }
        
	     ArrayList<User> turkishUsers = new ArrayList<>();
	     ArrayList<User> spanishUsers = new ArrayList<>();
	     ArrayList<User> germanUsers = new ArrayList<>();
	     ArrayList<User> italianUsers = new ArrayList<>();
	
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

        
        LeagueOperations leagueOperations = new LeagueOperations();
        League[] spanishLeagues = leagueOperations.leaguePlacement(LanguageEnum.SPANISH, spanishUsers);
        League[] germanLeagues = leagueOperations.leaguePlacement(LanguageEnum.GERMAN, spanishUsers);
        League[] italianLeagues = leagueOperations.leaguePlacement(LanguageEnum.ITALIAN, spanishUsers);
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
        String maxKeyUnit = null;
        int maxValueUnit = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : unitNumbersOfLanguages.entrySet()) {
            if (entry.getValue() > maxValueUnit) {
                maxValueUnit = entry.getValue();
                maxKeyUnit = entry.getKey();
            }
        }  

        System.out.println("3- " + maxKeyUnit + " " + maxValueUnit);
        
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : quizNumbersMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }       
        System.out.println("4- " + maxKey + " " + maxValue);
        
        

        List<User> firstThreeInItalian = italianUsers.subList(0, 3);
        System.out.print("5- Italian Silver League Top : ");
        for(User user: firstThreeInItalian) {
        	System.out.print(user.getUsername() + " ");
        }
        System.out.println();
        

    }	
}