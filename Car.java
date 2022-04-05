
public class Car extends Rec{
   private double miles;
   private String cars[];
   private int numCarsInArray = 0;
   private static int countCarObjects = 0;
   public static final int MAX_MILES = 425;
   public static final double COST_PER_CAR = 0.575;
   public Car(String phone){
      super(phone);
      this.cars = new String[Rec.NUM_FAMILY];
      
   }
 
   public static int getCountCarObjects(){ return countCarObjects;}
   public int getNumCarsInArray(){ return this.numCarsInArray;}
   public String getCars(int num){
      
      if(num<Rec.COST_MIN||num>=(this.getNumCarsInArray()+1)){
         throw new IllegalArgumentException("Error! Cost does not exist in that specified index");
      }
      String grr = this.cars[num];
      return grr;
      
   }
   public double getMiles(){ return this.miles;}
   public void setMiles(double miles){
      if(miles<=Rec.COST_MIN||miles>MAX_MILES){
         throw new IllegalArgumentException("Error! miles must be greater than "+Rec.COST_MIN+" or less than/equal to "+MAX_MILES);
      }
      this.miles = miles;
   }
   public void setCars(String car, int num){
      
      if(num<Rec.COST_MIN||num>=(this.getNumCarsInArray()+1)){
            throw new IllegalArgumentException("Error! Cost does not exist in that specified index");
         }
      this.cars[num] = car; 
      numCarsInArray++;
   }
   public static void setCountCarObjects(boolean checker){ 
      if(checker){
         countCarObjects++;
      }
      else{
         countCarObjects--;
      }
      
   }
   public void calculateTotalCost(){
      super.setTotalCost(miles * COST_PER_CAR * this.getNumCarsInArray());
   }
   
   public String toString(){
      String meow = super.toString();
      meow += "Car Vacation:\nMiles: " +this.getMiles() +"\n";
      meow += "List of Cars:\n";
      for(int i = 0;i<getNumCarsInArray();i++){
         meow +="Car Number " +i+": "+this.getCars(i)+"\n";
      }
      meow +="Total Cost: "+super.getTotalCost()+"\n";
      return meow;
   }
}
