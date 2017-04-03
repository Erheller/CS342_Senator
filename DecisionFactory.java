public class DecisionFactory {
	
	public DecisionFactory(){
		
	};
	
	//only send two arguements here for now
	private String[] packageStrings (String...strings) {
		return strings;
	}
	
	/*
	 * Here are the different Decisions you can make
	 * Format is like this:
	 * 	method to create decision
	 * 	interface that the decision class uses
	 */
	
	
	public Decision vaccination (District d) {
		//2 decisions
        String descString = "It's flu season, and many of the people in your district are unvaccinated. Will you spend funds for a free vaccination program?";
        String[] decisionDescString = packageStrings (
        		"Allocate $50,000 to fund the vaccination program.",
        		"The funds will be better used elsewhere.");
		String[] outcomeDescString = packageStrings (
				"The vaccination program is a success! There are no deaths from the flu this year.",
				"This season's flu is especially bad. People die. You bring shame and dishonor to your family.");
		return new Decision(new DVaccination(), Category.Population, descString, 2, decisionDescString, outcomeDescString, d);
	}
	class DVaccination implements Behavior {
		//reduce money, change nothing else
	    public void AcceptDecision(District d) {
	        d.updateBudget(d.getBudget() - 50000);
	    }
	    //decrease population
	    public void IgnoreDecision(District d) {
	        d.updatePop(d.getPop() * 0.95);
	    }
	}
	
	
	public Decision road (District d) {
		//2 decisions
        String descString = "Many of the roads in your district are out of repair, and your office has been receiving complaints from the citizenry. Will you allocate funds to repair the roads?";
        String[] decisionDescString = packageStrings (
        		"Roads are important. Allocate $200,000 to start the repairs",
        		"The roads are fine. At least near your house.");
		String[] outcomeDescString = packageStrings (
				"You've allocated funds to improve the roads around town. In a few months, the town's roads will be nice and shiny, but in the meantime the citizens have to deal with increased traffic and the noise of jackhammers.",
				"The roads are not repaired. They continue to fall into disrepair, making the citizens unhappy. A few traffic accidents also occur.");
		return new Decision(new DBuildRoads(), Category.Infrastructure, descString, 2, decisionDescString, outcomeDescString, d);
	}
	class DBuildRoads implements Behavior {
		//reduce money
		//TODO reduce approval
	    public void AcceptDecision(District d) {
	        d.updateBudget(d.getBudget() - 200000);
	    }
	    //increase death rate
	    public void IgnoreDecision(District d) {
	        d.updateDeath(d.getDeath() + d.getPop() * 0.01);
	    }
	}
	
	
	public Decision kill (District d) {
		//2 decisions
        String descString = "A mysterious man approaches you. He asks, 'Would you like to kill everyone in your district?' What do you say?";
        String[] decisionDescString = packageStrings (
        		"hell ya",
        		"hell naw");
		String[] outcomeDescString = packageStrings (
				"Congratulations! You've killed everyone in your district. Are you proud of yourself?",
				"Uh, congrats. You didn't kill your entire town.");
		return new Decision(new DKILL(), Category.Population, descString, 2, decisionDescString, outcomeDescString, d);
	}
	class DKILL implements Behavior {
		//kill everyone
	    public void AcceptDecision(District d) {
	        d.updatePop(0);
	    }
    	//do nothing
	    public void IgnoreDecision(District d) {
	    }
	}
	
	
}










