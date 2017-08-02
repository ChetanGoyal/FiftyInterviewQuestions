package com.topFifty.questions;

/*
 * It will return the first non repeated character in a string.
 * LinkedHashMap is preferred since it maintains the insertion order.
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		char s = NonRepeatedChar(str);
		System.out.println("First non repeated character is: " + s);
		scan.close();
	}
	
	public static char NonRepeatedChar(String string){
		
		Map<Character, Integer> map = new LinkedHashMap<>(string.length());
		
		for(int i=0;i<string.length();i++){
			Character ch = string.charAt(i);
			map.put(ch, map.containsKey(ch) ? map.get(ch)+1 : 1);
		}
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			if(entry.getValue()==1){
				return entry.getKey();
			}
		}
		throw new RuntimeException("Didn't find a non repeated character.");
	}

}
