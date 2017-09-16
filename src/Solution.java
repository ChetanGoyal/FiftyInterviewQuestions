import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Sorting the values according to the name but name field have duplicate values.
 * 
 */
public class Solution {
	public static void main(String args[]) throws Exception {
		/* Read input from STDIN. Print output to STDOUT */
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < number; i++) {
			arr.add(scan.next());
		}
		Map<Integer, String> unsortMap = new HashMap<Integer, String>();
		for (int i = 0; i < arr.size(); i++) {

			String[] str = arr.get(i).split(",");
			unsortMap.put(Integer.parseInt(str[0]), str[1]);
		}

		Map<Integer, String> sortedMap = sortByValue(unsortMap);
		printMap(sortedMap);
		scan.close();
	}

	private static Map<Integer, String> sortByValue(Map<Integer, String> unsortMap) {

		// 1. Convert Map to List of Map
		List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
			public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map
		// LinkedHashMap
		Map<Integer, String> sortedMap = new LinkedHashMap<Integer, String>();
		for (Map.Entry<Integer, String> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		/*
		 * //classic iterator example for (Iterator<Map.Entry<String, Integer>> it =
		 * list.iterator(); it.hasNext(); ) { Map.Entry<String, Integer> entry =
		 * it.next(); sortedMap.put(entry.getKey(), entry.getValue()); }
		 */

		return sortedMap;
	}

	public static <K, V> void printMap(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
}