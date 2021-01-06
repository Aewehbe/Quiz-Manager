package fr.epita.quiz.services.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.quiz.datamodel.Student;

public class StudentDAO {
	//create
		public int create(Student student) throws SQLException{
			//prepare the query
					PreparedStatement preparedStatement;
					
					try (Connection connection = getConnection()) {
						preparedStatement = connection
								.prepareStatement("INSERT INTO STUDENT_TBL(NAME) VALUES (?)");
						preparedStatement.setString(1, student.getName());
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
		public int update(Student student) throws SQLException{
			//taking the new name of the quiz from the user
			Scanner scanner = new Scanner(System.in);
			System.out.println("What is the name of the student?");
			String student_name = scanner.nextLine();
			
			//prepare the query
			PreparedStatement preparedStatement;
					
			try (Connection connection = getConnection()) {
				preparedStatement = connection
						.prepareStatement("UPDATE STUDENT_TBL SET NAME = ? WHERE STUDENT_ID = ?");
				preparedStatement.setString(1, student_name);
				preparedStatement.setString(2, student.getId());
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
		public int search(Student student) throws SQLException {
			//open the connection
			Connection connection = getConnection();
			
			String query = "SELECT NAME FROM STUDENT_TBL WHERE STUDENT_ID = ?";	
			
			//prepare the query
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, student.getId());
			ResultSet results = prepareStatement.executeQuery();
			
			//create a list of quizzes
			List<Student> students = new ArrayList<Student>();
			while (results.next()) {
				String studentName = results.getString("name");
				Student std_tmp = new Student();
				std_tmp.setName(studentName);
				students.add(std_tmp);
				System.out.println("Student: " + std_tmp.getName());
			}
			//return the list of questions
			return 1;
		}
		
		//delete
		public int delete(Student student) throws SQLException{
			//prepare the query
			PreparedStatement preparedStatement;
					
			try (Connection connection = getConnection()) {
				preparedStatement = connection
						.prepareStatement("DELETE FROM STUDENT_TBL WHERE STUDENT_ID = ?");
				preparedStatement.setString(1, student.getId());
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
