import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2021/4/23-9:32
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3, 4}));
        System.out.println(largestDivisibleSubset(new int[]{1}));
        System.out.println(largestDivisibleSubset(new int[]{5,9,18,54,108,540,90,180,360,720}));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> lists = new ArrayList<>();
        int i = 0;
        if (nums[i] == 1) {
            i++;
        }
        while (i < nums.length) {
            int maxLen = 0;
            for (List<Integer> list : lists) {
                if (list.size() > maxLen && nums[i] % list.get(list.size() - 1) == 0) {
                    maxLen = list.size();
                }
            }
            int len = lists.size();
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                List<Integer> list = lists.get(j);
                if (list.size() == maxLen && nums[i] % list.get(list.size() - 1) == 0) {
                    List<Integer> list2 = new ArrayList<>(list);
                    list2.add(nums[i]);
                    lists.add(list2);
                    flag = true;
                }
            }
            if (!flag) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                lists.add(list);
            }
            i++;
        }
        if (lists.size() == 0) {
            lists.add(new ArrayList<>());
        }

        int k = 0;
        for (i = 1; i < lists.size(); i++) {
            if (lists.get(i).size() > lists.get(k).size()) {
                k = i;
            }
        }

        if (nums[0] == 1) {
            lists.get(k).add(1);
        }

        return lists.get(k);
    }

//    public static List<Integer> largestDivisibleSubset(int[] nums) {
//        Arrays.sort(nums);
//
//        List<List<Integer>> lists = new ArrayList<>();
//        int i = 0;
//        if (nums[i] == 1) {
//            i++;
//        }
//        while (i < nums.length) {
//            int len = lists.size();
//            for (int j = 0; j < len; j++) {
//                List<Integer> list = lists.get(j);
//                if (nums[i] % list.get(list.size() - 1) == 0) {
//                    ArrayList<Integer> list2 = new ArrayList<>(list);
//                    list2.add(nums[i]);
//                    lists.add(list2);
//                }
//            }
//            List<Integer> list = new ArrayList<>();
//            list.add(nums[i]);
//            lists.add(list);
//            i++;
//        }
//        if (lists.size() == 0) {
//            lists.add(new ArrayList<>());
//        }
//
//        int k = 0;
//        for (i = 1; i < lists.size(); i++) {
//            if (lists.get(i).size() > lists.get(k).size()) {
//                k = i;
//            }
//        }
//
//        if (nums[0] == 1) {
//            lists.get(k).add(1);
//        }
//
//        return lists.get(k);
//    }
}
