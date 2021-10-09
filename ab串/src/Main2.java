import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n==0){
            System.out.println(0);
            return;
        }
        if (n==1){
            System.out.println(2);
            return;
        }
        if (n==2){
            System.out.println(4);
            return;
        }

        long m=998244353;

        long ab=1, aa=1, ba=1, bb=1;
        for (int i = 2; i < n; i++) {
            long taa = aa;
            long tab = ab;
            long tba = ba;
            long tbb = bb;
            aa = (taa+tba)%m;
            ab = taa%m;
            ba = tbb%m;
            bb = (tbb+tab)%m;

        }
        long ans = aa+bb+ab+ba;
        long l = ans % m;

        System.out.println(l);
    }
}