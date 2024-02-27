package org.yorke.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Yorke
 * @Date: 2024/2/27 15:39
 *
 * LC437 路径总和 III
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class Code08_PathSumIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right =  new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        int res = pathSum(root, targetSum);
        System.out.println(res);
    }

    // 朴素做法为遍历每一个节点，并以该节点为root向下遍历，记录路径和，遇到和为targetSum时结果+1
    // 此种做法时间复杂度为 O(n2)

    // 优化的切入点为 路径只能向下， 如果能统计从根节点到每一个节点为结尾时经过的路径和curSum
    // 则对路径上任意两个节点a, b, 有a到b的路径和 = curSum(b) - curSum(a)
    // 即两节点的前缀和之差 就是 两节点之间的路径和
    // 故 可使用一个Map<Integer, Integer>存储遍历过程中每个节点的前缀和，以及出现的次数
    // 遇到新节点b时,根据公式 curSum(b) - curSum(a) = targetSum
    // 判断map中是否存在 cumSum(b) - targetSum, 即 curSum(a), 如果存在则结果增加map.get(curSum(b) - targetSum);

    // 前缀和因为只遍历1次树，故时间复杂度为 O(N)
    static int res = 0;
    static Map<Long, Integer> map = new HashMap<>();
    public static int pathSum(TreeNode root, int targetSum) {
        map.put(Long.valueOf(0), 1);
        dfs(root, targetSum, 0);
        return res;
    }

    public static void dfs(TreeNode root, int targetSum, long curSum) {
        if(root == null) return;

        curSum += root.val;
        // curSum(b) - curSum(a) = targetSum 时即说明a到b的路径和为targetSum
        res += map.getOrDefault(curSum - targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        dfs(root.left, targetSum, curSum);
        dfs(root.right, targetSum, curSum);
        // 所有孩子节点遍历完后，移除当前节点的值
        map.put(curSum, map.get(curSum) - 1);
    }
}
