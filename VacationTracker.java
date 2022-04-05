/**

Description:
The vacation tracker program will allow a user to input up to 13 car or plane objects with necessary information. It will
also print all recommendations, print budget recommendations, print extravagent recommendations, and when exiting, print
an exit message with the number of car and plane recommendations and if there was a BMW listed in a car rec. 

*/
import javax.swing.JOptionPane;
public class VacationTracker{
   public static void main(String[] args){
      //array used to hold references for Car/Plane objects
      Rec[] recs = new Rec[Rec.NUM_FAMILY];      
      menu(recs);
      
   }
     /**
   Method Purpose: To hold the structure for a user to be directed to add a child, enroll a child, remove a child, print a
   child record, or quit the program.
   Parameter: Rec recs[]
   Return Type: void
   */
   public static void menu(Rec recs[]){
      
      int choice;
      //used to allow the user to exit the dowhile loop if they picked 5.
      final int EXIT = Rec.ACTIVITY_LENGTH;
      
      //used to only allow the user to choose what to do, can only exit by entering 5.
      
      do{
         choice = pickChoice();        
         switch(choice){
            case 1: 
               if(Rec.getNumRec() < recs.length){
                 try{
                     recs[Rec.getNumRec()] = addRec(recs);
                 }
                 catch(NumberFormatException e){
                     JOptionPane.showMessageDialog(null, "You did not enter a number. ");
                  }
                  catch(IllegalArgumentException e){
                     JOptionPane.showMessageDialog(null, "The recommendation could not be added. " + e.getMessage());
                  }
               }
               else{JOptionPane.showMessageDialog(null, "Error! Cannot enter more recommendations");}
            break;
            case 2:
               if(Rec.getNumRec() == 0){
                  JOptionPane.showMessageDialog(null, "Error! No recommendations have been added!");
               }
               else{
                  printAllRecs(recs);
               }                                               
            break;
            case 3:
               if(Rec.getNumRec() == 0){
                  JOptionPane.showMessageDialog(null, "Error! No recommendations have been added!");
               }
               else{
                  printBudgetRec(recs);
               }     
            break;
            case 4:
               if(Rec.getNumRec() == 0){
                  JOptionPane.showMessageDialog(null, "Error! No recommendations have been added!");
               }
               else{
                  printExtraRec(recs);
               }  
            break;
            case 5:
               
               printExitMessage(recs);
            break;   
         }   
      }while(choice!=EXIT);
   }
    /**
   Method Purpose: To add a recommendation object to the recs array.
   Parameter: Rec recs[]
   Return Type: Rec object
   */
   public static Rec addRec(Rec recs[]){
      String circle="";
      Plane test1=null;
      Car test2=null;
      do{
         
         try{
            circle = JOptionPane.showInputDialog("Enter 'plane' or 'car' to create a recommendation of that type");
         }
         catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "You entered a number!");
            
         }
         if((!circle.equalsIgnoreCase("plane"))&&(!circle.equalsIgnoreCase("car"))){
            JOptionPane.showMessageDialog(null, "You did not enter 'car' or 'plane'!");
         }
      }while((!circle.equalsIgnoreCase("plane"))&&(!circle.equalsIgnoreCase("car")));
      
      String phone=JOptionPane.showInputDialog("Enter the phone number associated with the person making the recommendation");
      if(circle.equals("plane")){
         int i = 0;
         boolean vali = false;
         test1 = new Plane(phone);
         if(Rec.getNumRec()!=0){
            while(!vali || i<=Rec.getNumRec()){
               if(recs[i].equals(test1)){
                  JOptionPane.showMessageDialog(null, "Error! You cannot use the same phone number for another recommendation");
                  vali =true;
               }
               i++;
            }
         }
         if(!vali){
            
            test1.setName(JOptionPane.showInputDialog("Enter the name of the person's recommendation"));
            test1.setDest(JOptionPane.showInputDialog("Enter the destination of this recommendation"));
            i = 0;
            vali = true;
            String option="";
            while(option.equals("yes")&&i<Rec.ACTIVITY_LENGTH){
               test1.setActivities(JOptionPane.showInputDialog("Enter the name of the activity: "), i);
               test1.setCost(Double.parseDouble(JOptionPane.showInputDialog("Enter the cost of the activity")), i);
               do{
                 option = JOptionPane.showInputDialog("Enter 'yes' or 'no' to enter another activity"); 
                  if(!option.equals("yes")&&!option.equals("no")){
                     JOptionPane.showMessageDialog(null,"Error! Enter 'yes' or 'no'");
                  }
               }while(!option.equals("yes")&&!option.equals("no"));
               
               i++;
            }
            test1.setTicketCost(Double.parseDouble(JOptionPane.showInputDialog("Enter the ticket cost for one person")));
            Rec.setNumRec(true);
            Plane.setPlaneCountObjects(true);
            test1.setWhatClass(circle);
         }
      }
      else{
         int i = 0;
         boolean vali = false;
         test2 = new Car(phone);
         if(Rec.getNumRec()!=0){
            while(!vali || i<=Rec.getNumRec()){
               if(recs[i].equals(test2)){
                  JOptionPane.showMessageDialog(null, "Error! You cannot use the same phone number for another recommendation");
                  vali =true;
               }
               i++;
            }
         }
         if(!vali){
            
            test2.setName(JOptionPane.showInputDialog("Enter the name of the person's recommendation"));
            test2.setDest(JOptionPane.showInputDialog("Enter the destination of this recommendation"));
            i = 0;
            boolean vali1 = true;
            String option="yes";
            JOptionPane.showMessageDialog(null, Rec.ACTIVITY_LENGTH);
            while(option.equals("yes")&&i<Rec.ACTIVITY_LENGTH){
               test1.setActivities(JOptionPane.showInputDialog("Enter the name of the activity: "), i);
               test1.setCost(Double.parseDouble(JOptionPane.showInputDialog("Enter the cost of the activity")), i);
               do{
                 option = JOptionPane.showInputDialog("Enter 'yes' or 'no' to enter another activity"); 
                  if(!option.equals("yes")&&!option.equals("no")){
                     JOptionPane.showMessageDialog(null, "Error! Enter 'yes' or 'no'");
                  }
                  
               }while(!option.equals("yes")&&!option.equals("no"));
               i++;
               
            }
            vali=true;
            i = 0;
            option="yes";
            while(option.equals("yes") && i<=Rec.NUM_FAMILY){
               test2.setCars(JOptionPane.showInputDialog("Enter the type of car that a person will be driving"), i);
               do{
                  option = JOptionPane.showInputDialog("Enter 'yes' or 'no' to enter another car");
                  if(!option.equals("yes")&&!option.equals("no")){
                     JOptionPane.showMessageDialog(null, "Error! Enter 'yes' or 'no'");
                  }
               }while(!option.equals("yes")&&!option.equals("no"));
               i++;
              
            }
            test2.setMiles(Double.parseDouble(JOptionPane.showInputDialog("Enter the amount of miles to drive to the location: ")));
            Rec.setNumRec(true);
            Car.setCountCarObjects(true);
            test2.setWhatClass(circle);
         }
      }
      if(circle.equals("plane")){
         return test1;
      }
      else{
         return test2;
      }
      
   }
    /**
   Method Purpose: To print all the recommendations entered.
   Parameter: Rec recs[]
   Return Type: void
   */
   public static void printAllRecs(Rec recs[]){
      
      String printDat="";
      for(int i=0;i<Rec.getNumRec();i++){
         printDat += recs[i].toString();
      }
      JOptionPane.showMessageDialog(null, printDat);
   }
    /**
   Method Purpose: To print the budget recommendation (The plane or car object with the lowest cost)
   Parameter: Rec recs[]
   Return Type: void
   */
   public static void printBudgetRec(Rec recs[]){
      String printJah="Budget Recommendation:\n";
      Rec printMin = recs[0];
      if(Rec.getNumRec() > 1){
         for(int i=0;i<Rec.getNumRec();i++){
            if(recs[i].getTotalCost()<printMin.getTotalCost()){
               printMin = recs[i];
            }
         }                 
      }
      printJah+=printMin.toString();
      JOptionPane.showMessageDialog(null, printJah);
   }
     /**
   Method Purpose: To print the extravagent recommendation (The plane or car object with the highest cost)
   Parameter: Rec recs[]
   Return Type: void
   */
   public static void printExtraRec(Rec recs[]){
      String printJeh="Budget Recommendation:\n";
      Rec printMin = recs[0];
      if(Rec.getNumRec() > 1){
         for(int i=0;i<Rec.getNumRec();i++){
            if(recs[i].getTotalCost()>printMin.getTotalCost()){
               printMin = recs[i];
            }
         }                 
      }
      printJeh+=printMin.toString();
      JOptionPane.showMessageDialog(null, printJeh);
   }
      /**
   Method Purpose: To print the exit message with the number of plane and car objects and if there was a BMW car listed in a car object.
   Parameter: Rec recs[]
   Return Type: void
   */
   public static void printExitMessage(Rec recs[]){
      int i;
      int g;
      boolean touchStone;
      if(Rec.getNumRec()==0){
         JOptionPane.showMessageDialog(null, "Error! No recommendations have been made");
      }
      else{
         String printJih ="The number of car recommendations: "+Car.getCountCarObjects()+"\n";
         printJih+="The number of plane recommendations: "+Plane.getPlaneCountObjects()+"\n";
         i=0; 
         JOptionPane.showMessageDialog(null, printJih);       
         touchStone = false;
         //while(i<Rec.getNumRec() || !touchStone){
            //JOptionPane.showMessageDialog(null, i + recs[i].getWhatClass());
            //String sunlight = recs[i].getWhatClass();
            //if(recs[0].getWhatClass().equals("car")){
               //g = 0;
               //while((!touchStone)||(g<recs[i].getNumCarsInArray())){
                  //if(recs[i].getCars(g).equalsIgnoreCase("BMW")){
                     //touchStone = true;
                  //}
                  //g++;
              // }
               
           // }
            //i++;
         //}
         if(touchStone){
            printJih+="BMW is listed as one of the cars travelling in a car recommendation";
         }
         else{
            printJih+="BMW is NOT listed as one of the cars travelling in a car recommendation";
         }
      }
      
      
   }
   /**
   Method Purpose: To list a menu and allow the user to pick a choice from the menu.
   Parameter: none
   Return Type: int.
   */
   public static int pickChoice(){
      //used to validate user input/exit loop
       int CHECKER = Rec.CHECK;
      //used to validate user input/exit loop
       int DOUBLE_CHECKER=Rec.ACTIVITY_LENGTH;
      //used to exit the loop
      
      int choice;
      do{
         try{
            
            choice = Integer.parseInt(JOptionPane.showInputDialog(
            "Please Enter a number for the following actions:\n" +
            "1. Add Recommendation\n"+
            "2. Print All Recommendations\n"+
            "3. Print Budget Recommendation (Recommendation with the lowest cost)\n"+
            "4. Print Extravagent Recommendation (Recommendation with the highest cost)\n"+
            "5. Quit"));
         }
         catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "You didn't enter a number. Please try again.");
            choice = -1;
         }
         if(choice<CHECKER || choice>DOUBLE_CHECKER){
            JOptionPane.showMessageDialog(null, "Error! Please enter a number between 1 and 5 inclusive.");
            choice = -1;
         }   
      }while(choice<CHECKER || choice>DOUBLE_CHECKER);
      return choice;
  
   
   }
}
