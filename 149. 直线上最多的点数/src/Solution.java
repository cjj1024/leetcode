import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-09-19-10:31
 */
public class Solution {
    public static void main(String[] args) {
//        int[][] points = {
//                {1, 1},
//                {3, 2},
//                {5, 3},
//                {4, 1},
//                {2, 3},
//                {1, 4}
//        };
//        int[][] points = {
//                {2, 3},
//                {3, 3},
//                {-5, 3}
//        };
//        int[][] points = {
//                {1, 1},
//                {1, 1},
//                {2, 2},
//                {2, 2}
//        };
//        int[][] points = {
//                {0, 0},
//                {0, 0}
//        };
//        [[0,0],[94911151,94911150],[94911152,94911151]]
        int[][] points = {
                {0, 0},
                {94911151,94911150},
                {94911152,94911151}
        };
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        if (points == null || points.length < 1) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }

        int maxNum = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int samePoint = 0;
            int num = 0;
            map.clear();
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    samePoint++;
                    continue;
                }

                int a = points[i][0] - points[j][0];
                int b = points[i][1] - points[j][1];
                int c = gcd(a, b);
                String key;
                if (a == 0 || b == 0) {
                    if (a == 0) {
                        key = "0/";
                    } else {
                        key = "/0";
                    }
                } else {
                    key = a / c + "/" + b / c;
                }
                map.put(key, map.getOrDefault(key, 0) + 1);
                num = Math.max(num, map.get(key));
            }
            maxNum = Math.max(maxNum, num + samePoint + 1);
        }

        return maxNum;
    }

    private static int gcd2(int dy, int dx) {
        if (dx == 0) return dy;
        else return gcd(dx, dy % dx);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }
}
