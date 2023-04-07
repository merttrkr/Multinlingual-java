
public class SpeakingQuestion extends Question {
	
	public SpeakingQuestion(String languageName) {
		super(8, createSpeakingContent(languageName), languageName);
	}
	
	public static Object[] createSpeakingContent(String languageName) {
		Object[] speakingContent = new Object[2];
		speakingContent[0] = new AudioContent(languageName);
		speakingContent[1] = new AudioContent(languageName);
		return speakingContent;
	}
}
