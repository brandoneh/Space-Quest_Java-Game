import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 * 
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room. Descriptions for these exits 
 * are stored in the HashMap exitsDescrip.
 * 
 * @author  162228
 * @version 2
 */

public class Room 
{
    private String description;
    private String roomType;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, String> exitsDescrip; //stores descriptions of exits
    private String planet;
    /**
     * Create a Room with a given description and roomType.
     * 
     * @param String description The room's description.
     * @param String roomType The type of room.
     */
    public Room(String description, String roomType, String planet) 
    {
        this.description = description;
        this.roomType = roomType;
        this.planet = planet;
        exits = new HashMap<String, Room>();
        exitsDescrip = new HashMap<String, String>();
    }

    /**
     * Define an exit from this room.
     * 
     * @param String direction The direction of the exit used for KeyWord matching.
     * @param String neighborDescrip A description of the room which is printed.
     * @param Room neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, String neighborDescrip, Room neighbor) 
    {
        exits.put(direction, neighbor);
        exitsDescrip.put(neighborDescrip, direction );
    }
    
    /**
     * An accessor function for the roomType.
     * 
     * @return the roomType of the Room.
     */
    public String getRoomType()
    {
        return roomType;    
    }
    
    /**
     * An accessor function for the planet.
     * 
     * @return the planet of the Room.
     */
    public String getPlanet()
    {
        return planet;    
    }
    
    
    /**
     * A mutator function setting the roomType as a given string.
     * 
     * @param String newRoomType.
     */
    public void setRoomType(String newRoomType)
    {
        roomType = newRoomType;
    }
    
    /**
     * An accessor function for the description.
     * 
     * @return description of the room.
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Returns a description of the room in the form "You are on Exodar"
     * and the exits of the current room as a string with a line inbetween.
     * 
     * @return A long description of this room.
     */
    public String getLongDescription()
    {
        return "\nYou are " + description + ".\n\n" + getExitString() + "\n";
    }

    /**
     * Returns a string consisting of the room's exits by iterating through a
     * set containing the exit HashMap's keys.
     * 
     * @return a spaced string of the room's exits
     */
    public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exitsDescrip.keySet();
        for(String exit : keys) {
            returnString += "| " + exit + " |" ;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * 
     * @param String direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

