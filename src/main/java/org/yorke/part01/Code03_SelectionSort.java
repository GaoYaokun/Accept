package org.yorke.part01;

/**
 * @Author: Yorke
 * @Date: 2023/12/6 21:38
 *
 * 选择排序：不稳定排序
 */
public class Code03_SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9,4,5,2,33,83,1,14,25};
        selectionSort(arr);
        printArray(arr);
    }

    private static void selectionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for(int i = 0; i < n; i ++) {
            int minValueIndex = i;
            for(int j = i + 1; j < n; j ++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
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
