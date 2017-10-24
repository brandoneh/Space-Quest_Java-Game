
import java.util.Random;

/**
 * EnemyShip is a subclass of Ship, adding the ability to scale the weaponDamage and hull to produce
 * combat events with a randomised element.
 * 
 * @author 162228
 * @version 2
 */
public class EnemyShip extends Ship
{
    private float scaling;
    private Random rand;
    
    /**
     * A Random object is created and a float is generated to give a random decimal between 0.7 and
     * 1.2
     */
    public EnemyShip()
    {
        rand = new Random();
        scaling = ((rand.nextFloat()/2) + 0.7f);                               
    }
    
    /**
     * This method scales the weaponDamage of the EnemyShip by multiplying with the scaling variable.
     */
    public void scaleWeaponDamage()
    {
        getWeapon().setWeaponDamage(Math.round(scaling * 7));        
    }
    
    /**
     * This method scales the hull of the EnemyShip by multiplying with the scaling variable.
     */
    public void scaleHull()
    {
        int scaledHull = Math.round(scaling * 100);
        setHull(scaledHull);        
    }
}
