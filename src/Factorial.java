

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		Scanner scan = new Scanner(System.in);
		number=scan.nextInt();
		
		long fact = factorialRec(number);
		System.out.println("The factorial is:" + fact);
		scan.close();
	}
	
	//iterative version
	
	public static int factorial(int val){
		int result = 1;
		
		for(int i = 1 ; i<=val ;i++){
			result = result * i;
		}
		
		return result;
	}
	
	//Recursive version
	
	public static int factorialRec(int val){
		if(val == 1){
			return 1;
		}
		return val * factorial(val -1);
	}

}
