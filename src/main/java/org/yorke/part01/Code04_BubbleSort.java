package org.yorke.part01;

/**
 * @Author: Yorke
 * @Date: 2023/12/6 22:01
 *
 * 冒泡排序：稳定排序
 */
public class Code04_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9,4,5,2,33,83,1,14,25};
        bubleSort(arr);
        printArray(arr);
    }

    public static void bubleSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        int n = arr.length;
        for(int end = n - 1; end >= 0; end--) {
            for(int i = 1; i <= end; i++) {
                if(arr[i-1] > arr[i]){
                    swap(arr,i-1,i);
                }
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
