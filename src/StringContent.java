import java.util.Random;

public class StringContent extends ContentType{
	private String text;

	
	public StringContent(String languageName) {
		super(languageName);
		this.text = randomStringGenerator();
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
	
}
