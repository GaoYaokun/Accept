package org.yorke.lcr;

/**
 * @Author: Yorke
 * @Date: 2023/12/8 14:47
 *
 * LCR 002. 二进制求和
 * 简单
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class LCR002 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String ans = addBinary(a,b);
        System.out.println(ans);
    }

    private static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int n = Math.max(a.length(), b.length());
        int temp = 0;
        for(int i = 0; i < n; i ++) {
           temp += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
           temp += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
           ans.append(temp % 2);
           temp = temp / 2;
        }

        if(temp == 1) ans.append(1);
        return ans.reverse().toString();
    }
}
