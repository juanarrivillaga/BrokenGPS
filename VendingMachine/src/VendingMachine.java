import java.util.Scanner;
public class VendingMachine 
{//class
	   public static void main(String[] args)
	   {//main method
	      int sentinal1;
	      int sentinal2;
	      int sentinal3;
	      
	      Scanner input = new Scanner(System.in);
	      String [] product = {"Coke", "Juice", "Chips", "Water","Candy"};
	      double [] price = {1.80, 2.09, 2.00, 2.25, 0.98};
	      String [] coin = {"Quarter","Dime","Nickle","Penny"};
	     
	      double [] moneyIn = new double[6]; // array holds number of each type of currency inserted
	                                         
	      double [] cart = new double[5]; // this array will hold the products selected

	      double credit; 
	      double cost;
	      
	      for (int loop = 1; loop<=3; loop++){//Testing program will include 3 different data combinations
	    	  
	      do // this loop simulates a user entering money
	      {//do...while
	         sentinal1 = 1;
	         System.out.println();
	         System.out.println("Insert Money:");
	         System.out.println("$5 Bill: <l>, $1 Bill: <w>, Quarter: <q>, Dime: <d>, Nickle: <n>, Penny: <p>, Finish [0]");
	         char insert = input.next().charAt(0); //user inserts money by entering lowercase letters
	         
	         //increment appropriate currency counter (to be stored in moneyIn array
	         switch(insert) // this selection statement
	         {//switch
	            case 'l':   //insert 5 dollar bill
	               ++moneyIn[0];
	               break;
	            case 'w':   //insert 1 dollar bill
	               ++moneyIn[1];
	               break;   
	            case 'q':   //insert quarter
	               ++moneyIn[2];
	               break;
	            case 'd':   //insert dime
	               ++moneyIn[3];
	               break;
	            case 'n':   //insert nickle
	               ++moneyIn[4];
	               break;
	            case 'p':   // insert penny
	               ++moneyIn[5];
	               break;
	            case '0':   //user initiated exit
	               sentinal1 = 0;
	               break;
	            default: //in case of invalid entry
	               System.out.println("Currency Input Not Recognized, please Try again or enter [0] to finish");
	         }
	         credit = 5*moneyIn[0]+1*moneyIn[1]+.25*moneyIn[2]+.10*moneyIn[3]+.05*moneyIn[4]+.01*moneyIn[5];
	         System.out.printf("Total Credit: $%.2f\n",credit);
	         
	      } while (sentinal1 != 0);
	      
	      do // this loop simulates user selecting products
	      {// do... while
	         sentinal2 = 1;
	         cost = price[0]*cart[0] + price[1]*cart[1] + price[2]*cart[2] + price[3]*cart[3] + price[4]*cart[4];
	         System.out.printf("%n%s"+product[0]+": $%.2f%s"+product[1]+": $%.2f%s"+product[2]+": $%.2f%s"+product[3]+": $%.2f%s"+product[4]+": $%.2f",
	                           "[1]",price[0]," [2]",price[1]," [3]",price[2]," [4]",price[3]," [5]",price[4]);
	         System.out.println();
	         System.out.println("Please make selection, or if you are finished, enter [0]");
	         
	         int selection = input.nextInt(); //user makes selection by entering a number from 1 to 5 or 0 to finish
	         
	         // increment appropriate product counter (to be stored in cart array)
	         switch (selection)
	         {//switch
	         
	            case 1:  
	               ++cart[0];
	               cost = price[0]*cart[0] + price[1]*cart[1] + price[2]*cart[2] + price[3]*cart[3] + price[4]*cart[4];
	               if (credit-cost < 0) // check for sufficient funds
	                  {
	                     System.out.println("****INSUFFICIENT FUNDS****");
	                     --cart[0];
	                  }
	               break;
	               
	            case 2:
	               ++cart[1];
	               cost = price[0]*cart[0] + price[1]*cart[1] + price[2]*cart[2] + price[3]*cart[3] + price[4]*cart[4];
	               if (credit-cost < 0)// check for sufficient funds
	                  {
	                     System.out.println("****INSUFFICIENT FUNDS****");
	                     --cart[1];
	                  }
	               break;
	                  
	            case 3:
	               ++cart[2];
	               cost = price[0]*cart[0] + price[1]*cart[1] + price[2]*cart[2] + price[3]*cart[3] + price[4]*cart[4];
	               if (credit-cost < 0)//check for sufficient funds
	                  {
	                     System.out.println("****INSUFFICIENT FUNDS****");
	                     --cart[2];
	                  }
	               break;
	               
	            case 4:
	               ++cart[3];
	               cost = price[0]*cart[0] + price[1]*cart[1] + price[2]*cart[2] + price[3]*cart[3] + price[4]*cart[4];
	               if (credit-cost < 0) // check for sufficient funds
	                  {
	                     System.out.println("****INSUFFICIENT FUNDS****");
	                     --cart[3];
	                  }
	               break;
	               
	            case 5:
	               ++cart[4];
	               cost = price[0]*cart[0] + price[1]*cart[1] + price[2]*cart[2] + price[3]*cart[3] + price[4]*cart[4];
	               if (credit-cost < 0) // check for sufficient funds
	                  {
	                     System.out.println("****INSUFFICIENT FUNDS****");
	                     --cart[4];
	                  }
	               break;
	            case 0: //user controled exit
	               sentinal2 = 0;
	               break;
	            default: // in case of invalid entries
	               System.out.println("Invalid selection, please try again or enter [0] to finish selection");
	            
	         }
	       
	      } while (sentinal2 != 0);
	      
	      for (int counter = 0; counter < cart.length; counter++) // displays the number and types of items selected
	      {//for
	         if (cart[counter] == 0)
	            ;
	         else 
	         {
	            System.out.printf("%n%s%.0f %s","You have selected ", cart[counter], product[counter]); 
	         }
	      }
	      
	      double moneyToChange = credit - cost; // this variable stores how much we need to make change for
	      
	      do
	      {//do while
	         sentinal3=1;
	         System.out.printf("%nEnter <y> to accept or enter <x> to cancel transaction%n");
	      
	         char finalAnswer = input.next().charAt(0);

	         switch(finalAnswer)
	         {//switch
	            case 'y': // user has chosen to proceed with selection
	               System.out.println("Thank you");
	               for (int counter = 0; counter < cart.length; counter++) // for-looop displays the number and type of product dispensed
	               {//for
	                  if (cart[counter] == 0)
	                     ;
	                  else 
	                  {
	                     System.out.printf("%n%s%.0f %s","***Dispenses*** ", cart[counter], product[counter]);
	                      
	                  }
	               }
	               int[]change = makeChange(moneyToChange); // use makeChange method to return a "change vector"...  print number and type of coins dispensed
	               System.out.printf("%n***Dispenses*** %d Quarters, %d Dimes, %d Nickle, %d Penny ", change[0], change[1], change[2], change[3]);
	               sentinal3 = 0;
	               break;
	               
	            case 'x':// user chooses to cancel selection....
	               change = makeChange(credit); // so now we make change out of credit variable, returning the initial amount in coins
	               System.out.printf("%n***Dispenses*** %d Quarters, %d Dimes, %d Nickle, %d Penny ", change[0], change[1], change[2], change[3]);
	               System.out.printf("%nGoodbye");
	               sentinal3 = 0;
	               break;
	            default: // in case of invalid entries
	               System.out.printf("%nSorry, invalid entry. Please try again");
	             
	               
	         }
	        
	      } while(sentinal3!=0);
	      
	      for(int a = 0; a < moneyIn.length; a++)
	    	{moneyIn[a] = 0;     // reset array for purposes of testing
	    	  
	        }
          for (int b = 0; b < cart.length; b++)
          	{
        	  cart[b] = 0; // reset array for purposes of testing
          	}
	   }
	   }
	   // returns the number of coins needed to make change
	   public static int[] makeChange(double x) 
	   {//method makeChange
	      int qCount=0; //counts quarters
	      int dCount=0; //counts dimes
	      int nCount=0; //counts nickles
	      int pCount=0; //counts pennies
	      

	      
	      x=x*100;// I could not get this approach to work unless I multiplied the initial value by 100
	              // would often miss a penny. Multiplying by 100 ensures I am dealing with a whole number and does not
	              // seem to ever miss pennies.
	      
	      if (x-25 <0)//if less than 25 cents skip quarters
	      {
	      qCount=0;
	      
	      }
	      
	      else
	      {
	         for (int counter = 1; x-counter*25>=0; counter++)// count number of whole quarters that fit into x
	         {                                                
	            qCount=counter;
	         } 
	      
	      }
	      
	      x = x - qCount*25;//subtract quarter value from x
	      
	      if (x-10 <0)// if less than 10 cents skip dimes
	      {
	         dCount=0;
	      
	      }
	      
	      else
	      {
	         for (int counter = 1; x-counter*10>=0; counter++)//count number of whole dimes that fit into x
	         {
	            dCount=counter;
	         } 
	      }
	      
	      x = x - dCount*10;// xubtract dime value from x
	      
	      if (x-5 <0) //if less than 5 cents skip 
	      {
	         nCount=0;
	      
	      }
	      
	      else
	      {
	         for (int counter = 1; x-counter*5>=0; counter++)// count number of whole nickles that fit into x
	         {
	            nCount=counter;
	         } 
	      }
	      
	      x = x - nCount*5;//subtract value of nickles
	      
	      if (x-1 <0)
	      {
	         pCount=0;
	      
	      }
	      
	      else
	      {
	         for (int counter = 1; x-counter*1>=0.00; counter++)
	         {
	            pCount=counter;
	         } 
	      }
	      
	      int [] coins = {qCount,dCount,nCount,pCount};
	      
	      return coins; 

	      
	   }
	}



