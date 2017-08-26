

import java.util.HashMap;
import java.util.Map;

public class RepeatedCharacters {

	public static void main(String[] args) {
		
		String str = "Programmingisvvvvfunnyyyppp";
		printRepeatedCharacter(str.toLowerCase());
	}
	
	public static void printRepeatedCharacter(String s){
		Map<Character,Integer> map = new HashMap<>();
		char[] charSet = s.toCharArray();
		for(Character ch : charSet){
			if(map.containsKey(ch)){
				int val = map.get(ch);
				++val;
				map.put(ch, val);
			}
			else
				map.put(ch, 1);
		}
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			if(entry.getValue()>1){
				System.out.println("Repeated Character: " + entry.getKey() + " " + entry.getValue());
			}
		}
	}

}
