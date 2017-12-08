import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class FileReader {

	private static Scanner fileScanner;
	private static File quizFile;
	private static String[] questions;	
	
	public static void printQuestions() {
		/*first call this method to scan the file once*/
		readFile("mini_quiz.csv");
    
    //Creates an array of the words in a Question String
    
    String QuizQuestion = getRandomQuestion();
    String[] QuizQuestion1 = QuizQuestion.split(",");
     
    //Generates a random number in the range of 1 to 4//
    
    int[] number = new int[4];
    int count=0;
    int num;
    Random r = new Random();
    while(count<number.length){
        num = r.nextInt(5);
        boolean repeat=false;
        do{
            for(int i=0; i<number.length; i++){
                if(num==number[i]){
                    repeat=true;
                    break;
                }
                else if(i==count){
                    number[count]=num;
                    count++;
                    repeat=true;
                    break;
                }
            }
        }while(!repeat);

    }


        
    System.out.println("\t\tNew word: " +QuizQuestion1[0]);
    System.out.println("\t\t1." +QuizQuestion1[number[0]]);
    System.out.println("\t\t2." +QuizQuestion1[number[1]]);
    System.out.println("\t\t3." +QuizQuestion1[number[2]]);
    System.out.println("\t\t4." +QuizQuestion1[number[3]]);
    System.out.println("\t\t5. I’m not sure\t" );
    System.out.println("\n");
    System.out.println("\t\tPlease choose an option:");
		
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
