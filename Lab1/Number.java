import java.util.Scanner;

public class Number {
    int Number;
    public Number(){
        System.out.println("Vvedite chislo");
        Scanner in = new Scanner(System.in);
        this.Number = in.nextInt();
        int num= this.Number;
        int edinOfNum = num%10;
        int desOfNum = (num%100)/10;
        int sotOfNum = num/100;
        if (num>0){
            if ((edinOfNum+desOfNum+sotOfNum)%2==0 && (edinOfNum*desOfNum*sotOfNum)%2==0){
                System.out.println("Dvajdi chetnoe");
            }
            else {
                System.out.println("Ne dvajdi chetnoe");
            }
        }
    }
}

