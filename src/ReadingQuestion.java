
public class ReadingQuestion extends Question{
	
	public ReadingQuestion(String languageName) {
		super(10, createReadingContent(languageName), languageName );
	}
	
	
	public static Object[] createReadingContent(String languageName) {
		Object[] readingContent = new StringContent[2];
		readingContent[0] = new StringContent(languageName);
		readingContent[1] = new StringContent("English");
		return readingContent;
	}
	
	@Override
    public String toString() {
        return "Reading Question";
    }	
}
