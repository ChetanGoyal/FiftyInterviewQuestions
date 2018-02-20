package SortingAlgorithms;

/**
 * Merge Sort works on Divide and Conquer technique
 * Time Complexity is O(nlgn)
 */

public class MergeSort {

    public static void main(String[] args){
        int[] arr = {7,4,9,1,10,3,2,5,89,34,12,10,0,99,54,32};

        //sort the array by dividing them in two sub arrays.

        sortArray(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void sortArray(int[] arr,int l,int r){
        if(l<r){

            int m = (l+r)/2;

            //sort the two sub arrays.
            sortArray(arr,l,m);
            sortArray(arr,m+1,r);

            mergeArray(arr,l,m,r);
        }
    }

    public static void mergeArray(int[] arr,int l,int m, int r){
        //Find the length of two arrays.

        int n1=m-l+1;
        int n2 = r-m;

        //Make two temp arrays of size n1 and n2

        int[] L = new int[n1];
        int[] R = new int[n2];

        //Copy the element in to the temp array.
        for(int i=0;i<n1;i++){
            L[i] = arr[l+i];
        }

        for(int j=0;j<n2;j++){
            R[j] = arr[m+1+j];
        }

        int i=0,j=0;
        int k = l;

        //Merge the two sorted arrays.

        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //Copy the remaining elements in to the array.

        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
