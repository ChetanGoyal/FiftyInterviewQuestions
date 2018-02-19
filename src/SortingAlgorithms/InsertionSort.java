package SortingAlgorithms;

public class InsertionSort {

    public static void main(String[] args){
        int[] arr = {6,3,4,2,1,5,7,8,0};

        insertSort(arr);

        for (int i:arr) {
            System.out.println(i);
        }
    }

    private static void insertSort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j=j-1;
            }
            arr[j+1] = key;
        }
    }
}
