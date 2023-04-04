
public abstract class Question {
	private int point;
	private Object[] content;
	
	public Question() {}
	
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
	
}
