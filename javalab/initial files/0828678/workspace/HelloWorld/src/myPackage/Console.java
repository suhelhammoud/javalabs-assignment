package myPackage;

import java.io.*;

public class Console {

    public  static BufferedReader console = new BufferedReader( 
            new InputStreamReader( System.in ) );

    public static double readDouble(){
        double result=-1;
        try{
            result= Double .valueOf(console.readLine()).doubleValue();    
        }catch(IOException ioe){}
        return result;

    }

    public static String readString(){
        String result="";
        try{
            result=  console.readLine()  ;    
        }catch(IOException ioe){}
        return result;
    }
}
