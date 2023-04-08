import java.util.Random;

public abstract class Question {
	private int point;
	private Object[] content;
	private String languageName;
	private int answer;
	
	public Question(int point, Object[] content, String languageName ) {
		Random rand = new Random();
		this.point = point;
		this.content= content;
		this.languageName = languageName;
		this.answer = rand.nextInt(1);	
	}
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Object[] getContent() {
		return content;
	}
	public void setContent(Object[] content) {
		this.content = content;
	}

	public String getLanguageName() {
		return languageName;
	}
	public int getAnswer() {
		return answer;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	public boolean controlUserAnswer(int userAnswer) {
		if (userAnswer == answer) {
			return true;
		}
		return false;
	}
	
	
}
