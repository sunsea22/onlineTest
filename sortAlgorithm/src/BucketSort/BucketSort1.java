package BucketSort;

import java.util.Arrays;

/**
 * Created by Sunsea on 16/8/31.
 */
public class BucketSort1 {
    public static void main(String[] args) {
        int[] nums = {3,5,2,1,4,9,12};
        System.out.println(maximumGap1(nums));
    }

    public static int maximumGap1(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        int min = num[0];
        int max = num[0];

        for (int i: num) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        int gap = (int)Math.ceil((double)(max - min) / (num.length - 1));
        int[] bucketMin = new int[num.length + 1];
        int[] bucketMax = new int[num.length + 1];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        for (int i: num) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap;
            bucketMax[idx] = Math.max(i, bucketMax[idx]);
            bucketMin[idx] = Math.min(i, bucketMin[idx]);
        }

        int maxGap = Integer.MIN_VALUE;
        int previous = min;

        for (int i = 0; i < num.length; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE && bucketMin[i] == Integer.MAX_VALUE)
                continue;
            maxGap = Math.max(maxGap, bucketMin[i] - previous);
            previous = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}
