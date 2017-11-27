import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class FileReader {

	public static Scanner fileScanner;
	public static File quizFile;

	public static void main(String[] args) {

		String question = readFiles("d:/mini_quiz.csv");

		if (question == null) {
			System.out.println("No question found.");
		} else {
			System.out.println(question);
		}
	}

	public static String readFiles(String file) {
		try {
			quizFile = new File(file);
			
			String[] questions = new String[findTotalQuestions()];			

			fileScanner = new Scanner(quizFile);

			for (int index = 0; index < questions.length; index++) {
				questions[index] = fileScanner.nextLine();
			}
			
			return questions[new Random().nextInt(questions.length)];
		}
		catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
			System.out.println("File mini_quiz.csv was not found.");
			System.out.println("or couldn't be opened");
			System.exit(0);
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return null;
	}

	public static int findTotalQuestions() throws Exception{
		fileScanner = new Scanner(quizFile);
