
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EnemyShipTest.
 *
 * @author  162228
 * @version 2
 */
public class EnemyShipTest
{
    /**
     * Default constructor for test class EnemyShipTest
     */
    public EnemyShipTest()
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
     * Tests that the scaleHull method of the EnemyShip class produces values within the expected
     * range.
     */
    @Test
    public void scalingHullTest()
    {
        for(int i = 0; i < 100; i++) {
            EnemyShip es1 = new EnemyShip();
            es1.scaleHull();
            System.out.println(es1.getHull());
            assertEquals(true, (es1.getHull() <= 120));
            assertEquals(true, (es1.getHull() >= 70));
        }
    }
    
    /**
     * Tests that the scaleWeapon method of the EnemyShip class produces values within the expected
     * range.
     */
    @Test
    public void scalingWeaponDamageTest()
    {
        for(int i = 0; i < 100; i++) {
            EnemyShip es1 = new EnemyShip();
            es1.scaleWeaponDamage();
            System.out.println(es1.getWeapon().getWeaponDamage());
            assertEquals(true, (es1.getWeapon().getWeaponDamage() <= 8));
            assertEquals(true, (es1.getWeapon().getWeaponDamage() >= 5));
        }
    }
}
