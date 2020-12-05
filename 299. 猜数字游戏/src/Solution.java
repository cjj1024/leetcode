/**
 * @author CuiJunJie
 * @create 2020/12/5-15:44
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }

    public static String getHint(String secret, String guess) {
        int[] nums1 = new int[10];
        int[] nums2 = new int[10];

        int A = 0;
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++A;
            } else {
                ++nums1[secret.charAt(i) - '0'];
                ++nums2[guess.charAt(i) - '0'];
            }
        }

        int B = 0;
        for (int i = 0; i < 10; i++) {
            B += Math.min(nums1[i], nums2[i]);
        }

        return A + "A" + B + "B";
    }
}
