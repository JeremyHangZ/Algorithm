package Hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount_454 {
    /**
     * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     * @return 满足要求组合的数量
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        Map<Integer, Integer> sumList = new HashMap<>();

        // 先算出前两个数组的和的可能性
        for (int i : nums1){
            for (int j : nums2){
                int sum = i + j;
                sumList.put(sum, sumList.getOrDefault(sum, 0)+ 1);
            }
        }

        // 再算出后两个数组的和的负数存在在前两个数组和中的数量
        for (int i : nums3){
            for (int j : nums4){
                int sum = i + j;
                ans += sumList.getOrDefault(-sum, 0);
            }
        }

        return ans;
    }
}
