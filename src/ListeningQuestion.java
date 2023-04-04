import java.util.Random;

public class ListeningQuestion extends Question{

	public ListeningQuestion() {
		//super(7, (Object[]);
		int[] listeningContent = new int[2];
		listeningContent[0] = getRandomInt();
		listeningContent[1] = getRandomInt();
		//setCon
	}
	
	public int getRandomInt() {
	    Random rand = new Random();
	    int num = rand.nextInt(300) + 1;
	    return num;
	}
		
}
