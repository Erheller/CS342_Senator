/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senatorsim2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;




/**
 *
 * @author Erheller
 */
public class SenatorSim2 extends Application {
    //buttonsS
    @FXML
    private Button toSenatorSelectScreen;
    @FXML
    private Button loadGame;
    @FXML
    private Button options;
    @FXML
    private Button exitToDesktop;
    @FXML
    private Button toTitleScreen;
    @FXML
    private Button toDistrictSelectScreen;
    @FXML
    private RadioButton selectDem;
    @FXML
    private RadioButton selectGop;
    @FXML
    private RadioButton selectInd;    
    @FXML
    private Button confirmSenatorDistrict;
    @FXML
    private RadioButton selectCoastal;
    @FXML
    private RadioButton selectRural;
    @FXML
    private RadioButton selectUrban;
    @FXML
    private Text textDistrictName;
    @FXML
    private Text textPopulation;    
    @FXML
    private Text textDeathRate;    
    @FXML
    private Text textBudget;
    @FXML
    private Button toDecisionScreen;
    
    //decision screen components
    @FXML
    private Button decision0Button;
    @FXML
    private Button decision1Button;
    @FXML
    private Button decision2Button;
    @FXML
    private Button decision3Button;
    @FXML
    private Button decision4Button;
    @FXML
    private Button decision5Button;
    @FXML
    private Button decision6Button;
    @FXML
    private Button decision7Button;
    //decision screen popup components
    @FXML
    private Pane decisionPopUp;
    @FXML
    private Text decisionDescription;
    @FXML
    private Button decisionAction0;
    @FXML
    private Button decisionAction1;
    @FXML
    private Button decisionReturn;
    int decisionFlag;
    //public Scene scene;
    public Scene titleScene;
    public Scene senatorSelectScene;
    
    
    //flags for senator creation
    senatorAffiliation senatorFlag;
    districtType districtFlag;
    
    //district
    District d;
    
    //decision array
    Decision [] decisionArray;
    DecisionFactory df = new DecisionFactory();
    int whatDecision = 0;
    int decisionIndex;
    
    @Override
    public void start(Stage newStage) throws Exception {
        //make the scene here
        
        
        //Parent root = FXMLLoader.load(getClass().getResource("TitleScreen.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TitleScreen.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
              
        
        //set the stage to be the title scene
        newStage.setScene(scene);
        //newStage.setScene(senatorSelectScene);
        newStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void loadScene (ActionEvent e, String sceneName) throws Exception {
        //create the new scene
        Scene newScene;

        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneName));
        loader.setController(this);
        Parent root = loader.load();


        //Parent root = FXMLLoader.load(getClass().getResource(sceneName));

        newScene = new Scene(root);

        //get the stage
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();

        //set the stage to the new scene
        stage.setScene(newScene);



