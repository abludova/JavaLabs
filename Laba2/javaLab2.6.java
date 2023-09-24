public class Main {
    public static void main(String[] args) {
        int[][] Arr = {{1, 2, 3}, {4, 5, 6}};
        int sum = sumOfElements(Arr);
        System.out.println("Сумма " + sum);
    }

    public static int sumOfElements(int[][] Arr) {
        int sum = 0;
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr[i].length; j++) {
                sum += Arr[i][j];
            }
        }
        return sum;
    }
}