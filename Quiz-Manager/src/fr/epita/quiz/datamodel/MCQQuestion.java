package fr.epita.quiz.datamodel;

public class MCQQuestion extends Question{
	
	//constructor
	public MCQQuestion() {
		super();
	}
	
	//constructor
	public MCQQuestion(String question, String[] topics, int difficulty) {
		super(question, topics, difficulty);
	}

	public MCQQuestion(String question, int difficulty) {
		super(question, difficulty);
	}

	public MCQQuestion(String question, int difficulty, int id) {
		super(question, difficulty, id);
	}
}
