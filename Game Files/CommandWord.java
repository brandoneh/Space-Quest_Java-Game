/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author 162228
 * @version 2
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), BUY("buy"),
    ATTACK("attack"), RUN("run");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command word.
     * 
     * @param commandWord The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * Accessor method for the commandString.
     * 
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
