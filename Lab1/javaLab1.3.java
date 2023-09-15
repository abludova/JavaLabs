import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x=0, y=0;
        int numDirect =-1;
        System.out.println("Vvedite koordinati x, y");
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int Y = in.nextInt();

        System.out.println("Vvedite napravlenie север юг запад восток или стоп");
        String direct = in.next();
        while(!direct.equals("стоп")){
            System.out.println("Vvedite chislo shagov");
            int steps = in.nextInt();
            if (x==X && y==Y){
                break;
            }
            switch (direct) {
                case "север" -> Y += steps;
                case "юг" -> Y -= steps;
                case "восток" -> X += steps;
                case "запад" -> X -= steps;
            }
            if (Objects.equals(direct, "стоп")){
                break;
            }

            System.out.println("Vvedite ostalnie");
            direct = in.next();
            numDirect ++;

        }

        System.out.println(numDirect);

    }
}