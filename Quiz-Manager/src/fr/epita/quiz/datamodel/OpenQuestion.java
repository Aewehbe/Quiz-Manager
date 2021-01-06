package fr.epita.quiz.datamodel;

public class OpenQuestion extends Question {

	//constructor
		public OpenQuestion() {
			super();
		}
		
		//constructor
		public OpenQuestion(String question, String[] topics, int difficulty) {
			super(question, topics, difficulty);
		}

		public OpenQuestion(String question, int difficulty) {
			super(question, difficulty);
		}

		public OpenQuestion(String question, int difficulty, int id) {
			super(question, difficulty, id);
		}
}
