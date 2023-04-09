import java.io.File;
import java.util.Random;
import java.util.*; 

public class UserQuestionOperations {


	public void answerQuestion(String questionsOfSingleQuiz) {

    	//questionsOfSingleQuiz = "3 Listening Questions,3 Reading Questions,4 Speaking Questions,5 Word Matching Questions";
        Map<String, Integer> map = new HashMap<>();

        String[] parts = questionsOfSingleQuiz.split(",");
        for (String part : parts) {
            String[] subparts = part.trim().split(" ");
            int value = Integer.parseInt(subparts[0]);
            String key = String.join(" ", Arrays.copyOfRange(subparts, 1, subparts.length));
            map.put(key, value);
        }
        System.out.println(map.keySet()  + "values: " +map.values());
        System.out.println();
        }
	
}
