public class Main {
    public static void main(String[] args) {
        int[] Arr = {1, 2, 3, 4, 5, 6};
        int findNum = 7;
        sumNum(Arr, findNum);
    }

    public static void sumNum(int[] Arr, int findNum) {
        int len = Arr.length;
        boolean pairFound = false;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Arr[i] + Arr[j] == findNum) {
                    System.out.printf("Пара (%d,%d)%n", Arr[i], Arr[j]);
                    pairFound = true;
                }
            }
        }

        if (!pairFound) {
            System.out.println("Пары нет");
        }
    }
}