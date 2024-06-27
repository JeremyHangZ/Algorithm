package List;

public class SquaredList_977 {
    public static void main(String[] args) {
        int[] origin = new int[] {-3,0,4};
        int[] ans = new SquaredList_977().squaredList(origin);
        for (int i : ans){
            System.out.print(i + " ");
        }
    }

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * 使用双向指针
     */
    public int[] squaredList(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        int[] ans = new int[nums.length];
        while (left <= right){
            if (left == right){
                ans[index] = nums[left] * nums[left];
                left ++;
                index --;
            }else if (nums[left]*nums[left] >= nums[right]*nums[right]){
                ans[index] = nums[left] * nums[left];
                left ++;
                index --;
            }else {
                ans[index] = nums[right] * nums[right];
                right --;
                index --;
            }
        }
        return ans;
    }

}
