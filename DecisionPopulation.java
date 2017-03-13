
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




