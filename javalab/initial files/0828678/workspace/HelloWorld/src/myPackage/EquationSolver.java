package myPackage;

import myPackage.Console;
public class EquationSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//define coefficient variables
		String answer="y";//comment
		double a,b,c,d;
		do{
		System.out.print("Input a:");
		a=Console.readDouble();
		
		System.out.print("Input b:");
		b=Console.readDouble();
	
		System.out.print("Input c:");
		c=Console.readDouble();
		
		if (a==0){
			System.out.println(" a=0, this is not quardatric equation");
			System.out.println("root="+ (-c/b));
			System.out.println("Countnue?(Y/N)");
			answer=Console.readString();
			continue;
		}
		
		  d= b*b-4*a*c;
		if (d<0){
			System.out.println("d="+d+", No real roots");
		}else{
			double root1=(-b+Math.sqrt(d))/(2*a);
			double root2=(-b-Math.sqrt(d))/(2*a);
			System.out.println("root 1="+root1);
			System.out.println("root 2="+root2);
		}
	System.out.println("Continue ? (Y/N)");
	answer=Console.readString();
	}while (answer.startsWith("y") ||answer.startsWith("Y"));
}
}