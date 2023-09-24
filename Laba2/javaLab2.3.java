
public class Main {
    public static int sumArr(int[] Arr){

    int maxSum =0;
    int endSum =0;
    for (int i:Arr){
        endSum =endSum+i;
        endSum=Integer.max(endSum,0);
        maxSum=Integer.max(maxSum,endSum);
    }
    return maxSum;
    }
    public static void main(String[] args) {
        int[] Arr = {1, 5, 10, -9, 6, 33};
        System.out.println("Самая большая подсумма" + sumArr(Arr));
    }
}