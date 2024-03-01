package org.yorke.tricks;

import java.util.Arrays;

/**
 * @Author: Yorke
 * @Date: 2024/3/1 11:29
 *
 * LC204 计数质数
 *
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7
 */
public class Code01_CountPrimes {
    public static void main(String[] args) {
        int n = 28743;
        int res = countPrimes1(n);
        System.out.println(res);
    }

    public static int countPrimes(int n){
        int res = 0;
        for(int i = 2; i < n; i++) {
            res += isPrime(i) ? 1 : 0;
        }
        return res;
    }

    /**
     * 1. 朴素想法
     * 遍历从2 到 n的所有数，判断其是否是n的因数，如果找到了n的因数就返回false
     * 可优化为遍历从2到 根号, 因为如果存在 大于 根号n 的因数，则另一个因数一定小于 根号n
     * 时间复杂度O(n√n), 单个素数时间复杂度为O(√n)
     */
    public static boolean isPrime(int num) {
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    /**
     * 2. 埃氏筛查法 (埃拉托斯特尼筛法, 古希腊数学家Eratosthenes提出)
     * 步骤如下：
     *  1) 创建一个包含从2到n的所有整数的列表
     *  2) 从列表种找到最小的素数(初始为2), 并标记它的所有倍数(除了他自己)为非素数(合数)
     *  3) 在剩余的未标记的数中，找到下一个最小的数(此时它也是素数),重复步骤2
     *  4) 重复步骤3,直到遍历完列表中的所有数
     * 优化：
     *  标记时只需要从当前素数的 平方 开始的 倍数 即可
     *  例如 x = 5, 标记只需要从 5 * 5 开始即可, 因为2 * 5, 3 * 5 已经在x = 2, x = 3时标记过了
     *
     * 复杂度：O(nloglogn)
     * */
    public static int countPrimes1(int n){
        int isPrime[] = new int[n];

        for(int i = 2; i * i < n; i ++) {
            // 如果当前 i 是素数
            if (isPrime[i] == 0) {
                // 从 i * i 开始染色
                for(int j = i * i; j < n; j += i) {
                    isPrime[j] = 1;
                }
            }
        }

        int res = 0;
        for(int i = 2; i < n; i++) {
            res += isPrime[i] == 0 ? 1 : 0;
        }
        return res;
    }
}
