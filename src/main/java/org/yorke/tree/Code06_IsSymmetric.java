package org.yorke.tree;

/**
 * @Author: Yorke
 * @Date: 2024/2/27 9:39
 *
 * LC101 对称二叉树
 *
 * 给定一个二叉树的根节点root，检查它是否轴对称
 */
public class Code06_IsSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right =  new TreeNode(3);

        boolean res = isSymmetric(root);
        System.out.println(res);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        if(left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
