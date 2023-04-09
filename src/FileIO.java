import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*; 

public class FileIO {
    public List<User> readUsersCSV(String fileName) {
        String csvFile = fileName;
        String line = "";
        String csvSplitBy = ";";
        List<User> userList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(csvSplitBy);
                String username = userData[0];
                String password = userData[1];
                User user = new User(username, password);
                userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }
    
    public void createLanguagesCSV(Language[] languages){
		try {
            FileWriter writer = new FileWriter("languages.csv");
            writer.append("Language Name;Number of Units;Number of Quizzes;The number of questions in each quiz;The types of questions in each quiz\n");

            for (Language language : languages) {
                Unit[] units = language.getUnitsArray();
                for (Unit unit : units) {
                    Quiz[] quizzes = unit.getQuizArray();
                    writer.append(language.getName())
              	    .append(";")
              	    .append(String.valueOf(language.getUnitNumber()))
                    .append(";")
                    .append(String.valueOf(unit.getQuizNumber()));
         
                    for (Quiz quiz: quizzes) {   
                        writer.append(";")
                        	   .append(String.valueOf(quiz.getListeningQuestionNumber() + " Listening Questions ," + quiz.getReadingQuestionNumber() + " Reading Questions ," + quiz.getSpeakingQuestionNumber() + " Speaking Questions ," + quiz.getWordMatchingQuestionNumber() + " Word Matching Questions" ));        	        
                    }
                    writer.append("\n");
                }
            }
            writer.flush();
            writer.close();
            System.out.println("languages.csv file generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}
    public Map<String, Integer> getQuizNumbers() {
    	Map<String, Integer> quizNumbers = new HashMap<>();
    	try {
    	    BufferedReader reader = new BufferedReader(new FileReader("languages.csv"));
    	    reader.readLine();
    	    String line = reader.readLine(); 
    	    String prevFirstCol = "Spanish";
    	    int total = 0;
    	    while (line != null ) {
    	        String[] values = line.split(";");
    	        String firstCol = values[0];
    	        int thirdCol = Integer.parseInt(values[2]);
    	        //System.out.println(firstCol); 
	            if (prevFirstCol.equals(firstCol)) {
	                total += thirdCol;	                
	            } 
	            else {
	            	//System.out.println("else içinde , prevFirst: " + prevFirstCol + "firstCol: " + firstCol);
	            	quizNumbers.put(prevFirstCol, total);
	            	total =thirdCol;
	            	prevFirstCol = values[0];
	            }
	            line = reader.readLine();
    	    }
    	    quizNumbers.put(prevFirstCol, total);
    	    reader.close();
    	    //System.out.println("Total value: " + total);
       	
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}
	    return quizNumbers;
    }
    
    public void getQuizzesArray(User user){
    	try {
    	    BufferedReader reader = new BufferedReader(new FileReader("languages.csv"));
    	    reader.readLine();
    	    String line = reader.readLine(); 
    	    String userLanguage = user.getLanguageChoice();
    	    //int currentTotalQuizzesCompleted = ;
    	    int quizzesToBeSolved = user.getQuizzesCompleted();
    	    System.out.println("user quiz num: " + quizzesToBeSolved);
    	    /*user 17
    	    user > unitenin quiz sayısı
    	    	tüm ünite
    	    	user-8= 9
	    	hayır:
	    		1>0
	    		user- 
	    		uniteden bi quiz seçer 
	    		0larız
	    		*/  
    	    int unitCounter = 0;
    	    int totalPoint = 0;
    	    while (line != null && (quizzesToBeSolved != 0 ) ) {
    	        String[] values = line.split(";");
    	        if (values[0].equals(userLanguage)) {
    	        	//System.out.println("current line lang: " + values[0] + values[2]);
    	        	
    	        	int currentUnitQuizNum = Integer.parseInt(values[2]);
    	        	if ((quizzesToBeSolved > currentUnitQuizNum) ){
    	        		unitCounter ++;
    	        		//System.out.println("satırdaki quiz num: " + values[2] );
    	        		//System.out.println("quizzesToBeSolved: " + quizzesToBeSolved );
    	        		
    	        		for (int i = 3; i < values.length ; i++) {
    	    	        	String currentQuizLine = values[i];
    	    	        	//System.out.println("curr quiz line: "+ currentQuizLine);
    	    	        	UserQuestionOperations userQuestionOperations = new UserQuestionOperations();
    	    	        	totalPoint += userQuestionOperations.calculateQuizPoint(currentQuizLine);
    	    	        	
    	    	        	quizzesToBeSolved -- ;
    	    	        }

    	        	}
    	        	else {
    	        		unitCounter ++;
    	        		//System.out.println("satırdaki quiz num ELSE: " + values[2] );
    	        		//System.out.println("quizzesToBeSolved ELSE: " + quizzesToBeSolved );
    	        		int quizNumberForLastUnitRange = 3 + quizzesToBeSolved;
    	        		for (int i = 3; i < quizNumberForLastUnitRange ; i++) {
    	    	        	String currentQuizLine = values[i];
    	    	        	//System.out.println("curr quiz line: "+ currentQuizLine);
    	    	        	UserQuestionOperations userQuestionOperations = new UserQuestionOperations();
    	    	        	totalPoint += userQuestionOperations.calculateQuizPoint(currentQuizLine);
    	    	        	user.setPoint(totalPoint);
    	    	        	quizzesToBeSolved --;
        	        		//System.out.println("quizzesToBeSolved ELSE FORDA: " + quizzesToBeSolved );
        	        		//System.out.println();
    	    	        }
    	        		
    	        	System.out.println("Unit Number : " + unitCounter);	
    	        	user.setCurrentUnit(unitCounter);
    	        	user.setPoint(totalPoint);
    	        	System.out.println("total Point: " + totalPoint);
    	        	}
    	        }
    	        line = reader.readLine();

    	    }
    	    reader.close();
       	
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}

    }
    
}