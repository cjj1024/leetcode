/**
 * @author CuiJunJie
 * @create 2020-10-10-15:02
 */
public class Solution {
    public static void main(String[] args) {

//        System.out.println(reverseBits(43261596)); //00000010100101000001111010011100 964176192
        System.out.println(reverseBits(-3)); //11111111111111111111111111111101 -1073741825
        System.out.println(Integer.toBinaryString(-3));
    }

    public static int reverseBits(int n) {
        int ret = 0;

        if (n % 2 == 1 || n % 2 == -1) {
            ret = ret | 1;
        }
        for (int i = 0; i < 31; i++) {
            ret = ret << 1;
            n = n >> 1;

            if (n % 2 == 1 || n % 2 == -1) {
                ret = ret | 1;
            }
        }

        return ret;
    }

    public static int reverseBits2(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0b11111111000000001111111100000000) >>> 8) | ((n & 0b00000000111111110000000011111111) << 8);
        n = ((n & 0b11110000111100001111000011110000) >>> 4) | ((n & 0b00001111000011110000111100001111) << 4);
        n = ((n & 0b11001100110011001100110011001100) >>> 2) | ((n & 0b00110011001100110011001100110011) << 2);
        n = ((n & 0b10101010101010101010101010101010) >>> 1) | ((n & 0b01010101010101010101010101010101) << 1);

        return n;
    }
}
