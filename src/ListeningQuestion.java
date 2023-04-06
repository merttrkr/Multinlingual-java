import java.util.Random;

public class ListeningQuestion extends Question{
	
	public ListeningQuestion() {
		super(7, createListeningContent());
	}
	
	
	public static Object createListeningContent() {
	    Random rand = new Random();
		int[] listeningContent = new int[2];
		listeningContent[0] = rand.nextInt(300) + 1;
		listeningContent[1] = rand.nextInt(300) + 1;
		return listeningContent;
	}
		
}
