package org.yorke.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Yorke
 * @Date: 2024/2/20 21:47
 * 105. 从前序与中序遍历序列构造二叉树
 * 中等
 *
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历，inorder 是同一棵树的中序遍历，
 * 请构造二叉树并返回其根节点。
 *
 * 示例1：
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * 示例2：
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 * 提示:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */
public class LC105 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode res = buildTree(preorder, inorder);

    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inLen; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preLen - 1, inMap, 0, inLen - 1);
    }

    private static TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> inMap, int inLeft, int inRight) {
        if(preLeft > preRight || inLeft > inRight) return null;

        TreeNode head = new TreeNode(preorder[preLeft]);
        preLeft += 1;

        int i = inMap.get(head.val);

        head.left = buildTree(preorder, preLeft, preLeft + i - 1 - inLeft, inMap, inLeft, i - 1);
        head.right = buildTree(preorder, preLeft + i - inLeft, preRight, inMap, i + 1, inRight);

        return head;
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
}