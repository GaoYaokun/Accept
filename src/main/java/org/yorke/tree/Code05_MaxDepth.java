package org.yorke.tree;

/**
 * @Author: Yorke
 * @Date: 2024/2/27 9:20
 *
 * LC104 二叉树的最大深度
 */
public class Code05_MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right =  new TreeNode(7);

        int res = maxDepth(root);
        System.out.println(res);
    }

    static int max = 0;
    public static int maxDepth(TreeNode root) {
        if(root == null) return max;

        maxDepth(root, 1);
        return max;
    }

    public static void maxDepth(TreeNode root, int depth) {
        if(root.left == null && root.right == null) max = Math.max(max, depth);

        if(root.left != null) maxDepth(root.left, depth + 1);
        if(root.right != null) maxDepth(root.right, depth + 1);
    }
}
