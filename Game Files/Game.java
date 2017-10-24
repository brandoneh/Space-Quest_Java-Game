import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
/**
 *  This class controls a large amount of interactions between other classes. It creates
 *  a representation of the current room, space and event rooms,
 *  a HashMap of possible weapons and their corresponding planets,
 *  variables indicating whether a fight is occurring, has been 
 *  started and has been won, as well as whether an enemyShip has 
 *  created and if it is the enemy's turn (for combat events).
 *  It creates a copy of a command when entering a combat event to
 *  allow movement to the intended room once finished. It also creates
 *  instances of the Weapon class.
 * 
 * @author  162228
 * @version 2
 */

public class Game 
{
    private Room currentRoom;
    private Room spaceHub;
    private Parser parser;
    private EventRoom eventRoom;
    private Player playerStart;
    private Ship shipStart;
    private EnemyShip enemyShip;
    private JTextArea textAreaRep;
    private HashMap <String, Weapon> planetWeaponList; 
    private boolean fight;
    private boolean fightStart;
    private boolean fightWin;
    private boolean enemyTurn;
    private boolean enemyShipMade;
    private Command preFightCommand;
    private Weapon railgun, raptor13, neutronBomb, hadronRifle, deathRay;

    /**
     * The Game class is passed instances of the Player, Ship, and Parser.
     */
    public Game(JTextArea textArea, Player playerStart, Ship shipStart, Parser parser) 
    {
        createRooms();
        this.textAreaRep = textArea;
        this.playerStart = playerStart;
        this.shipStart = shipStart;
        this.parser = parser;
        planetWeaponList = new HashMap <String, Weapon>();
        planetWeaponList.put("exodar",railgun = new  Weapon("railgun"));
        planetWeaponList.put("hondara",raptor13 = new  Weapon("raptor-13"));
        planetWeaponList.put("nespion",neutronBomb = new  Weapon("neutron-bomb")); 
        planetWeaponList.put("saryn",hadronRifle = new  Weapon("hadron-rifle"));
        planetWeaponList.put("epleithea",deathRay = new  Weapon("death-ray"));
        fight = false;
        fightStart = false;
        fightWin = false;
        enemyTurn = false;
        enemyShipMade = false;
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room exodarHub, exodarShop, exodarHangar, hondaraHub, hondaraShop, hondaraHangar, nespionHub,
        nespionShop, nespionHangar, sarynHub, sarynShop, sarynHangar, epleitheaHub, epleitheaShop,
        epleitheaHangar;

        // create the rooms
        exodarHub = new Room("in the cantina of a small colony on Exodar","hub","exodar");
        exodarShop = new Room("in a small parts shop on Exodar","shop","exodar");
        exodarHangar = new Room("on your ship in a hangar on Exodar","hangar","exodar");

        hondaraHub = new Room("in the Megatropolis of Hondara","hub","hondara");
        hondaraShop = new Room("next in line at the five star mechanic of Hondara","shop","hondara");
        hondaraHangar = new Room("on your ship in a hangar on Hondara","hangar","hondara");

        nespionHub = new Room("in a back-alley in a seedy part of Nespion","hub","nespion");
        nespionShop = new Room("in the black market of Nespion","shop","nespion");
        nespionHangar = new Room("on your ship in a hangar on Nespion","hangar","nespion");

        sarynHub = new Room("on the deck of the satellite Saryn","hub","saryn");
        sarynShop = new Room("in the deserted shop of Saryn","shop","saryn");
        sarynHangar = new Room("on your ship in a hangar on Saryn","hangar","saryn");  

        epleitheaHub = new Room("in a bar on Epleithea","hub","epleithea");
        epleitheaShop = new Room("in the market of Epleithea","shop","epleithea");
        epleitheaHangar = new Room("on your ship in a hangar on Epleithea","hangar","epleithea");

        eventRoom = new EventRoom("drifting through space","event", "event");

        spaceHub = new Room("drifting through space. \nWhere would you like to go?",
            "space", "space");

        // initialise room exits

        exodarHub.setExit("shop","To the parts shop", exodarShop);
        exodarHub.setExit("hangar","To the hangar", exodarHangar);
        exodarShop.setExit("street","To the street", exodarHub);
        exodarHangar.setExit("street","To the street", exodarHub);
        exodarHangar.setExit("space","To space", spaceHub);

        hondaraHub.setExit("mechanic","To the mechanic", hondaraShop);
        hondaraHub.setExit("hangar","To the hangar", hondaraHangar);
        hondaraShop.setExit("megatropolis","To the megatropolis", hondaraHub);
        hondaraHangar.setExit("megatropolis","To the megatropolis", hondaraHub);
        hondaraHangar.setExit("space","To space", spaceHub);

        nespionHub.setExit("blackmarket","To the blackmarket", nespionShop);
        nespionHub.setExit("hangar","To the hangar", nespionHangar);
        nespionShop.setExit("alley","To the alley", nespionHub);
        nespionHangar.setExit("alley","To the alley", nespionHub);
        nespionHangar.setExit("space","To space", spaceHub);

        sarynHub.setExit("shop","To the shop", sarynShop);
        sarynHub.setExit("hangar","To the hangar", sarynHangar);
        sarynShop.setExit("deck","To the deck", sarynHub);
        sarynHangar.setExit("deck","To the deck", sarynHub);
        sarynHangar.setExit("space","To space", spaceHub);

        epleitheaHub.setExit("market","to the market", epleitheaShop);
        epleitheaHub.setExit("hangar","to the hangar", epleitheaHangar);
        epleitheaShop.setExit("bar","To the bar", epleitheaHub);
        epleitheaHangar.setExit("bar","To the bar", epleitheaHub);
        epleitheaHangar.setExit("space","To space", spaceHub);

        eventRoom.setExit("back","Back", spaceHub);
        eventRoom.setExit("exodar","Exodar", exodarHub);
        eventRoom.setExit("hondara", "Hondara", hondaraHub);      
        eventRoom.setExit("nespion", "Nespion",nespionHub);
        eventRoom.setExit("saryn", "Saryn", sarynHub);
        spaceHub.setExit("exodar","Exodar", eventRoom);
        spaceHub.setExit("hondara", "Hondara", eventRoom);      
        spaceHub.setExit("nespion", "Nespion",eventRoom);
        spaceHub.setExit("saryn", "Saryn", eventRoom);      

        currentRoom = exodarHub;
    }

