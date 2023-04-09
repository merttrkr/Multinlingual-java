
public abstract class Question {
	private int point;
	private Object[] content;
	private String languageName;
	
	public Question(int point, Object[] content, String languageName ) {
		this.point = point;
		this.content= content;
		this.languageName = languageName;	
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

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}	
}
