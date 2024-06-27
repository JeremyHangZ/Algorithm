package List;

public class DoubleIndexingDeleteItem_27 {
    public static void main(String[] args) {
        int ans = new DoubleIndexingDeleteItem_27().removeItem(new int[]{1,2,2,3,2,4}, 2);
        System.out.println(ans);
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 使用快慢指针
     */
    public int removeItem(int[] nums, int target){
        int i = 0; // 快指针
        int j = 0; // 慢指针
        while (i < nums.length){
            if (nums[i] == target){ // 如果找到需要删除的元素，只向后移动快指针
                i++;
            }else{ // 慢指针指向当前需要插入元素的格子，插入元素后慢指针也向后移动一格
                nums[j] = nums[i];
                i++;
                j++;
            }
        }
        return j;
    }
}