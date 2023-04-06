import java.util.Random;

public class SpeakingQuestion extends Question {
	
	public SpeakingQuestion() {
		super(8, createSpeakingContent());
	}
	
	public static Object createSpeakingContent() {
	    Random rand = new Random();
		int[] speakingContent = new int[2];
		speakingContent[0] = rand.nextInt(300) + 1;
		speakingContent[1] = rand.nextInt(300) + 1;
		return speakingContent;
	}
}
