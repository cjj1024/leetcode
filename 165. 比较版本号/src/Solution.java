/**
 * @author CuiJunJie
 * @create 2020-09-25-15:32
 */
public class Solution {
    public static void main(String[] args) {
        String version1 = "1.0", version2 = "1.0.0";

        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null || version1.length() < 1 || version2.length() < 1) {
            return 0;
        }

        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        for (int i = 0; i < Math.min(ver1.length, ver2.length); i++) {
            int num1 = Integer.parseInt(ver1[i]);
            int num2 = Integer.parseInt(ver2[i]);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }

        if (ver1.length > ver2.length) {
            for (int i = ver2.length; i < ver1.length; i++) {
                int num = Integer.parseInt(ver1[i]);
                if (num > 0) {
                    return 1;
                }
            }
        } else if (ver1.length < ver2.length) {
            for (int i = ver1.length; i < ver2.length; i++) {
                int num = Integer.parseInt(ver2[i]);
                if (num > 0) {
                    return -1;
                }
            }
        }

        return 0;
    }
}
