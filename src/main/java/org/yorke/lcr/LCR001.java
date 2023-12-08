package org.yorke.lcr;

/**
 * @Author: Yorke
 * @Date: 2023/12/8 10:03
 *
 * LCR 001. 整数除法
 * 简单
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *
 * 注意：
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31−1]。本题中，如果除法结果溢出，则返回 2^31 − 1
 *
 * 示例 1：
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * 示例 2：
 *
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * 示例 3：
 *
 * 输入：a = 0, b = 1
 * 输出：0
 * 示例 4：
 *
 * 输入：a = 1, b = 1
 * 输出：1
 *
 * 提示:
 * -2^31 <= a, b <= 2^31 - 1
 * b != 0
 */
public class LCR001 {
    public static void main(String[] args) {
        int a = -2147483648;
        System.out.println(a);
        int b = -2147483648;

        // int ans = divide(a,b);
        int ans = divide2(a,b);
        System.out.println(ans);
    }

    // 解法2： 优化，除数慢开始，指数级增长（类似TCP拥塞控制）
    private static int divide2(int a, int b) {
        // 规避 0 - Integer.MIN_VALUE = Integer.MIN_VALUE的情况
        if(a == b) return 1;
        int ans = 0;

        int flag = 1;
        if((a > 0 && b < 0) || (a < 0 && b > 0)) {
            flag = -1;
        }
        // a,b全转为负数，取相反数 -a = ~a+1 = ~(a-1)
        a = a > 0 ? ~a + 1 : a;
        b = b > 0 ? ~b + 1 : b;

        int cur = b;
        int time = 1;
        while(a - b <= 0) {
            while(a - cur <= 0) {
                a = a - cur;
                ans -= time;

                if(flag == 1) {
                    if(ans <= Integer.MIN_VALUE + 1) {
                        return Integer.MAX_VALUE;
                    }
                }else {
                    if(ans == Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }

                // 防止cur * 2 超过Integer最小值
                if(cur + cur < 0) {
                    cur = cur + cur;
                    time = time + time;
                }
            }
            cur = b;
            time = 1;
        }
        return flag == 1 ? ~ans + 1 : ans;

    }

    // 解法1： 模拟 ————————> 超时，当a=Integer的最大值/最小值，b=1时，减法需要计算21亿次
    private static int divide(int a, int b) {
        int ans = 0;

        int flag = 1;
        if((a > 0 && b < 0) || (a < 0 && b > 0)) {
            flag = -1;
        }

        // 取相反数 -a = ~a+1 = ~(a-1)
        a = a > 0 ? ~a + 1 : a;
        b = b > 0 ? ~b + 1 : b;

        while(a - b <= 0) {
            a = a - b;
            ans --;
            if(flag == 1) {
                if(ans <= Integer.MIN_VALUE + 1) {
                    return Integer.MAX_VALUE;
                }
            }else {
                if(ans == Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }

        return flag == 1 ? ~ans + 1: ans;
    }
}
