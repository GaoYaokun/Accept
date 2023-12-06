package org.yorke.part01;

/**
 * @Author: Yorke
 * @Date: 2023/12/6 21:32
 *
 * 求阶乘的和 f(x) = 1! + 2! + 3! + 4! + ... + N!
 */
public class Code02_Factorial {
    public static void main(String[] args) {
        int n = 10;
        factorial(n);
    }

    private static void factorial(int n) {
        int cur = 1;
        int res = 0;
        for(int i = 1; i <= n; i++) {
            cur = cur * i;
            res += cur;
        }
        System.out.println(res);
    }
}
