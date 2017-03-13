
public class DecisionPopulation implements Behavior
{
    public DecisionPopulation() {
        
    }
    

    public void AcceptDecision(District d) {
        d.updatePop(d.getPop() * 1.05);
    }
    
    
    public void IgnoreDecision(District d) {
        d.updatePop(d.getPop() * 0.95);
    }
}




class DVaccination implements Behavior {
    public DVaccination() {
        
    }
    
    
    public void AcceptDecision(District d) {
        d.updateBudget(d.getBudget() - 50000);
        System.out.println("The vaccination program is a success! There are no deaths from the flu this year.");
    }
    
    
    public void IgnoreDecision(District d) {
        d.updatePop(d.getPop() * 0.95);
        System.out.println("This season's flu is especially bad. People die. You bring shame and dishonor to your family.");
    }
}

class DBuildRoads implements Behavior {
    public DBuildRoads () {
        
    }

    public void AcceptDecision(District d) {
        d.updateBudget(d.getBudget() - 200000);
        System.out.println("You've allocated funds to improve the roads around town. In a few months, the town's roads will be nice and shiny, but in the meantime the citizens have to deal with increased traffic and the noise of jackhammers.");
    }
    
    
    public void IgnoreDecision(District d) {
        d.updateDeath(d.getDeath() + d.getPop() * 0.01);
        System.out.println("The roads near your house are perfectly fine. Let's proceed to the next pressing matter. Traffic deaths increase.");
    }
    
}

class DKILL implements Behavior {
    public DKILL () {
    
    }
    
    public void AcceptDecision(District d) {
        System.out.println("Uh, congrats. You didn't kill your entire town.");
    }
    
    
    public void IgnoreDecision(District d) {
        d.updatePop(0);
        System.out.println("Congratulations! You've killed everyone in your district. Are you proud of yourself?");
    }
    
}