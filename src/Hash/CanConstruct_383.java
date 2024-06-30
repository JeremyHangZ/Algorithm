package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class CanConstruct_383 {

    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * 如果可以，返回 true ；否则返回 false 。
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     *
     * @return true or false
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        // 字符不能重复使用
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // 长度固定，使用数组更有效
        int[] records = new int[26];

        // 统计magazine中每个字符出现的次数
        for (int i : magazine.toCharArray()) {
            records[i - 'a']++;
        }

        // 从表中移除所有ransomNote的字符，如果有
        for (int j : ransomNote.toCharArray()) {
            records[j - 'a']--;
            if (records[j - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
