package com.topFifty.questions;

import java.util.Calendar;
import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year;
		Scanner scan = new Scanner(System.in);
		year = scan.nextInt();
		
		boolean result = isLeap(year);
		System.out.println(result);
		scan.close();
	}
	
	public static boolean isLeapOrNot(int value){
		
		if(value % 4 ==0){
			return true;
		}
		else
			return false;
	}
	
	//Using the Calender Instance
	
	public static boolean isLeap(int value){
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, value);
		int noOfDays = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
		
		if(noOfDays>365){
			return true;
		}
		else
			return false;
	}

}
