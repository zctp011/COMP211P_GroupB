# COMP211P_GroupB
//--------------------------
//Code Starts Here
//--------------------------

import java.util.Scanner;
public class Menu
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
      
        // -----------------------------------------------------
        // Menu code
        // -----------------------------------------------------
        
        char selection = 'z';
        while (selection != 'Q' && selection != 'q')
        {
            System.out.println();
            System.out.println("\tWelcome to the Word Game");
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
                System.out.print("\t\tlogin");
                break;
              case 'R':
              case 'r':
                //Register
                break;
              case 'A':
              case 'a':
                //About
                break;
              case 'P':
              case 'p':
                //Play
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
        String aName = scan.nextLine();
        System.out.print("\n\t\tEnter your username: ");
        String aUser = scan.nextLine();
        System.out.print("\n\t\tEnter your password: ");
        String aPass = scan.nextLine();
      
        Player thePlayer = new Player(aName, aUser, aPass);
    }
}

//Seperate Class for Player
public class Player
{
    
    private String name;
    private String user;
    private String pass;
  
    
    
    public Player (String playername, String username, String password)
    {
        name = playername;
        user = username;
        pass = password;
    }
    
}

