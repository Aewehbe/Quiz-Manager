package fr.epita.quiz.services.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.quiz.datamodel.Quiz;

public class QuizDAO {

	//create
	public int create(Quiz quiz) throws SQLException{
		//prepare the query
				PreparedStatement preparedStatement;
				
				try (Connection connection = getConnection()) {
					preparedStatement = connection
							.prepareStatement("INSERT INTO QUIZ_TBL(QUIZ_NAME) VALUES (?)");
					preparedStatement.setString(1, quiz.getTitle());
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
	
	//update
	public int update(Quiz quiz) throws SQLException{
		//taking the new name of the quiz from the user
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the new name of the quiz?");
		String quiz_name = scanner.nextLine();
		
		//prepare the query
		PreparedStatement preparedStatement;
				
		try (Connection connection = getConnection()) {
			preparedStatement = connection
					.prepareStatement("UPDATE QUIZ_TBL SET QUIZ_NAME = ? WHERE QUIZ_ID = ?");
			preparedStatement.setString(1, quiz_name);
			preparedStatement.setInt(2, quiz.getId());
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

	//search
	public int search(Quiz quiz) throws SQLException {
		//open the connection
		Connection connection = getConnection();
		
		String query = "SELECT QUIZ_NAME FROM QUIZ_TBL WHERE QUIZ_ID = ?";	
		
		//prepare the query
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, quiz.getId());
		ResultSet results = prepareStatement.executeQuery();
		
		//create a list of quizzes
		List<Quiz> quizzes = new ArrayList<Quiz>();
		while (results.next()) {
			String quizTitle = results.getString("quiz_name");
			Quiz quiz_tmp = new Quiz();
			quiz.setTitle(quizTitle);
			quizzes.add(quiz_tmp);
			System.out.println("Quiz: " + quiz.getTitle());
		}
		//return the list of questions
		return 1;
	}
	
	//delete
	public int delete(Quiz quiz) throws SQLException{
		//prepare the query
		PreparedStatement preparedStatement;
				
		try (Connection connection = getConnection()) {
			preparedStatement = connection
					.prepareStatement("DELETE FROM QUIZ_TBL WHERE QUIZ_ID = ?");
			preparedStatement.setInt(1, quiz.getId());
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
