package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * @return 所有满足的条件的解法
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return resList;
            }

            // 去重a
            if (i > 0 && nums[i-1] == nums[i]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0){
                    right--;
                } else if (sum < 0) {
                    left++;
                }else {
                    // 满足条件，加入list
                    resList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重 b 和 c
                    while (right > left && nums[right -1] == nums[right]) right--;
                    while (right > left && nums[left + 1] == nums[left]) left ++;

                    right --;
                    left ++;
                }
            }
        }
        return resList;
    }
}
