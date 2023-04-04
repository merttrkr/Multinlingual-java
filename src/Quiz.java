import java.util.Random;

public class Quiz {
	private Question[] questionsArray;
	private int questionNumber;
	
	public Quiz( ) {// attributes randomly generated in this class.
		createQuestions();
    }
	public Question[] getQuestionsArray() {
		return questionsArray;
	}

	public void setQuestionsArray(Question[] questionsArray) {
		this.questionsArray = questionsArray;
	}
	
	public void createQuestions() {
		Random rand = new Random();
		this.questionNumber= rand.nextInt(8) + 8; // generates a random number between 60 and 100
        for(int i= 0; i < questionNumber ; i ++) {
        	this.questionsArray[i] = generateRandomQuestion(rand.nextInt(4));
        	 
        }
        setQuestionsArray(questionsArray);
	}
	public Question generateRandomQuestion(int key) {
		
		if (key == 0) {
			System.out.println(0);
			ListeningQuestion question = new ListeningQuestion();
			 return question;
		} 
		else if( key == 1) {
			System.out.println(1);
			 ListeningQuestion question = new ListeningQuestion();
			 return question;
		}
		else if( key == 2) {
			System.out.println(2);
			ListeningQuestion question = new ListeningQuestion();
			 return question;
		}
		else{
			System.out.println(3);
			ListeningQuestion question = new ListeningQuestion();
			 return question;
		}


			
	}

}