    /**
     * Print out the opening message for the player, allowing them to set their Player name and shipName
     * as well as showing them the available actions (commandwords).
     */
    public void printWelcome()
    {
        textAreaRep.append("Welcome to the vast expanse of space!\n");
        wait(2000);
        textAreaRep.append("You are the Commander of a spaceship in the 35th Quadrant of the Milky Way.\n");
        wait(3000);
        textAreaRep.append("\nFirst thing's first, what is your name?\n");
        playerStart.playerNameIntro();
        wait(1000);
        textAreaRep.append("\nAnd what ship do you command?\n");
        textAreaRep.append("\n The _____________?");
        shipStart.shipNameIntro();
        wait(1000);
        textAreaRep.append("\nCongratulations Commander " + playerStart.getPlayerName() + "!\n");
        textAreaRep.append("This is the start of your interstellar adventure!\n");
        wait(3000);
        textAreaRep.append("\nIn this game you take the role of an Intergalactic Treasure Hunter.\n");
        wait(2000);
        textAreaRep.append("\nYou find loot on uncharted planets and sell it to upgrade your ship.\n");
        wait(4000);

        textAreaRep.append("\nYour journey begins " + currentRoom.getShortDescription() + 
            ", a small farming planet.\n");
        wait(2000);
        textAreaRep.append("\nYour available actions are: \n\n");  
        ArrayList<String> allCommands = parser.showCommands();
        for(int i =0; i < allCommands.size(); i++) {
            textAreaRep.append(allCommands.get(i));
        }
        textAreaRep.append("\n\n");
        wait(3000);
        textAreaRep.append(currentRoom.getExitString());

    }

