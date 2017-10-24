import java.util.ArrayList;
import java.util.Arrays;
/**
 * This Class contains Room-specific ArrayLists of keywords used to check against the user's input.
 * An existing ArrayList is added to the keyWords ArrayList when the condition in the if statement is met.
 * 
 * @author 162228
 * @version 2
 */
public class KeyWords
{
    private ArrayList <String> keyWords;

    /**
     * Creates an empty ArrayList to be filled with keywords.
     */
    public KeyWords()
    {
        keyWords = new ArrayList <String> ();
    }

    /**
     * This method generates the appropriate ArrayList of keywords based on the current Room's roomType and,
     * if in a shop, adds the planet-appropriate weapon.
     * 
     * @param String roomType The type of the current room in the game class.
     * @param String planet 
     * @return ArrayList. 
     */
    public ArrayList <String> getKeyWordOption(String roomType, String planet)
    {
        if(roomType == "shop") {
            if(planet == "exodar") {
                ArrayList <String> shopArrayList = new ArrayList<>(Arrays.asList("hull","repair","crewbots","crew","street","bar",
                            "deck","alley","megatropolis", "railgun","weapon" ));  
                keyWords = shopArrayList;
            }
            else if(planet == "hondara") {
                ArrayList <String> shopArrayList = new ArrayList<>(Arrays.asList("hull","repair","crewbots","crew","street","bar",
                            "deck","alley","megatropolis", "raptor-13","weapon" ));  
                keyWords = shopArrayList;
            }
            else if(planet == "nespion") {
                ArrayList <String> shopArrayList = new ArrayList<>(Arrays.asList("hull","repair","crewbots","crew","street","bar",
                            "deck","alley","megatropolis", "neutron-bomb","weapon" ));  
                keyWords = shopArrayList;
            }
            else if(planet == "saryn") {
                ArrayList <String> shopArrayList = new ArrayList<>(Arrays.asList("hull","repair","crewbots","crew","street","bar",
                            "deck","alley","megatropolis", "hadron-rifle","weapon" ));  
                keyWords = shopArrayList;
            }
            else if(planet == "epleithea") {
                ArrayList <String> shopArrayList = new ArrayList<>(Arrays.asList("hull","repair","crewbots","crew","street","bar",
                            "deck","alley","megatropolis", "death-ray","weapon" ));  
                keyWords = shopArrayList;
            }
        }
        else if(roomType == "hangar") {
            ArrayList <String> hangarArrayList = new ArrayList<>(Arrays.asList("space","back","street","bar","deck",
                        "alley","megatropolis"));
            keyWords =  hangarArrayList;
        }
        else if(roomType == "space") {
            ArrayList <String> hangarArrayList = new ArrayList<>(Arrays.asList("saryn","exodar","hondara","nespion","epleithia"));
            keyWords =  hangarArrayList;
        }

        else if(roomType == "event") {
            ArrayList <String> eventArrayList = new ArrayList<>(Arrays.asList("away","enemy","ship"));
            keyWords = eventArrayList;    
        }
        else if(roomType == "hub") {
            ArrayList <String> hubArrayList = new ArrayList<>(Arrays.asList("mechanic","market","blackmarket",
                        "back","shop","hangar"));
            keyWords = hubArrayList;    
        }
        return keyWords;
    }

    /**
     * This method checks if the current ArrayList of keywords contains a given String, used for user inputs.
     * 
     * @param String item The item who's presence is being queried.
     * @return Boolean true if the given String  matches an item in the ArrayList
     */
    public boolean checkKeyWordContents (String item)
    {
        if(keyWords.contains(item)) {
            return true;
        }
        else {
            return false;
        }
    }   
}

