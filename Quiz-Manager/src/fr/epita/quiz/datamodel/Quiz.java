package fr.epita.quiz.datamodel;

public class Quiz {

	//private variables
	private int Id;
	private String title;
	
	//constructor
	public Quiz() {
		
	}
	
	//constructor
	public Quiz(String title) {
		this.title = title;
	}

	public Quiz(int id) {
		this.Id = id;
	}

	//getter and setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
}
