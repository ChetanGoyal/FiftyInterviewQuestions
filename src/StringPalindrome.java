

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "A Santa lived as a devil at Nasa";
		str = str.replaceAll("\\s","");
		boolean result = isPalindrome(str.toLowerCase());
		System.out.println(result);
	}
	
	//Using Iterative version
	public static boolean isPalindrome(String s) {
		if (s.length() < 0) {
			return false;
		}
		String rev = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			rev = rev + s.charAt(i);
		}
		if (s.equals(rev)) {
			return true;
		} else
			return false;

	}
	
	//Using map
	public static boolean isPalindromeMap(String s){
		if(s.length()<0){
			return false;
		}
		int count = 0;
		Map<Character,Integer> map = new HashMap<>();
		
		for(int i = 0;i<s.length();i++){
			Character ch = s.charAt(i);
			if(map.containsKey(ch)){
				int val = map.get(ch);
				++val;
				map.put(ch, val);
			}
			else
				map.put(ch, 1);
		}
		
		for(Character c : map.keySet()){
			int val = map.get(c);
			if(val%2 == 1){
				count++;
			}
			else
				count--;
		}
		return count<=1;
	}
	
	//Using Stack
	
	public static boolean isPalindromeStack(String res){
		
		Stack<Character> st = new Stack<>();
		String rev = "";
		for(int i=0;i<res.length();i++){
			st.push(res.charAt(i));
		}
		while(!st.isEmpty()){
			rev = rev + st.pop();
		}
		if(res.equals(rev)){
			return true;
		}
		else
			return false;
	}
	
	//Using recursion
	
	public static boolean isPalindromeRec(String st){
		String rev = reverse(st);
		
		if(st.equals(rev)){
			return true;
		}
		else
			return false;
	}
	
	public static String reverse(String val){
		if(val == null || val.isEmpty()){
			return val;
		}
		return (val.charAt(val.length()-1))+reverse(val.substring(0,val.length()-1));
	}

}
