import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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
    
}