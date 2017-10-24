import java.util.ArrayList;
import java.util.Arrays;
/**
 * The EventScript class contains the text to be printed when an EventRoom is entered, with the particular event
 * being decided by the randomly generated value eventType from the EventRoom class.
 * 
 * @author 162228
 * @version 2
 */
public class EventScript
{

    /**
     * There are no Instance Variables for this class.
     */
    public EventScript()
    {
        
    }

    /**
     * This method stores the appropriate script for the EventRoom in an ArrayList and returns it
     * 
     * @param eventType An int specifying which event should be printed to the terminal.
     * @return script ArrayList of lines to be appended to the GUI JTextArea.
     */
    public ArrayList <String> getScriptIntro(int eventType)
    {
        ArrayList <String> script = new ArrayList <String>();
        if(eventType == 1) {
            script.addAll(Arrays.asList( "\nYour hyperspace jump lands you smack-dab in the middle of an asteroid field.\n",
            "\nTime to have some words with your navigator bot.\n" ,
            "\nYour ship is damaged ~ you lose 20 hull integrity"));
        }
        else if(eventType == 2) {
            script.addAll(Arrays.asList( "\nYou have found an uncharted planet on your travels. Time to explore!\n",
            "\nYou find some hearty space-treasure ~ you gain 25 SpaceBux\n" ,
            "Some of your crew is lost in the process ~ you lose 5 Crewbots"));
        }
        else if(eventType == 3) {
            script.addAll(Arrays.asList( "\nYou spy a ship of outlaws and rogues tailing you. They start to speed up.\n",
            "\nDo you want to attack the ship or run away?\n"));            
        }
        return script;
    }
    
    /**
     * This method is used when a combat event occurs. It returns the script for the player's turn.
     * 
     * @param int playerWeaponDamage the current weaponDamage of the player's ship.
     * @param int enemyHull the current hull of the enemyShip.
     * @return script ArrayList of lines to be appended to the GUI JTextArea.
     */
    public ArrayList <String> fightScriptPlayer(int playerWeaponDamage, int enemyHull)
    {
        ArrayList <String> script = new ArrayList <String>();
        script.addAll(Arrays.asList( "\nYou fire a shot at the enemy ship, great shot!\n",        
        "~ -" + playerWeaponDamage + " Hull Integrity!\n", "\nRemaining Hull ~ " + enemyHull));
        return script;
    }
    
    /**
     * This method is used when a combat event occurs. It returns the script for the enemy's turn.
     * 
     * @param int enemyWeaponDamage the current weaponDamage of the enemy's ship.
     * @return script ArrayList of lines to be appended to the GUI JTextArea.
     */
    public ArrayList <String> fightScriptEnemy(int enemyWeaponDamage)
    {
        ArrayList <String> script = new ArrayList <String>();
        script.addAll(Arrays.asList( "\nThe enemy ship returns a barrage of fire!\n",
        
        " ~ Your ship loses " + enemyWeaponDamage + " Hull Integrity!\n"));
        return script;
    }

}
