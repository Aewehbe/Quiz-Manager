package fr.epita.quiz.datamodel;

public class Question {
	//private variables
	private int id;
	private String question;
	private String[] topics;
	private int difficulty;
	
	//constructor
	public Question() {
	
	}
	
	//constructor
	public Question(String question, String[] topics, int difficulty) {
		this.question = question;
		this.topics = topics;
		this.difficulty = difficulty;
	}

	public Question(String question, int difficulty) {
		this.question = question;
		this.difficulty = difficulty;
	}

	public Question(String question, int difficulty, int id) {
		this.question = question;
		this.difficulty = difficulty;
		this.id = id;
	}

	//getters and setters
	public String[] getTopics() {
		return topics;
	}

	public void setTopics(String[] topics) {
		this.topics = topics;
	}

	public int getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

}
