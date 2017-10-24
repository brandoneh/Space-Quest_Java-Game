import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.io.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 * The GUI class produces the user interface and acts as the main class, creating instances of 
 * other classes required to run the game. It also adds ActionListener functions to a button
 * and an editable JTextArea, allowing the player to enter commands in the interface as opposed
 * to a system input window.
 * 
 * @author 162228 
 * @version 2
 */
public class GUI
{
    public JFrame frame;
    public ImageIcon ship_g, ship_r, ship_y, space_bg, game_over, 
    hangar, exodar, epleithea, hondara, nespion, saryn, 
    exodar_m, epleithea_m, hondara_m, nespion_m, saryn_m;

    public JTextArea textOutScroll;
    public Game g;
    public Player playerStart;
    public Ship shipStart;
    public Parser parser;
    public PrintWriter userLog;
    public boolean logMade;
    public boolean finished;
    public boolean end;

    /**
     * The GUI class creates a JTextArea to show the text output as well as the Player and Ship 
     * representations, the Parser, the Game and some boolean values. The booleans are 
     * logMade (indicates that a textFile has been opened and is being written to), finished
     * (indicating whether conditions have been met to perform an exit) and end (indicating that 
     * the game is ready to exit). It also beings play, the main method.
     */
    public GUI()
    {
        textOutScroll = new JTextArea(7,60);
        playerStart = new Player();
        shipStart = new Ship();
        parser = new Parser();
        g = new Game(textOutScroll, playerStart, shipStart, parser);
        logMade = false;
        finished = false;
        end = false;

        play();
    }

    
    /**
     * The main method, creating a log of the the user's inputs by writing to a newly created text
     * file or overwriting the existing one. Exceptions produced by being unable to open or write
     * to the text file are caught by an exception handler. It then calls the makeFrame method
     * to produce the interface (regardless of if an exception occures) and begins the game. 
     */
    public void play()
    {
        try {
            userLog = new PrintWriter(new FileWriter("UserLog.txt"));                    
            logMade = true;
            userLog.println("User Log for Space Quest!\n\n");
        } catch (IOException e) {
            System.err.println("Caught IOException: " +  e.getMessage());

        } finally {
            makeFrame();
        }
    }

