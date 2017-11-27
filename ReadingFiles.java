import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class ReadingFile {

    public static void main(String[] args) {
        
        String[] Question = readFiles("mini_quiz.csv");
      
        for(int index=0; index < Question.length; index++)
        {
        System.out.println(Question[index]);
        }
        
    }
   //Method that return an array of 10 randomly selected questions from a file//
   public static String[] readFiles(String file) {
    try{
     //Counts the number of lines in the file//
      File f = new File(file);
      Scanner s = new Scanner(f);
      int counter = 0;
      while (s.hasNextLine()){
        counter++;
        s.nextLine();
      }
      //Creates an array for the Questions in the file//
      String[] AllQuestions = new String[counter];
      Scanner s1 = new Scanner(f);
      
      for(int index=0; i < AllQuestions.length; index++){
        AllQuestions[index] = s1.nextLine();
      
      }
      //Creates an array for 10 randomly selected Questions from the file//
      String[] SelectedQuestions = new String[10];
       for(int index=0; index < 10; index++)
      SelectedQuestions[i] = AllQuestions[new Random().nextInt(AllQuestions.length)];
      return SelectedQuestions;
      
    }
      
    catch (FileNotFoundException e)
        {
          System.out.println("File Sentence.txt was not found.");
          System.out.println("or couldn't be opened");
          System.exit(0);
        }
   return null;
  }
  
}
