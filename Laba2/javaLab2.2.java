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
        int[] firstArr = {1, -1, 5, 22, 2, 45};
        int[] secArr = {23, 4, 6, 8, -9};
        int[] merged = mergeArrays(firstArr, secArr);

        System.out.println("Объединенный массив: " + Arrays.toString(merged));
    }
}