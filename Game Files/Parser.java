import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**  
 * 
 * This parser reads user input, tokenises it and stores it in an ArrayList. It
 * then compares the elements to a list of strings from a KeyWordList and stores 
 * a match as a keyWord. It then returns a Command object consisting of a 
 * CommandWord and Keyword.
 *
 * 
 * @author 162228
 * @version 2
 */
public class Parser 
{
    private CommandWords commands;  // holds all valid command words   // source of command input
    private KeyWords keyWordList;
    /**
     * Create a parser to read from the terminal window and a KeyWords object,
     * keyWordList, to retrieve the appropriate list of keywords for the current
     * roomType.
     */
    public Parser() 
    {
        commands = new CommandWords();
        keyWordList = new KeyWords();
    }

    /**
     * Takes a user input, tokenises it and stores it in an ArrayList. It then takes the first
     * item as the CommandWord and iterates through the remaining items while comparing it with
     * items in the Room-relevant keyWordList, passing it to the Command if a match is found.
     * 
     * @param roomType A string containing the roomType of the current room.
     * @return The next command along with a keyword to interpret the next action.
     */
    public Command getCommand(String roomType, String planet, String inputLine) 
    {
        keyWordList.getKeyWordOption(roomType, planet); //gets the appropriate keywordlist for the current room
        //Scanner tokenizer = new Scanner(inputLine).useDelimiter("\\s{1,}"); //removes spaces from the input.
        String [] tokens = inputLine.split("\\s{1,}");
        ArrayList <String> inputList = new ArrayList <String>();
        String keyWord = null;   //initialising variables for use in the iteration.
        String store = null;
        String first = null;
        
        
        for(int i = 0; i < tokens.length; i++) {
            store = tokens[i];
            store = (store.trim()).toLowerCase(); //converts the user input to lowercase characters.
            inputList.add(store); 
        }
        
        if( !inputList.isEmpty()) {
            first = inputList.get(0);
                    for (String item : inputList) {
                if(keyWordList.checkKeyWordContents(item)) {
                    keyWord = item;
                }
            }
        }
        Command command = new Command (commands.getCommandWord(first));
        command.setKeyWord(keyWord);
        return command;
    }

     /**
     * Returns a list of available CommandWords.
     * 
     * @return List of available CommandWords
     */
    public ArrayList<String> showCommands() 
    {
        ArrayList<String> allCommands = new ArrayList<String>();
        allCommands = commands.showAll();
        return allCommands;
    }


}
