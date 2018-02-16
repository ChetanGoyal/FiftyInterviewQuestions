/*
It will find the max sum of a contiguous sub array in an array containing both positive and negative numbers.
Along with start and end index of the sub array.
 */

public class LongestSumSubArray {

    public static void main(String[] args){
        int arr[] = {-2,-3,4,-1,5,-3,8};

        int maxSum = sumMaxSubArray(arr);
        System.out.println("The max sum of contiguous array is:" + maxSum);
    }

    public static int sumMaxSubArray(int[] arr){
        int max_num = Integer.MIN_VALUE;
        int max_subArray_sum = 0;
        int n = arr.length;
        int start = 0;
        int end=0;
        int s=0;

        for(int i=0;i<n;i++){
            max_subArray_sum +=arr[i];

            if(max_subArray_sum>max_num){
                max_num = max_subArray_sum;
                start = s;
                end =i;
            }
            if(max_subArray_sum<0){
                max_subArray_sum = 0;
                s+=i;
            }
        }

        System.out.println("The starting index is:" + start);
        System.out.println("The end index is:"+ end);
        return max_subArray_sum;
    }
}
