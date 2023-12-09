package org.yorke.lcr;

import java.util.Arrays;

/**
 * @Author: Yorke
 * @Date: 2023/12/8 14:59
 *
 * LCR 003. 比特位计数
 * 简单
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 *
 * 示例 1:
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * 示例 2:
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * 说明 :
 *
 * 0 <= n <= 105
 *
 * 进阶:
 *
 * 给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？
 * 要求算法的空间复杂度为 O(n) 。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。
 */
public class LCR003 {
    public static void main(String[] args) {
        int n = 80;
        int[] arr = countBits(n);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 要使时间复杂度为O(n)，而不是O(n * sizeof(integer))，不能针对每个数的全部二进制位进行&1操作
     * 考虑动态规划（找规律，填表，用前值算后值）
     * 考虑：整数只有 奇数 和 偶数 两种
     *
     * 1. i为奇数，则i比上一个偶数i-1的二进制末尾多了一个1
     *    dp[i] = dp[i-1] + 1;
     * 2. i为偶数，则i二进制末尾一定为0，此时i右移1位，即除以2，二进制中1的个数不变
     *    dp[i] = dp[i/2];
     * 3. 初始条件 dp[0] = 0;
     *
     * 由此，可以推算出所有数二进制中1的个数
     *
     * 优化： i / 2 = i >> 1
     *       i % 2 = i & 1
     */
    private static int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 1; i <= n; i ++) {
            ans[i] = (i & 1) == 0 ? ans[i >> 1] : ans[i - 1] + 1;
        }
        return ans;
    }
}
