
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        System.out.println("Vvedite N=");
        Scanner in = new Scanner(System.in);

        for(int N = in.nextInt(); N > 1; ++counter) {
            if (N % 2 == 0) {
                N /= 2;
            } else {
                N = 3 * N + 1;
            }
        }

        System.out.println(counter);
    }
}
