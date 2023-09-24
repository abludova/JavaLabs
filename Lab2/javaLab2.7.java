public class Main {
    public static void main(String[] args) {
        int[][] Arr = {
                {1, 4, 3},
                {10, 1, 6},
                {7, 8, 12}
        };
        for (int i = 0; i < Arr.length; i++) {
            int maxInRow = Arr[i][0];
            for (int j = 1; j < Arr[i].length; j++) {
                if (Arr[i][j] > maxInRow) {
                    maxInRow = Arr[i][j];
                }
            }
            System.out.println("Максимальный элемент в строке " + maxInRow);
        }
    }
}