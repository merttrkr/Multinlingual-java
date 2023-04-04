import java.util.Random;

public class Unit {
	private Quiz[] quizArray;
	private int quizNumber;
	

    public Unit( ) {// attributes randomly generated in this class.
       createQuizzes();
    }
	

	public int getQuizNumber() {
		return quizNumber;
	}
	
	public Quiz[] getQuizArray() {
		return quizArray;
	}

	public void createQuizzes() {
		Random rand = new Random();
        int numQuizzes = rand.nextInt(10) + 1; // generates a random number between 60 and 100
        this.quizNumber = numQuizzes;
        
        for(int i= 0; i < numQuizzes ; i ++) {
        	Quiz quiz = new Quiz();
        	this.quizArray[i] = quiz;
        }
        
	}
}