    /**
     * This method creates the compnents constituting the graphical user interface, most 
     * importantly linking the stats of the player's ship (shipStart) to the shipStats 
     * JTextArea, creating a JScrollPane containing the game's output, a JTextField for 
     * user entry and JButton with an ActionListener that processes this entry.
     */
    public void makeFrame()
    {
        //Hull indicator Icons
        ship_g = new ImageIcon("img/ship_green.png","ship_g");
        ship_r = new ImageIcon("img/ship_red.png","ship_r");
        ship_y = new ImageIcon("img/ship_yellow.png","ship_y");
        
        //Background Icons for the main Jlabel
        game_over = new ImageIcon("img/game_over.png","game_over");
        space_bg = new ImageIcon("img/space_bg.png","space_bg");
        hangar = new ImageIcon("img/hangar.png","hangar");
        exodar = new ImageIcon("img/exodar.png","exodar");
        epleithea = new ImageIcon("img/epleithea.png","epleithea");
        hondara = new ImageIcon("img/hondara.png","hondara");
        nespion = new ImageIcon("img/nespion.png","nespion");
        saryn = new ImageIcon("img/saryn.png","saryn");
        
        //The Backgrounds shown for planets when in a shop
        exodar_m = new ImageIcon("img/exodar_m.png","exodar_m");
        epleithea_m = new ImageIcon("img/epleithea_m.png","epleithea_m");
        hondara_m = new ImageIcon("img/hondara_m.png","hondara_m");
        nespion_m = new ImageIcon("img/nespion_m.png","nespion_m");
        saryn_m = new ImageIcon("img/saryn_m.png","saryn_m");

        frame = new JFrame("Space Quest!");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        //The bottom section of the GUI displaying text, shipStats
        //and a hull indicator
        JPanel base = new JPanel();
        base.setBackground(Color.black);
        contentPane.add(base,BorderLayout.SOUTH);
        base.setLayout(new BoxLayout(base, BoxLayout.LINE_AXIS)); 
        
        //The JLabel displaying the background image
        JLabel main =  new JLabel();
        main.setIcon(exodar);
        contentPane.add(main,BorderLayout.CENTER);

        //adds a border around the edge of the components
        base.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //The hull indicator
        JLabel shipImg = new JLabel();
        shipImg.setIcon(ship_g);
        base.add(shipImg);
        
        //Adds a space between components (repeated further down)
        base.add(Box.createRigidArea(new Dimension(10,0)));

        //The display of shipStart's stats
        JTextArea shipStats = new JTextArea(6,17);
        shipStats.setText(
            " _____________" + 
            "\n Hull Integrity: " + shipStart.getHull() + 
            "\n Crewbots: " + shipStart.getCrewbots() + 
            "\n SpaceBux: " + shipStart.getMoney() +
            "\n Weapon: " + shipStart.getWeapon().getWeaponString() +
            "\n Damage: " + shipStart.getWeapon().getWeaponDamage());

        shipStats.setEditable(false);
        shipStats.setBackground(Color.lightGray);
        shipStats.setFont(new Font("Monospaced", Font.BOLD, 19));
        base.add(shipStats);
        base.add(Box.createRigidArea(new Dimension(10,0)));
        
        //Designates the area that displays text input and output
        JPanel textIn = new JPanel();
        base.add(textIn);
        textIn.setLayout(new BorderLayout());
        
        //Automatically displays newly produced text while allowing 
        //scrolling
        DefaultCaret caret = (DefaultCaret)textOutScroll.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        //Sets the font, size and wrapping behaviour of the text output        
        textOutScroll.setFont(new Font("Monospaced", Font.ITALIC, 12));
        textOutScroll.setLineWrap(true);
        textOutScroll.setWrapStyleWord(true);
        
        //Contains the output JTextArea and allows scrolling as text
        //is appended to it
        JScrollPane scrollPane = new JScrollPane(textOutScroll);
        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        textOutScroll.setEditable(false);
        textIn.add(scrollPane,BorderLayout.CENTER);

        //Designates the area for the input field and entry button
        JPanel inputArea = new JPanel();
        inputArea.setLayout(new BorderLayout());
        textIn.add(inputArea,BorderLayout.SOUTH);

        //The input field
        JTextField field1 = new JTextField("");
        inputArea.add(field1,BorderLayout.CENTER);
        
        //Creates the entry button and adds an ActionListener
        JButton enter = new JButton("ENTER");
        enter.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                    String reset = "";
                    String input = (field1.getText()).trim();
                    //Checks if a playerName has been set and sets it if not
                    if(playerStart.getPlayerNamed() == false || shipStart.getShipNamed() == false){
                        if(playerStart.getPlayerNamed() == false) {
                            if(!input.isEmpty()) {

                                textOutScroll.append("\n>> " + input + "\n");
                                playerStart.setPlayerName(input);

                                playerStart.setPlayerNamed(true);

                                field1.setText(reset);
                            }
                            else{
                                textOutScroll.append("\nYou need a name!");
                            }                            
                        }
                        //Checks if a shipName has been set and sets it if not
                        else if(shipStart.getShipNamed() == false) {
                            if(!input.isEmpty()) {

                                shipStart.setShipName(input);

                                textOutScroll.append("\n>> The " + input + "\n\n");
                                shipStart.setShipNamed(true);
                                field1.setText(reset);
                            }
                            else{
                                textOutScroll.append("\nYour ship needs a name!");
                            }
                        }
                    }

                    else {
                        //placement of toLowerCase method here allows capitalisation of ship and player name
                        input = input.toLowerCase();
                        //Checks if conditions have been met to quit the game
                        if (! finished) { 
                            //Checks if a combat event is occuring and it is the enemyShip's turn or if the 
                            //user has just won a combat event, calling the event method of the Game class
                            //if conditions are met
                            if((g.getFight() == true && g.getEnemyTurn() == true) ||g.getFightWin() == true) {
                                g.event();
                                if(!shipStart.hasHull()) { //checks if the player's hull value is above 0 and quits if not.
                                    textOutScroll.append("\n\nAs your ship's hull disintegrates you are thrown into the cold vacuum of space.\n");

                                    finished = true;
                                }  
                            }
                            else {
                                //Processes the user input and resets the JTextField to empty
                                Command command = parser.getCommand(g.getCurrentRoomType(),g.getCurrentRoomPlanet(), input);
                                textOutScroll.append("\n\n>>" + input + "\n");
                                field1.setText(reset);
                                finished = true;

                                finished = g.processCommand(command);

                            }
                        }

                    }
                    //Checks if the game game is ready to exit
                    if(end) {
                        quit();
                    }
                    else if(finished){
                        textOutScroll.append("\nThank you for playing.\n");
                        textOutScroll.append("\nPress the ENTER button to exit.");
                        userLog.close();
                        end = true;

                    }
                    //Adds the user input to the created text file
                    if(logMade == true){
                        userLog.println(">> " + input);
                    }
                    //repaints the GUI after each input
                    updateGUI(main, shipImg, shipStats);
                }
            });
        inputArea.add(enter,BorderLayout.EAST);

        frame.setPreferredSize(new Dimension(800,600));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        //prints the introductory message of the game, allowing the playerName
        //and shipName to be set
        g.printWelcome();

    }
    
    /**
     * This method repaints the GUI with the appropriate background image (depending on the
     * game's currentRoom's roomType), the hull icon depending on shipStart's current hull
     * integrity and the stats of shipStart.
     */
    private void updateGUI(JLabel main, JLabel shipImg, JTextArea shipStats)
    {
        String planet = g.getCurrentRoomPlanet();
        String roomType = g.getCurrentRoomType();
        int hull = shipStart.getHull();
        int crewbots = shipStart.getCrewbots();
        if(roomType == "hangar") {
            main.setIcon(hangar);
        }
        else if(planet == "space") {

            main.setIcon(space_bg);

        }
        else if(planet == "exodar") {
            if(roomType == "shop") {
                main.setIcon(exodar_m);
            }
            else{
                main.setIcon(exodar);
            }
        }
        else if(planet == "epleithea") {
            if(roomType == "shop") {
                main.setIcon(epleithea_m);
            }
            else{
                main.setIcon(epleithea);

            }
        }
        else if(planet == "hondara") {
            if(roomType == "shop") {
                main.setIcon(hondara_m);
            }
            else{
                main.setIcon(hondara);
            }
        }
        else if(planet == "nespion") {
            if(roomType == "shop") {
                main.setIcon(nespion_m);
            }
            else{
                main.setIcon(nespion);
            }
        }
        else if(planet == "saryn") {
            if(roomType == "shop") {
                main.setIcon(saryn_m);
            }
            else{
                main.setIcon(saryn);
            }
        }

        if(hull < 26) {
            shipImg.setIcon(ship_r);
        }
        else if(hull > 25 && hull < 51) {
            shipImg.setIcon(ship_y);
        }
        else {
            shipImg.setIcon(ship_g);
        }

        if(hull < 1 || crewbots < 1) {
            main.setIcon(game_over);
        }

        if(shipStart.getShipNamed()){
            shipStats.setText(
                " The " + shipStart.getShipName() + 
                "\n Hull Integrity: " + shipStart.getHull() + 
                "\n Crewbots: " + shipStart.getCrewbots() + 
                "\n SpaceBux: " + shipStart.getMoney() +
                "\n Weapon: " + shipStart.getWeapon().getWeaponString() +
                "\n Damage: " + shipStart.getWeapon().getWeaponDamage());
        }

        frame.repaint();
        frame.revalidate();
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
     * Quits the game.
     */
    private void quit()
    {

        wait(5000);
        System.exit(0);
    }

}
