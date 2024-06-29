package Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 */
public class IsHappy_202 {

    /*
     * 题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现，这对解题很重要！
     * 正如：关于哈希表，你该了解这些！ (opens new window)中所说，当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法了。
     * 所以这道题目使用哈希法，来判断这个sum是否重复出现，如果重复了就是return false， 否则一直找到sum为1为止。
     * 判断sum是否重复出现就可以使用unordered_set。
     */

    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        while (n != 1 && !nums.contains(n)){
            nums.add(n);
            n = getNextNum(n);
        }

        return n == 1;
    }

    // 求和的过程
    public int getNextNum(int n){
        int res = 0;
        while (n > 0){
            res += (n % 10) * (n % 10);
            n = n / 10;
        }

        return res;
    }
}
