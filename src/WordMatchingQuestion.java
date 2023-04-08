import java.util.HashMap;
import java.util.Map;

public class WordMatchingQuestion extends Question {
	public WordMatchingQuestion(String languageName) {
		super(8, createWordMatchingContent(languageName), languageName);
	}
	
	public static Object[] createWordMatchingContent(String languageName) {
		Object[] wordMatchingContent = new Object[1];
		StringContent englishWord = new StringContent("English");
		StringContent translatedWord = new StringContent(languageName);
		Map<StringContent, StringContent> content = new HashMap<>();
		content.put(englishWord, translatedWord);
		wordMatchingContent[0] = content;
		return wordMatchingContent;
	}
	
	@Override
    public String toString() {
        return "Word Matching Question";
    }
}
