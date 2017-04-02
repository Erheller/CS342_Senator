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
    String[] outcomeDesc;
    
    District d;
    
    
    public Decision() {
        
    }
    
    public Decision (Behavior b) {
        behavior = b;
    }
    
    public Decision (Behavior b, Category newCat, String newDesc, int newNum, String[] newDesDesc, String[] newOutDesc, District newD) {
        behavior = b;
        setCategory(newCat);
        setDescription(newDesc);
        setDecisonDesc(newNum, newDesDesc);
        setOutcomeDesc(newNum, newOutDesc);
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
    public void setDecisonDesc(int newNumber , String[] newDescription){
        this.numDecisions = newNumber;
        this.decisionDesc = newDescription;
    }
    
    public String getdecisionDesc(int i) {
        return this.decisionDesc[i];
    }
    
    public void setOutcomeDesc(int newNumber , String[] newDescription){
        this.numDecisions = newNumber;
        this.outcomeDesc = newDescription;
    }    
    public void setDistrict (District newD) {
        this.d = newD;
    }

     
    
    public void Accept () {
        behavior.AcceptDecision(d);
        System.out.println(this.outcomeDesc[0]);
    }
    
    
    public void Ignore () {
        behavior.IgnoreDecision(d);
        System.out.println(this.outcomeDesc[1]);
    }
    
    
}




enum Category {
    Education, Population, Crime, Commerce, Infrastructure
}