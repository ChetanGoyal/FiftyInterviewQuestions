package com.topFifty.questions;

import java.util.Scanner;

public class FibonacciSeries {

	
	public static void main(String[] args){
		int number;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number: ");
		number = scan.nextInt();
		
		for(int i=0;i<=number;i++){
			System.out.println(fibonacciRecursive(i) + " ");
		}
		scan.close();
	}
	
	//Iterative version of printing the fibonacci series;
	
	public static int fibonacci(int num){
		if(num == 0){
			return 0;
		}
		if(num == 1){
			return 1;
		}
		
		int first = 0;
		int second = 1;
		int sum = 1;
		
		for(int i = 2;i<=num;i++){
			sum = first + second;
			first = second;
			second = sum;
		}
		return sum;
		
	}
	
	//Recursive version of the same;
	
	public static int fibonacciRecursive(int num){
		if(num == 0){
			return 0;
		}
		if(num==1){
			return 1;
		}
		return fibonacciRecursive(num-1)+fibonacciRecursive(num-2);
	}
}
