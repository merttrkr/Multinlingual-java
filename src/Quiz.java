import java.util.Random;

public class Quiz {
	private Question[] questionsArray;
	private int questionNumber;
	private String languageName;
	
	public Quiz(String languageName) {// attributes randomly generated in this class.
		Random rand = new Random();
		questionNumber= rand.nextInt(8) + 8; // generates a random number between 60 and 100
		questionsArray = new Question[questionNumber];
		this.languageName = languageName;
		createQuestions();
    }
	
	public String getLanguageName() {
		return languageName;
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
        	questionsArray[i] = question ;    	 
        }

	}
	public Question generateRandomQuestion(int key) {
		
		if (key == 0) {
			ReadingQuestion question = new ReadingQuestion(languageName);
			//String[] cont = (String[]) question.getContent();
			///System.out.println("content str " + cont[0] );
			return question;
		} 
		else if( key == 1) {
			//System.out.println("q typ " + 1);
			 ListeningQuestion question = new ListeningQuestion(languageName);
			 return question;
		}
		else if( key == 2) {
			//System.out.println("q typ " + 2);
			SpeakingQuestion question = new SpeakingQuestion(languageName);
			 return question;
		}
		else{
			//System.out.println("q typ " + 3);
			WordMatchingQuestion question = new WordMatchingQuestion(languageName);
			 return question;
		}


			
	}

}
