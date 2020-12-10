import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2020/12/10-10:10
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,5,10,20}));
        System.out.println(lemonadeChange(new int[]{5,5,10}));
        System.out.println(lemonadeChange(new int[]{10,10}));
        System.out.println(lemonadeChange(new int[]{5,5,10,10,20}));
        System.out.println(lemonadeChange(new int[]{5,5,5,10,5,5,10,20,20,20}));
        System.out.println(lemonadeChange(new int[]{5,5,5,5,20,20,5,5,5,5}));
    }

    public static boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length < 1) {
            return true;
        }

//        Arrays.sort(bills);

        int change5 = 0;
        int change10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                change5 += 5;
            } else if (bill == 10) {
                if (change5 <= 0) {
                    return false;
                }
                change5 -= 5;
                change10 += 10;
            } else {
                if (change5 <= 0) {
                    return false;
                }
                bill -= 10;
                change5 -= 5;
                if (change10 >= bill) {
                    change10 -= bill;
                } else {
                    change10 = 0;
                    bill -= change10;
                    if (bill > change5) {
                        return false;
                    } else {
                        change5 -= bill;
                    }
                }
            }
        }

        return true;
    }
}
