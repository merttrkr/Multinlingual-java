
public class ListeningQuestion extends Question{
	
	public ListeningQuestion(String languageName) {
		super(7, createListeningContent(languageName), languageName);
	}
	
	public static Object[] createListeningContent(String languageName) {
		Object[] listeningContent = new Object[2];
		listeningContent[0] = new StringContent(languageName);
		listeningContent[1] = new AudioContent(languageName);
		return listeningContent;
	}		
}
