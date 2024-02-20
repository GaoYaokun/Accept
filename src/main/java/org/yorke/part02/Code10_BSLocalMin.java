package org.yorke.part02;

/**
 * @Author: Yorke
 * @Date: 2024/2/4 9:40
 *
 * 局部最小定义：
 * 1) 数组a中 若 a[0] < a[1] , 则 0 位置元素局部最小
 * 2) 数组a中 若 a[len-1] < a[len-2], 则 len - 1 位置元素局部最小
 * 3) 数组a中 若 a[i-1] > a[i] < a[i+1], 则 i 位置元素局部最小
 *
 * 题目： 给定一个无序数组，且相邻元素不相等，请返回数组中任意一个局部最小的元素位置
 */
public class Code10_BSLocalMin {
    public static void main(String[] args) {
        int[] arr = {9,6,8,5,3,2,7,12};
        System.out.println(oneMinIndex(arr));
    }


    // arr 整体无序，且相邻的数不相等
    public static int oneMinIndex(int[] arr) {
        // 边界处理 arr.len <= 2
        if(arr == null || arr.length == 0)  return -1;
        // if(arr.length == 1) return 0;
        // if(arr.length == 2) {
        //     return arr[0] < arr[1] ? 0 : 1;
        // }
        int N = arr.length;
        if(N == 1) return 0;
        if(arr[0] < arr[1]) return 0;
        if(arr[N-1] < arr[N-2]) return N-1;

        // arr.len > 2
        int L = 0;
        int R = N - 1;
        int ans = -1;

        while(L < R) {
            int mid = (L + R) / 2;
            if(arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]){
                ans = mid;
                break;
            } else if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            }
        }

        return ans;
    }

    // 对数器:  生成随机数组，且相邻数不相等
    public static int[] randomArray(int  maxLen, int maxValue) {
        int len = (int)(Math.random() * maxLen);
        int[] arr = new int[len];
        if(len > 0) {
            // 生产随机数
            arr[0] = (int)(Math.random() * maxValue);
            for(int i = 1; i < len; i ++){
                // 确保相邻不相等
                do {
                    arr[i] = (int)(Math.random() * maxValue);
                }while(arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

}
