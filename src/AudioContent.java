import java.util.Random;

public class AudioContent extends ContentType {
	private int audioLength;
	
	public AudioContent( String languageName) {
		super(languageName);
		Random rand = new Random();
		this.audioLength = rand.nextInt(300) + 1;	
	}

	public int getAudioLength() {
		return audioLength;
	}

}
