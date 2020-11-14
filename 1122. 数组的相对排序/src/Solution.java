import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020-11-14-10:15
 */
public class Solution {
    public static void main(String[] args) {
//        [2,2,2,1,4,3,3,9,6,7,19]
        int[] arr = relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();

//        [2,42,38,0,43,21,5,7,12,12,13,23,24,24,27,29,30,31,33,48]
        arr = relativeSortArray(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31},
                new int[]{2,42,38,0,43,21});
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        List<Integer> list =  new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }
        Collections.sort(list, (o1, o2) -> {
            if (map.containsKey(o1) && map.containsKey(o2)) {
                return map.get(o1) - map.get(o2);
            } else if (map.containsKey(o1)) {
                return -1;
            } else if (map.containsKey(o2)) {
                return 1;
            } else {
                return o1 - o2;
            }
        });

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }

        return arr1;
    }

//    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : arr1) {
//            int count = map.getOrDefault(num, 0) + 1;
//            map.put(num, count);
//        }
//
//        int index = 0;
//        for (int num : arr2) {
//            int count = map.getOrDefault(num, 0);
//            Arrays.fill(arr1, index, index + count, num);
//            index += count;
//            map.remove(num);
//        }
//        Integer[] remains = new Integer[arr1.length - index];
//        int index2 = 0;
//        for (Integer key : map.keySet()) {
//            int count = map.getOrDefault(key, 0);
//            Arrays.fill(remains, index2, index2 + count, key);
//            index2 += count;
//        }
//        Arrays.sort(remains);
//        for (int i = 0; i < remains.length; i++) {
//            arr1[index++] = remains[i];
//        }
//
//        return arr1;
//    }
}
