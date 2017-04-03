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
	
	
	public Decision foodInspection (District d) {
		//2 decisions
        String descString = "The food inspection department is running over budget.";
        String[] decisionDescString = packageStrings (
        		"Give them $200,000 of extra funding.",
        		"Let them find their own sources for money.");
		String[] outcomeDescString = packageStrings (
				"The food inspection department continues to request more money. Eventually someone notices that their balances don't add up, but no one is able to find out where the money went or who is responsible.",
				"The food inspection department undergoes restructuring. People are laid off, and inspections stop for the forseeable future.");
		return new Decision(new DFoodInspection(), Category.Commerce, descString, 2, decisionDescString, outcomeDescString, d);
	}
	class DFoodInspection implements Behavior {
		//Spend money
		//[TODO] Lower population satisfaction
	    public void AcceptDecision(District d) {
	        d.updateBudget(d.getBudget() - 200000);
	    }
	    //Increase death rate slightly
	    //[TODO] Lower population satisfaction
	    public void IgnoreDecision(District d) {
	    	d.updateDeath(d.getDeath() + d.getPop() * 0.001);
	    }
	}
	
	
	public Decision schoolTalk (District d) {
		//2 decisions
        String descString = "The local high school invites you to give a presentation about your role in the government to their current students.";
        String[] decisionDescString = packageStrings (
        		"Accept. You like talking about yourself.",
        		"Decline. They're high school students. You don't like high school students.");
		String[] outcomeDescString = packageStrings (
				"Your speech is generally successful. The local newspaper covers the event, and your approval goes up.",
				"Eh, the kids probably didn't want to listen to you anyways.");
		return new Decision(new DSchoolTalk(), Category.Population, descString, 2, decisionDescString, outcomeDescString, d);
	}
	class DSchoolTalk implements Behavior {
		//[TODO] Approval rating goes up
	    public void AcceptDecision(District d) {
	        
	    }
	    //nothing happens
	    public void IgnoreDecision(District d) {
	        
	    }
	}
	
	
	public Decision merchantInvestigation (District d) {
		//2 decisions
        String descString = "You are approached by a wealthy businessman, one of the most influential in the district. 'I'm under investigation for municipal tax evasion,' he mutters, eyes darting around the room. 'Help me out, and I'll make it worth your while'.";
        String[] decisionDescString = packageStrings (
        		"Accept.",
        		"Decline.");
		String[] outcomeDescString = packageStrings (
				"The charges against the businessman are dropped. Everyone knows something suspicious went on, but no one has solid proof you helped. But the rumors start anyways.",
				"The businessman, obviously flustered by your refusal, hems and haws for a few minutes before leaving. The courts slap him with a heavy fine.");
		return new Decision(new DMerchantInvestigation(), Category.Personal, descString, 2, decisionDescString, outcomeDescString, d);
	}
	class DMerchantInvestigation implements Behavior {
		//Receive money
		//[TODO] Decrease approval
	    public void AcceptDecision(District d) {
	    	d.updateBudget(d.getBudget() + 1000000);
	    }
	    //receive money
	    public void IgnoreDecision(District d) {
	    	d.updateBudget(d.getBudget() + 100000);
	    }
	}
	
	
	
	//template
	/*
	public Decision ["NAMEOFDECISION"] (District d) {
		//2 decisions
        String descString = "[DESCRIPTION]";
        String[] decisionDescString = packageStrings (
        		"[OPTION1]",
        		"[OPTION2");
		String[] outcomeDescString = packageStrings (
				"[OUTCOME1]",
				"[OUTCOME2]");
		return new Decision(new ["INTERFACE"](), Category.["CATEGORY"], descString, 2, decisionDescString, outcomeDescString, d);
	}
	class ["INTERFACE"] implements Behavior {
		//[DOCUMENTATION]
	    public void AcceptDecision(District d) {
	        
	    }
	    //[DOCUMENTATION]
	    public void IgnoreDecision(District d) {
	        
	    }
	}
	*/
}










