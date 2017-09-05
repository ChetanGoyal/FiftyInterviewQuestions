
import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {

		int[] array = { 1, 2, 4, 2, 2, 3, 5, 3, 4, 4, 5 };
		int n = array.length;
		Arrays.sort(array);
		n = removeDuplicates(array, n);

		for (int i = 0; i < n; i++) {
			System.out.println(array[i] + " ");
		}
	}

	public static int removeDuplicates(int[] array, int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int j = 0;

		for (int i = 0; i < n - 1; i++) {
			if (array[i] != array[i + 1]) {
				array[j++] = array[i];
			}
		}
		array[j++] = array[n - 1];
		return j;
	}

}
