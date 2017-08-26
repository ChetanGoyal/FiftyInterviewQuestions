package com.topFifty.questions;

import java.util.Stack;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ReverseAString";

		String rev = reverseRecursion(str.toLowerCase());
		System.out.println(rev);
	}

	// Reversing a String by looping the string from last character.
	public static String reverseString(String s) {
		String rev = "";

		for (int i = s.length() - 1; i >= 0; i--) {
			rev = rev + s.charAt(i);
		}
		return rev;
	}

	// reversing a string using Stack.
	public static String reverseStringStack(String s) {
		String rev = "";

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			st.push(ch);
		}

		while (!st.isEmpty()) {
			rev = rev + st.pop();
		}
		return rev;
	}

	// Recursively reverse a string.
	public static String reverseRecursion(String s) {

		if (s == null || s.isEmpty()) {
			return s;
		}
		return s.charAt(s.length() - 1) + reverseRecursion(s.substring(0, s.length() - 1));
	}

}
