package com.topFifty.questions;

/*
 * This will reverse the contents of the array.
 * Implemented this with two methods: In place reversal and Using Stack.
 */
import java.util.Stack;

public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4,45,12,13,24,35,24,34};
		reverseArray(array);
		
		//In place reversal of the array
		
		for(int i=0;i<array.length/2;i++){
			int temp = array[i];
			array[i]=array[array.length-1-i];
			array[array.length-1-i] = temp;
		}
		
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	
	//Using Stack.
	public static void reverseArray(int[] arr){
		Stack<Integer> st = new Stack<>();
		int[] arrRev = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			st.push(arr[i]);
		}
		for(int i=0;i<arr.length && !st.isEmpty();i++){
			arrRev[i] = st.pop();
		}
		
		for(int i=0;i<arrRev.length;i++){
			System.out.println(arrRev[i]);
		}
	}

}