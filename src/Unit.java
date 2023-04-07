import java.util.Random;

public class Unit {
	private Quiz[] quizArray;
	private int quizNumber;
	private String languageName;
	

    public Unit(String languageName ) {// attributes randomly generated in this class.
       Random rand = new Random();
       quizNumber = rand.nextInt(10) + 1;
       quizArray = new Quiz[quizNumber];
       this.languageName = languageName;
       createQuizzes();
    }
	

	public String getLanguageName() {
		return languageName;
	}


	public int getQuizNumber() {
		return quizNumber;
	}
	
	public Quiz[] getQuizArray() {
		return quizArray;
	}

	public void createQuizzes() {
        for(int i= 0; i < quizNumber ; i ++) {
        	Quiz quiz = new Quiz(languageName);
        	this.quizArray[i] = quiz;
        }
        
	}
}
