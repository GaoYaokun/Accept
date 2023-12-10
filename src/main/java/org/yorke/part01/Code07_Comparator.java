package org.yorke.part01;

import java.util.Arrays;

/**
 * @Author: Yorke
 * @Date: 2023/12/10 10:23
 *
 * 对数器：生成随机样本，校验算法对错的机器
 *
 * 通过构造随机大样本数据，来校验算法是否正确
 */
public class Code07_Comparator {
    public static void main(String[] args) {
        int maxLen = 50;
        int maxValue = 1000;
        int testTimes = 10000;

        for(int i = 0; i < testTimes; i++) {
            int[] arr1 = lenRandonValueRandom(maxLen, maxValue);
            int[] arr2 = copyArray(arr1);
            // 校验选择排序
            Code03_SelectionSort.selectionSort(arr1);
            if(!isSorted(arr1)) {
                System.out.println(Arrays.toString(arr2));
                System.out.println("算法错误！！！");
                break;
            }
        }
        System.out.println("算法正确，校验无误！");

    }

    // 构建随机数组
    public static int[] lenRandonValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for(int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    // 备份数据
    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    // 校验是否数组是否相等
    public static boolean equalValues(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // 校验数组是否有序
    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) return true;
        int maxValue = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(maxValue > arr[i]) {
                return false;
            }
            maxValue = arr[i];
        }
        return true;
    }

}
