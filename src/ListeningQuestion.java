import java.util.Random;

public class ListeningQuestion extends Question{
	
	public ListeningQuestion() {
		super();
		this.setPoint(7);
		
		Object[] listeningContent = new Object[2];
		
		listeningContent[0] = getRandomInt();
		listeningContent[1] = getRandomInt();
		System.out.println(listeningContent[0]);
		setContent(listeningContent);
		
		//setCon
	}
	
	public int getRandomInt() {
	    Random rand = new Random();
	    int num = rand.nextInt(300) + 1;
	    return num;
	}
		
}