    /**
     * Given a command, process (that is: execute) the command. This method is responsible for initiating events
     * and allowing shop purchases via the event and shop methods below respectively. 
     * 
     * @param Command command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
        if(currentRoom.getRoomType() == "space") {
            preFightCommand = new Command(command.getCommandWord());
            preFightCommand.setKeyWord(command.getKeyWord());
        }
        if(commandWord == CommandWord.UNKNOWN) {
            textAreaRep.append("I don't know what you mean...");
            return false;
        }

        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        //Checks if a combat event has been initiated
        else if(fightStart == true) {
            if (commandWord == CommandWord.GO) {
                textAreaRep.append("\n\nGo where? You're fighting!\n");
                textAreaRep.append("\nYou can ATTACK the enemy or RUN away.\n");
            }
            else if (commandWord == CommandWord.HELP) {
                printHelp();
            }
            else if (commandWord == CommandWord.BUY) {
                textAreaRep.append("\n\nBuy what? You're fighting!\n");
                textAreaRep.append("\nYou can ATTACK the enemy or RUN away.\n");
            }
            else if (commandWord == CommandWord.ATTACK ) {
                //If the CommandWord attack is found, sets fight as true
                fight = true;
                //Checks if an enemyShip has been made, creating one and scaling
                //its stats if not
                if(enemyShipMade == false) {
                    enemyShip = new EnemyShip();
                    enemyShip.scaleWeaponDamage();
                    enemyShip.scaleHull();

                }

                //Checks if the user has won the combat event
                if(!enemyShip.hasHull()) {
                    textAreaRep.append("\n\nVictory! Your shot cleaves the ship in two! \n");
                    textAreaRep.append("The battle is over and to the victor go the spoils.\n\n");
                    textAreaRep.append("You find some loot ~ + 50 SpaceBux\n");
                    fight = false;
                    fightStart = false;
                    fightWin = true;
                    enemyShipMade = false;
                    textAreaRep.append("\n\nPress ENTER to continue\n");
                }

                else{
                    event();                    
                }
            }
            else if (commandWord == CommandWord.RUN) {
                //If the CommandWord run is found, carries out the appropriate actions
                //based of whether the user chose to engage the enemy (fight = true)
                //or run away (fight = false) when given the initial choice
                if(fight == true) {
                    textAreaRep.append("\n\nYou flee and escape the enemy ship.\n");
                    textAreaRep.append("\n\nYour crewbots see your cowardice and a few take their leave ~ You lose 5 crewbots.\n");
                    shipStart.loseCrewbots(5);
                    fight = false;
                }
                else{
                    textAreaRep.append("\n\nYou narrowly escape the enemy ship and continue to your destination.\n");
                }
                fightStart = false;
                wait(5000);
                goRoom(preFightCommand);
            }
        }
        else {            
            if (commandWord == CommandWord.GO) {

                goRoom(command);

                if(currentRoom.getRoomType() == "event") { //checks if the user is in a room which should begin an event.                    
                    event();
                    if(!shipStart.hasHull()) { //checks if the player's hull value is above 0 and quits if not.
                        textAreaRep.append("\n\nAs your ship's hull disintegrates you are thrown into the cold vacuum of space.\n");

                        wantToQuit = true;
                    }  
                    else if(!shipStart.hasCrew()) { //checks if the ship's crewbots value is above 0 and quits if not.
                        textAreaRep.append("\n\nAs your last crewbot ceases to function you realise ");
                        textAreaRep.append("that you don't know what that beeping sound is.");
                        textAreaRep.append("You realise that it is the reactor cooling system too");
                        textAreaRep.append("little too late.\n");

                        wantToQuit = true;
                    }
                    else {              
                            //Checks if a fight has been initiated and if the user input has a keyWord
                            if(command.hasKeyWord() && fight == false) {
                                command.setKeyWord(command.getKeyWord());
                                wait(2000);

                                goRoom(command);
                            }
                            else if(!command.hasKeyWord()){
                                //Returns an error message if no keyWord has been found
                                wait(4000);
                                textAreaRep.append("\nWhere would you like to go?\n");
                                textAreaRep.append(currentRoom.getExitString());
                            }                        
                    }
                }                
                        }
            else if (commandWord == CommandWord.HELP) {
                printHelp();
            }

            else if (commandWord == CommandWord.BUY) {
                if(command.hasKeyWord()) {
                    //Checks if the keyWord of the given Command corresponds to a weapon
                    //in the planetWeaponList HashMap, weaponMatch  = true if a match
                    //is found
                    boolean weaponMatch = false;
                    String inputWeaponString = command.getKeyWord();
                    Weapon checkInputWeapon = new Weapon(inputWeaponString);
                    for(int i = 0; i < planetWeaponList.size();i++) {
                        ArrayList <Weapon> possibleWeapons = new ArrayList <Weapon>(planetWeaponList.values());
                        if(checkInputWeapon.getWeaponString().equals(possibleWeapons.get(i).getWeaponString())) {
                            weaponMatch = true;
                        }
                    }

                    if(currentRoom.getRoomType() != "shop"){
                        textAreaRep.append("\nYou are not at a shop!");
                    }
                    else if(command.getKeyWord().equals("hull") || command.getKeyWord().equals("repair")) {
                        if(shipStart.getMoney() < 20) {
                            textAreaRep.append("\nYou do not have enough SpaceBux to buy this!\n\n");
                            wait(3000);
                            textAreaRep.append(currentRoom.getExitString());
                        }
                        else{
                            shipStart.addHull(20);
                            shipStart.loseMoney(20);
                            textAreaRep.append("\nYou have increased your hull integrity by 20!\n");
                            textAreaRep.append("You have spent 20 SpaceBux.\n");
                            textAreaRep.append(currentRoom.getExitString());
                        }
                    }
                    else if(command.getKeyWord().equals("crewbots") || command.getKeyWord().equals("crew")) {
                        if(shipStart.getMoney() < 20) {
                            textAreaRep.append("\nYou do not have enough SpaceBux to buy this!\n");
                            wait(3000);
                            textAreaRep.append(currentRoom.getExitString());
                        }
                        else{
                            shipStart.addCrewbots(5);
                            shipStart.loseMoney(20);
                            textAreaRep.append("\nYou have purchased 5 Crewbots!\n");
                            textAreaRep.append("You have spent 20 SpaceBux.\n");
                            textAreaRep.append(currentRoom.getExitString());
                        }
                    }
                    else if(command.getKeyWord().equals("weapon") || weaponMatch) {
                        Weapon shopWeapon = planetWeaponList.get(getCurrentRoomPlanet());                        
                        if(shipStart.getMoney() < shopWeapon.getPrice()) {
                            textAreaRep.append("\nYou do not have enough SpaceBux to buy this!\n");
                            wait(3000);
                            textAreaRep.append(currentRoom.getExitString());
                        }
                        else{
                            if(getCurrentRoomPlanet().equals("exodar")) {
                                shipStart.weaponUpgrade("railgun");                            
                            }
                            else if(getCurrentRoomPlanet().equals("hondara")) {
                                shipStart.weaponUpgrade("raptor-13");
                            }
                            else if(getCurrentRoomPlanet().equals("nespion")) {
                                shipStart.weaponUpgrade("neutron-bomb");
                            }
                            else if(getCurrentRoomPlanet().equals("saryn")) {
                                shipStart.weaponUpgrade("hadron-rifle");
                            }
                            else if(getCurrentRoomPlanet().equals("epleithea")) {
                                shipStart.weaponUpgrade("death-ray");
                            }
                            shipStart.loseMoney(shopWeapon.getPrice());
                            textAreaRep.append("\nYou have purchased " + shopWeapon.getWeaponString() + " !\n");
                            textAreaRep.append("You have spent " + shopWeapon.getPrice() + " SpaceBux.\n");
                            textAreaRep.append(currentRoom.getExitString());
                        }
                    }
                }
                else {
                    textAreaRep.append("Buy what?\n");
                    wait(3000);
                }
            }
            else if (commandWord == CommandWord.RUN) {
                textAreaRep.append("Why would you be running?\n");
                wait(3000);
            }
            else if (commandWord == CommandWord.ATTACK) {
                textAreaRep.append("There's nothing to attack.\n");
                wait(3000);
            }
        }
        return wantToQuit;
    }

    /**
     * Accessor method to get the currentRoom.
     * 
     * @return currentRoom;
     */
    public String getCurrentRoomType()
    {
        return currentRoom.getRoomType();
    }

