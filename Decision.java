/* Himanshu Dhamija
 * Decision class
 */

import java.util.Scanner; // scanner class for user input
import java.util.Random; 
import java.util.*;
  
public class Decision
{
    Behavior behavior;
    Category cat;
    String description;
    int numDecisions;
    String[] decisionDesc;
    
    District d;
    
    
    public Decision() {
        
    }
    
    public Decision (Behavior b) {
        behavior = b;
    }
    
    public Decision (Behavior b, Category newCat, String newDesc, int newNum, String[] newDesDesc, District newD) {
        behavior = b;
        setCategory(newCat);
        setDescription(newDesc);
        setDecisonsdisc(newNum, newDesDesc);
        setDistrict(newD);
    }
    
    public Category getCategory () {
        return this.cat;
    }
    
    public void setCategory (Category newCat) {
        this.cat = newCat;
    }
    
    public String getDescription () {
        return this.description;
    }
    
    public void setDescription (String newDescription) {
        this.description = newDescription;
    }
    
    public int getNumDecision(){
        return this.numDecisions;
    }
    public void setDecisonsdisc(int newNumber , String[] newDescription){
        this.numDecisions = newNumber;
        this.decisionDesc = newDescription;
    }
    
    public String getdecisionDesc(int i) {
        return this.decisionDesc[i];
    }
    
    public void setDistrict (District newD) {
        this.d = newD;
    }

     
    
    public void Accept () {
        behavior.AcceptDecision(d);
    }
    
    
    public void Ignore () {
        behavior.IgnoreDecision(d);
    }
    
    
}




enum Category {
    Education, Population, Crime, Commerce
}