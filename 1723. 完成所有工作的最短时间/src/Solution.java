import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author CuiJunJie
 * @create 2021/5/8-10:49
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(minimumTimeRequired(new int[]{3, 2, 3}, 3));     // 3
        System.out.println(minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));       // 11
        System.out.println(minimumTimeRequired(new int[]{4345079,7190302,6957449,5605110}, 1));     // 24097940
        System.out.println(minimumTimeRequired(
                new int[]{9899456,8291115,9477657,9288480,5146275,7697968,8573153,3582365,3758448,9881935,2420271,4542202},
                9));
    }

    public static int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        for (int i = 0, j = jobs.length - 1; i < j; i++, j--) {
            int t = jobs[i];
            jobs[i] = jobs[j];
            jobs[j] = t;
        }

        int left = jobs[0];
        int right = Arrays.stream(jobs).sum();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(jobs, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean check(int[] jobs, int k, int limitTime) {
        return backtrace(jobs, 0, new int[k], limitTime);
    }

    private static boolean backtrace(int[] jobs, int t, int[] times, int limitTime) {
        if (t >= jobs.length) {
            return true;
        }

        int cur = jobs[t];
        for (int j = 0; j < times.length; j++) {
            if (times[j] + cur <= limitTime) {
                times[j] += cur;
                if (backtrace(jobs, t + 1, times, limitTime)) {
                    return true;
                }
                times[j] -= cur;
            }

            if (times[j] == 0 || times[j] + cur == limitTime) {
                break;
            }
        }

        return false;
    }

//    public static int minimumTimeRequired(int[] jobs, int k) {
//        if (jobs.length <=k) {
//            return Arrays.stream(jobs).max().getAsInt();
//        }
//
//        maxTime = Integer.MAX_VALUE;
//        upBound = greedy(jobs, k);
//
//        backtrace(jobs, jobs.length - 1, new int[k]);
//
//        return maxTime;
//    }
//
//    private static int greedy(int[] jobs, int k) {
//        Arrays.sort(jobs);
//        int[] times = new int[k];
//        int j = 0;
//        int sign = 1;
//        for (int i = jobs.length - 1; i >= 0; i--) {
//            times[j] += jobs[i];
//            j += sign;
//            if (j == k || j == -1) {
//                sign = -sign;
//                j += sign;
//            }
//        }
//
//        return Arrays.stream(times).max().getAsInt();
//    }
//
//    private static int maxTime = 0;
//    private static int upBound = 0;
//    public static void backtrace(int[] jobs, int k, int[] works) {
//        if (k == -1) {
//            int m = Arrays.stream(works).max().getAsInt();
//            if (maxTime > m) {
//                maxTime = m;
//            }
//
//            return;
//        }
//
//        for (int i = 0; i < works.length; i++) {
//            if (works[i] + jobs[k] <= upBound) {
//                works[i] += jobs[k];
//                backtrace(jobs, k - 1, works);
//                works[i] -= jobs[k];
//            }
//        }
//    }
}
