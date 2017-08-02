package com.topFifty.questions;

/*
 * This checks for two strings to be Anagram. 
 * It is implemented with three methods:
 * 1: Sorting
 * 2: Array
 * 3: Maps.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] words = {{"apple","paple"},{"hello","lefol"},{"kitty","titky"}};
		for(String[] str : words){
			String word1 = str[0];
			String word2 = str[1];
			boolean result = anagramMaps(word1,word2);
			System.out.println(result);
		}
	}
	//using Sorting techniques
	
	public static boolean anagram(String s1,String s2){
		return sort(s1).equals(sort(s2));
	}
	
	public static String sort(String s){
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
	//using Array
	
	public static boolean anagramArray(String s1, String s2){
		
		int[] arr = new int[128];
		for(int i=0;i<s1.length();i++){
			arr[s1.charAt(i)]++;
		}
		for(int i=0;i<s2.length();i++){
			arr[s2.charAt(i)]--;
			
			if(arr[s2.charAt(i)]<0){
				return false;
			}
		}
		return true;
	}

	//Using Maps.
	
	public static boolean anagramMaps(String s1, String s2){
		Map<Character, Integer> map1 = new HashMap<>();
		for(int i=0;i<s1.length();i++){
			Character ch = s1.charAt(i);
			if(map1.containsKey(ch)){
				int val = map1.get(ch);
				++val;
				map1.put(ch,val);
			}
			else
				map1.put(ch, 1);
		}
		Map<Character,Integer> map2 = new HashMap<>();
		for(int i=0;i<s2.length();i++){
			Character ch = s2.charAt(i);
			if(map2.containsKey(ch)){
				int val = map2.get(ch);
				++val;
				map2.put(ch, val);
			}
			else
				map2.put(ch, 1);
		}
		if(map1.equals(map2)){
			return true;
		}
		else
			return false;
	}
}
