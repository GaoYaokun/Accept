package org.yorke.tricks;

/**
 * @Author: Yorke
 * @Date: 2024/3/6 10:36
 *
 * Lazy 线段树
 * 问题：一个数组，更新一个子数组的值（都加上一个数，把子数组内的元素取反， 。。。）
 *              查询一个子数组的值（求和，求最大值，。。。）
 *
 * 两大思想
 * 1. 挑选 O(n) 个特殊区间，使得任意一个区间可以拆分为O(logn)个特殊区间(用最近公共祖先来思考)
 *      O(n) <= 4n
 *    挑选O(n)个特殊区间：build
 *
 * 2. lazy 更新/延迟更新
 * lazy tag : 用一个数组维护每个区间需要更新的值
 * 如果这个值 = 0， 表示不需要更新
 * 如果这个值 ！= 0， 表示更新操作在这个区间停住了，不继续递归更新子区间了
 *
 * 如果后面又来了一个更新，破坏了有lazy tag的区间，那么这个区间就得继续递归更新
 *
 *
 */
public class SegmentTree {

    int[] nums = {1,2,3,4,5,6,7,8,9,10};
    int len = nums.length;

    //lazy 数组
    int[] todo = new int[4 * len];

    /**
     * 建树， 后序遍历
     * 完全二叉树在数组中的坐标： i节点的左孩子，坐标为2*i, 右孩子坐标为2*i+1
     */
    public void build(int i, int l, int r) {
        if(l == r) {
            //....
            return;
        }

        int mid = (l + r) / 2;
        build(i * 2, l, mid);
        build(i * 2 + 1, mid + 1, r);
        // 维护...
    }

    /**
     * 更新【L，R】区域内的值，每个值都增加add
     */
    public void update(int i, int l, int r, int L, int R, int add) {
        if(L <= l && r <= R) {
            // 更新
            todo[i] += add; // 不继续递归更新了
            return;
        }
        int mid = (l + r) / 2;

        // 需要继续递归， 就把todo[i]内容传下去(给左儿子，右儿子)
        if(todo[i] != 0) {
            // 更新 i * 2
            todo[i * 2] += todo[i];
            // 更新 i * 2 + 1
            todo[i * 2 + 1] += todo[i];
            todo[i] = 0;
        }

        // 搜索区间(l, mid, mid+1, r)
        // 如果 L <= mid, 需要将任务下发至左子树
        // 如果 R >= mid+1 (R > mid), 需要将任务下发至右子树
        if(L <= mid) update(i * 2, l, mid, L, R, add);
        if(R > mid) update(i * 2 + 1, mid + 1, r, L, R, add);
        // 维护...
    }


}
