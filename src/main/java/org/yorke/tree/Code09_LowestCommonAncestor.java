package org.yorke.tree;

import sun.reflect.generics.tree.Tree;

/**
 * @Author: Yorke
 * @Date: 2024/2/29 11:09
 *
 * LC236 二叉树的最近公共祖先
 * 中等
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Code09_LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode p = root.left.left;
        TreeNode q = root.right;
        TreeNode res = lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }

    /**
     *
     * 递归函数：在左右子树中寻找p,q
     * 1. 若root 就是 p or q, 直接返回root， 若root为null，也返回
     * 2. 否则先序遍历, 分别在左子树和右子树中寻找p, q
     * 3. 寻找的结果只有3种可能，p,q,null
     * 4. 若left != null && right != null 则说明p,q分属左右子树，故返回root
     * 5. 若left == null || right == null 则说明在一侧找到了p or q, 另一侧未找到。说明 p和q在同一条链路上，返回非空的结果即可
     *
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return (left != null && right != null) ? root : (left != null ? left : right);
    }
}
