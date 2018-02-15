import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StairCase {
    

/*
 * Complete the function below.
 */


    	
        static int summation(int[] numbers) {

        	int total = 0;
        	for (int i = 0; i < numbers.length; i++) {
        		total = total + numbers[i];
        	}
        	
        	return total;

        }


    
    public static void main(String args[]) {
    	
    	summation(6);
    	
    }
}

