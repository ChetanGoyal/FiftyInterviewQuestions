

import java.util.Scanner;

public class PrimeOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number ;
		
		Scanner scan = new Scanner(System.in);
		number = scan.nextInt();

		boolean result = isPrime(number);
		System.out.println(result);
		scan.close();
	}
	
	public static boolean isPrime(int num){
		
		for(int i=2;i<num;i++){
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}

}
