import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    int maxx = 0;
    int road = 1;

    Scanner in = new Scanner(System.in);
    System.out.println("Vvedite kol-vo dorog D=");
    int numDorog = in.nextInt();
    for (int i=0; i<numDorog;i++){
        int locMin = Integer.MAX_VALUE;
        System.out.println("Vvedite chislo tunelei T=");
        int numTunnel = in.nextInt();
        for (int j=0;j<numTunnel;j++){
            System.out.println("Vvedite visoty");
            int Height = in.nextInt();
            if (locMin>Height){
                locMin=Height;
            }
        }
        if (maxx<locMin){
            maxx=locMin;
            road = i+1;
        }
    }
    System.out.println(road+" "+ maxx);
    }
}