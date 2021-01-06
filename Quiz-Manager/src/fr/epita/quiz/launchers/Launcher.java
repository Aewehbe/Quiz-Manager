package fr.epita.quiz.launchers;

import java.sql.SQLException;
import java.util.Scanner;

import fr.epita.quiz.datamodel.MCQQuestion;
import fr.epita.quiz.datamodel.OpenQuestion;
import fr.epita.quiz.datamodel.Quiz;
import fr.epita.quiz.datamodel.Student;
import fr.epita.quiz.services.data.MCQQuestionDAO;
import fr.epita.quiz.services.data.OpenQuestionDAO;
import fr.epita.quiz.services.data.QuizDAO;
import fr.epita.quiz.services.data.StudentDAO;

public class Launcher {

	public static void main(String[] args) throws SQLException {
		//variables
		boolean menu1 = true;
		Scanner scanner = new Scanner(System.in);
		
		//authentication
		System.out.println("Hello, please login");
		System.out.print("Username: ");
		
		String login = scanner.nextLine();
		System.out.print("Password: ");
		String pwd = scanner.nextLine();
		
		// authenticate
		if ( !AuthenticationService.authenticate(login, pwd)) {
			System.out.println("unauthorized");
			scanner.close();
			return;
		}
		
		while (menu1) {
			boolean menu2 = true;
			boolean menu3 = true; 
			boolean menu4 = true;
			System.out.println("Please choose one of the options: ");
			System.out.println("1 - MCQ Questions");
			System.out.println("2 - Open Questions");
			System.out.println("3 - Quiz");
			System.out.println("4 - Student");
			System.out.println("5 - Quit");
			String first_choice = scanner.nextLine();
			switch (first_choice) {
			case "1":
				while (menu2) {
					System.out.println("Please choose one of the options:");
					System.out.println("C - Create");
					System.out.println("R - Read");
					System.out.println("U - Update");
					System.out.println("D - Delete");
					System.out.println("Q - Go back");
					String choice = scanner.nextLine();
					switch (choice) {
					case "c":
					case "C":
						System.out.println("Create");
						System.out.print("Enter the question:");
						String question_tmp = scanner.nextLine();
						System.out.print("Enter the first topic:");
						String topic1_tmp = scanner.nextLine();
						System.out.print("Enter the second topic:");
						String topic2_tmp = scanner.nextLine();
						System.out.print("Enter the third topic:");
						String topic3_tmp = scanner.nextLine();
						System.out.print("Enter the difficulty:");
						int difficulty_tmp = scanner.nextInt();
						String[] topics_tmp = {topic1_tmp, topic2_tmp, topic3_tmp};
						MCQQuestion q = new MCQQuestion(question_tmp, topics_tmp, difficulty_tmp);
						MCQQuestionDAO qdao = new MCQQuestionDAO();
						qdao.create(q);
						break;
					case "r":
					case "R":
						System.out.println("Search");
						System.out.print("Enter the question:");
						String question1_tmp = scanner.nextLine();
						System.out.print("Enter the difficulty:");
						int difficulty1_tmp = scanner.nextInt();
						MCQQuestion q1 = new MCQQuestion(question1_tmp, difficulty1_tmp);
						MCQQuestionDAO qdao1 = new MCQQuestionDAO();
						qdao1.search(q1);
						break;
					case "d":
					case "D":
						System.out.println("Delete");
						System.out.print("Enter the question:");
						String question2_tmp = scanner.nextLine();
						System.out.print("Enter the difficulty:");
						int difficulty2_tmp = scanner.nextInt();
						MCQQuestion q2 = new MCQQuestion(question2_tmp, difficulty2_tmp);
						MCQQuestionDAO qdao2 = new MCQQuestionDAO();
						qdao2.delete(q2);
						break;
					case "u":
					case "U":
						System.out.println("Update");
						System.out.print("Enter the question:");
						String question3_tmp = scanner.nextLine();
						System.out.print("Enter the difficulty:");
						int difficulty3_tmp = scanner.nextInt();
						System.out.println("Enter the ID:");
						int id3_tmp = scanner.nextInt();
						MCQQuestion q3 = new MCQQuestion(question3_tmp, difficulty3_tmp, id3_tmp);
						MCQQuestionDAO qdao3 = new MCQQuestionDAO();
						qdao3.update(q3);
						break;
					case "q":
					case "Q":
						menu2 = false;
						break;
					default:
						System.out.println("Unrecognized option");
					}
				}
				break;
			case "2":
				while (menu2) {
					System.out.println("Please choose one of the options:");
					System.out.println("C - Create");
					System.out.println("R - Read");
					System.out.println("U - Update");
					System.out.println("D - Delete");
					System.out.println("Q - Go back");
					String choice = scanner.nextLine();
					switch (choice) {
					case "c":
					case "C":
						System.out.println("Create");
						System.out.print("Enter the quiz name:");
						String question_tmp = scanner.nextLine();
						System.out.print("Enter the first topic:");
						String topic1_tmp = scanner.nextLine();
						System.out.print("Enter the second topic:");
						String topic2_tmp = scanner.nextLine();
						System.out.print("Enter the third topic:");
						String topic3_tmp = scanner.nextLine();
						System.out.print("Enter the difficulty:");
						int difficulty_tmp = scanner.nextInt();
						String[] topics_tmp = {topic1_tmp, topic2_tmp, topic3_tmp};
						OpenQuestion q = new OpenQuestion(question_tmp, topics_tmp, difficulty_tmp);
						OpenQuestionDAO qdao = new OpenQuestionDAO();
						qdao.create(q);
						break;
					case "r":
					case "R":
						System.out.println("Search");
						System.out.print("Enter the question:");
						String question1_tmp = scanner.nextLine();
						System.out.print("Enter the difficulty:");
						int difficulty1_tmp = scanner.nextInt();
						OpenQuestion q1 = new OpenQuestion(question1_tmp, difficulty1_tmp);
						OpenQuestionDAO qdao1 = new OpenQuestionDAO();
						qdao1.search(q1);
						break;
					case "d":
					case "D":
						System.out.println("Delete");
						System.out.print("Enter the question:");
						String question2_tmp = scanner.nextLine();
						System.out.print("Enter the difficulty:");
						int difficulty2_tmp = scanner.nextInt();
						OpenQuestion q2 = new OpenQuestion(question2_tmp, difficulty2_tmp);
						OpenQuestionDAO qdao2 = new OpenQuestionDAO();
						qdao2.delete(q2);
						break;
					case "u":
					case "U":
						System.out.println("Update");
						System.out.print("Enter the question:");
						String question3_tmp = scanner.nextLine();
						System.out.print("Enter the difficulty:");
						int difficulty3_tmp = scanner.nextInt();
						System.out.println("Enter the ID:");
						int id3_tmp = scanner.nextInt();
						OpenQuestion q3 = new OpenQuestion(question3_tmp, difficulty3_tmp, id3_tmp);
						OpenQuestionDAO qdao3 = new OpenQuestionDAO();
						qdao3.update(q3);
						break;
					case "q":
					case "Q":
						menu2 = false;
						break;
					default:
						System.out.println("Unrecognized option");
					}
				}
				break;
			case "3":
				while (menu3) {
					System.out.println("Please choose one of the options:");
					System.out.println("C - Create");
					System.out.println("R - Read");
					System.out.println("U - Update");
					System.out.println("D - Delete");
					System.out.println("Q - Go back");
					String choice = scanner.nextLine();
					switch (choice) {
					case "c":
					case "C":
						System.out.println("Create");
						System.out.print("Enter the quiz name:");
						String quiz = scanner.nextLine();
						Quiz quiz_tmp = new Quiz(quiz);
						QuizDAO quiz_dao = new QuizDAO();
						quiz_dao.create(quiz_tmp);
						break;
					case "r":
					case "R":
						System.out.println("Search");
						System.out.print("Enter the quiz id");
						int quiz_id4_tmp = scanner.nextInt();
						Quiz quiz4_tmp = new Quiz(quiz_id4_tmp);
						QuizDAO quiz4_dao = new QuizDAO();
						quiz4_dao.search(quiz4_tmp);
						break;
					case "d":
					case "D":
						System.out.println("Delete");
						System.out.print("Enter the quiz id");
						int quiz_id2_tmp = scanner.nextInt();
						Quiz quiz2_tmp = new Quiz(quiz_id2_tmp);
						QuizDAO quiz2_dao = new QuizDAO();
						quiz2_dao.delete(quiz2_tmp);
						break;
					case "u":
					case "U":
						System.out.println("Update");
						System.out.print("Enter the quiz id");
						int quiz_id3_tmp = scanner.nextInt();
						Quiz quiz3_tmp = new Quiz(quiz_id3_tmp);
						QuizDAO quiz3_dao = new QuizDAO();
						quiz3_dao.update(quiz3_tmp);
						break;
					case "q":
					case "Q":
						menu3 = false;
						break;
					default:
						System.out.println("Unrecognized option");
					}
				}
				break;
			case "4":
				while (menu4) {
					System.out.println("Please choose one of the options:");
					System.out.println("C - Create");
					System.out.println("R - Read");
					System.out.println("U - Update");
					System.out.println("D - Delete");
					System.out.println("Q - Go back");
					String choice = scanner.nextLine();
					switch (choice) {
					case "c":
					case "C":
						System.out.println("Create");
						System.out.print("Enter the student's name:");
						String student = scanner.nextLine();
						Student student_tmp = new Student(student);
						StudentDAO student_dao = new StudentDAO();
						student_dao.create(student_tmp);
						break;
					case "r":
					case "R":
						System.out.println("Search");
						System.out.print("Enter the student id");
						String student_id4_tmp = scanner.nextLine();
						Student student4_tmp = new Student();
						student4_tmp.setId(student_id4_tmp);
						StudentDAO student4_dao = new StudentDAO();
						student4_dao.search(student4_tmp);
						break;
					case "d":
					case "D":
						System.out.println("Delete");
						System.out.print("Enter the student id");
						String student_id2_tmp = scanner.nextLine();
						Student student2_tmp = new Student();
						student2_tmp.setId(student_id2_tmp);
						StudentDAO student2_dao = new StudentDAO();
						student2_dao.delete(student2_tmp);
						break;
					case "u":
					case "U":
						System.out.println("Update");
						System.out.print("Enter the student id");
						String student_id3_tmp = scanner.nextLine();
						Student student3_tmp = new Student();
						student3_tmp.setId(student_id3_tmp);
						StudentDAO student3_dao = new StudentDAO();
						student3_dao.update(student3_tmp);
						break;
					case "q":
					case "Q":
						menu4 = false;
						break;
					default:
						System.out.println("Unrecognized option");
					}
				}
				break;
			case "5":
				System.out.println("Program terminated.");
				menu1 = false;
				break;
			default:
				System.out.println("Invalid input");
				break;
			}	
			}
		scanner.close();
		}
	}
