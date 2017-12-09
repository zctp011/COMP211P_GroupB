import java.util.Random;
import java.util.Scanner;
public class Play
{
    public static int ScoreCount = 0;
    public static int SkippedCount = 0;
    public static int QuestionsAnsweredCount = 0;
    public static int index = 0;
    public static String[] QuizQuestion1;
  
    static{
    	 FileReader.readFile("mini_quiz.csv");
    }
    
    public static void printQuestions() {
		/*first call this method to scan the file once*/  

    String QuizQuestion = FileReader.getRandomQuestion();
 /*Creates an array of the words in a given Question */
   QuizQuestion1 = QuizQuestion.split(",");
    
      
      /* Gives a random number without duplication between the range 1-4 */
      
    int[] number = new int[4];
    int count=0;
    int num;
    Random r = new Random();
    int result = 4;
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
                    if(num == 4){
                    	result = count+1;
                    }
                    count++;
                    repeat=true;
                    break;
                }
            }
        }
      while(!repeat);

    }
        
    /* Prints out the question in the required format with the words in random order */

    System.out.println();
    System.out.println("\t\tNew word: " +QuizQuestion1[0]); 
    System.out.println();
    System.out.println("\t\t1." +QuizQuestion1[number[0]]); 
    System.out.println("\t\t2." +QuizQuestion1[number[1]]);
    System.out.println("\t\t3." +QuizQuestion1[number[2]]);
    System.out.println("\t\t4." +QuizQuestion1[number[3]]);
    System.out.println("\t\t5. I’m not sure\t" );
    System.out.println();
    System.out.println();
    
    /* Asks the user to choose an option */
    System.out.println("\t\tPlease choose an option:");
    Scanner scan = new Scanner(System.in);
    int answer = scan.nextInt();  
    
    
    while(answer >= 0 && answer <= 5)
    {
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
      else if (answer != 5 || answer != result)
      {
        
        System.out.println("\t\tInCorrect!");
        returnFeedback();  
    }
      else
      {
        System.out.println("\t\tPlease Enter a valid option");
      }
      break;
    }
  }
     /* Provides feedback after every question is answered */
      public static void returnFeedback()
      {
        System.out.println();
        System.out.println("\t\t\t"+QuizQuestion1[0]+ " means " +QuizQuestion1[4]);
        System.out.println();
        System.out.println();
        System.out.println("\t\tQuestions answered:" +QuestionsAnsweredCount+ "/10");
        System.out.println("\t\tQuestions Skipped:" +SkippedCount+ "/10");
        System.out.println();
        System.out.println("\t\tCurrent score:" +ScoreCount+ "/10");
        System.out.println();
        System.out.println("\t\tPress any key to continue"); 
        Scanner scan3 = new Scanner(System.in);
        scan3.next();
        if(scan3 != null && QuestionsAnsweredCount < 10)
        {
          printQuestions();
        }
      }
}
