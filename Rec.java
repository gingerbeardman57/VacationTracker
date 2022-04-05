/**
Name: Joseph Roesch
Date: 4/21/2019
Course/Section: IT206.003
Assignment 8
Description:


*/
public abstract class Rec{
   private String phone;
   private String name;
   private String dest;
   private String[] activities;
   private double[] cost;
   private static int numRec = 0;
   private double totalCost;
   private String whatClass;
   private int numCost = 0;
   private int numActivities = 0;
   public static final int NUM_FAMILY=13;
   public static final int PHONE_LENGTH=9;
   public static final double COST_MIN=0;
   public static final double COST_MAX=25;
   public static final int ACTIVITY_LENGTH = 5;
   public static final int STRING_LENGTH = 30;
   public static final int CHECK = 1;
   
   public Rec(String phone){
      if(phone == null || phone.equals("")){
         throw new IllegalArgumentException("Error! Phone cannot be blank");
      }
      if (phone.length() != PHONE_LENGTH){
         throw new IllegalArgumentException("Error! Phone must be 9 digits!");
      }
      
      int i = 0;
      char check;
      while (i<phone.length()){
         check = phone.charAt(i);
         if(!Character.isDigit(check)){
            throw new IllegalArgumentException("Error! Phone must be digits only!");
            
         }
         i++;
      }
      this.phone = phone;
      this.activities = new String[ACTIVITY_LENGTH];
      this.cost = new double[ACTIVITY_LENGTH];
      
   }
   public String getWhatClass(){
      return this.whatClass;
   }
   public void setWhatClass(String whatClass){
      this.whatClass = whatClass;
   }
   public String getPhone(){return this.phone;}
   public String getName(){return this.name;}
   public String getDest(){return this.dest;}
   public String getActivities(int num){ 
      if (num<COST_MIN || num>=this.getNumActivities()){
         throw new IllegalArgumentException("Error! Activity does not exist in that specified index");
      }
      return this.activities[num];
   }
   public static void setNumRec(boolean checker){
      if(checker){
         numRec++;
         }
      else{
         numRec--;
      }
   }
   public static int getNumRec(){
      return numRec;
   }
   public double getCost(int num){
      if(num<COST_MIN||num>=this.getNumCost()){
         throw new IllegalArgumentException("Error! Cost does not exist in that specified index");
      }
      return this.cost[num];
      
   }
   public int getNumActivities(){ return this.numActivities;
   }
   public int getNumCost(){ return this.numCost;
   }
   public double getTotalCost(){ return this.totalCost;}
   public void setPhone(String phone){
      if(phone == null || phone.equals("")){
         throw new IllegalArgumentException("Error! Phone cannot be blank");
      }
      if (phone.length() != PHONE_LENGTH){
         throw new IllegalArgumentException("Error! Phone must be 9 digits!");
      }
      
      int i = 0;
      char check;
      while (i<phone.length()){
         check = phone.charAt(i);
         if(Character.isDigit(check)){
            throw new IllegalArgumentException("Error! Phone must be digits only!");
            
         }
         i++;
      }
      this.phone = phone;
   }
   public void setName(String name){
      if(name == null || name.equals("")){
         throw new IllegalArgumentException("Error! Name cannot be blank");
      }
      if (name.length() > STRING_LENGTH){
         throw new IllegalArgumentException("Error! Name cannot be more than 30 characters");
      }
      this.name = name;
   }
   public void setDest(String dest){
      if(dest == null || dest.equals("")){
         throw new IllegalArgumentException("Error! Destination cannot be blank");
      }
      if (name.length() > STRING_LENGTH){
         throw new IllegalArgumentException("Error! Destination cannot be more than 30 characters");
      }
      this.dest = dest;
   }
   public void setActivities(String activities, int num){
      if(num<COST_MIN||num>=Rec.ACTIVITY_LENGTH){
         throw new IllegalArgumentException("Error! Activity cannot be put in that specified index");
      }
      this.activities[num] = activities;
      numActivities++;
   }
   public void setCost(double cost, int num){
      if(num<COST_MIN||num>=Rec.ACTIVITY_LENGTH){
         throw new IllegalArgumentException("Error! Cost cannot be put in that specified index");
      }
      if (cost<=COST_MIN||cost>COST_MAX){
         throw new IllegalArgumentException("Error! Cost cannot be great than 25 or less than/equal to 0");
      }
      this.cost[num] = cost;
      numCost++;
   }
   public void setTotalCost(double totalCost){ 
      if (totalCost <= COST_MIN){
         throw new IllegalArgumentException("Error, total cost must be greater than 0");
      }
      this.totalCost = totalCost;
   }
   public abstract void calculateTotalCost();
   public boolean equals(Object other){
      if(other == null) { return false;}
      
      Car other1 = (Car)other;
      return this.getPhone().equals(other1.getPhone());
   }
   public String toString(){
      String rawr="";
      rawr += "Name: " + this.getName() + "\n";
      rawr += "Phone: " + this.getPhone() + "\n";
      rawr += "Destination: " + this.getDest() + "\n";
      for(int i=0;i<getNumActivities();i++){
         rawr+="Activity "+i+": "+this.getActivities(i)+"\n";
      }
      for(int i=0;i<getNumCost();i++){
         rawr+="Cost "+i+": "+this.getCost(i)+"\n";
      }
      return rawr;
   }
}