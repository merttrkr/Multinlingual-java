import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.io.File;

public class Multilingualism {
    public static void main(String[] args) {
    	String csvFile = "users.csv";
    	FileIO fileIO = new FileIO();
        List<User> userList = new ArrayList<>();
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
        
        
        
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", "b",30, "Bronze", 51, 33, 500, "Spanish"));
        users.add(new User("Bob", "b",33,"Bronze", 52, 17, 510, "Spanish"));
        users.add(new User("Charlie", "b",30, "Bronze", 53, 20, 520, "Spanish"));
        users.add(new User("David", "b",31, "Bronze", 54, 30, 540, "Spanish"));
        users.add(new User("Efe", "b",32, "Bronze", 40, 16, 503, "Spanish"));

        Comparator<User> byPointThenStreakThenUnit = Comparator.comparing(User::getPoint)
                                                        .reversed()
                                                        .thenComparing(User::getStreakNumber)
                                                        .reversed()
                                                        .thenComparing(User::getCurrentUnit);
        Collections.sort(users, byPointThenStreakThenUnit);

        for (User user : users) {
            //System.out.println(user.getUsername() + " Point: " + user.getPoint() + " StreakNum: " + user.getStreakNumber() + " CurrentUnit: " + user.getCurrentUnit());
        }
    
    }	
}