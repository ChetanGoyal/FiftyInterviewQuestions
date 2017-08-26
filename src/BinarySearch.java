

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,5,2,3,7,6,9,12,15,18};
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int numResult = binarySearch(array,num);
		if(numResult == -1){
			System.out.println("Number not found");
		}
		else
			System.out.println("Number found at position " + numResult);
		scan.close();
	}
	
	public static int binarySearch(int[] arr, int num){
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length-1;
		while(high>=low){
			int mid = (low+high)/2;
			
			if(arr[mid] == num){
				return mid;
			}
			if(arr[mid]<num){
				low = mid + 1;
			}
			else if(arr[mid] > num){
				high = mid -1;
			}
		}
		return -1;
	}

}
