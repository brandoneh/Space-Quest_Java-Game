/** 
 * This class holds a command consisting of a CommandWord and a String 
 * keyWord which provides context for the CommandWord. If the CommandWord 
 * passed to this class does not match an existing one it returns
 * CommandWord.UNKNOWN. If the command consisted of 1 word the keyWord is 
 * <null>.
 * 
 * @author  162228
 * @version 2
 */

public class Command
{
    private CommandWord commandWord;
    private String keyWord;

    /**
     * Create a command object. First and second words must be supplied, but
     * the second may be null.
     * 
     * @param CommandWord commandWord
     */
    public Command(CommandWord commandWord)
    {
        this.commandWord = commandWord;
        keyWord = new String();
    }

    /**
     * Accessor method for the command's CommandWord.
     * 
     * @return The command word.
     */
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    /**
     * Accessor method for the command's keyWord.
     * 
     * @return The second word of this command. Returns null if there was 
     * no keyWord.
     */
    public String getKeyWord()
    {
        return keyWord;
    }
    
    /**
     * @return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }
    
    /**
     * Mutator method for the keyWord.
     * 
     * @param String word the new keyWord to be stored in the Command
     */
    public void setKeyWord(String word)
    {
        this.keyWord = word;
    }
    
    /**
     * @return true if the command has a key word.
     */
    public boolean hasKeyWord()
    {
        return (keyWord != null);
    }
}
