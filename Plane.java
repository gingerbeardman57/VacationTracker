
public class Plane extends Rec{
   public static final double MIN_COST = 79;
   public static final double MAX_COST = 419;
   private static int planeCountObjects = 0;
   private double ticketCost;
   public Plane(String phone){
      super(phone);
      
   }
   
   public void setTicketCost(double ticketCost){
      if(ticketCost < 79 || ticketCost > 419){
         throw new IllegalArgumentException("Error! ticket cost must be between "+Plane.MIN_COST+"and "+Plane.MAX_COST+" inclusive.");
      }
      this.ticketCost = ticketCost;
   }
   public static void setPlaneCountObjects(boolean checker){
      if(checker){
         planeCountObjects++;
      }
      else{
         planeCountObjects--;
      }
   }
   public double getTicketCost(){
      return this.ticketCost;
   }
   public static int getPlaneCountObjects(){
      return planeCountObjects;
   }
   public void calculateTotalCost(){
      
      super.setTotalCost(this.getTicketCost() * Rec.NUM_FAMILY);
   }
  
   public String toString(){
      String oink = super.toString();
      oink+="Plane Recommendation:\nTicket Cost: "+this.getTicketCost()+"\n";
      oink+="Total Cost: "+super.getTotalCost()+"\n";
      return oink;
   }
}
