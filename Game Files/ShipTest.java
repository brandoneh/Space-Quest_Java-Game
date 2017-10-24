

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class ShipTest.
 *
 * @author  162228
 * @version 2
 */
public class ShipTest
{
    /**
     * Default constructor for test class ShipTest
     */
    public ShipTest()
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
     * Tests the addHull, getHull, loseHull, addCrewbots, getCrewbots,
     * addMoney and getMoney methods of the Ship class.
     *
     */
    @Test
    public void testStatUpdates()
    {
        //valid when starting values: Hull = 100, Crewbots = 20, Money = 50
        Ship s1 = new Ship();
        s1.addHull(10);
        assertEquals(110,s1.getHull());
        s1.loseHull(100);
        assertEquals(10,s1.getHull());
        s1.addCrewbots(10);
        assertEquals(30,s1.getCrewbots());                
        s1.addMoney(50);
        assertEquals(100,s1.getMoney());
        
    }
}
