import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int arr[] = {13, 6, 4, 9, 21, 5, 9, 1, 10, 14};
        for (int i = 1; i < arr.length; i++) { 
            int j = 0;
            while (j < i) {
                if (arr[j] > arr[i]) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
                j += 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    
}
