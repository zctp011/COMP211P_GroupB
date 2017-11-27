import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class FileReader {

	private static Scanner fileScanner;
	private static File quizFile;
	private static String[] questions;	
	
	public static void main(String[] args) {
		/*first call this method to scan the file once*/
		readFile("mini_quiz.csv");
		getRandomQuestions(5);
    System.out.println(getRandomQuestion());
		
	}

	/*This method can be called repeatedly to get a random question.*/
	public static String getRandomQuestion(){
		if(questions == null){
			return null;
		}
		return questions[new Random().nextInt(questions.length)];
	}
	
	/*This method can be called repeatedly to get a random question collection.*/
	public static String[] getRandomQuestions(int numberOfQuestions){
		if(questions == null || numberOfQuestions < 1){
			return new String[0];
		}
		
	   String[] selectedQuestions = new String[numberOfQuestions];
       for(int index=0; index < numberOfQuestions; index++){
    	   selectedQuestions[index] = questions[new Random().nextInt(questions.length)];
       }
       return selectedQuestions;
	}
	
	public static void readFile(String file) {
		try {
			quizFile = new File(file);
			
			questions = new String[findTotalQuestions()];			

			fileScanner = new Scanner(quizFile);

			for (int index = 0; index < questions.length; index++) {
				questions[index] = fileScanner.nextLine();
			}
			
			fileScanner.close();
		}
		catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
			System.out.println("File mini_quiz.csv was not found.");
			System.out.println("or couldn't be opened");
			System.exit(0);
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	private static int findTotalQuestions() throws Exception{
		fileScanner = new Scanner(quizFile);

		int totalQuestions = 0;
		while (fileScanner.hasNextLine()) {
			totalQuestions++;
			fileScanner.nextLine();
		}
		fileScanner.close();
		return totalQuestions;
	}
}
