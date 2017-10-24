

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RoomTest.
 *
 * @author  162228
 * @version 2
 */
public class RoomTest
{
    /**
     * Default constructor for test class RoomTest
     */
    public RoomTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Tests the setRoomType, getRoomType, getShortDescription, setExit and getExit functions of
     * the Room class.
     */
    @Test
    public void exitTest()
    {
        Room r1 = new Room("This room is a test","nothing","no planet");
        Room r2 = new Room("This is a neighbour","neighbour", "neighbour planet");
        r1.setRoomType("test");
        //Check the roomType
        assertEquals("test",r1.getRoomType());
        //Check the description
        assertEquals("This room is a test",r1.getShortDescription());
        r1.setExit("down", "the neighbour is down", r2);
        //Check that the exit and its direction have been assigned correctly
        assertEquals(r2,r1.getExit("down"));
        
    }
}