    /**
     * Accessor method to check planet of the currentRoom.
     * 
     * @return planet;
     */
    public String getCurrentRoomPlanet()
    {
        return currentRoom.getPlanet();
    }

    /**
     * Accessor method to check if it is the enemy's turn in a combat event.
     * 
     * @return enemyTurn boolean;
     */
    public boolean getEnemyTurn()
    {
        return enemyTurn;
    }

    /**
     * Accessor method to check if a combat event is ongoing.
     * 
     * @return fight boolean;
     */
    public boolean getFight()
    {
        return fight;
    }

    /**
     * Accessor method to check if the user has won a combat event.
     * 
     * @return fightWin boolean;
     */
    public boolean getFightWin()
    {
        return fightWin;
    }

    /**
     * Carries out an event when travelling between planets using the eventRoom's EventScript.
     * Prints the ship's updated stats.
     * 
     */   
    public void event()
    {
        //Checks if a combat event is occurring
        if(fight == true) {
            if (enemyTurn == false) {
                //Gets the appropriate script from the EventEvent (player turn)
                enemyShipMade = true;
                int playerDamage = shipStart.getWeapon().getWeaponDamage();
                ArrayList <String> scriptLines = eventRoom.getEventScript().fightScriptPlayer(playerDamage, enemyShip.getHull());
                for(int i = 0; i < scriptLines.size(); i++){
                    textAreaRep.append(scriptLines.get(i));
                    wait(2000);
                }
                //Enacts the effects of combat
                enemyShip.loseHull(playerDamage);
                enemyTurn = true;
                textAreaRep.append("\n\nPress ENTER to continue\n");
            }
            else{
                //Gets the appropriate script from the EventEvent (enemy turn)
                int enemyDamage = enemyShip.getWeapon().getWeaponDamage();
                ArrayList <String> scriptLines = eventRoom.getEventScript().fightScriptEnemy(enemyDamage);
                for(int i = 0; i < scriptLines.size(); i++){
                    textAreaRep.append(scriptLines.get(i));
                    wait(2000);
                }
                shipStart.loseHull(enemyDamage);
                enemyTurn = false;
                if(shipStart.hasHull()) { //checks if the player's hull value is above 0.
                    textAreaRep.append("\nWould you like to attack the enemy or run away?\n");
                }                
            }
        }
        else if(fightWin == true) {
            goRoom(preFightCommand);
            fightWin = false;
        }
        else {
            eventRoom.newEventType();
            ArrayList <String> scriptLines = eventRoom.getScriptIntro();
            for(int i = 0; i < scriptLines.size(); i++){
                textAreaRep.append(scriptLines.get(i));
                wait(2000);
            }
            if(eventRoom.getEventType() == 1) { //asteroid event
                shipStart.loseHull(20);
                wait(4000);
            }
            if(eventRoom.getEventType() == 2) { //exploration event
                shipStart.loseCrewbots(5);
                shipStart.addMoney(25);
                wait(4000);

            }
            if(eventRoom.getEventType() == 3) { //fight event
                fightStart = true;
            }
        }

    }

