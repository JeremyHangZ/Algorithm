package List;

public class SpinMatrix_59 {
    public static void main(String[] args) {
        int[][] ans;
        ans = new SpinMatrix_59().spinMatrix(5);
        for (int[] s1 : ans){
            for (int ele : s1){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    /**
     * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     */
    public int[][] spinMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0; int startY = 0; // 每一行
        int offset = 1; // 每多一圈右开的距离都要多一格
        int round = n/2; // 圈数
        int counter = 1; //计数
        int i,j; // i 代表行， j 代表列
        int mid = n/2; // 如果是单数n, 单独加入mid

        while (round >= 0){
            for (j = startY; j < n-offset; j++){
                nums[startX][j] = counter++;
            }

            for (i = startX; i < n-offset; i++){
                nums[i][j] = counter++;
            }

            for (; j>=offset; j--){
                nums[i][j] = counter++;
            }

            for (; i>=offset; i--){
                nums[i][j] = counter++;
            }

            if (n % 2 != 0){
                nums[mid][mid] = n*n;
            }

            round --;
            startX ++;
            startY ++;
            offset ++;
        }
        return nums;
    }
}
