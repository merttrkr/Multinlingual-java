import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*; 

public class FileIO implements IFileIO {
	
	// This method reads user data from a CSV file and returns an ArrayList of User objects
    public ArrayList<User> readUsersCSV(String fileName) {
        String csvFile = fileName;
        String line = "";
        String csvSplitBy = ";";
        ArrayList<User> userList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read each line of the CSV file and create a User object from the data
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
        // Return the list of User objects
        return userList;
    }

    
 // This method creates a CSV file with information about the languages, units, and quizzes
    public void createLanguagesCSV(Language[] languages){
		try {
            // Create a new FileWriter object to write to the CSV file
            FileWriter writer = new FileWriter("languages.csv");
            // Write a header row to the CSV file
            writer.append("Language Name;Number of Units;Number of Quizzes;The number of questions in each quiz;The types of questions in each quiz\n");

            // Loop through each Language object in the array
            for (Language language : languages) {
                // Get the array of Unit objects for this Language
                Unit[] units = language.getUnitsArray();
                // Loop through each Unit object in the array
                for (Unit unit : units) {
                    // Get the array of Quiz objects for this Unit
                    Quiz[] quizzes = unit.getQuizArray();
                    // Write the language, unit, and quiz data to the CSV file
                    writer.append(language.getName())
              	    .append(";")
              	    .append(String.valueOf(language.getUnitNumber()))
                    .append(";")
                    .append(String.valueOf(unit.getQuizNumber()));
         
                    for (Quiz quiz: quizzes) {   
                        writer.append(";")
                        	   .append(String.valueOf(quiz.getListeningQuestionNumber() + " Listening Questions ," + quiz.getReadingQuestionNumber() + " Reading Questions ," + quiz.getSpeakingQuestionNumber() + " Speaking Questions ," + quiz.getWordMatchingQuestionNumber() + " Word Matching Questions" ));        	        
                    }
                    // Write a new line to the CSV file for the next Unit object
                    writer.append("\n");
                }
            }
            // Flush and close the FileWriter object
            writer.flush();
            writer.close();
            // Print a message indicating that the file was created successfully
            System.out.println("languages.csv file generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}

    public Map<String, Integer> getQuizNumbers() {
        // Create a new HashMap to store the quiz numbers by language
        Map<String, Integer> quizNumbers = new HashMap<>();
        try {
            // Open the file "languages.csv" for reading
            BufferedReader reader = new BufferedReader(new FileReader("languages.csv"));
            reader.readLine();
            String line = reader.readLine();
            String prevFirstCol = "Spanish";
            int total = 0;
            // Loop over each data row in the file
            while (line != null ) {
                // Split the data row into an array of values using the ";" delimiter
                String[] values = line.split(";");
                // Extract the language from the first column of the data row
                String firstCol = values[0];
                // Extract the quiz number from the third column of the data row and parse it as an integer
                int thirdCol = Integer.parseInt(values[2]);
                // If the language is the same as the previous row, add the quiz number to the running total
                if (prevFirstCol.equals(firstCol)) {
                    total += thirdCol;
                }
                // Otherwise, store the total quiz number for the previous language in the map,
                // reset the running total to the quiz number for the current row,
                // and update the previous language to the current language
                else {
                    quizNumbers.put(prevFirstCol, total);
                    total = thirdCol;
                    prevFirstCol = values[0];
                }
                // Read the next data row
                line = reader.readLine();
            }
            // Store the total quiz number and language in the map
            quizNumbers.put(prevFirstCol, total);
            reader.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        // Return the map of quiz numbers by language
        return quizNumbers;
    }
    
 // This method returns a map of language names and the corresponding number of units for each language.

    public Map<String, Integer> getUnitNumbers() {
    // Initialize a new HashMap to store the language names and their corresponding unit numbers.
    Map<String, Integer> quizNumbers = new HashMap<>();
    try {
        // Create a new BufferedReader object to read the data from the "languages.csv" file.
        BufferedReader reader = new BufferedReader(new FileReader("languages.csv"));
        
        // Skip the first line of the file, which contains column headers.
        reader.readLine();
        
        // Read the first data line from the file.
        String line = reader.readLine(); 
        
        // Initialize a variable to store the name of the previous language read from the file.
        String prevFirstCol = "Spanish";
        
        // Loop through each line of data in the file.
        while (line != null ) {
            
            // Split the line into an array of values using the ";" delimiter.
            String[] values = line.split(";");
            
            // Extract the language name and number of units from the array.
            String languageName = values[0];
            int numberOfUnits = Integer.parseInt(values[1]);

            // Check if the current language name is the same as the previous language name.
            if (prevFirstCol.equals(languageName)) {
                
                // If the current language name is the same as the previous language name, add the language name
                // and unit number to the HashMap.
                quizNumbers.put(prevFirstCol, numberOfUnits);
            } 
            else {
                
                // If the current language name is different from the previous language name, update the
                // prevFirstCol variable to the current language name.
                prevFirstCol = values[0];
            }
            
            // Read the next line of data from the file.
            line = reader.readLine();
        }
        
        // Close the BufferedReader object to release system resources.
        reader.close();
        
    } catch (IOException e) {
        // If an exception occurs while reading the file, print the stack trace to the console.
        e.printStackTrace();
    }

    // Return the HashMap containing the language names and their corresponding unit numbers.
    return quizNumbers;
    }
    
    
    public void getQuizzesArrayAndSolve(User user){
        try {
            // Open the file "languages.csv" for reading
            BufferedReader reader = new BufferedReader(new FileReader("languages.csv"));
            reader.readLine();
            String line = reader.readLine();
            // Get the user's chosen language and number of quizzes to solve
            String userLanguage = user.getLanguageChoice();
            int quizzesToBeSolved = user.getQuizzesCompleted();

            // Initialize variables to track the current unit, total points earned, and whether there are quizzes left to solve
            int unitCounter = 0;
            int totalPoint = 0;
            // Loop over each data row in the file while there are quizzes left to solve
            while (line != null && (quizzesToBeSolved != 0 )) {
                // Split the data row into an array of values using the ";" delimiter
                String[] values = line.split(";");
                // If the language in the data row matches the user's chosen language, proceed
                if (values[0].equals(userLanguage)) {

                    int currentUnitQuizNum = Integer.parseInt(values[2]);
                    // If there are enough quizzes in the current unit to satisfy the user's remaining quiz count,
                    // increment the current unit counter, solve the quizzes, and update the total points earned
                    if ((quizzesToBeSolved > currentUnitQuizNum) ){
                        unitCounter ++;

                        for (int i = 3; i < values.length ; i++) {
                            String currentQuizLine = values[i];
                            UserQuestionOperations userQuestionOperations = new UserQuestionOperations();
                            totalPoint += userQuestionOperations.calculateQuizPoint(currentQuizLine);

                            quizzesToBeSolved -- ;
                        }

                    }
                    // Otherwise, solve the remaining quizzes in the current unit and update the current unit counter and total points earned
                    else {
                        unitCounter ++;

                        int quizNumberForLastUnitRange = 3 + quizzesToBeSolved;
                        for (int i = 3; i < quizNumberForLastUnitRange ; i++) {
                            String currentQuizLine = values[i];
                            UserQuestionOperations userQuestionOperations = new UserQuestionOperations();
                            totalPoint += userQuestionOperations.calculateQuizPoint(currentQuizLine);

                            quizzesToBeSolved --;

                        }
                    }
                }
                // Read the next data row
                line = reader.readLine();
            }
            // Update the user's current unit and total points earned based on the quizzes solved
            user.setCurrentUnit(unitCounter);
            user.setPoint(totalPoint);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}