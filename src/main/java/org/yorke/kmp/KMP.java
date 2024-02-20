package org.yorke.kmp;

/**
 * @Author: Yorke
 * @Date: 2024/2/5 15:24
 */
public class KMP {
    public static void main(String[] args) {
        String s1 = "ABC ABCDAB ABCDABCDABDE";
        String s2 = "ABCDABD";

        System.out.println(kmp(s1.toCharArray(), s2.toCharArray()));
    }

    public static int kmp(char[] s1, char[] s2) {
        // s1中当前比对的位置是x
        // s2中当前比对的位置是y
        int n = s1.length, m = s2.length, x = 0, y = 0;
        int[] next = nextArray(s2);
        while (x < n && y < m) {
            if (s1[x] == s2[y]) {
                x ++;
                y ++;
            }else if (y == 0) {
                x ++;
            }else {
                y = next[y];
            }
        }

        return y == m ? x - y : -1;
    }

    public static int[] nextArray(char[] s) {
        int len = s.length;
        if(len == 1){
            return new int[] { -1 };
        }
        int[] next = new int[len];
        next[0] = -1;
        next[1] = 0;

        // i表示当前要求next值的位置
        // cn表示当前要和前一个字符比对的下标
        int i = 2, cn = 0;
        while(i < len) {
            if(s[i - 1] == s[cn]) {
                next[i] = cn + 1;
                i ++;
                cn ++;
                // next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i] = 0;
                i ++;
                // next[i++] = 0;
            }
        }

        return next;
    }
}
