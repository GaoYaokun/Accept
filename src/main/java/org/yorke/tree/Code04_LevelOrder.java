package org.yorke.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Yorke
 * @Date: 2024/2/26 17:18
 *
 * LC102 二叉树的层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历
 */
public class Code04_LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right =  new TreeNode(7);

        List<List<Integer>> res = levelOrder(root);
        for(int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            for(int j = 0; j < list.size(); j ++) {
                System.out.print(list.get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // 层序遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add(tmp);
        }

        return res;
    }
}
