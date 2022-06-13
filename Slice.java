public class Slice
{
  private String color;
  private int prizeAmount;


  public Slice(String c, int p) {
   color = c;
   prizeAmount = p;
  }


  public int getPrizeAmount() {
    return prizeAmount;
  }


  public String getColor() {
    return color;
  }


 
  public String toString() {
    return "Color: " + color + ", Prize Amount: $" + prizeAmount;
  }
}
