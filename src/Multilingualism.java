import java.io.File;
import java.util.*; 

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
        System.out.println("Spanish quiz number: " + fileIO.getQuizNumbers().keySet() +fileIO.getQuizNumbers().values() );
        

        for(User user: userList) {
        	
        	Random rand = new Random();
        	user.setQuizzesCompleted(rand.nextInt(6, fileIO.getQuizNumbers().get(userList.get(0).getLanguageChoice())));
        	fileIO.getQuizzesArray(user);
        }

        //user random question cevaplıcak
        //user ın puanı hesaplancak
        //user ın uniti hesaplancak
        //userları sıralıcaz
        //userları league e yerleştircez
        //Leagueları languagelardan çıkarmak lazım
        //multilanguage a soru ekle
        //interface yaz
        //comment yaz
        
        
        
        Comparator<User> byPointThenStreakThenUnit = Comparator.comparing(User::getPoint)
                                                        .thenComparing(User::getStreakNumber)
                                                        .reversed();
        Collections.sort(userList, byPointThenStreakThenUnit);
        
        User[] userArray = userList.toArray(new User[userList.size()]); 

        for (User user : userArray) {
            System.out.println(user.getUsername() + " Point: " + user.getPoint() + " StreakNum: " + user.getStreakNumber() + " CurrentUnit: " + user.getCurrentUnit() + " Quizzes Completed: " +user.getQuizzesCompleted());
        }
        
        BronzeLeague bronzeLeagueSpanish = new BronzeLeague(LanguageEnum.SPANISH.getName());
        SilverLeague silverLeagueSpanish = new SilverLeague(LanguageEnum.SPANISH.getName());
        GoldenLeague goldenLeagueSpanish = new GoldenLeague(LanguageEnum.SPANISH.getName());
        SaphireLeague saphireLeagueSpanish = new SaphireLeague(LanguageEnum.SPANISH.getName());
        RubyLeague rubyLeagueSpanish = new RubyLeague(LanguageEnum.SPANISH.getName());
        
        BronzeLeague bronzeLeagueGerman = new BronzeLeague(LanguageEnum.GERMAN.getName());
        SilverLeague silverLeagueGerman = new SilverLeague(LanguageEnum.GERMAN.getName());
        GoldenLeague goldenLeagueGerman = new GoldenLeague(LanguageEnum.GERMAN.getName());
        SaphireLeague saphireLeagueGerman = new SaphireLeague(LanguageEnum.GERMAN.getName());
        RubyLeague rubyLeagueGerman = new RubyLeague(LanguageEnum.GERMAN.getName());
        
        BronzeLeague bronzeLeagueItalian = new BronzeLeague(LanguageEnum.ITALIAN.getName());
        SilverLeague silverLeagueItalian = new SilverLeague(LanguageEnum.ITALIAN.getName());
        GoldenLeague goldenLeagueItalian = new GoldenLeague(LanguageEnum.ITALIAN.getName());
        SaphireLeague saphireLeagueItalian = new SaphireLeague(LanguageEnum.ITALIAN.getName());
        RubyLeague rubyLeagueItalian = new RubyLeague(LanguageEnum.ITALIAN.getName());
        
        BronzeLeague bronzeLeagueTurkish = new BronzeLeague(LanguageEnum.TURKISH.getName());
        SilverLeague silverLeagueTurkish = new SilverLeague(LanguageEnum.TURKISH.getName());
        GoldenLeague goldenLeagueTurkish = new GoldenLeague(LanguageEnum.TURKISH.getName());
        SaphireLeague saphireLeagueTurkish = new SaphireLeague(LanguageEnum.TURKISH.getName());
        RubyLeague rubyLeagueTurkish = new RubyLeague(LanguageEnum.TURKISH.getName());
        
        bronzeLeagueSpanish.setLeaderBoard(userList);
        
        ArrayList<User> promotedToSilver = bronzeLeagueSpanish.promoteToSilver();
        silverLeagueSpanish.setLeaderBoard(promotedToSilver);
        
        ArrayList<User> promotedToGolden = silverLeagueSpanish.promoteToGolden();
        goldenLeagueSpanish.setLeaderBoard(promotedToGolden);
        
        ArrayList<User> promotedToSaphire = goldenLeagueSpanish.promoteToSaphire();
        saphireLeagueSpanish.setLeaderBoard(promotedToSaphire);
        
        ArrayList<User> promotedToRuby = saphireLeagueSpanish.promoteToSaphire();
        rubyLeagueSpanish.setLeaderBoard(promotedToRuby);
        
        for(User user : saphireLeagueSpanish.getLeaderBoard()) {
        	System.out.println("Saphire: "+ user.getUsername());
        }
              
        for(User user : rubyLeagueSpanish.getLeaderBoard()) {
        	System.out.println("Ruby: "+ user.getUsername());
        }

    }	
}