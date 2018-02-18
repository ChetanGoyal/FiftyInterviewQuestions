package SortingAlgorithms;

/**
 * Bubble Sort
 *
 * Time Complexity of : O(n^2)
 * Space : inPlace.
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] arr = {7,1,6,9,3,4,2,0};

        bubbleSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
