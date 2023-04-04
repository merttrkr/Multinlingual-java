
public abstract class QuestionType {
	private Object content;
	private String language;
	
	public QuestionType(Object content, String language) {
		this.content = content;
		this.language = language;
	}
	
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
