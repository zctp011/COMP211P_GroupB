public class Question
{

	private String question;
	private String wrong1;
  private String wrong2;
  private String wrong3;
  private String wrong4;
	private String answer;

 
	//--------------------------------------------------------
	//  Sets the default values 
	//--------------------------------------------------------
	
  public Question()
  {
      question = " ";
      wrong1 = " ";
      wrong2 = " ";
      wrong3 = " ";
      wrong4 = " ";
      answer = " ";
      
  }

  //---------------------------------------------------------
  //  Creates an object for the question
  //---------------------------------------------------------

  public Question (String question, String wrong1, String wrong2, String wrong3, String wrong4, String answer)
  {
      this.question = question;
      this.wrong1 = wrong1;
      this.wrong2 = wrong2;
      this.wrong3 = wrong3;
      this.wrong4 = wrong4;
      this.answer = answer;
  }

   //---------------------------------------------------------
  //  Sets the values
  //---------------------------------------------------------
  
  public void setQuestion(String aQuestion)
  {
     question = aQuestion;
  }
  
  public void setWrong1(String aWrong)
  {
     wrong1 = aWrong;
  }
  
  public void setWrong2(String aWrong)
  {
     wrong2 = aWrong;
  }
  
  public void setWrong3(String aWrong)
  {
     wrong3 = aWrong;
  }
  
  public void setWrong4(String aWrong)
  {
     wrong4 = aWrong;
  }
  
  public void setAnswer(String answer)
  {
     answer = answer;
  }
  
  //---------------------------------------------------------
  //  Returns values
  //---------------------------------------------------------

  public String getQuestion()
  { 
       return question;
  }

  public String getWrong1()
  {
       return wrong1;
  }

  public String getWrong2()
  {
       return wrong2;
  }
  
  public String getWrong3()
  {
       return wrong3;
  }
  
  public String getWrong4()
  {
       return wrong4;
  }
  
  public String getAnswer()
  {
       return answer;
  }
  
  //checks if a question is equal to another
  public boolean equals(Question otherQuestion)
  {
      return (question.equals(otherQuestion.question)
              && wrong1.equals(otherQuestion.wrong1)
              && wrong2.equals(otherQuestion.wrong2)
              && wrong3.equals(otherQuestion.wrong3)
              && wrong4.equals(otherQuestion.wrong4)
              && answer.equals(otherQuestion.answer));
  }
  
  //---------------------------------------------------------
  //  toString
  //---------------------------------------------------------
  
  public String toString()
  {
       return (question + " "
               + wrong1 + " "
               + wrong2 + " "
               + wrong3 + " "
               + wrong4 + " "
               + answer);
  }
  
}
