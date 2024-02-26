package org.yorke.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Yorke
 * @Date: 2024/2/26 11:59
 *
 * LC145 二叉树的后序遍历
 *
 * 给你二叉树的根节点 root ，返回它节点值的 后序 遍历。
 */
public class Code03_PostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right =  new TreeNode(7);

        List<Integer> res = postorderTraversal1(root);
        for(int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            System.out.print(" ");
        }
    }

    // 递归
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private static void postorder(TreeNode root, List<Integer> res) {
        if(root == null) return;

        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    // 迭代
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> postStack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            postStack.push(cur);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }

        while(!postStack.isEmpty()) {
            res.add(postStack.pop().val);
        }

        return res;
    }
}
