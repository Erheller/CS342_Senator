public class District {
  //Right now theres only 3 criteria for a district, population, budget and death
  public int dType;
  public double pop;
  public double budget;
  public double death;
  public String dName;
  public District(int dType)
  {
    this.dType = dType;
  }
  //All the setters and getters for population
  public void setName()
  {
    if(dType == 1)
    {
    dName = "Urban District";
    }
    if(dType == 2)
    {
    dName = "Rural District";
    }
    if(dType == 3)
    {
    dName = "Coastal District";
    }
  }
  public void setPop(double decision)
  {
    if(dType == 1)
    {
    pop = 50000 + decision;
    }
    if(dType == 2)
    {
    pop = 2000 + decision;
    }
    if(dType == 3)
    {
    pop = 8300 + decision;
    }
  }
  public void setBudget(double decision)
  {
    if(dType == 1)
    {
    budget = 1000000 + decision;
    }
    if(dType == 2)
    {
    budget = 15000 + decision;
    }
    if(dType == 3)
    {
    budget = 200000+ decision;
    }
  }
  public void setDeath(double decision)
  {
    if(dType == 1)
    {
    death = pop*.00823 + decision;
    }
    if(dType == 2)
    {
    death = pop*.00823 + decision;
    }
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