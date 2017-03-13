public class RuralDistrict implements District {

  public int dType;
  public double pop;
  public double budget;
  public double death;
  public String dName;
  public RuralDistrict(int dType)
  {
    this.dType = dType;
  }
  //All the setters and getters for population
  //***March 12, 2017 - Took out dType passing because we have classes for each district so dont need to specify here. - Shanil Lobanwala
  public void setName()
  {
     dName = "Rural District";
  }
  public void setPop(double decision)
  {
     pop = 2000 + decision;
  }
  public void setBudget(double decision)
  {
     budget = 15000 + decision;
  }
  public void setDeath(double decision)
  {
     death = pop*.00823 + decision;
  }
  public String getDistrict()
  {    
    return "District Type: " + dName + "\nPopulation: " + Double.toString(pop) + "\nBudget: " + Double.toString(budget) 
      + "\nDeaths: " + Double.toString(death);
  }
}