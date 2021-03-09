/**
 * @author CuiJunJie
 * @create 2021/3/9-15:51
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(isValidSerialization("1,#"));
        System.out.println(isValidSerialization("9,#,#,1"));
    }

    public static boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");

        int slots = 1;
        for (String node : nodes) {
            slots--;
            if (slots < 0) {
                return false;
            }

            if (!"#".equals(node)) {
                slots += 2;
            }
        }

        return slots == 0;
    }
}
