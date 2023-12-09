package org.yorke.lcr;

import java.util.Arrays;

/**
 * @Author: Yorke
 * @Date: 2023/12/9 10:13
 *
 * LCR 004. 只出现一次的数字 II
 * 中等
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class LCR004 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2,3,3,6};
        int ans = singleNumber(nums);
        System.out.println(ans);
    }

    private static int singleNumber(int[] nums) {
        int ans = 0;
        int[] cnt = new int[32];

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < 32; j++) {
                cnt[j] += (nums[i] & (1 << j)) == 0 ? 0 : 1;
            }
        }

        for(int i = 0; i < 32; i ++) {
            ans += cnt[i] % 3 == 1 ? 1 << i : 0;
        }
        return ans;
    }
}
