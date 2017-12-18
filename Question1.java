import java.util.Random;
import java.util.Scanner;

public class Question
{
    private String selectedQuestion;
	  private String question;
    private String option1;
    private String option2;
    private String option3;
	  private String answer;
  
    public static String[] QuizQuestion;
    public static int result;
    public static int ScoreCount = 0;
    public static int SkippedCount = 0;
    public static int QuestionsAnsweredCount = 0;

 
	//--------------------------------------------------------
	//  Sets the default values 
	//--------------------------------------------------------
	
  public Question()
  {
      selectedQuestion = " ";
      question = " ";
      option1 = " ";
      option2 = " ";
      option3 = " ";
      answer = " ";
      
  }

  //---------------------------------------------------------
  //  Creates an object for the question
  //---------------------------------------------------------

  public Question (String question, String option1, String option2, String option3, String answer, String selectedQuestion)
  {
      this.selectedQuestion = selectedQuestion;
      this.question = question;
      this.option1 = option1;
      this.option2 = option2;
      this.option3 = option3;
      this.answer = answer;
  }

   //---------------------------------------------------------
  //  Sets the values
  //---------------------------------------------------------
  
  public void setSelectedQuestion(String selectedQuestion)
  {
    this.selectedQuestion = FileReader.getRandomQuestion();
  }
  public void setQuestion(String Question)
  {
     this.question = QuizQuestion[0];
  }
  
  public void setOption1(String Option1)
  {
     this.option1 = QuizQuestion[1];
  }
  
  public void setOption2(String Option2)
  {
     this.option2 = QuizQuestion[2];
  }
  
  public void setOption3(String Option3)
  {
     this.option3 = QuizQuestion[3];
  }
  
  public void setAnswer(String answer)
  {
     this.answer = QuizQuestion[4];
  }
  
  //---------------------------------------------------------
  //  Returns values
  //---------------------------------------------------------
  public String getSelectedQuestion()
  { 
       return selectedQuestion;
  }
  
  public String getQuestion()
  { 
       return question;
  }

  public String getOption1()
  {
       return option1;
  }

  public String getOption2()
  {
       return option2;
  }
  
  public String getOption3()
  {
       return option3;
  }
  
  
  public String getAnswer()
  {
       return answer;
  }
  
  //checks if a question is equal to another
  public boolean equals(Question otherQuestion)
  {
      return (selectedQuestion.equals(otherQuestion.selectedQuestion)
              && question.equals(otherQuestion.question)
              && option1.equals(otherQuestion.option1)
              && option2.equals(otherQuestion.option2)
              && option3.equals(otherQuestion.option3)
              && answer.equals(otherQuestion.answer));
  }
  

   //---------------------------------------------------------
  //  Shuffles the answer options
  //---------------------------------------------------------
      public static void shuffleAnswers(){
        result = new Random().nextInt(4);
        result++;
        
        Question q = new Question();
        
        QuizQuestion = FileReader.getRandomQuestion().split(",");
        String holdAnswer = QuizQuestion[result];
        QuizQuestion[result] = QuizQuestion[4];
        QuizQuestion[4] = holdAnswer;

        System.out.println();
        System.out.println("\t\tNew word: " +q.getQuestion()); 
        System.out.println();
        for(int index = 1;index < 5;index++){         
            System.out.println("\t\t" + (index) + "." +QuizQuestion[index]);          
        }
        
          System.out.println("\t\t5. I’m not sure\t" );
        System.out.println();
        System.out.println();
      }
  
  

    
    public static void printQuestions() {
		    
       
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
          printQuestions();
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
