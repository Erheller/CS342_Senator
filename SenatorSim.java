import java.util.Scanner;
public class SenatorSim
{
    Scanner sc;
    
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
            System.exit(0);
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
    District createDistrict (int dType) {
        District d = new CoastalDistrict(dType);
        d.setName();
        d.setPop(0);
        d.setBudget(0);
        d.setDeath(0);
        System.out.println(d.getDistrict());    //debug line
        return d;
    }
    
    void processCommandLoop () {
        int districtType = getDistrictFromUser ();
        createDistrict(districtType);
    }
    
}