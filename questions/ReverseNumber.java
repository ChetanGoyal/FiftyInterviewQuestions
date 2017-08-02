package com.topFifty.questions;

/*
 * This will return the reverse of a number.
 */
import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();

		int reverseNum = reverseNum(num);
		System.out.println(reverseNum);
		scan.close();
	}
	//Can also be made to check if the reversed number is palindrome or not.
	/*
	 * compare digit with reverse and if they are equal, it is palindrome.
	 * After the while loop ends.
	 * if(digit == reverse){
	 * 	return true;
	 * }
	 */
	public static int reverseNum(int digit) {
		int number = digit;
		int reverse = 0;
		while (number != 0) {
			int remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number = number / 10;
		}
		return reverse;
	}
}
