public class Player 
{

	private String name;
	private String username;
	private String password;
 
	//--------------------------------------------------------
	//  Sets the default values 
	//--------------------------------------------------------
	
  public Player()
  {
      name = " ";
      username = " ";
      password = " ";
  }

  //---------------------------------------------------------
  //  Sets the values for name, username and password
  //---------------------------------------------------------

  public Player (String name, String username, String password)
{
    this.name = name;
    this.username = username;
    this.password = password;
}
  
  //---------------------------------------------------------
  //  Returns values for name, username and password
  //---------------------------------------------------------

  public String getName()
  { 
       return name;
  }

  public String getUsername()
  {
       return username;
  }

  public String getPassword()
  {
        return password;
  }

}
