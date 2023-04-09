import java.util.Map;

public interface IUserQuestionOperations {
	public Map<String, Integer> parseSingleQuiz(String questionsOfSingleQuiz);
	public int answerQuiz( Map<String, Integer> singleQuizMap);
	public int calculateQuizPoint(String questionsOfSingleQuiz);

}
