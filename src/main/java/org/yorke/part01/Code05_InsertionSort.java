package org.yorke.part01;

/**
 * @Author: Yorke
 * @Date: 2023/12/6 22:10
 *
 * 插入排序：稳定排序
 */
public class Code05_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9,4,5,2,33,83,1,14,25};
        insertionSort(arr);
        printArray(arr);
    }

    private static void insertionSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        // 插入排序模型想象：摸牌，如何使手牌有序
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int cur = arr[i];
            for(int j = i - 1; j >= 0; j --) {
                if(cur < arr[j]) swap(arr, j, j+1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
