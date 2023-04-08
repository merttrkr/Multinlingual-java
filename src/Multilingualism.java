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
        System.out.println("Spanish quiz number: " + fileIO.getQuizNumbers().keySet() +fileIO.getQuizNumbers().values() );
        
        for(User user: userList) {
        	Random rand = new Random();
        	user.setQuizzesCompleted(rand.nextInt(6, fileIO.getQuizNumbers().get(user.getLanguageChoice())));
        	System.out.println("user lang: " + user.getLanguageChoice());
        	System.out.println("user quiz num: " + user.getQuizzesCompleted());
        }
        /*
         *String input = "3 Listening Questions,3 Reading Questions,4 Speaking Questions,5 Word Matching Questions";
        Map<String, Integer> map = new HashMap<>();

        String[] parts = input.split(",");
        for (String part : parts) {
            String[] subparts = part.trim().split(" ");
            int value = Integer.parseInt(subparts[0]);
            String key = String.join(" ", Arrays.copyOfRange(subparts, 1, subparts.length));
            map.put(key, value);
        }

        System.out.println("First element: "+map.get("Listening Questions"));

         */
        
        //user random question cevaplıcak
        //user ın puanı hesaplancak
        //user ın uniti hesaplancak
        //userları sıralıcaz
        //userları league e yerleştircez
        //Leagueları languagelardan çıkarmak lazım
        //multilanguage a soru ekle
        //interface yaz
        //comment yaz
        
        
        /*Comparator<User> byPointThenStreakThenUnit = Comparator.comparing(User::getPoint)
                                                        .reversed()
                                                        .thenComparing(User::getStreakNumber)
                                                        .reversed()
                                                        .thenComparing(User::getCurrentUnit);
        Collections.sort(users, byPointThenStreakThenUnit);

        for (User user : users) {
            //System.out.println(user.getUsername() + " Point: " + user.getPoint() + " StreakNum: " + user.getStreakNumber() + " CurrentUnit: " + user.getCurrentUnit());
        }*/
    
    }	
}