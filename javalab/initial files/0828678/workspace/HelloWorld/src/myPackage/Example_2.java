package myPackage;

public class Example_2 {
	   public static void main(String[] args) {
		   
		      long startTime; // Starting time of program, in milliseconds.
		      long endTime;   // Time when computations are done, in milliseconds.
		      double time;    // Time difference, in seconds.
		      
		      startTime = System.currentTimeMillis();
		      
		      double width, height, hypotenuse;  // sides of a triangle
		      width = 42.0;
		      height = 17.0;
		      hypotenuse = Math.sqrt( width*width + height*height );
		      System.out.print("A triangle with sides 42 and 17 has hypotenuse ");
		      System.out.println(hypotenuse);
		      
		      System.out.println("\nMathematically, sin(x)*sin(x) + "
		                                       + "cos(x)*cos(x) - 1 should be 0.");
		      System.out.println("Let's check this for x = 1:");
		      System.out.print("      sin(1)*sin(1) + cos(1)*cos(1) - 1 is ");
		      System.out.println( Math.sin(1)*Math.sin(1) 
		                                        + Math.cos(1)*Math.cos(1) - 1 );
		      System.out.println("(There can be round-off errors when" 
		                                      + " computing with real numbers!)");
		      
		      System.out.print("\nHere is a random number:  ");
		      System.out.println( Math.random() );
		      
		      endTime = System.currentTimeMillis();
		      time = endTime - startTime;
		      
		      System.out.print("\nRun time in milliseconds was:  ");
		      System.out.println(time);
		   
		   } // end main()
		   
		} // end class 


