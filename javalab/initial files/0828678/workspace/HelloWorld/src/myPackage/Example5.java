package myPackage;

public class Example5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dblNumber;   // One of the double input by the user.
		double  sum;           // The sum of the positive doubles.
		int count;         // The number of positive integers.
		double average;    // The average of the positive doubles.

		/* Initialize the summation and counting variables. */

		sum = 0;
		count = 0;

		/* Read and process the user's input. */

		System.out.println("Enter positive double ( 0 to exit):");
		dblNumber = Console.readDouble();

		while (dblNumber != 0) {
			sum = sum +  dblNumber; // Add inputNumber to running sum.
			/* the previous statement could be written as:
			 * sum += dblNumber; 
			 */
			count++;   // Count the input by adding 1 to count.
			System.out.println(" Enter positive double: ( 0 to exit):");
			dblNumber = Console.readDouble();
		}

		/* Display the result. */

		if (count == 0) {
			System.out.println("You didn't enter any data!");
		}
		else {
			average = ((double)sum) / count;
			System.out.println();
			System.out.println("You entered " + count +
						 " positive integers.");
			System.out.println("Their average is  " + average);
		}

	} // end main()
}


