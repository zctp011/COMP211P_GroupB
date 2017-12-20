import java.util.Random;
import java.util.Scanner;

public class Question
{
    
  
    public static String[] QuizQuestion;
    public static int result;
    public static int ScoreCount = 0;
    public static int SkippedCount = 0;
    public static int QuestionsAnsweredCount = 0;

   //---------------------------------------------------------
  //  Shuffles the answer options
  //---------------------------------------------------------
      public static void shuffleAnswers(){
        result = new Random().nextInt(4);
        result++;
        
        QuizQuestion = FileReader.getRandomQuestion().split(",");
        String holdAnswer = QuizQuestion[result];
        QuizQuestion[result] = QuizQuestion[4];
        QuizQuestion[4] = holdAnswer;

        System.out.println();
        System.out.println("\t\tNew word: " +QuizQuestion[0]); 
        System.out.println();
        for(int index = 1;index < 5;index++){         
            System.out.println("\t\t" + (index) + "." +QuizQuestion[index]);          
        }
        
          System.out.println("\t\t5. I’m not sure\t" );
        System.out.println();
        System.out.println();
      }
  
  

    
    public static void printQuestion() {
		    
       
      /* Gives a random number without duplication between the range 1-4 */      
     
     Question.shuffleAnswers();
    
    /* Asks the user to choose an option */
    System.out.println("\t\tPlease choose an option:");     
      
    int answer = 0;
    
    do{
       answer = readInteger(); 
       if(answer < 0 || answer > 5){
       System.out.println("\t\tPlease enter a valid option");
      }
    }while(answer < 0 || answer > 5);
      
      QuestionsAnsweredCount++;
      if(answer == result) /* The option choosen is correct */
      {
        ScoreCount++;  /* Counts the number of correct answers */
        System.out.println("\t\tCorrect!");
        returnFeedback();
        
      }
      else if (answer == 5) /* The question is skipped */
      {
        SkippedCount++; /* Counts the number of skipped questions */
        
        returnFeedback();
      }
      else 
      {
        
        System.out.println("\t\tInCorrect!");
        returnFeedback();  
    }
    }
    
    
    
     /* Provides feedback after every question is answered */
      public static void returnFeedback()
      {
        
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t"+QuizQuestion[0]+ " means " +QuizQuestion[4]);
        System.out.println();
        System.out.println("\t\tQuestions answered:" +QuestionsAnsweredCount+ "/10");
        System.out.println("\t\tQuestions Skipped:" +SkippedCount+ "/10");
        System.out.println();
        System.out.println("\t\tCurrent score:" +ScoreCount+ "/10");
        System.out.println();
        System.out.println("\t\tPress any key to continue"); 
        Scanner scan3 = new Scanner(System.in);
        scan3.next();
        while(scan3 != null )
        {
          if(QuestionsAnsweredCount <= 9)
          {
          printQuestion();
          }
          else
          {
        System.out.println("\t\tGame Over!");
        System.out.println();
        System.out.println("\t\tQuestions answered:" +QuestionsAnsweredCount+ "/10");
        System.out.println("\t\tQuestions Skipped:" +SkippedCount+ "/10");
        System.out.println();
        System.out.println("\t\tCurrent score:" +ScoreCount+ "/10");
        System.out.println();
        System.out.println("\t\tPress any key to continue"); 
        Scanner scan4 = new Scanner(System.in);
        scan4.next();
        while(scan4 != null)
        {
          Menu.runMenu();
        }
            break;
        }   
          break;
        }
        
      }
    
    
    
  //Converts input into an integer value //
      private static int readInteger() {
        int value = -1;
         Scanner scan = new Scanner(System.in);
          String answer = scan.next();  
        try{
          value = Integer.parseInt(answer);
        }catch(Exception exception){
          
        }
        return value;
      }
}
