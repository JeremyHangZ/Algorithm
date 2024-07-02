package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseSubString_KM55 {

    /**
     * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
     * 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
     * 输入：输入共包含两行，第一行为一个正整数 k，代表右旋转的位数。第二行为字符串 s，代表需要旋转的字符串。
     * 输出：输出共一行，为进行了右旋转操作后的字符串。
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = Integer.parseInt(in.nextLine());
        String target = in.nextLine();
        String reverse1 = reverseSubString(target,0, target.length() - 1);
        String reverse2 = reverseSubString(reverse1,0,len-1);
        String reverse3 = reverseSubString(reverse2,len, reverse2.length()-1);
        System.out.println(reverse3);
    }

    public static String reverseSubString(String s, int start, int end){
        char[] charArray = s.toCharArray();
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start ++;
            end --;
        }
        return new String(charArray);
    }

}
