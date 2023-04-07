import java.util.Random;

public class AudioContent {
	private int audioLength;
	private String languageName;
	
	public AudioContent( String languageName) {
		Random rand = new Random();
		this.audioLength = rand.nextInt(300) + 1;
		this.languageName = languageName;
		
	}

	public int getAudioLength() {
		return audioLength;
	}

	public String getLanguageName() {
		return languageName;
	}
}
