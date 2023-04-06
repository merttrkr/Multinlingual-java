import java.util.Random;

public class Unit {
	private Quiz[] quizArray;
	private int quizNumber;
	

    public Unit( ) {// attributes randomly generated in this class.
       Random rand = new Random();
       quizNumber = rand.nextInt(10) + 1;
       quizArray = new Quiz[quizNumber];
       createQuizzes();
    }
	

	public int getQuizNumber() {
		return quizNumber;
	}
	
	public Quiz[] getQuizArray() {
		return quizArray;
	}

	public void createQuizzes() {
        for(int i= 0; i < quizNumber ; i ++) {
        	Quiz quiz = new Quiz();
        	this.quizArray[i] = quiz;
        }
        
	}
}
