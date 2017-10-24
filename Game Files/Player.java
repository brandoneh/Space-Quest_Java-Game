import javax.swing.*;
/**
 * The Player class sets and contains the name of the player and a boolean showing
 * whether a name has been set.
 * 
 * @author 162228
 * @version 2
 */
public class Player
{
    private boolean playerNamed;
    private String playerName;  
    
    /**
     * The Player constructor initializes the playerName as null and playerNamed
     * as false as a name has not been set.
     */
    public Player()
    {
        playerNamed = false;
        playerName = null;
    }

    /**
     * A method that holds the game while playerName is being set.
     */
    public void playerNameIntro()
    {
        while(playerName == null) {            
        }
    }
    
     /**
     * Accessor method to check if the playerName has been set.
     * 
     * @return playerNamed boolean;
     */
    public boolean getPlayerNamed()
    {
        return playerNamed;
    }
    
    /**
     * Accessor method for the user's chosen name.
     * 
     * @return the playerName string.
     */
    public String getPlayerName()
    {
        return playerName;
    }
    
    /**
     * Mutator method to set the playerName.
     * 
     * @param String name;
     */
    public void setPlayerName(String name)
    {
        playerName = name;
    }
    
    
    /**
     * Mutator method to show that the playerName has been set.
     * 
     * @param boolean b;
     */
    public void setPlayerNamed(boolean b)
    {
        playerNamed = b;
    }
}
    
    