    /**
     * Prints out the options when the player enters a shop room.
     */
    private void shop()
    {
        Weapon shopWeapon = planetWeaponList.get(getCurrentRoomPlanet());
        textAreaRep.append("\nWelcome to the shop. Available purchases:\n");
        wait(2000);
        textAreaRep.append("\nRepair the hull ~ +20 hull for 20 SpaceBux\n");
        textAreaRep.append("\nBuy Crewbots ~ +5 Crewbots for 20 SpaceBux\n");
        textAreaRep.append("\nBuy " + shopWeapon.getWeaponString()  + " ~ " + shopWeapon.getWeaponDamage() + " Damage for " + shopWeapon.getPrice() + " SpaceBux\n");
        textAreaRep.append("\n" + currentRoom.getExitString());
    }

    /**
     * Print out some help information and a list of the command words. The text output depends
     * on whether the player is in a combat event.
     */
    private void printHelp() 
    {
        if(fight == true) {
            textAreaRep.append("\nYou are a Spaceship Captain aboard the " + shipStart.getShipName() + ".");
            textAreaRep.append("\nThe enemy ship is in front of you, no time for messing around!\n");
            textAreaRep.append("\nYou can ATTACK the enemy or RUN away.\n");
        }

        else {
            textAreaRep.append("\nYou are a Spaceship Captain aboard the " + shipStart.getShipName() + ".");
            textAreaRep.append("You may explore the universe or buy items for your ship.\n");
            textAreaRep.append("\nYour command words are:\n");
            ArrayList<String> allCommands = parser.showCommands();
            for(int i =0; i < allCommands.size(); i++) {
                textAreaRep.append(allCommands.get(i));
            }
            textAreaRep.append("\n\n");
        }
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * 
     * @param command detailing the room to be entered.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasKeyWord()) { //checks if a the given command has a keyWord.
            textAreaRep.append("Go where?");
            //return;
        }

        String direction = command.getKeyWord();

        Room nextRoom = currentRoom.getExit(direction);   // Try to leave current room.

        if (nextRoom == null) {
            textAreaRep.append("That is not a valid direction!");
        }
        else {
            currentRoom = nextRoom;
            if(currentRoom.getRoomType() != "event") { //stops the print if the eventRoom is entered.
                textAreaRep.append(currentRoom.getLongDescription());
            }
        }
        if(currentRoom.getRoomType() == "shop") { //calls the shop method if the present room is a shop.
            shop();
        }
    }

    /**
     * Wait for a specified number of milliseconds before carrying out the next command.
     * 
     * @param  milliseconds  the number 
     */
    private void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (Exception e)
        {

        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * 
     * @param command taken from the user's input.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasKeyWord()) {
            textAreaRep.append("Quit what?");
            return false;
        }
        else {
            //signals we should quit
            return true;
        }
    }
}
