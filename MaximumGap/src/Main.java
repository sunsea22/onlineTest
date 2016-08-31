/**
 * Created by Sunsea on 16/8/31.
 * leetcodeOJ
 * 164. Maximum Gap
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {3,5,2,1,4,9,12};
        System.out.println(new Main().maximumGap(nums));
    }

    public class bucket {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        int len = nums.length;
        bucket[] buckets = new bucket[len];
        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < len; i++) {
            if (nums[i] < min)
                min = nums[i];
            if (nums[i] > max)
                max = nums[i];
        }

        //Math.ceil()返回不小于参数的最小整数
        int seg = (int)Math.ceil((double)(max-min)/(len - 1));
        if (seg == 0)
            return 0;
        for (int i = 0; i < len; i++) {
            int t = nums[i];
            int k = (t - min) / seg;
            if (buckets[k] == null)
                buckets[k] = new bucket();
            if (buckets[k].max < t)
                buckets[k].max = t;
            if (buckets[k].min > t)
                buckets[k].min = t;
        }

        int gap = 0;
        int preMax = max;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                gap = Math.max(gap, buckets[i].min - preMax);
                preMax = buckets[i].max;
            }
        }
        return gap;
    }
}
