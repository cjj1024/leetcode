/**
 * @author CuiJunJie
 * @create 2021/1/1-11:28
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
//        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
//        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2));
//        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
//        System.out.println(canPlaceFlowers(new int[]{0}, 1));
        System.out.println(canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if ((i + 1 == flowerbed.length || flowerbed[i + 1] == 0) &&
                    (i - 1 == -1 || flowerbed[i - 1] == 0)){
                i += 2;
                n--;
            } else {
                i++;
            }
        }

        return n <= 0;
    }
}
