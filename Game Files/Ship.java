import java.util.Random;
/**
 * The Player class sets and contains the stats of the player including name, ship
 * name, hull(health), weapon, crewbots and money. It also contains a boolean to
 * check if shipName has been set.
 * 
 * @author 162228
 * @version 2
 */
public class Ship
{
    // instance variables - replace the example below with your own
    private boolean shipNamed;
    private String shipName;
    private int hull;
    private Weapon weapon;
    private int crewbots;
    private int money;


    /**
     * The Ship constructor initializes some values for the ship's 
     * statistics and a boolean.
     */
    public Ship()
    {
        shipNamed = false;
        shipName = null;
        hull = 100;
        weapon = new Weapon("laser-cannon");
        crewbots = 20;
        money = 50;

    }

    /**
     * A method that holds the game while shipName is being set.
     */
    public void shipNameIntro()
    {
        while(shipName == null) {          
        }       
    }
    
     /**
     *Accessor method to check if the shipName has been set.
     * 
     * @return shipNamed boolean;
     */
    public boolean getShipNamed()
    {
        return shipNamed;
    }

    /**
     * Accessor method to get the current hull value.
     * 
     * @return hull.
     */
    public int getHull()
    {
        return hull;
    }

    /**
     * Accessor method to get the current Weapon of the ship.
     * 
     * @return Weapon.
     */
    public Weapon getWeapon()
    {
        return weapon;
    }

    /**
     * Mutator method to update the ship's Weapon
     * 
     * @param String newWeapon.
     */
    public void weaponUpgrade(String newWeapon)
    {
        weapon = new Weapon(newWeapon);
    }
    

    /**
     * Accessor method to get the current crewbot value.
     * 
     * @return crewbots. 
     */
    public int getCrewbots()
    {
        return crewbots;
    }

    /**
     * Accessor method to get the current money value.
     * 
     * @return money.
     */
    public int getMoney()
    {
        return money;
    }

    /**
     * Accessor method to get the shipName that the user has chosen.
     * 
     * @return shipname.
     */
    public String getShipName()
    {
        return shipName;
    }
    
    /**
     * Mutator method to set the hull.
     * 
     * @param int newHull;
     */
    public void setHull(int newHull)
    {
        hull = newHull;
    }
    
    /**
     * Mutator method to set the shipName.
     * 
     * @param String name;
     */
    public void setShipName(String name)
    {
        shipName = name;
    }
    
    /**
     * Mutator method to show that the shipName has been set.
     * 
     * @param boolean b;
     */
    public void setShipNamed(boolean b)
    {
        shipNamed = b;
    }
    
    /**
     * Reduces the value of hull by a given int value.
     * 
     * @param int damage dealt to ship.
     */
    public void loseHull(int damage)
    {
        hull -= damage;
        if(hull <1) {
            hull = 0;
        }
    }

    /**
     * Reduces the value of money by a given int value.
     * 
     * @param int loss the amount of money spent.
     */
    public void loseMoney(int loss)
    {
            money -= loss;
            if(money <1) {
                money = 0;            
        }
    }

    /**
     * Reduces the value of crewbots by a given int value.
     * 
     * @param number of crewmen lost.
     */
    public void loseCrewbots(int loss)
    {
        crewbots -= loss;
        if(crewbots <1) {
            crewbots = 0;   
        }
    }

    /**
     * Increases the value of hull by a given int value.
     * 
     * @param increase amount of hull restored.
     */
    public void addHull (int increase)
    {
        hull += increase;
    }

    /**
     * Mutator method to set the current weapon.
     * 
     * @param Weapon newWeapon.
     */
    public void Weapons(Weapon newWeapon)
    {
        weapon = newWeapon;
    }    
    
    /**
     * Increases the value of crewbots by a given int value.
     * 
     * @param increase amount of crewbots purchased.
     */
    public void addCrewbots(int increase)
    {
        crewbots += increase;
    }

    /**
     * Increases the value of money by a given int value.
     * 
     * @param int increase amount of money found.
     */
    public void addMoney (int increase)
    {
        money += increase;
    }

    /**
     * A method to indicate the status of the ship's hull.
     * 
     * @return boolean true if the ship's hull value is above 0.
     */
    public boolean hasHull ()
    {
        boolean alive = false;

        if(hull > 0) {
            alive = true;
        }
        return alive;
    }

    /**
     * A method to indicate the status of the ship's crewbots.
     * 
     * @return boolean true if the ship's crewbots value is above 0.
     */
    public boolean hasCrew ()
    {
        boolean staffed = false;

        if(crewbots > 0) {
            staffed = true;
        }
        return staffed;
    }
}
