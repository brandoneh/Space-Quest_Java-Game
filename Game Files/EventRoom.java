import java.util.Random;
import java.util.ArrayList;
/**
 * A Subclass of Room adding the ability to initiate an event while
 * travelling between planets by randomly generating a 1, 2 or 3 and using
 * that to determine which event occurs through the getScriptIntro 
 * function of an EventScript.
 * 
 * @author 162228
 * @version 2
 */
public class EventRoom extends Room
{
    private Random rand;
    private int eventType;
    private EventScript eventScript;
    /**
     * Create an EventRoom with a given description and roomType,
     * as well as creating an EventScript and a Random object to
     * generate an eventType to pass to it.
     */
    public EventRoom(String description, String roomType, String planet)
    {
        super(description, roomType, planet);
        rand = new Random();
        eventType = (rand.nextInt(3) + 1);
        eventScript = new EventScript();
    }
    
    /**
     * An accessor function for the eventType.
     * 
     * @return the eventType of the EventRoom.
     */
    public int getEventType()
    {
        return eventType;
    }
    
    /**
     * A mutator function for the eventType.
     * 
     * @param int newEventType the eventType of the EventRoom.
     */
    public void setEventType(int newEventType)
    {
        eventType = newEventType;
    }
    
    /**
     * Generates a new random eventType.
     * 
     * @return a new eventType.
     */
    public int newEventType()
    {
        eventType =(rand.nextInt(3)) + 1;
        return eventType;
    }
    
    /**
     * Passes the EventScript the generated eventType to begin the 
     * corresponding event.
     */
    public ArrayList <String> getScriptIntro()
    {
        
        ArrayList <String> script = eventScript.getScriptIntro(this.eventType);
        return script;
    }
    
    /**
     * An accessor function for the eventScript.
     * 
     * @return the eventScript of the EventRoom.
     */
    public EventScript getEventScript() {
        return eventScript;
    }
}
