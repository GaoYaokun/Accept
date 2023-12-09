package org.yorke.lcr;

/**
 * @Author: Yorke
 * @Date: 2023/12/9 12:07
 *
 * LCR 005. 最大单词长度乘积
 * 中等
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。
 * 假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 * 示例 1:
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 *
 * 示例 2:
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 * 示例 3:
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 * 提示：
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 */
public class LCR005 {
    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","fxyz","abcdef"};
        int ans = maxProduct(words);
        System.out.println(ans);
    }

    private static int maxProduct(String[] words) {
        int ans = 0;

        int[] intArr = wordToInt(words);
        for(int i = 0; i < intArr.length - 1; i++) {
            for(int j = i + 1; j < intArr.length; j++) {
                if((intArr[i] & intArr[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    private static int[] wordToInt(String[] words) {
        int[] ans = new int[words.length];
        for(int i = 0; i < words.length; i ++) {
            for(int j = 0; j < words[i].length(); j++) {
                // |= : 或运算可保证如果出现相同字符只计算1次，例如'aa', a出现2次，01 | 01 = 01
                ans[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        return ans;
    }
}
