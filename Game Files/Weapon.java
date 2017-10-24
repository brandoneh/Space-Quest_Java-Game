
/**
 * The Weapon class is a representation of the Ship class's weapon. It stores
 * the name of the weapon, a String used for internal recognition and the
 * damage.
 * 
 * @author 162228
 * @version 2
 */
public class Weapon
{
    private String weaponString;
    private String hiddenWeaponString;
    private int weaponDamage;
    private int price;

    /**
     * Creates a weapon with a given String as the hiddenWeaponString. The 
     * other variables are set in response to this by the setupWeapon method.
     */
    public Weapon(String hiddenWeaponString)
    {
        // initialise instance variables
        this.hiddenWeaponString = hiddenWeaponString;
        setupWeapon(hiddenWeaponString);
    }

    /**
     * The setupWeapon assings the weapon a weaponString and weaponDamage
     * depending on the given hiddenWeaponString. If no argument is given
     * these variables are set to be empty.
     * 
     * @param String hiddenWeaponString.
     */
    public void setupWeapon(String hiddenWeaponString)
    {
        try {
            if(hiddenWeaponString.equals("laser-cannon")) {
                weaponString = "Laser-Cannon";
                weaponDamage = 5;
                price = 0;
            }
            else if(hiddenWeaponString.equals("railgun")) {
                weaponString = "Railgun";
                weaponDamage = 6;
                price = 100;
            }
            else if(hiddenWeaponString.equals("neutron-bomb")) {
                weaponString = "Neutron-Bomb";
                weaponDamage = 7;
                price = 200;
            }
            else if(hiddenWeaponString.equals("death-ray")) {
                weaponString = "Death-Ray";
                weaponDamage = 8;
                price = 300;
            }
            else if(hiddenWeaponString.equals("hadron-rifle")) {
                weaponString = "Hadron-Rifle";
                weaponDamage = 9;
                price = 400;
            }
            else if(hiddenWeaponString.equals("raptor-13")) {
                weaponString = "Raptor-13";
                weaponDamage = 10;
                price = 500;
            }
        }
        catch (NullPointerException e) {
            weaponString = "empty";
            weaponDamage = 0;
            price = 0;
        }
    }

    /**
     * Accessor method to get the current hiddenWeaponString.
     * 
     * @return hiddenWeaponString.
     */
    public String getHiddenWeaponString()
    {
        return hiddenWeaponString;
    }

    /**
     * Accessor method to get the current weaponString.
     * 
     * @return weaponString.
     */
    public String getWeaponString()
    {
        return weaponString;
    }

    /**
     * Accessor method to get the price.
     * 
     * @return weapon.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Mutator method to set the current weaponString.
     * 
     * @param String newString.
     */
    public void setWeaponString(String newString)
    {
        weaponString = newString;
    }

    /**
     * Mutator method to set the current hiddenWeaponString
     * 
     * @param String newString.
     */
    public void setHiddenWeaponString(String newString)
    {
        hiddenWeaponString = newString;
    }

    /**
     * Accessor method to get the current weapon's damage.
     * 
     * @return weaponDamage.
     */
    public int getWeaponDamage()
    {
        return weaponDamage;
    }

    /**
     * Mutator method to set the current weapon's damage.
     * 
     * @param int weaponDamage.
     */
    public void setWeaponDamage(int newWeaponDamage)
    {
        weaponDamage = newWeaponDamage;
    }

}
