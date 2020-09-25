import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author CuiJunJie
 * @create 2020-09-23-15:42
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,6,9,1};
        System.out.println(maximumGap(nums));
    }

    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();


        int bucketSize = Math.max(1, (maxVal - minVal) / (nums.length - 1));
        int bucketNum = (maxVal - minVal) / bucketSize + 1;

        int[] minVals = new int[bucketNum];
        int[] maxVals = new int[bucketNum];
        Arrays.fill(minVals, Integer.MAX_VALUE);
        Arrays.fill(maxVals, Integer.MIN_VALUE);
        boolean[] used = new boolean[bucketNum];

        for (int num : nums) {
            int index = (num - minVal) / bucketSize;
            used[index] = true;
            minVals[index] = Math.min(minVals[index], num);
            maxVals[index] = Math.max(maxVals[index], num);
        }

        int prevBucketMax = minVal;
        int maxGap = 0;
        for (int i = 0; i < bucketNum; i++) {
            if (!used[i]) {
                continue;
            }
            maxGap = Math.max(maxGap, minVals[i] - prevBucketMax);
            prevBucketMax = maxVals[i];
        }

        return maxGap;
    }
}