        //if the scene is the demographics scene, update it
        if (sceneName == "DistrictStatusScreen.fxml") {
            this.updateDemographicScreen();                
        }
    }
    
    public void titleScreenButtonClicked (ActionEvent e) throws Exception{

        //these are the TitleScreen buttons
        //for newGame, we want to load the SenatorSelectScreen scene
        if (e.getSource() == toSenatorSelectScreen) {
            this.loadScene(e, "SenatorSelectScreen.fxml");
        }
        else if (e.getSource() == loadGame) {
            System.out.println("Loading game");
        }
        else if (e.getSource() == options) {
            System.out.println("This is the options menu");
        }
        else if (e.getSource() == exitToDesktop) {
            System.exit(0);
        }
    }
    
    public void senatorSelectButtonClicked (ActionEvent e) throws Exception{
        //go to titleScreen
        if (e.getSource() == toTitleScreen) {
            this.loadScene(e, "TitleScreen.fxml");
        }
        else if (e.getSource() == toDistrictSelectScreen) {
            this.loadScene(e, "DistrictSelectScreen.fxml");
        }
    }
    
    public void selectSenator (ActionEvent e) {
        if (e.getSource() == selectDem) {
            //set affiliation
            System.out.println("Democrat selected");
            this.senatorFlag = senatorAffiliation.DEM;
            //make the confirm button clickable
            toDistrictSelectScreen.setDisable(false);
        }
        else if (e.getSource() == selectGop) {
            System.out.println("Republican selected");
            this.senatorFlag = senatorAffiliation.GOP;
            toDistrictSelectScreen.setDisable(false);
        }        
        else if (e.getSource() == selectInd) {
            System.out.println("Independent selected");
            this.senatorFlag = senatorAffiliation.IND;            
            toDistrictSelectScreen.setDisable(false);
        }  
    }
    
    
        public void districtSelectButtonClicked (ActionEvent e) throws Exception{
        //go to titleScreen
        if (e.getSource() == toSenatorSelectScreen) {
            //whatDecision = 0;
            this.loadScene(e, "SenatorSelectScreen.fxml");
        }
        else if (e.getSource() == confirmSenatorDistrict) {
            //this.loadScene(e, "DistrictSelectScreen.fxml");
            System.out.println("Confirm");
            
            //create the district here
            this.d = createDistrict (districtFlag);
            
            //let's make the array of decisions
            this.decisionArray = new Decision[8];
            //okay, let's hardcode 4 decisions in that array
            
            this.decisionArray[0] = df.vaccination(d);
            this.decisionArray[1] = df.road(d);
            this.decisionArray[2] = df.kill(d);
            this.decisionArray[3] = df.amazonTax(d);
            this.decisionArray[4] = df.foodInspection(d);
            this.decisionArray[5] = df.schoolTalk(d);
            this.decisionArray[6] = df.merchantInvestigation(d);
            this.decisionArray[7] = df.ratInfestation(d);
            
            //load the next scene
            this.loadScene(e, "DistrictStatusScreen.fxml");
            
            
        }
    }
    
    public void selectDistrict (ActionEvent e) {
        if (e.getSource() == selectCoastal) {
            //set district type
            System.out.println("Coastal selected");
            this.districtFlag = districtType.COASTAL; 
            //make the confirm button clickable
            confirmSenatorDistrict.setDisable(false);
        }
        else if (e.getSource() == selectRural) {
            System.out.println("Rural selected");
            this.districtFlag = districtType.RURAL;            
            confirmSenatorDistrict.setDisable(false);
        }        
        else if (e.getSource() == selectUrban) {
            System.out.println("Urban selected");
            this.districtFlag = districtType.URBAN;            
            confirmSenatorDistrict.setDisable(false);
        }  
    }
    
    public void districtDemographicsButtonClicked (ActionEvent e) throws Exception {
        if (e.getSource() == toDecisionScreen) {
            //load the next scene
            System.out.println("Loading decision scene");
            if(whatDecision == 0){
            this.loadScene(e, "DecisionScreen.fxml");
            }
            if(whatDecision == 1)
            {
            this.loadScene(e, "DecisionScreen1.fxml");    
            }
        }
        
    }
    
    public void updateDemographicScreen () {
        textDistrictName.setText(d.getName());
        /*
        double stuff = d.getPop();
        int stuff2 = (int)stuff;
        String stuff3 = Integer.toString(stuff2);
        */
        textPopulation.setText(Integer.toString((int)d.getPop()));
        textDeathRate.setText(Integer.toString((int)d.getDeath()));
        textBudget.setText(Integer.toString((int)d.getBudget()));

    }
    
    
    public void decisionScreenButtonClicked (ActionEvent e) throws Exception {
        if (e.getSource() == decision0Button) {
            System.out.println("Decision 0 clicked");
            updateDecisionPopup(this.decisionArray[0]);
            this.decisionIndex = 0;            
            System.out.println("Setting popup to be visible");
            whatDecision = 1;
            decisionPopUp.setVisible(true);
        }
        else if (e.getSource() == decision1Button) {
            System.out.println("Decision 1 clicked");
            updateDecisionPopup(this.decisionArray[1]);
            this.decisionIndex = 1;
            System.out.println("Setting popup to be visible");
            whatDecision = 1;
            decisionPopUp.setVisible(true);
        }        
        else if (e.getSource() == decision2Button) {
            System.out.println("Decision 2 clicked");
            updateDecisionPopup(this.decisionArray[2]);
            this.decisionIndex = 2;
            System.out.println("Setting popup to be visible");
            whatDecision = 1;
            decisionPopUp.setVisible(true);
        } 
        else if (e.getSource() == decision3Button) {
            System.out.println("Decision 3 clicked");
            updateDecisionPopup(this.decisionArray[3]);
            this.decisionIndex = 3;
            System.out.println("Setting popup to be visible");
            whatDecision = 1;
            decisionPopUp.setVisible(true);
        } 
        
        
        //popup buttons
        else if (e.getSource() == decisionReturn) {
            System.out.println("Setting popup to be invisible");
            decisionPopUp.setVisible(false);
        } 
        else if (e.getSource() == decisionAction0) {
            //do the action
            System.out.println("Doing action 0");
            this.decisionArray[this.decisionIndex].behavior.AcceptDecision(d);
            decisionFlag = 1;
            
            
            
            //return to the demographics screen
            this.loadScene(e, "DistrictStatusScreen.fxml");
        }
        else if (e.getSource() == decisionAction1) {
            //do the action
            System.out.println("Doing action 1");
            this.decisionArray[this.decisionIndex].behavior.IgnoreDecision(d);
            decisionFlag = 1;
            
            
            //return to the demographics screen
            this.loadScene(e, "DistrictStatusScreen.fxml");
        }
    }
    public void decisionScreenButtonClicked1 (ActionEvent e) throws Exception{
          if (e.getSource() == decision4Button) {
            System.out.println("Decision 4 clicked");
            updateDecisionPopup(this.decisionArray[4]);
            this.decisionIndex = 4;
            System.out.println("Setting popup to be visible");
            whatDecision = 1;
            decisionPopUp.setVisible(true);
        }
          if (e.getSource() == decision5Button) {
            System.out.println("Decision 5 clicked");
            updateDecisionPopup(this.decisionArray[5]);
            this.decisionIndex = 5;
            System.out.println("Setting popup to be visible");
            whatDecision = 1;
            decisionPopUp.setVisible(true);
        }
          if (e.getSource() == decision6Button) {
            System.out.println("Decision 6 clicked");
            updateDecisionPopup(this.decisionArray[6]);
            this.decisionIndex = 6;
            System.out.println("Setting popup to be visible");
            whatDecision = 1;
            decisionPopUp.setVisible(true);
        }
          if (e.getSource() == decision7Button) {
            System.out.println("Decision 7 clicked");
            updateDecisionPopup(this.decisionArray[7]);
            this.decisionIndex = 7;
            System.out.println("Setting popup to be visible");
            whatDecision = 1;
            decisionPopUp.setVisible(true);
        }
          //popup buttons
        else if (e.getSource() == decisionReturn) {
            System.out.println("Setting popup to be invisible");
            decisionPopUp.setVisible(false);
        } 
        else if (e.getSource() == decisionAction0) {
            //do the action
            System.out.println("Doing action 0");
            this.decisionArray[this.decisionIndex].behavior.AcceptDecision(d);
            decisionFlag = 1;
            
            
            
            //return to the demographics screen
            this.loadScene(e, "DistrictStatusScreen.fxml");
        }
        else if (e.getSource() == decisionAction1) {
            //do the action
            System.out.println("Doing action 1");
            this.decisionArray[this.decisionIndex].behavior.IgnoreDecision(d);
            decisionFlag = 1;
            
            
            //return to the demographics screen
            this.loadScene(e, "DistrictStatusScreen.fxml");
        }
    }
        
    private void updateDecisionPopup (Decision dec) {
        decisionDescription.setText(dec.getDescription());  //set description
        //descriptions for buttons
        decisionAction0.setText(dec.getdecisionDesc(0));
        decisionAction1.setText(dec.getdecisionDesc(1));
        
    } 
    
    
    
    /*
    * Methods for creating districts
    */
    District createDistrict (districtType dType) {
        switch (dType) {
            case COASTAL:
                return createDistrictCoastal (0);
            case RURAL:
                return createDistrictRural (1);
            case URBAN:
                return createDistrictUrban(2);
        }
        return null;
    }
    
    
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
}

enum senatorAffiliation {
    DEM, GOP, IND
}

enum districtType {
    COASTAL, RURAL, URBAN
}