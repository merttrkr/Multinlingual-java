import java.util.HashMap;
import java.util.Random;
import java.util.Map;

public class WordMatchingQuestion extends Question {
	public WordMatchingQuestion(String languageName) {
		super(5, createWordMatchingContent(languageName), languageName);
	}
	
	public static Object[] createWordMatchingContent(String languageName) {
		Random rand = new Random();
		int numberOfWords = rand.nextInt(4, 9);
		Object[] wordMatchingContent = new Object[numberOfWords];
	    Map<StringContent, StringContent> content = new HashMap<>();
	    for (int i = 0; i < numberOfWords; i++) {
	    	StringContent englishWord = new StringContent("English");
	     	StringContent translatedWord = new StringContent(languageName);
	     	content.put(englishWord, translatedWord);
	     	wordMatchingContent[i] = content;
	    }

	    return wordMatchingContent;
	}
	
	@Override
    public String toString() {
        return "Word Matching Question";
    }
}
