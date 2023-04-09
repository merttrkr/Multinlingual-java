import java.util.Random;

public class Quiz {
	private Question[] questionsArray;
	private int questionNumber;
	private String languageName;
	private int readingQuestionNumber;
	private int listeningQuestionNumber;
	private int wordMatchingQuestionNumber;
	private int speakingQuestionNumber;
	
	public Quiz(String languageName) {// attributes randomly generated in this class.
		Random rand = new Random();
		questionNumber= rand.nextInt(8, 16); // generates a random number between 60 and 100
		questionsArray = new Question[questionNumber];
		this.languageName = languageName;
		readingQuestionNumber = 0;
		listeningQuestionNumber = 0;
		wordMatchingQuestionNumber = 0;
		speakingQuestionNumber = 0;
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
	public int getQuestionNumber() {
		return questionNumber;
	}
	public int getReadingQuestionNumber() {
		return readingQuestionNumber;
	}

	public int getListeningQuestionNumber() {
		return listeningQuestionNumber;
	}

	public int getSpeakingQuestionNumber() {
		return speakingQuestionNumber;
	}

	public int getWordMatchingQuestionNumber() {
		return wordMatchingQuestionNumber;
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
			readingQuestionNumber = readingQuestionNumber + 1;
			return question;
		} 
		else if( key == 1) {
			 ListeningQuestion question = new ListeningQuestion(languageName);
			 listeningQuestionNumber = listeningQuestionNumber + 1;
			 return question;
		}
		else if( key == 2) {
			 SpeakingQuestion question = new SpeakingQuestion(languageName);
			 speakingQuestionNumber = speakingQuestionNumber + 1;
			 return question;
		}
		else{
			WordMatchingQuestion question = new WordMatchingQuestion(languageName);
			wordMatchingQuestionNumber = wordMatchingQuestionNumber + 1;
			return question;
		}
		
	}

}
