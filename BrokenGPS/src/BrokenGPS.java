//Pseudocode:
/*
Initialize position array as (0,0)
For (i = 0; i <= 60; i=i+5)
   Generate random number 1-4
   If 1
      Add (5,0) to position i.e. go east
   If 2
      Add (0,5) to position i.e. go north
   If 3
      Add (-5,0) to position i.e. go west
   If 4
      Add (0,-5) to position i.e. go south

Distance = Sqrt(pow(p1,2) + pow(p2,2))
Display Distance
END

*/
//Program Author: Juan Arrivillaga
import java.security.SecureRandom; // program uses class SecureRandom

public class BrokenGPS
{
    
   public static void main(String[] args)
   {
      //random number object will produce random numbers that will code for direction
      SecureRandom randomDirection = new SecureRandom();
      
      double[]position = new double [2]; // this array will store the coordinates of the vehicle
      
      for(int timer = 0; timer < 60; timer=timer+ 5)
      {
         int dir = randomDirection.nextInt(4);
         if (dir == 0){ position[0] = position[0] + 5;} // turn east and travel 5 miles
         if (dir == 1){ position[1] = position[1] + 5;} // turn north and travel 5 miles
         if (dir == 2){ position[0] = position[0] - 5;} // turn west and travel 5 miles
         if (dir == 3){ position[1] = position[1] - 5;} // turn south and travel 5 miles
         System.out.printf("%n(%.0f,%.0f)",position[0],position[1]);
         
      }
      
      double distance = Math.sqrt(Math.pow(position[0],2) + Math.pow(position[1],2)); // distance forumla
      System.out.printf("%n%nThe total distance travelled from the initial point is %f miles.", distance);
      
      
      
   }
}
