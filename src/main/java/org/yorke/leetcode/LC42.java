package org.yorke.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Yorke
 * @Date: 2024/3/14 14:39
 *
 * LC42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
 *
 */
public class LC42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap4(height);
        System.out.println(res);
    }

    /**
     * 1. 按行求
     * 从高度为1开始逐层寻找雨水
     * 复杂度 O(max * n)
     * 提交会超时
     */
    public static int trap1(int[] height) {
        int max = 0;
        int len = height.length;
        for(int i = 0; i < len; i++) {
            max = Math.max(height[i], max);
        }

        int res = 0;
        int h = 1;
        while(h <= max) {
            int tmp = 0;
            boolean left = false;
            for(int i = 0; i < len; i++) {
                if(left) {
                    if(height[i] >= h) {
                        res += tmp;
                        tmp = 0;
                    }else {
                        tmp ++;
                    }
                }else {
                    if(height[i] >= h) left = true;
                }
            }
            h ++;
        }
        return res;
    }


    /**
     * 2. 按列求
     * 对每一列 寻找左边及右边的最大高度left，right, 其中较低的减去当前列高度即为可容纳雨水量
     * 复杂度O(n*n)
     * 问题在于 寻找右侧最大高度right时，每次都要重新遍历一遍数组
     */
    public static int trap2(int[] height) {
        int len = height.length;
        int leftmax = 0;
        int rightmax = 0;

        int res = 0;
        for(int i = 0; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                rightmax = Math.max(rightmax, height[j]);
            }
            int h = Math.min(leftmax, rightmax);
            res += h > height[i] ? h - height[i] : 0;

            leftmax = Math.max(height[i], leftmax);
            rightmax = 0;
        }
        return res;
    }

    /**
     *  3. 动态规划
     *  动态规划求每个节点右边的最大值并记录，使整体只用遍历2次
     *  时间复杂度O(n)
     */
    public static int trap3(int[] height){
        int res = 0;
        int len = height.length;
        int max_left = 0;
        int[] max_right = new int[len];
        max_right[len - 1] = height[len - 1];
        for(int i = len - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i]);
        }

        for(int i = 0; i < len; i++) {
            int h = Math.min(max_left, max_right[i]);
            res += h > height[i] ? h - height[i] : 0;
            max_left = Math.max(max_left, height[i]);
        }
        return res;
    }

    /**
     * 4. 单调栈
     * 时间复杂度O(n)
     */
    public static int trap4(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int len = height.length;
        int res = 0;
        for(int i = 0; i < len; i ++) {
            int h = height[i];
            while(!stack.isEmpty() && h >= height[stack.peek()]) {
                int low = stack.pop();
                if (!stack.isEmpty()) {
                    res += (i - stack.peek() - 1) * (Math.min(h, height[stack.peek()]) - height[low]);
                }
            }
            stack.push(i);
        }
        return res;
    }
}
