import java.util.Random;

public class ReadingQuestion extends Question{
	
	public ReadingQuestion() {
		super(10, createReadingContent());
	}
	
	public static String randomStringGenerator() {
		Random rand = new Random();
		int stringLength = rand.nextInt(20) + 10;
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String randomString = "";
		for (int i = 0 ; i< stringLength; i++) {
			int currentIndex = rand.nextInt(alphabet.length());
			randomString += alphabet.charAt(currentIndex);
		}
		return randomString;
			
	}
	
	public static Object createReadingContent() {
		String[] readingContent = new String[2];
		readingContent[0] = randomStringGenerator();
		readingContent[1] = randomStringGenerator();
		return readingContent;
	}
		
}
