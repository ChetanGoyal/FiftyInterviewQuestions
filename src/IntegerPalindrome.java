

import java.util.Scanner;

public class IntegerPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number;
		Scanner sc = new Scanner(System.in);
		number  = sc.nextInt();
		boolean result = isPermutation(number);
		System.out.println(result);
		sc.close();
	}
	
	public static boolean isPermutation(int num){
		int permutation = num;
		int reverse = 0;
		
		while(permutation!=0){
			int remainder = permutation % 10;
			System.out.println(remainder);
			reverse = reverse * 10 + remainder;
			permutation = permutation / 10;
			System.out.println("Perm" + permutation);
		}
		if(num == reverse){
			return true;
		}
		else
			return false;
	}

}
