package List;

public class BinarySearch_704 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,6,8};
        System.out.println(new BinarySearch_704().binarySearch(nums,4));
    }

    /**
     * 左闭右闭二分查找： left = right 有意义
     * @return 下标（如果找到）， -1 （没找到）
     */
    public int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid  = (right + left) / 2;
            if (target == nums[mid]){
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return -1;
    }
}