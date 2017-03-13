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
  //***March 12, 2017 - Took out dType passing because we have classes for each district so dont need to specify here. - Shanil Lobanwala
  public void setName()
  {
     dName = "Coastal District";
  }
  public void setPop(double decision)
  {
     pop = 8300 + decision;
  }
  public void updatePop(double decision)
  {
    pop = decision;
  }
  public double getPop()
  {
    return pop;
  }
  public void setBudget(double decision)
  {
     budget = 1000000 + decision;
  }
  public void updateBudget(double decision)
  {
    budget = decision;
  }
  public double getBudget()
  {
    return budget;
  }
  public void setDeath(double decision)
  {
     death = pop*.00823 + decision;
  }
  public void updateDeath(double decision)
  {
    death = decision;
  }
  public double getDeath()
  {
    return death;
  }
  public String getDistrict()
  {    
    return "District Type: " + dName + "\nPopulation: " + Double.toString(pop) + "\nBudget: " + Double.toString(budget) 
      + "\nDeaths: " + Double.toString(death);
  }
}






class UrbanDistrict implements District {
    
    public int dType;
    public double pop;
    public double budget;
    public double death;
    public String dName;
    public UrbanDistrict(int dType)
    {
        this.dType = dType;
    }
    //All the setters and getters for population
    //***March 12, 2017 - Took out dType passing because we have classes for each district so dont need to specify here. - Shanil Lobanwala
    public void setName()
    {
        dName = "Urban District";
    }
    public void setPop(double decision)
    {
        pop = 50000 + decision;
    }
    public void updatePop(double decision)
    {
        pop = decision;
    }
    public double getPop()
    {
        return pop;
    }
    public void setBudget(double decision)
    {
        budget = 200000 + decision;
    }
    public void updateBudget(double decision)
    {
        budget = decision;
    }
    public double getBudget()
    {
        return budget;
    }
    public void setDeath(double decision)
    {
        death = pop*.00823 + decision;
    }
    public void updateDeath(double decision)
    {
        death = decision;
    }
    public double getDeath()
    {
        return death;
    }
    public String getDistrict()
    {
        return "District Type: " + dName + "\nPopulation: " + Double.toString(pop) + "\nBudget: " + Double.toString(budget)
        + "\nDeaths: " + Double.toString(death);
    }
}




class RuralDistrict implements District {
    
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
    public void updatePop(double decision)
    {
        pop = decision;
    }
    public double getPop()
    {
        return pop;
    }
    public void setBudget(double decision)
    {
        budget = 15000 + decision;
    }
    public void updateBudget(double decision)
    {
        budget = decision;
    }
    public double getBudget()
    {
        return budget;
    }
    public void setDeath(double decision)
    {
        death = pop*.00823 + decision;
    }
    public void updateDeath(double decision)
    {
        death = decision;
    }
    public double getDeath()
    {
        return death;
    }
    public String getDistrict()
    {
        return "District Type: " + dName + "\nPopulation: " + Double.toString(pop) + "\nBudget: " + Double.toString(budget)
        + "\nDeaths: " + Double.toString(death);
    }
}