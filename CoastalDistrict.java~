public class CoastalDistrict implements District {

  public int dType;
  public double pop;
  public double budget;
  public double death;
  public String dName;
  public CoastalDistrict(int dType)
  {
    this.dType = dType;
  }
  //All the setters and getters for population
  public void setName()
  {
    if(dType == 3)
    {
    dName = "Coastal District";
    }
  }
  public void setPop(double decision)
  {
    if(dType == 3)
    {
    pop = 8300 + decision;
    }
  }
  public void setBudget(double decision)
  {
    if(dType == 3)
    {
    budget = 200000+ decision;
    }
  }
  public void setDeath(double decision)
  {
    if(dType == 3)
    {
    death = pop*.00823 + decision;
    }
  }
  public String getDistrict()
  {    
    return "District Type: " + dName + "\nPopulation: " + Double.toString(pop) + "\nBudget: " + Double.toString(budget) 
      + "\nDeaths: " + Double.toString(death);
  }
}