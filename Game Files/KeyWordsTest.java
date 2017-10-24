
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class KeyWordsTest.
 *
 * @author  162228
 * @version 2
 */
public class KeyWordsTest
{
    /**
     * Default constructor for test class KeyWordsTest
     */
    public KeyWordsTest()
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
     * Tests the checkKeyWordContents, and getKeyWordOption methods of 
     * the KeyWords class.
     *
     *
     */
    @Test
    public void testWordListValid()
    {
        KeyWords kw1 = new KeyWords();
        //Check that the keyWordList is initialised as empty
        assertEquals(false, kw1.checkKeyWordContents("apple"));
        ArrayList <String> shopList = kw1.getKeyWordOption("shop","exodar");
        //Check that the first word in the keyWordList, when set as shop,
        //is correct 
        assertEquals("hull", shopList.get(0));
        assertEquals(true, kw1.checkKeyWordContents("crew"));
    }
}
