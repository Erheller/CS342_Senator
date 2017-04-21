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




    
    //public Scene scene;
    public Scene titleScene;
    public Scene senatorSelectScene;
    
    
    //flags for senator creation
    senatorAffiliation senatorFlag;
    districtType districtFlag;
    
    //district
    District d;
    
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
            this.loadScene(e, "SenatorSelectScreen.fxml");
        }
        else if (e.getSource() == confirmSenatorDistrict) {
            //this.loadScene(e, "DistrictSelectScreen.fxml");
            System.out.println("Confirm");
            
            //create the district here
            this.d = createDistrict (districtFlag);
            //System.out.println(this.d.getDistrict());
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
    
    public void districtDemographicsButtonClicked (ActionEvent e) {
        if (e.getSource() == toDecisionScreen) {
            //load the next scene
            System.out.println("Loading next scene");
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