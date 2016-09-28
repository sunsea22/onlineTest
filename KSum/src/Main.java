import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt(); //数组长度
            int k = scanner.nextInt();
            int target = scanner.nextInt(); //目标数
            int index = scanner.nextInt();
            int[] nums = new int[num];
            for (int i = 0; i < num; i++) {
                nums[i] = scanner.nextInt();
            }
            ArrayList<List<Integer>> res = new ArrayList<>();
            res = kSum(nums, target, k, index);
            for (int i = 0; i < res.size(); i++) {
                List<Integer> temp = new ArrayList<>();
                temp = res.get(i);
                for (int j = 0; j < temp.size(); j++) {
                    System.out.print(temp.get(j) + " ");
                }
                System.out.println();
            }
        }
        scanner.close();
    }

    private static ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (index >= len) return res;
        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j) {
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target - nums[i]);
                    res.add(temp);
                    //skip duplication
                    while (i < j && nums[i] == nums[i+1]) i++;
                    while (i < j && nums[j] == nums[j-1]) j--;
                    i++;
                    j--;
                }
                else if (target - nums[i] > nums[j]) {
                    i++;
                }
                else {
                    j--;
                }
            }
        }
        else {
            for (int i = index; i < len - k; i++) {
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                if (temp != null) {
                    for (List<Integer> t: temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len - 1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
