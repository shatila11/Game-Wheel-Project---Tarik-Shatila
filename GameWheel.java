import java.util.ArrayList;

public class GameWheel
{
  private ArrayList<Slice> slices; // List of slices making up the wheel
  private int currentPos;   // Position of currently selected slice on wheel


  // Returns string representation of GameWheel with each numbered slice on a new line
  
  public String toString(){
    String wheel = "";
    for (int i = 0; i < slices.size(); i++) {
      wheel += i + " - " + slices.get(i).toString() + "\n";
    }
    return wheel;
  }


  public void scramble()
  {
    //Implementing scramble method 
    ArrayList<Slice> black = new ArrayList<Slice>();
    ArrayList<Slice> red = new ArrayList<Slice>();
    ArrayList<Slice> blue = new ArrayList<Slice>();
    
    for (int i = 0; i < slices.size(); i++) {
      if (i % 5 == 0) {
        black.add(slices.get(i));
      } else if (i % 2 == 0 && i >= 2) {
        blue.add(slices.get(i));
      } else {
        red.add(slices.get(i));
      }
    }
    slices.clear();
    
    for (int i = 0; i < 20; i++) {
      if (i % 5 == 0) {
        slices.add(black.remove((int)(Math.random() * black.size())));
      } else if (i % 2 == 0) {
        slices.add(blue.remove((int)(Math.random() * blue.size())));
      } else {
        slices.add(red.remove((int)(Math.random() * red.size())));
      }
    }
  }

  /* Helper Method */
  public static void insertSort(ArrayList<Slice> list) {
    for (int i = 1; i < list.size(); i++) {
      int temp = list.get(i).getPrizeAmount();
      int j;
      for (j = i; j > 0; j--) {
        if (temp >= list.get(j - 1).getPrizeAmount()) {
          break;
        }
        list.add(j - 1, list.remove(j));
      }
    }
  }

  //Sorts the positions of the slices that are in the wheel by prize amount, but without changing the pattern of the colors.
   
  public void sort(){
    //Implement the sort method here
    ArrayList<Slice> black = new ArrayList<Slice>();
    ArrayList<Slice> red = new ArrayList<Slice>();
    ArrayList<Slice> blue = new ArrayList<Slice>();
    
    for (int i = 0; i < slices.size(); i++) {
      if (i % 5 == 0) {
        black.add(slices.get(i));
      } else if (i % 2 == 0 && i >= 2) {
        blue.add(slices.get(i));
      } else {
        red.add(slices.get(i));
      }
    }
    slices.clear();
    insertSort(black);
    insertSort(red);
    insertSort(blue);
    
    for (int i = 0; i < 20; i++) {
      if (i % 5 == 0) {
        slices.add(black.remove(0));
      } else if (i % 2 == 0 && i >= 2) {
        slices.add(blue.remove(0));
      } else {
        slices.add(red.remove(0));
      }
    }
  }


  //makes wheel with 20 preset slices
  
  public GameWheel()
  {
    this(getStandardPrizes());
  }

  //makes wheel with 20 slices, using values from array parameter
  
  public GameWheel(int[] prizes)
  {
    currentPos = 0;
    slices = new ArrayList<Slice>();
    for (int i = 0; i < 20; i++) {
      int pa = 0;
      String col = "blue";
      if (i < prizes.length)
        pa = prizes[i];
      if (i % 5 == 0)
        col = "black";
      else if (i % 2 == 1)
        col = "red";
      slices.add(new Slice(col, pa));
    }
  }

  //Spins the wheel so that a different slice is selected and returns that slice
  public Slice spinWheel()
  {
    //spin power between 1 and 50 inclusive
    int power = (int)(Math.random() * 50 + 1);
    int newPos = (currentPos + power) % slices.size();
    currentPos = newPos;
    return slices.get(currentPos);
  }

  public Slice getSlice(int i){
    int sliceNum = i;
    if(i < 0 || i > 19)
      sliceNum = 0;
    return slices.get(sliceNum);
  }

  // Makes a standard list of prizes
  private static int[] getStandardPrizes()
  {
    int[] arr = new int[20];
    for (int i = 0; i < 20; i++)
    {
      if (i % 5 == 0)
        arr[i] = i * 1000;
      else if (i % 2 == 1)
        arr[i] = i * 100;
      else
        arr[i] = i * 200;
    }
    return arr;
  }
}
