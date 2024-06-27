package List;

public class SlidingWindow_209 {
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,2,4,3};
        System.out.println(new SlidingWindow_209().minSubList(nums, 3));
    }

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * 快慢指针-滑动窗口
     * @param nums search list
     * @param target search key
     * @return 最短的sublist
     */
    public int minSubList(int[] nums, int target) {
        int fast = 0;
        int slow = 0;
        int subSum;
        int minLen = Integer.MAX_VALUE;
        while (fast < nums.length) {
            subSum = 0;
            for (int i = slow; i <= fast; i++) {
                subSum += nums[i];
            }
            if (subSum == target && (fast - slow + 1) < minLen) {
                minLen = fast - slow + 1;
                slow ++;
            } else if (subSum > target) {
                slow ++;
            }else if (subSum < target){
                fast ++;
            } else {
                slow ++;
            }
        }

        return minLen;
    }
}
