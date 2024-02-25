package org.yorke.string;

/**
 * @Author: Yorke
 * @Date: 2024/2/25 8:50
 *
 * LC1163. 按字典序排在最后的子串
 *
 * 困难
 *
 * 给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 *
 * 示例 1：
 *
 * 输入：s = "abab"
 * 输出："bab"
 * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 * 示例 2：
 *
 * 输入：s = "leetcode"
 * 输出："tcode"
 *
 *
 * 最小表示法
 */
public class Code01_LastSubstring {
    public static void main(String[] args) {
        String s = "babcbd";
        System.out.println(lastSubstring(s));
    }

    public static String lastSubstring(String s){
        int len = s.length();
        if(len <= 1) return s;

        int i = 0, j = 1, k = 0;
        char[] c = s.toCharArray();

        while(i + k < len && j + k < len) {
            if(c[i + k] > c[j + k]) {
                j = j + k + 1 <= i ? i + 1 : j + k + 1;
                k = 0;
            }else if(c[i + k] < c[j + k]) {
                i = i + k + 1 <= j ? j + 1 : i + k + 1;
                k =0;
            }else {
                k ++;
            }
        }

        return i < j ? s.substring(i) : s.substring(j);
    }

}
