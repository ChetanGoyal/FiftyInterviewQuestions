package com.topFifty.questions;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number;
		Scanner scan = new Scanner(System.in);
		number = scan.nextInt();

		boolean result = isArmstrongNumber(number);
		System.out.println(result);
		scan.close();
	}

	public static boolean isArmstrongNumber(int value) {
		int result = 0;
		int digit = value;
		while (digit != 0) {
			int remainder = digit % 10;
			result = result + remainder * remainder * remainder;
			digit = digit / 10;
		}
		if (value == result) {
			return true;
		} else
			return false;

	}

}
