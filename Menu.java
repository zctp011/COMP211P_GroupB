import java.util.Scanner;
import java.util.Arrays;
public class Menu
  

{
  // creates characters for selections in the menus
  public static char registerSelection, selection; 
  
  // blank array to add player details to
  
  // blank player
  public static Player thePlayer;
  
  // boolean for if someone is currently logged in
  public static boolean loggedInStatus;
  
  
  // sets default values 
  public Menu()
  {
    registerSelection = 'z';
    selection = 'z';
    loggedInStatus = false;
    thePlayer = new Player();
  }
  
  public static void runMenu()
  {
        
     Scanner scan = new Scanner(System.in);   	
        
     // -----------------------------------------------------
     // Menu code
     // -----------------------------------------------------
        
     // sets the selection characters to values that aren't used
     registerSelection = 'z';
     selection = 'z';
     while (selection != 'Q' && selection != 'q')
     {
          System.out.println();
          System.out.println("\t\t Welcome to the Word Game ");
        	System.out.println("\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println("\t\tLogin (L)");
          System.out.println("\t\tRegister (R)");
          System.out.println("\t\tAbout (A)");
          System.out.println("\t\tPlay the Game (P)");
          System.out.println("\t\tShow the Leader Board (B)");
          System.out.println("\t\tQuit (Q)");
          System.out.print("\n\t\tPlease choose an option: ");
            
          //---------------------------------------------------
          //Option Selection
          //---------------------------------------------------
            
          selection = scan.next().charAt(0);
          switch (selection)
          {
            case 'L':
            case 'l':
              System.out.println("\n\t\t          LOGIN           ");
              System.out.println("\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~");
              login();
              break;
            case 'R':
            case 'r':
              System.out.println("\n\t\t         REGISTER         ");
              System.out.println("\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~");
              register();
              break;
            case 'A':
            case 'a':
              instructions();
              //About
              break;
            case 'P':
            case 'p':
              if (loggedInStatus)
              {
                System.out.println("\t\tStarting Game");
                selection = 'q'; //temporary - quits game if user is logged in
              }
              else
              {
                System.out.println("\t\tSorry, you need to login to play");
              }
              break;
            case 'B':
            case 'b':
              selection = 'Q'; //Temporary
              //Leader Board
              break;
            case 'Q': //So error message doesn't show when quitting
            case 'q':
              break;
            default:  //Error incase of invalid option selection
              System.out.println("\n\t\tPlease choose a valid option");
              break;
          }
            
      }
      System.out.println("\n\t\tPROGRAM ENDED\n");
      
  }

//--------------------------------------
//Registers a player
//--------------------------------------

public static void register ()
{
    Scanner scan = new Scanner(System.in);
  
    System.out.print("\n\t\tEnter your name: ");
    String name = scan.nextLine();
    System.out.print("\n\t\tEnter your username: ");
    String username = scan.nextLine();
    System.out.print("\n\t\tEnter your password: ");
    String password = scan.nextLine();
  
    thePlayer = new Player(name, username, password);
}
//--------------------------------------
//Logs In a player
//--------------------------------------

public static void login ()
{
    Scanner scan = new Scanner(System.in);

    System.out.print("\t\tUsername:");
    String userName = scan.nextLine();
    System.out.print("\n\t\tPassword: ");
    String password = scan.nextLine();
    
    if ( userName.equals(thePlayer.getUsername() ) && password.equals(thePlayer.getPassword() ) )
    {
      System.out.println("\tWelcome! You have successfully logged in.");
      loggedInStatus = true;
    }
    else
    {
    System.out.println("\tUsername or Password Incorrect.");
    }
}
//--------------------------------------
//Displays Instructions
//--------------------------------------
public static void instructions()
{
   System.out.println("\tInstructions");
}


    
}

  
  	

