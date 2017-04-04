import java.util.Scanner;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class SenatorSim extends JFrame implements ActionListener

{
    static JButton newGame = null;
    static JButton load = null;
    static JButton options = null;
    static JButton exitGame = null;
    static JButton democrat = null;
    static JButton republican = null;
    static JButton independent = null;
    static JPanel mjp = null;
    ImageIcon mainImage = new ImageIcon("images/Senator.png");
    ImageIcon mainImage2 = new ImageIcon("images/Simulator.png");
    JLabel mainImageLabel = new JLabel("", mainImage, JLabel.CENTER);
    JLabel mainImageLabel2 = new JLabel("", mainImage2, JLabel.CENTER);
    Scanner sc;
    District d;
    Random rand;

    
    public SenatorSim () {
        // TODO Auto-generated constructor stub
        newGame = new JButton("New Game");
        load = new JButton("Load Game");
        options = new JButton("Options");
        exitGame = new JButton("Exit Game");
        newGame.addActionListener(this);
        load.addActionListener(this);
        options.addActionListener(this);
        exitGame.addActionListener(this);
        mjp = new JPanel();
        //Added buttons with easy to read references
        mjp.setLayout(null);
        newGame.setBounds(40, 100, 100, 60);
        load.setBounds(40, 200, 100, 60);
        options.setBounds(40, 300, 100, 60);
        exitGame.setBounds(40, 400, 100, 60);
        mainImageLabel.setBounds(300, 100, 373, 83);
        mainImageLabel2.setBounds(260, 200, 460, 82);
        mjp.add(newGame);
        mjp.add(load);
        mjp.add(options);
        mjp.add(exitGame);
        mjp.add(mainImageLabel);
        mjp.add(mainImageLabel2);
        mjp.setBackground(Color.BLACK);
        //JPanel panel = new JPanel(new BorderLayout());
        //panel.add( label, BorderLayout.CENTER ); 
        
        //mjp.drawImage(image, 0, 0, this);
        //mjp.setLayout(new BorderLayout());
        //mjp.add(newGame,BorderLayout.WEST);
        //mjp.add(load,BorderLayout.WEST);
        mjp.setBounds(0, 0, 1000, 700);
        mjp.setSize(1000,700);
  
  
        this.setTitle("Senator Simulator");
        this.setSize(1000, 700);
        this.getContentPane().setBackground(Color.BLACK);
        this.add(mjp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //this.setResizable(false);
        //end of Shanil Code
        //newGame.setBounds(0, 0, 5, 10);
        sc = new Scanner(System.in); //scanner for text input
        rand = new Random();
        
    }
    public void selectParty () {
      mjp.removeAll();
      democrat = new JButton("Democrat");
      republican = new JButton("Republican");
      independent = new JButton("Independent");
      democrat.addActionListener(this);
      republican.addActionListener(this);
      independent.addActionListener(this);
      democrat.setBounds(40, 100, 100, 60);
      republican.setBounds(40, 200, 100, 60);
      independent.setBounds(40, 300, 100, 60);
      mjp.add(democrat);
      mjp.add(republican);
      mjp.add(independent);
      mjp.revalidate();
      mjp.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    // Created methods in MyCanvas class so I can acess and pass values into the mouse pressed values so the buttons can do
    // what they need to.
        if(e.getActionCommand() == "Exit Game"){
        System.exit(0);  
    }
        if(e.getActionCommand() == "New Game"){
          selectParty();
    }
  }
 
//}
    
    public void control(){
      
        newGame.setLocation(0,0);
    }
    public static void main( String[] args)
    {
        SenatorSim ss = new SenatorSim ();
        //Where Shanil Dummy cases print
        ChangeOptions();
        changeBrightness();
        changeSize();
        changeMusic();
        ss.processCommandLoop();
        
    }
    
    //have the user input a number
    //if the number is a type of district, return that number
    //else return -1
    //TODO
    //exception handling
    int getDistrictFromUser () {
        System.out.println("Please enter type of district you want (1-3), or 0 to exit.\nPress 4 for a random district.");
        int type = sc.nextInt();
        
        if (type == 0) {
            System.out.println("Are you sure you want to exit? Say yes or no");
            String areYouSure = sc.next();
            if(areYouSure.equals("yes"))
            {
            System.exit(0);
            return -1;
            }
            return -1;
        }
        
        else if (type == 4) {
            return rand.nextInt(3);
        }

        else if (type > 0 && type < 4) {
            return type;
        }
        
        else
            return -1;
        
    }

    //create a district and initialize all of the fields
    
    //Here I set all the pop budget and death based on the dType, this is all done in the district class.
    //For a bDecision you would make it a negative value as it adds the value onto the criteria.
    //***We could just use a 1 or 0 and add or subtract a certain amount in the district but thats something I have to discuss
    //***With the team.
    
    District createDistrictUrban (int dType) {
        District d = new UrbanDistrict(dType);
        d.setName();
        d.setPop(0);
        d.setBudget(0);
        d.setDeath(0);
        System.out.println(d.getDistrict());    //debug line
        return d;
    }
    District createDistrictRural (int dType) {
        District d = new RuralDistrict(dType);
        d.setName();
        d.setPop(0);
        d.setBudget(0);
        d.setDeath(0);
        System.out.println(d.getDistrict());    //debug line
        return d;
    }
     District createDistrictCoastal (int dType) {
        District d = new CoastalDistrict(dType);
        d.setName();
        d.setPop(0);
        d.setBudget(0);
        d.setDeath(0);
        System.out.println(d.getDistrict());    //debug line
        return d;
    }
    
    public String getCategoryString (Category cat) {
        switch (cat) {
            case Education: return "Education";
            case Population: return "Population";
            case Crime: return "Crime";
            case Commerce: return "Commerce";
            case Infrastructure: return "Infrastructure";
        }
        
        return "";
    }
    
    public int printDecision (Decision d, int index) {
        System.out.println("  Type: " + getCategoryString(d.cat));
        
        System.out.println("  " + d.description);
        for (int foo = 0; foo < d.numDecisions; foo++) {
            index++;
            System.out.println("    " + Integer.toString(index) + ") " + d.decisionDesc[foo]);
        }
        
        return index;
    }
    
    void processCommandLoop () {
        //District creation
        int districtType = getDistrictFromUser ();
        if(districtType == 1)
        {
         d = createDistrictUrban(districtType);
        }
        if(districtType == 2)
        {
         d = createDistrictRural(districtType);
        }
        if(districtType == 3)
        {
         d = createDistrictCoastal(districtType);
        }
        
        //creating three different Decisions
        Decision[] decisions = new Decision[3];

        //DecisionFactory that produces decisions
        DecisionFactory df = new DecisionFactory();
        
        
        decisions[0] = df.vaccination(d);
        decisions[1] = df.road(d);
        decisions[2] = df.kill(d);

        
        
        
        System.out.println("\n\n");
        
        int index = 0;
        
        System.out.println("You have " + Integer.toString(decisions.length) + " decisions today.");
        for (int foo = 0; foo < decisions.length; foo++) {
            index = printDecision(decisions[foo], index);
        }
        
        System.out.println("\nWhich decision will you make? (enter an integer)");
        
        int input = sc.nextInt() - 1;

        for (int foo = 0; foo < decisions.length; foo++) {
            if (input == 0) {
                decisions[foo].Accept();
                break;
            }
            else if (input == 1) {
                decisions[foo].Ignore();
                break;
            }
            //TODO
            //Make this less rigid
            else {
                input -= 2;
            }
        }
        
        System.out.println(d.getDistrict());
        
        if (d.getPop() == 0) {
            System.out.println("\n\n\n\nEveryone in your district is dead. That's, uh, actually pretty impressive. I don't even think <STRING__BAD_POLITICIAN> would do such a bad job at governing.\n\nGame over.\n");
        
        }
        
        sc.nextInt();
        
    }
    //Shanil Dummy Cases

  public static void ChangeOptions()
  {
  System.out.println("Which options would you like to change?");
  }
  public static void changeBrightness()
  {
    System.out.println("You have modified the brightness to <this>");
  }
  public static void changeSize()
  {
    System.out.println("You have changed the canvas size to <this>");
  }
  public static void changeMusic()
  {
    System.out.println("You have set the default music to Mario 8 bit track");
  }
   
}


 
//Kyle Dummy cases
class DataStorage {
    public DataStorage() {
        System.out.println("DataStorage created!");
    }
    
    public void saveGame() {
        System.out.println("Game saved");
    }
    
    public void loadGame() {
        System.out.println("Game load");
    }
}