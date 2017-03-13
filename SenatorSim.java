import java.util.Scanner;
public class SenatorSim
{
    Scanner sc;
    District d;
    
    public SenatorSim () {
        sc = new Scanner(System.in); //scanner for text input
    }
    
    public static void main( String[] args)
    {
        SenatorSim ss = new SenatorSim ();
        ss.processCommandLoop();
    }
    
    //have the user input a number
    //if the number is a type of district, return that number
    //else return -1
    //TODO
    //exception handling
    int getDistrictFromUser () {
        System.out.println("Please enter type of district you want (1-3), or 0 to exit");
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
        
        //creating two different Decisions
        Decision[] decisions = new Decision[2];
        String[] tempString = new String[2];
        tempString[0] = "Allocate $50,000 to fund the vaccination program";
        tempString[1] = "I have more important things to take care of";
        
        decisions[0] = new Decision(new DecisionPopulation(), Category.Population, "It's flu season, and many of the people in your district are unvaccinated. Will you spend funds for a free vaccination program?", 2, tempString, d);
        tempString[0] = "Allocate $200,000 to start the road repairs";
        tempString[1] = "The roads are fine. At least near your house.";
        decisions[1] = new Decision(new DecisionPopulation(), Category.Infrastructure, "Many of the roads in your district are out of repair, and your office has been receiving complaints from the citizenry. Will you allocate funds to repair the roads?", 2, tempString, d);
        
        
        
    }
    
}