import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] Arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("исходный массив:");
        printArray(Arr);
        rotateArray(Arr);
        System.out.println("повернутый массив");
        printArray(Arr);
    }
    public static void rotateArray(int[][] Arr) {
        int len = Arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = Arr[i][j];
                Arr[i][j] = Arr[j][i];
                Arr[j][i] = temp;
            }
        }
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = Arr[i][j];
                Arr[i][j] = Arr[len - i - 1][j];
                Arr[len - i - 1][j] = temp;
            }
        }
    }
    public static void printArray(int[][] Arr) {
        for (int[] row : Arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}