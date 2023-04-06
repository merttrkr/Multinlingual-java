import java.util.Random;

public class Quiz {
	private Question[] questionsArray;
	private int questionNumber;
	
	public Quiz() {// attributes randomly generated in this class.
		Random rand = new Random();
		questionNumber= rand.nextInt(8) + 8; // generates a random number between 60 and 100
		questionsArray = new Question[questionNumber];
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
        for(int i= 0; i < questionNumber ; i ++) {
        	Question question = generateRandomQuestion(rand.nextInt(4));
        	System.out.println("the question obj " + question);
        	questionsArray[i] = question ;    	 
        }

	}
	public Question generateRandomQuestion(int key) {
		
		if (key == 0) {
			//System.out.println("q typ " + 0);
			ListeningQuestion question = new ListeningQuestion();
			 return question;
		} 
		else if( key == 1) {
			//System.out.println("q typ " + 1);
			 ListeningQuestion question = new ListeningQuestion();
			 return question;
		}
		else if( key == 2) {
			//System.out.println("q typ " + 2);
			ListeningQuestion question = new ListeningQuestion();
			 return question;
		}
		else{
			//System.out.println("q typ " + 3);
			ListeningQuestion question = new ListeningQuestion();
			 return question;
		}


			
	}

}
