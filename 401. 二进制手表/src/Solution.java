import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author CuiJunJie
 * @create 2021/6/21-9:23
 */
public class Solution {
    public static void main(String[] args) {
        // ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
        System.out.println(readBinaryWatch(2));
    }

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m  = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    times.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }

        return times;
    }

//    private static List<Integer> hours;
//    private static List<Integer> minutes;
//    private static Date date = new Date();
//    private static SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
//    private static Map<Integer, List<Integer>> hoursMap = new HashMap<>();
//    private static Map<Integer, List<Integer>> minutesMap = new HashMap<>();
//    public static List<String> readBinaryWatch(int turnedOn) {
//        List<String> times = new ArrayList<>();
//
//        for (int i = 0; i <= turnedOn; i++) {
//            if (hoursMap.containsKey(i)) {
//                hours  = hoursMap.get(i);
//            } else {
//                hours = new ArrayList<>();
//                findHours(i, new char[4], 0, 0);
//                hoursMap.put(i, hours);
//            }
//
//            if (minutesMap.containsKey(turnedOn - i)) {
//                minutes = minutesMap.get(turnedOn - i);
//            } else {
//                minutes = new ArrayList<>();
//                findMinutes(turnedOn - i, new char[6], 0, 0);
//                minutesMap.put(turnedOn - i, minutes);
//            }
//
//            for (Integer hour : hours) {
//                for (Integer minute : minutes) {
//                    date.setHours(hour);
//                    date.setMinutes(minute);
//                    times.add(sdf.format(date));
//                }
//            }
//        }
//
//        return times;
//    }
//
//    private static void findMinutes(int turned, char[] nums, int k, int n) {
//        if (k == 6) {
//            if (turned == n) {
//                int h = Integer.parseUnsignedInt(String.valueOf(nums).trim(), 2);
//                if (h < 60) {
//                    minutes.add(h);
//                }
//            }
//            return;
//        }
//
//        nums[k] = '1';
//        findMinutes(turned, nums, k + 1, n + 1);
//        nums[k] = '0';
//
//        findMinutes(turned, nums, k + 1, n);
//    }
//
//    private static void findHours(int turned, char[] nums, int k, int n) {
//        if (k == 4) {
//            if (turned == n) {
//
//                int h = Integer.parseUnsignedInt(String.valueOf(nums).trim(), 2);
//                if (h < 12) {
//                    hours.add(h);
//                }
//            }
//
//            return;
//        }
//
//        nums[k] = '1';
//        findHours(turned, nums, k + 1, n + 1);
//        nums[k] = '0';
//
//        findHours(turned, nums, k + 1, n);
//    }

}
