/* Himanshu Dhamija
 * Decission class
 * I wrote this code I hope it is the right way i did it
 * I would be free after 7:00pm fri so we can discord
 */

import java.util.Scanner; // scanner class for user input
import java.util.Random; 
import java.util.*;
  
public class decclass
{
  private String[] laws;
  private String[] district;
  private String[] opt;
  private String[] question_set1;
  private String[] question_set2;
  private String[][] opt_Set1;
  private String[][] opt_Set2;
  private String[] effects_district1;
  private String[] effects_district2;
  
  
   public int choice_number()
  {
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();
    //System.out.println(choice);
    return choice;
  }
  public void choices()  // constructor that will load all the information
  {
   
    /* kyle please type in the laws, district and question string for now
     * and we can make a daabase after
     * Thanks
     */
    laws = new String[]{ "...."};  // only 1 laws
    district = new String[]{ "....", "...."};   // only 2 districts
       
    question_set1 = new String[]{"............", "............", "............"};
    question_set2 = new String[]{"............", "............", "............"};
    // for now we shoukd have only 5 questions
    
    // options for the previous 2 sets of questions
    // each set for different district
    opt_Set1 = new String[][]{{"1....." , "2.....", "3...." , "Ignore"}, 
                            {"1....." , "2.....", "3...." , "Ignore"}, 
                            {"1....." , "2.....", "3...." , "Ignore"}}; 
    opt_Set2 = new String[][]{{"1....." , "2.....", "3...." , "Ignore"}, 
                              {"1....." , "2.....", "3...." , "Ignore"}, 
                              {"1....." , "2.....", "3...." , "Ignore"}};  
    // if chosen any option than accepts the decision else choses ignore
    
    /* I wasn't sure about the affects so for now
     * iassumed that every option chose will affect
     * the city and there will be 4 basic affects
     */
    
    /* For now i was assuming that we should pick questions that have
     * a particular effect when option 1 chosen doesnt matter from which question
     * because we have 6 questions for district set 1 and 2
     */ 
    effects_district1 = new String[] // conditional would be district 1 chosen these are the effects for the following options
    { "....." , ".....", ".....", "....."};
    effects_district2 = new String[]
    { "....." , ".....", ".....", "....."};// fill with the effects that could happen
  }
    
             
  //--------------------------------------------------------------------  
   // I am positive we need the following methods but i wwasn't sure if they are right.
   // I was thinking we could make all these in Main as well
 //---------------------------------------------------------------------
  public void law_Chosen( String selected) // for now we have only one law
  {
    int x = choice_number(); // checking with user input
    do
    { System.out.println("Choose Laws 1");
      if (x==1)
    { selected = laws[1];
      System.out.println("Law type 1 has been chosen.");
    }
      else{
         System.out.println("Input a valid number");
         }
    }while ( x != 1);
  }
  
  public void district_selected( String d_select) // only 2 districts are used for now
  {
    int y = choice_number();
    do
    { System.out.println("Choose District 1-3");
    if (y==1)
    {
      d_select = district[1];
      System.out.println("Your decicisons from now onward will effect district 1.");
    }
    else if (y==2)
    {  
      d_select = district[2];
      System.out.println("Your decicisons from now onward will effect district 2.");
    }
    else{
         System.out.println("Input a valid number");
         }
    } while (y!=1 || y!=2);
  }
  
  public void option_signed(String opt_select)
  {
    int z = choice_number();
    do
    { System.out.println("Choose what decision would you like to perform");
    
      if (z==1)
    {
      opt_select = opt[1];
      System.out.println("You selected decision 1.This decision of yours will select the future of the district");
    }
      else if (z==2)
    {  
      opt_select = opt[2];
      System.out.println("You selected decision 2.This decision of yours will select the future of the district");
    }
      else if (z==3)
    {  
      opt_select = opt[3];
      System.out.println("You selected decision 3.This decision of yours will select the future of the district");
    }
      else if (z==4)
    {  
      opt_select = opt[4];
      System.out.println("You selected decision 4.This decision of yours will select the future of the district");
    }
      else{
         System.out.println("Input a valid number");
         }
    } while (z!=1 || z!=2 || z!=3 || z !=4);
  }
}


class behavior extends decclass
{
  public boolean acceptDecisions(String user_Input)
  {
    if ( user_Input == "true"||user_Input =="True")
    { System.out.println("Decission Accepted");
      return true;
    }
    return false;
    // ask if you can use boolean
  }
  
  public static void main( String[] args)
  {
    // I created the constructor and used bunch of if else statment.
    // it worked perfect
  }
  
}
  
 