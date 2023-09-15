import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Vvedite N=");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Sum = 0;

        for(int i = 0; i < N; ++i) {
            if (i % 2 == 0) {
                Sum += in.nextInt();
            } else {
                Sum -= in.nextInt();
            }
        }

        System.out.println(Sum);
    }
}
