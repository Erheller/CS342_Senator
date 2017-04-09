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
    static JButton coastalDistrict = null;
    static JButton ruralDistrict = null;
    static JButton urbanDistrict = null;
    static JButton submit = null;
    static JButton continueBut = null;
    static JButton back = null;
    static JButton decisionBut1 = null;
    static JButton decisionBut2 = null;
    static JButton decisionBut3 = null;
    static JButton yes = null;
    static JButton no = null;
        
    static JPanel mjp = null;
    ImageIcon mainImage = new ImageIcon("images/Senator.png");
    ImageIcon mainImage2 = new ImageIcon("images/Simulator.png");
    ImageIcon imageparty = null;
    ImageIcon opt = null;
    ImageIcon exit = null;
    JLabel mainImageLabel = new JLabel("", mainImage, JLabel.CENTER);
    JLabel mainImageLabel2 = new JLabel("", mainImage2, JLabel.CENTER);
    JLabel imagepartylabel;
    JLabel imageDistrictlabel;
    JLabel optionLabel;
    JLabel exitLabel;
    JLabel line1;
    JLabel line2;
    JFrame frame;
    
    
    
    int partyFlag;
    int districtFlag;
    Scanner sc;
    District d;
    Random rand;
    String districtType = "";
    String pop = "";
    String budget = "";
    String death = "";
    int whatDistrict;
    int bflag = 0;
    int dflag = 0; //for printing decision 1, 2 and 3
    int decisionFlag = 0; //for yes and no and for submit button
    String imageName = "";
    String categoryBut1 = "";
    String categoryBut2 = "";
    String categoryBut3 = "";
    String descriptionBut1 = "";
    String descriptionBut2 = "";
    String descriptionBut3 = "";
    String decisionInfo = "";
    
    
    public SenatorSim () {
        mjp = new JPanel();
        mainMenu(mjp);
       
        sc = new Scanner(System.in); //scanner for text input
        rand = new Random();
     }
    
    public void mainMenu(JPanel mainScreen)
    {
        mainScreen.removeAll();
        
         

        //configImage();
        newGame = new JButton("New Game");
        load = new JButton("Load Game");
        options = new JButton("Options");
        exitGame = new JButton("Exit Game");
        newGame.addActionListener(this);
        load.addActionListener(this);
        options.addActionListener(this);
        exitGame.addActionListener(this);
        
        //Added buttons with easy to read references
        mainScreen.setLayout(null);
       
        newGame.setBounds(40, 100, 100, 60);
        load.setBounds(40, 200, 100, 60);
        options.setBounds(40, 300, 100, 60);
        exitGame.setBounds(40, 400, 100, 60);
        mainImageLabel.setBounds(350, 200, 373, 83);
        mainImageLabel2.setBounds(310, 300, 460, 82);
        mainScreen.add(newGame);
        mainScreen.add(load);
        mainScreen.add(options);
        mainScreen.add(exitGame);
        mainScreen.add(mainImageLabel);
        mainScreen.add(mainImageLabel2);
        //mainScreen.add(back);
        mainScreen.setBackground(Color.BLACK);
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
        
          
    }
   
    public void configImage()
    {
      exit = new ImageIcon("images/close.png");
      exitLabel = new JLabel("exit", exit, JLabel.CENTER);
      //exitLabel.addActionListener(this);
      exitLabel.setBounds(900 , 10 , 75 ,75);
      mjp.add(exitLabel);
      
      opt = new ImageIcon("images/opt.png");
      optionLabel = new JLabel("", opt, JLabel.CENTER);
      //optionLabel.addActionListener(this);
      optionLabel.setBounds(800 , 0 , 100 ,100);
      mjp.add(optionLabel);
    }
  /***********************************************SELECT PARTY********************************************************/
    public void selectParty()
    {
      mjp.removeAll(); // remove all the previous stuff
      
      // creating new buttons
      back = new JButton("<<<<");
      democrat = new JButton("Democrat");
      republican = new JButton("Republican");
      independent = new JButton("Independent");
      submit = new JButton("Submit");
      // action
      back.addActionListener(this);
      democrat.addActionListener(this);
      republican.addActionListener(this);
      independent.addActionListener(this);
      submit.addActionListener(this);
      // location setting
      back.setBounds(900, 610, 100, 50);
      democrat.setBounds(40, 100, 100, 60);
      republican.setBounds(40, 200, 100, 60);
      independent.setBounds(40, 300, 100, 60);
      submit.setBounds(800, 350, 100, 60);
      // adding all the buttons to jpanel
      mjp.add(democrat);
      mjp.add(back);
      mjp.add(republican);
      mjp.add(independent);
      mjp.add(submit);
      mjp.revalidate();
      mjp.repaint();
      // checking the back flag
      bflag = 1;                                    
     }
    
   
  /*****************************************************END*********************************************************/
    
 /************************************************DISTRICT FRAME*****************************************************/
    public void selectDistrict () {
      mjp.removeAll(); // REMOVING ALL THE PREV COMPONENT
      //creating new buttons
      back = new JButton("<<<<");
      coastalDistrict = new JButton("Coastal");
      ruralDistrict = new JButton("Rural");
      urbanDistrict = new JButton("Urban");
      submit = new JButton("Submit");
      // action
      coastalDistrict.addActionListener(this);
      back.addActionListener(this);
      ruralDistrict.addActionListener(this);
      urbanDistrict.addActionListener(this);
      submit.addActionListener(this);
      // location
      coastalDistrict.setBounds(40, 100, 100, 60);
      ruralDistrict.setBounds(40, 200, 100, 60);
      urbanDistrict.setBounds(40, 300, 100, 60);
      submit.setBounds(800, 350, 100, 60);
      back.setBounds(900, 610, 100, 50);
      // adding to the frame
      mjp.add(coastalDistrict);
      mjp.add(ruralDistrict);
      mjp.add(urbanDistrict);
      mjp.add(submit);
      mjp.add(back);
      // repainting
      mjp.revalidate();
      mjp.repaint();
      // checking the back flag
      bflag = 2;
    }
  
    
    /******************************************************END*****************************************************/
    
    
    /**************************************************GAME STATS*************************************************/
    
    
    public void dgScreen()
    {
      back = new JButton("<<<<");
      continueBut = new JButton("Continue");
      back.addActionListener(this);
      continueBut.addActionListener(this);
      JLabel type = new JLabel(districtType);
      JLabel popLabel = new JLabel(pop);
      JLabel budgetLabel = new JLabel(budget);
      JLabel deathLabel = new JLabel(death);
     // type.setFont(new Font("Serif", Font.PLAIN, 25));
      type.setFont(type.getFont().deriveFont(64.0f));
      popLabel.setFont(type.getFont().deriveFont(32.0f));
      budgetLabel.setFont(type.getFont().deriveFont(32.0f));
      deathLabel.setFont(type.getFont().deriveFont(32.0f));
      
      type.setForeground(Color.red);
      popLabel.setForeground(Color.blue);
      budgetLabel.setForeground(Color.blue);
      deathLabel.setForeground(Color.blue);
      back.setBounds(200, 550, 100, 50);
      continueBut.setBounds(650, 550, 100, 50);
      type.setBounds(300, -100, 600, 600);
      popLabel.setBounds(300, 0, 600, 600);
      budgetLabel.setBounds(300, 50, 600, 600);
      deathLabel.setBounds(300, 100, 600, 600);
      mjp.add(type);
      mjp.add(continueBut);
      mjp.add(popLabel);
      mjp.add(budgetLabel);
      mjp.add(deathLabel);
      mjp.add(back);
      mjp.revalidate();
      mjp.repaint();
      bflag = 3;
      
    }
   /****************************************************END*****************************************************/ 
   
   /************************************************DEMOGRAPHICS************************************************/ 
     
    public void demographics(int whatDistrict) {
      mjp.removeAll();
      
      if(whatDistrict == 1)
      {
      createDistrictUrban(1); 
      dgScreen();
      }
      if(whatDistrict == 2)
      {
      createDistrictRural(1); 
      dgScreen();
      }
      if(whatDistrict == 3)
      {
      createDistrictCoastal(1);
      dgScreen();
      }
      //String s = Double.toString(d.getDeath());
     
    }
    
   /****************************************************END*****************************************************/
    
   /**************************************************IMAGES****************************************************/ 
    
    public void imagePop() {
      
      if( partyFlag == 1) // democratic
     {
      selectParty();
      //adding image to the select party frame
      imageparty = new ImageIcon("images/obama.jpg");
      JLabel imagepartylabel = new JLabel("", imageparty, JLabel.CENTER);
      imagepartylabel.setBounds(250 , 100 , 500 , 500);
      mjp.add(imagepartylabel);
     }
     if(partyFlag == 2) // republic
     {
     selectParty();
     imageparty = new ImageIcon("images/trump.gif");
     JLabel imagepartylabel = new JLabel("", imageparty, JLabel.CENTER);
     imagepartylabel.setBounds(175 , 0 , 600 , 650);
     mjp.add(imagepartylabel);
    }
     if(partyFlag == 3) // independent
     {
     selectParty();
     imageparty = new ImageIcon("images/bernie.png");
     JLabel imagepartylabel = new JLabel("", imageparty, JLabel.CENTER);
     imagepartylabel.setBounds(300 , 100 , 400 , 400);
     mjp.add(imagepartylabel);
     }
     if(districtFlag == 1) // urban
     {
     selectDistrict();
     imageparty = new ImageIcon("images/urban.jpg");
     JLabel imagepartylabel = new JLabel("", imageparty, JLabel.CENTER);
     imagepartylabel.setBounds(300 , 100 , 400 , 400);
     mjp.add(imagepartylabel);
     }
     if(districtFlag == 2) // rural
     {
     selectDistrict();
     imageparty = new ImageIcon("images/rural.jpg");
     JLabel imagepartylabel = new JLabel("", imageparty, JLabel.CENTER);
     imagepartylabel.setBounds(300 , 100 , 400 , 400);
     mjp.add(imagepartylabel);
     }
     if(districtFlag == 3) // coastal
     {
     selectDistrict();
     imageparty = new ImageIcon("images/coastal.jpg");
     JLabel imagepartylabel = new JLabel("", imageparty, JLabel.CENTER);
     imagepartylabel.setBounds(300 , 100 , 400 , 400);
     mjp.add(imagepartylabel);
     }
   }
    
    public void joptionFrame()
    { 
      JFrame frame = new JFrame("Input");
      Object[] choice = {"Hell Yeah","Noo..!","Not smart Enough"};
      
      int name = JOptionPane.showOptionDialog(frame, "Are you sure you want to continue?",
                                               "A Silly Question",
                                                JOptionPane.YES_NO_CANCEL_OPTION,
                                               JOptionPane.QUESTION_MESSAGE,
                                               null,
                                               choice,
                                               choice[0]);
    /*  if(choice[2] == true)
      {
        System.exit(0);
      }*/
                                               
      
    
    }
    //---------------------------------Create decision array-----------------------
    /*public void createDecision() {
      Decision[] decisions = new Decision[3];
      DecisionFactory df = new DecisionFactory();
        
      decisions[0] = df.vaccination(d);
      decisions[1] = df.road(d);
      decisions[2] = df.kill(d);
    }*/
    //-------------------------------First question-----------------------------
    public void firstDecision () {
      mjp.removeAll(); // REMOVING ALL THE PREV COMPONENT
      dflag = 1;
      int index = 0;
      Decision[] decisions = new Decision[3];
      DecisionFactory df = new DecisionFactory();  
      decisions[0] = df.vaccination(d);
      decisions[1] = df.road(d);
      decisions[2] = df.kill(d);
       for (int foo = 0; foo < decisions.length; foo++) {
         index = printDecision(decisions[foo], index);
         dflag++;
        }
      //creating new buttons
      decisionBut1 = new JButton("<html>" + categoryBut1 + "<br/>" + descriptionBut1 + "</html>");
      decisionBut2 = new JButton("<html>" + categoryBut2 + "<br/>" + descriptionBut2 + "</html>");
      decisionBut3 = new JButton("<html>" + categoryBut3 + "<br/>" + descriptionBut3 + "</html>");
      yes = new JButton("Yes");
      no = new JButton("No");
      submit = new JButton("Submit");
      // action
      decisionBut1.addActionListener(this);
      decisionBut2.addActionListener(this);
      decisionBut3.addActionListener(this);
      yes.addActionListener(this);
      no.addActionListener(this);
      submit.addActionListener(this);
      decisionBut1.setActionCommand("decision1");
      decisionBut2.setActionCommand("decision2");
      decisionBut3.setActionCommand("decision3");
      // location
      decisionBut1.setBounds(50, 100, 700, 100);
      decisionBut2.setBounds(50, 250, 700, 100);
      decisionBut3.setBounds(50, 400, 700, 100);
      yes.setBounds(40, 500, 100, 60);
      no.setBounds(40, 600, 100, 60);
      submit.setBounds(800, 450, 100, 60);
      // adding to the frame
      mjp.add(decisionBut1);
      mjp.add(decisionBut2);
      mjp.add(decisionBut3);
      mjp.add(yes);
      mjp.add(no);
      mjp.add(submit);
      // repainting
      mjp.revalidate();
      mjp.repaint();
      // checking the back flag
    }
   
    //--------------------------End of first question-------------------------------
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
        if(e.getActionCommand() == "Democrat"){
          partyFlag = 1;
          imagePop();
        }
        if(e.getActionCommand() == "Republican"){
          partyFlag = 2;
          imagePop();
        }
        if(e.getActionCommand() == "Independent"){
          partyFlag = 3;
          imagePop();
        }
        if(e.getActionCommand() == "Urban"){
          //demographics(1);
          districtFlag = 1;
          imagePop();
           //demographics(districtFlag);
        }
        if(e.getActionCommand() == "Rural"){
          districtFlag = 2;
          imagePop();
           //demographics(districtFlag);
        }
        if(e.getActionCommand() == "Coastal"){
          districtFlag = 3;
          imagePop();
          //demographics(districtFlag);
         
        }
        if(e.getActionCommand() == "decision1")
        {
          System.out.println("yo");
          mainMenu(mjp);
        }
        if(e.getActionCommand() == "decision2")
        {
          System.out.println("yo");
          mainMenu(mjp);
        }
        if(e.getActionCommand() == "decision3")
        {
          System.out.println("yo");
          mainMenu(mjp);
        }
        if(e.getActionCommand() == "yes")
          {
            decisionFlag = 1;
          }
          if(e.getActionCommand() == "no")
          {
            decisionFlag = 2;
          }
        if(e.getActionCommand() == "Submit"){
          if(partyFlag > 0)
          {
            joptionFrame();
           selectDistrict();
          }
          if(districtFlag > 0)
          {
             demographics(districtFlag);
          }
          if(decisionFlag > 0)
          {
            //update demographics
            demographics(districtFlag);
          }
          
        }
        if(e.getActionCommand() == "Continue"){
          firstDecision();
        }
          if(e.getActionCommand() == "<<<<")
          {
           
            if(bflag == 1)
            { 
              mainMenu(mjp);
            }
            if(bflag == 2)
                 {
              selectParty();
                 }
            if(bflag == 3)
            {
              selectDistrict();
            }
          }
          
        }
  
 
    
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
        //ss.processCommandLoop();
        
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
        districtType = d.getName();
        pop = Double.toString(d.getPop());
        budget = Double.toString(d.getBudget());
        death = Double.toString(d.getDeath());
        return d;
    }
    District createDistrictRural (int dType) {
        District d = new RuralDistrict(dType);
        d.setName();
        d.setPop(0);
        d.setBudget(0);
        d.setDeath(0);
        System.out.println(d.getDistrict());    //debug line
        districtType = d.getName();
        pop = Double.toString(d.getPop());
        budget = Double.toString(d.getBudget());
        death = Double.toString(d.getDeath());
        return d;
    }
     District createDistrictCoastal (int dType) {
        District d = new CoastalDistrict(dType);
        d.setName();
        d.setPop(0);
        d.setBudget(0);
        d.setDeath(0);
        System.out.println(d.getDistrict());    //debug line
        districtType = d.getName();
        pop = Double.toString(d.getPop());
        budget = Double.toString(d.getBudget());
        death = Double.toString(d.getDeath());
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
        if(dflag == 1)
        {
        categoryBut1 = "  Type: " + getCategoryString(d.cat);
        }
        if(dflag == 2)
        {
        categoryBut2 = "  Type: " + getCategoryString(d.cat);
        }
        if(dflag == 3)
        {
        categoryBut3 = "  Type: " + getCategoryString(d.cat);
        }
        System.out.println("  " + d.description);
        if(dflag == 1)
        {
        descriptionBut1 = "  " + d.description;
        }
        if(dflag == 2)
        {
        descriptionBut2 = "  " + d.description;
        }
        if(dflag == 3)
        {
        descriptionBut3 = "  " + d.description;
        }
        for (int foo = 0; foo < d.numDecisions; foo++) {
            index++;
            System.out.println("    " + Integer.toString(index) + ") " + d.decisionDesc[foo]);
            if(dflag == 1)
            {
            decisionInfo = decisionInfo + Integer.toString(index) + ") " + d.decisionDesc[foo];
            }
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