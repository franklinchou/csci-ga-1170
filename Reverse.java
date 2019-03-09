import java.util.Arrays;

public class Reverse {

    public static void main(String []args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i = i + 1;
            j = j - 1;
        }
        System.out.println(Arrays.toString(arr));
    }
    
}
