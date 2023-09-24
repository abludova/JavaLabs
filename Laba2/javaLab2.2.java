import java.util.Arrays;

public class MergeSortedArrays {
    public static int[] mergeArrays(int[] firstArr, int[] secArr) {
        int len1 = firstArr.length;
        int len2 = secArr.length;
        int[] merged = new int[len1 + len2];
        System.arraycopy(firstArr, 0, merged, 0, len1);
        System.arraycopy(secArr, 0, merged, len1, len2);
        Arrays.sort(merged);
        return merged;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, -1, 5, 22, 2, 45};
        int[] arr2 = {23, 4, 6, 8, -9};
        int[] merged = mergeArrays(arr1, arr2);

        System.out.println("Объединенный массив: " + Arrays.toString(merged));
    }
}