package fr.epita.quiz.services.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.quiz.datamodel.MCQQuestion;
import fr.epita.quiz.datamodel.Question;

public class MCQQuestionDAO {
	
	//insert
	public int create(MCQQuestion question) throws SQLException {
		//prepare the query
		PreparedStatement preparedStatement;
		
		try (Connection connection = getConnection()) {
			preparedStatement = connection
					.prepareStatement("INSERT INTO MCQQUESTION_TBL(QUESTION, TOPIC1, TOPIC2, TOPIC3, DIFFICULTY) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, question.getQuestion());
			preparedStatement.setString(2, question.getTopics()[0]);
			preparedStatement.setString(3, question.getTopics()[1]);
			preparedStatement.setString(4, question.getTopics()[2]);
			preparedStatement.setInt(5, question.getDifficulty());
			//execute the query
			if (preparedStatement.executeUpdate() == 1) {
				System.out.println("Successfully created!");
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Did not succeed!");
		return 0;
	}
	
	//select
	public List<Question> search(MCQQuestion questionExample) throws SQLException {
		//open the connection
		Connection connection = getConnection();
		
		String query = "SELECT QUESTION, TOPIC1, TOPIC2, TOPIC3, DIFFICULTY FROM MCQQUESTION_TBL WHERE "
				+ "(QUESTION IS NULL OR QUESTION LIKE ?)"
				+ "and (DIFFICULTY = -1 OR DIFFICULTY = ?)";	
		
		//prepare the query
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setString(1, "%" + questionExample.getQuestion() + "%");
		prepareStatement.setInt(2, questionExample.getDifficulty());
		ResultSet results = prepareStatement.executeQuery();
		
		//create a list of questions
		List<Question> questions = new ArrayList<Question>();
		while (results.next()) {
			String questionTitle = results.getString("question");
			int difficulty = results.getInt("difficulty");
			Question question = new Question();
			question.setQuestion(questionTitle);
			question.setDifficulty(difficulty);
			questions.add(question);
			System.out.println("Question: " + question.getQuestion() + "\nWith difficulty: " + difficulty);
		}
		//return the list of questions
		return questions;
	}

	//delete
	public int delete(MCQQuestion question) throws SQLException{
		//prepare the query
		PreparedStatement preparedStatement;
		
		try (Connection connection = getConnection()) {
			preparedStatement = connection
					.prepareStatement("DELETE FROM MCQQUESTION_TBL WHERE "
							+ "(QUESTION IS NULL OR QUESTION LIKE ?)"
							+ "AND (DIFFICULTY = -1 OR DIFFICULTY = ?)");
			preparedStatement.setString(1,"%" + question.getQuestion() + "%");
			preparedStatement.setInt(2, question.getDifficulty());
			//execute the query
			if (preparedStatement.executeUpdate() == 1) {
				System.out.println("Successfully deleted!");
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Did not succeed!");
		return 0;
	}

	//update
	public int update(MCQQuestion question) throws SQLException{
		//prepare the query
		PreparedStatement preparedStatement;
	
		try (Connection connection = getConnection()) {
			preparedStatement = connection
					.prepareStatement("UPDATE MCQQUESTION_TBL SET QUESTION = ?, DIFFICULTY = ? WHERE MCQ_QUEST_ID = ?");
			preparedStatement.setString(1, question.getQuestion());
			preparedStatement.setInt(2, question.getDifficulty());
			preparedStatement.setInt(3, question.getId());
			//execute the query
			if (preparedStatement.executeUpdate() == 1) {
				System.out.println("Successfully updated!");
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Did not succeed!");
		return 0;
	}
	
	//connection
	private static Connection getConnection() throws SQLException {
		//main URL
		String url = "jdbc:postgresql://localhost:5432/postgres";
		
		//User
		String user = "postgres";

		//Password
		String password = "123456";

		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
