package SortingAlgorithms;

/**
 * Selection Sort : Time Complexity : O(n^2)
 * Space Complexity : O(1)
 *
 * It is best when memory writes are costly.
 */

public class SelectionSort {

    public static void main(String[] args){
        int[] arr = {1,4,2,3,8,9,6,5,10,78,32};

        selSort(arr);
        for (int i: arr){
            System.out.println(arr[i]+"");
        }
    }

    private static void selSort(int[] arr){
        int n = arr.length;

        for(int i=0;i<n-1;i++){
            int min_index = i;

            /*
            This loop will find the minimum element in the whole array and place its index in min_index.
             */
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min_index]){
                    min_index = j;
                }
            }
            /*
            swapping will take place for the elements.
             */
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }
}
