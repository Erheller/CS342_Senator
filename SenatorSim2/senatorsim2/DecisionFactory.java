package senatorsim2;

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
  *  method to create decision
  *  interface that the decision class uses
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
 
 
 public Decision amazonTax (District d) {
  //2 decisions
        String descString = "Some members of your cabinet want to collect sales tax from online retailers that ship to your region.";
        String[] decisionDescString = packageStrings (
          "Tax them. They get free shipping anyways.",
          "Don't tax them. You don't want to pay sales tax on that new washing machine you're buying.");
  String[] outcomeDescString = packageStrings (
    "The tax passes. Revenue increases.",
    "Your washing machine arrives. Free shipping, no sales tax. How nice.");
  return new Decision(new DAmazonTax(), Category.Commerce, descString, 2, decisionDescString, outcomeDescString, d);
 }
 class DAmazonTax implements Behavior {
  //Get money
  //[TODO] Lower approval
     public void AcceptDecision(District d) {
      d.updateBudget(d.getBudget() + 500000);
     }
     //Nothing happens
     public void IgnoreDecision(District d) {
         
     }
 }
 
 
 public Decision ratInfestation (District d) {
  //2 decisions
        String descString = "District has an infestation of rats";
        String[] decisionDescString = packageStrings (
          "Get exterminators and professionals to take care of this issue",
          "People can take care of themselves just have signs posted around");
  String[] outcomeDescString = packageStrings (
    "Public is happy, lost some money in the budget but it was worth it.",
    "Death happened and bad health conditions of many. Lost a good amount of the population");
  return new Decision(new DratInfestation(), Category.Population, descString, 2, decisionDescString, outcomeDescString, d);
 }
 class DratInfestation implements Behavior {
  //[DOCUMENTATION]
     public void AcceptDecision(District d) {
      d.updateBudget(d.getBudget() - 100000);
     }
     //[DOCUMENTATION]
     public void IgnoreDecision(District d) {
      d.updatePop(d.getPop() / 2);
      d.updateDeath(d.getDeath() + 125000 );
     }
 }
 
 
 public Decision publicTransportation (District d) {
  //2 decisions
        String descString = "Public transit authority requires more money.";
        String[] decisionDescString = packageStrings (
          "Give them more money.",
          "They're lying, do not give them money");
  String[] outcomeDescString = packageStrings (
    "More trains are added and more people come to the district.",
    "People cannot afford moving around, so many leave the district.");
  return new Decision(new DpublicTransportation(), Category.Infrastructure, descString, 2, decisionDescString, outcomeDescString, d);
 }
 class DpublicTransportation implements Behavior {
  //[DOCUMENTATION]
     public void AcceptDecision(District d) {
      d.updateBudget(d.getBudget() - 435042);   
     }
     //[DOCUMENTATION]
     public void IgnoreDecision(District d) {
      d.updatePop(d.getPop() / 3);   
     }
 }
 
 
 public Decision serialKiller (District d) {
  //2 decisions
        String descString = "A serial killer is on the loose killing innocents.";
        String[] decisionDescString = packageStrings (
          "Send more law enforcement officers to take care of the situation.",
          "Let the people know you care but we have no money.");
  String[] outcomeDescString = packageStrings (
    "Good men die but the job is done, the serial killer is put to death sentence.",
    "The serial killed kills half your population before the people find him.");
  return new Decision(new dserialKiller(), Category.Crime, descString, 2, decisionDescString, outcomeDescString, d);
 }
 class dserialKiller implements Behavior {
  //[DOCUMENTATION]
     public void AcceptDecision(District d) {
         d.updatePop(d.getPop() - 50);
     }
     //[DOCUMENTATION]
     public void IgnoreDecision(District d) {
         d.updatePop(d.getPop() / 2);
     }
 }
 
 
  public Decision riot (District d) {
  //2 decisions
        String descString = "People are rebelling against your leadership.";
        String[] decisionDescString = packageStrings (
          "Give law enforcement the green light for more severe actions",
          "Try to quell the anger of the people with a public speech.");
  String[] outcomeDescString = packageStrings (
    "Many people die but you are still in control.",
    "People feel more compassionate and give you a second chance, tourism increases.");
  return new Decision(new driot(), Category.Population, descString, 2, decisionDescString, outcomeDescString, d);
 }
 class driot implements Behavior {
  //[DOCUMENTATION]
     public void AcceptDecision(District d) {
          d.updatePop(d.getPop() - 555394);
     }
     //[DOCUMENTATION]
     public void IgnoreDecision(District d) {
          d.updatePop(d.getPop() + 210);
     }
 }
 
 
  public Decision stocks (District d) {
  //2 decisions
        String descString = "Stocks for many companies in your district are falling";
        String[] decisionDescString = packageStrings (
          "Invest in them with the districts money.",
          "Ignore it, happens all the time they drop then they rise.");
  String[] outcomeDescString = packageStrings (
    "Stocks rise again but many public resources have less money for this quarter.",
    "Many corporations close down, people lost jobs and deaths increase.");
  return new Decision(new dstocks(), Category.Commerce, descString, 2, decisionDescString, outcomeDescString, d);
 }
 class dstocks implements Behavior {
  //[DOCUMENTATION]
     public void AcceptDecision(District d) {
          d.updateBudget(d.getBudget() - 334500);
     }
     //[DOCUMENTATION]
     public void IgnoreDecision(District d) {
          d.updateDeath(d.getDeath() + 335000);
          d.updatePop(d.getPop() - d.getDeath());
     }
 }
    
    
    
    public Decision powerPlant (District d) {
        //2 decisions
        String descString = "The electric company has informed you that one of their generators is failing, which will leave a quarter of your district without power.";
        String[] decisionDescString = packageStrings (
                                                      "Invest in a new power generator.",
                                                      "Will your home have power? Yes? Carry on.");
        String[] outcomeDescString = packageStrings (
                                                     "A new generator is procured, and the citizens continue on their daily lives.",
                                                     "Power is out for a week. People can't open their garage door to go to work. Kids can't watch TV. Grandparents fall down stairs.");
        return new Decision(new dPowerPlant(), Category.Commerce, descString, 2, decisionDescString, outcomeDescString, d);
    }
    class dPowerPlant implements Behavior {
        //[DOCUMENTATION]
        public void AcceptDecision(District d) {
            d.updateBudget(d.getBudget() - 300000);
        }
        //[DOCUMENTATION]
        public void IgnoreDecision(District d) {
            d.updateDeath(d.getDeath() + 200);
            d.updatePop(d.getPop() - d.getDeath());
        }
    }
    
    
    
    public Decision team (District d) {
        //2 decisions
        String descString = "A local baseball player suggests making a district baseball team.";
        String[] decisionDescString = packageStrings (
                                                      "Yes! This could attract new people and investors.",
                                                      "I don't like baseball.");
        String[] outcomeDescString = packageStrings (
                                                     "Investing in the sports team takes more money than you initially expected, but some new people move to the district.",
                                                     "Oh. Okay.");
        return new Decision(new dTeam(), Category.Commerce, descString, 2, decisionDescString, outcomeDescString, d);
    }
    class dTeam implements Behavior {
        //[DOCUMENTATION]
        public void AcceptDecision(District d) {
            d.updatePop(d.getPop() + 100);
        }
        //[DOCUMENTATION]
        public void IgnoreDecision(District d) {
            
        }
    }
    
    
    public Decision hospital (District d) {
        //2 decisions
        String descString = "The local hospital requests additional funding for new equipment.";
        String[] decisionDescString = packageStrings (
                                                      "Grant the funds. It's important that people stay healthy.",
                                                      "Ignore the hospital and make a public service announcement to encourage the populace to eat more apples.");
        String[] outcomeDescString = packageStrings (
                                                     "The hospital puts the funds to good use, lowering the number of deaths in the district.",
                                                     "The hospital is unable to adequately care for patients. Also, apple sales do not rise.");
        return new Decision(new dHospital(), Category.Population, descString, 2, decisionDescString, outcomeDescString, d);
    }
    class dHospital implements Behavior {
        //[DOCUMENTATION]
        public void AcceptDecision(District d) {
            d.updateDeath(d.getDeath() - 20);
            if (d.getDeath() <= 0) {
                d.updateDeath(0);
            }
        }
        //[DOCUMENTATION]
        public void IgnoreDecision(District d) {
            d.updateDeath(d.getDeath() + 10);
        }
    }
    
    
    
    
    
    public Decision internet (District d) {
        //2 decisions
        String descString = "A new internet service provider offers to install optic fiber cables in your district for a price. The current ISP offers you a wad of cash to reject the offer.";
        String[] decisionDescString = packageStrings (
                                                      "Invest in the optic fiber cables. It's important that people can access the internet.",
                                                      "Money is worth more than people's ability to check their Facebook.");
        String[] outcomeDescString = packageStrings (
                                                     "The cables are successfully installed.",
                                                     "Nothing happens, except that you're a little richer than before.");
        return new Decision(new dInternet(), Category.Infrastructure, descString, 2, decisionDescString, outcomeDescString, d);
    }
    class dInternet implements Behavior {
        //[DOCUMENTATION]
        public void AcceptDecision(District d) {
            d.updateBudget(d.getBudget() - 200000);
        }
        //[DOCUMENTATION]
        public void IgnoreDecision(District d) {
            d.updateBudget(d.getBudget() + 100000);
        }
    }
    
    
    
    
    public Decision heat (District d) {
        //2 decisions
        String descString = "There's a heat wave in your district!";
        String[] decisionDescString = packageStrings (
                                                      "Have emergency services distribute water and check on the elderly.",
                                                      "Do nothing. Save money.");
        String[] outcomeDescString = packageStrings (
                                                     "The EMT's undoubtedly save several lives.",
                                                     "People die from the heat.");
        return new Decision(new dHeat(), Category.Population, descString, 2, decisionDescString, outcomeDescString, d);
    }
    class dHeat implements Behavior {
        //[DOCUMENTATION]
        public void AcceptDecision(District d) {
            d.updateDeath(d.getDeath() - 10);
        }
        //[DOCUMENTATION]
        public void IgnoreDecision(District d) {
            d.updateDeath(d.getDeath() + 30);
        }
    }
    
    
    
    
    public Decision sewer (District d) {
        //2 decisions
        String descString = "The sewers have been unusually smelly for the past few days. Residents complain.";
        String[] decisionDescString = packageStrings (
                                                      "Send inspectors to the sewers.",
                                                      "You don't have the money. Ignore the residents.");
        String[] outcomeDescString = packageStrings (
                                                     "There was a gas leak in the sewers, which could have caused an explosion. Fortunately, the inspectors repaired it.",
                                                     "Several days later, an explosion occurs in town. Several people are badly injured and later die in the hopsital. It is later determined that the cause was a gas leak in the sewers.");
        return new Decision(new dSewer(), Category.Population, descString, 2, decisionDescString, outcomeDescString, d);
    }
    class dSewer implements Behavior {
        //[DOCUMENTATION]
        public void AcceptDecision(District d) {
            d.updateBudget(d.getBudget() - 20000);
        }
        //[DOCUMENTATION]
        public void IgnoreDecision(District d) {
            d.updatePop(d.getPop() - 5);
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










