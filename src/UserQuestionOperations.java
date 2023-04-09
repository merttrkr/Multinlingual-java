import java.util.Random;
import java.util.*; 

public class UserQuestionOperations {


	public Map<String, Integer> parseSingleQuiz(String questionsOfSingleQuiz) {

    	//questionsOfSingleQuiz = "3 Listening Questions,3 Reading Questions,4 Speaking Questions,5 Word Matching Questions";
        Map<String, Integer> map = new HashMap<>();

        String[] parts = questionsOfSingleQuiz.split(",");
        for (String part : parts) {
            String[] subparts = part.trim().split(" ");
            int value = Integer.parseInt(subparts[0]);
            String key = String.join(" ", Arrays.copyOfRange(subparts, 1, subparts.length));
            map.put(key, value);
        }
        return map;
    }
	
	public int answerQuiz( Map<String, Integer> singleQuizMap) {
        Random rand = new Random();
        int correctlySolvedListening = rand.nextInt(0, (singleQuizMap.get("Listening Questions")+1));
        int correctlySolvedReading = rand.nextInt(0, (singleQuizMap.get("Reading Questions")+1));
        int correctlySolvedWordMatching = rand.nextInt(0, (singleQuizMap.get("Word Matching Questions")+1));
        int correctlySolvedSpeaking = rand.nextInt(0, (singleQuizMap.get("Speaking Questions")+1));
        int totalPoint = (7 * correctlySolvedListening) + (10 * correctlySolvedReading) + (5 * correctlySolvedWordMatching) + (8 * correctlySolvedSpeaking);
        //System.out.println("7 *" + correctlySolvedListening + ", 10 * "+correctlySolvedReading + ", 5 * " + correctlySolvedWordMatching + ", 8 * " + correctlySolvedSpeaking );
        return totalPoint;
	}
	
	public int calculateQuizPoint(String questionsOfSingleQuiz) {
		int quizPoint = answerQuiz(parseSingleQuiz(questionsOfSingleQuiz));
		//System.out.println("Quiz Point: " + quizPoint);
		return quizPoint;
		
	}
}
